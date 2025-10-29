package com.dnnviet.personal.project.CellphoneS.service.user;

import com.dnnviet.personal.project.CellphoneS.dto.request.user.UserCreateRequest;
import com.dnnviet.personal.project.CellphoneS.entities.user.Customer;
import com.dnnviet.personal.project.CellphoneS.entities.user.Staff;
import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import com.dnnviet.personal.project.CellphoneS.enums.ErrorCode;
import com.dnnviet.personal.project.CellphoneS.exception.AppException;
import com.dnnviet.personal.project.CellphoneS.mapping.user.UserMapper;
import com.dnnviet.personal.project.CellphoneS.repositories.user.CustomerRepo;
import com.dnnviet.personal.project.CellphoneS.repositories.user.StaffRepo;
import com.dnnviet.personal.project.CellphoneS.repositories.user.UserRepo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
public class UserService {

    UserRepo userRepository;
    UserMapper userMapper;
    StaffRepo staffRepository;
    CustomerRepo customerRepository;
    PasswordEncoder passwordEncoder;

    public User createUser(UserCreateRequest request) {

        if(userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(request.getRole())
                .isActive(true)
                .build();

        User savedUser = userRepository.save(user);

        switch (request.getRole()) {
            case STAFF -> {
                Staff staff = Staff.builder()
                        .staffName(request.getStaffName() != null ? request.getStaffName() : request.getUsername())
                        .email(request.getEmail())
                        .phone(request.getPhone())
                        .startDate(LocalDateTime.now())
                        .user(savedUser)
                        .build();

                // Set expertise và area nếu có
                if (request.getExpertiseId() != null) {
                    // Load expertise từ repo
                }
                if (request.getAreaId() != null) {
                    // Load area từ repo
                }

                staffRepository.save(staff);
            }
            case CUSTOMER -> {
                Customer customer = Customer.builder()
                        .customerName(request.getCustomerName() != null ? request.getCustomerName() : request.getUsername())
                        .email(request.getEmail())
                        .phoneNumber(request.getPhone())
                        .address(request.getAddress())
                        .user(savedUser)
                        .build();
                customerRepository.save(customer);
            }
        }

        return savedUser;
    }

}
