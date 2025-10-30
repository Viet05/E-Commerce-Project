package com.dnnviet.personal.project.CellphoneS.service.user;

import com.dnnviet.personal.project.CellphoneS.dto.request.user.UserCreateRequest;
import com.dnnviet.personal.project.CellphoneS.dto.respone.UserResponse;
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
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class UserService {

    UserRepo userRepository;
    UserMapper userMapper;
    StaffRepo staffRepository;
    CustomerRepo customerRepository;
    PasswordEncoder passwordEncoder;

    public User createUser(UserCreateRequest request) {
        if (request == null || request.getUsername() == null || request.getPassword() == null || request.getEmail() == null || request.getRole() == null) {
            throw new AppException(ErrorCode.INVALID_INPUT);
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        // (Có thể check existedByEmail tương tự nếu cần)
        User user = userMapper.toUserRequest(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        User savedUser = userRepository.save(user);
        switch (request.getRole()) {
            case STAFF: {
                Staff staff = Staff.builder()
                        .staffName(request.getStaffName() != null ? request.getStaffName() : request.getUsername())
                        .email(request.getEmail())
                        .phone(request.getPhone())
                        .startDate(LocalDateTime.now())
                        .user(savedUser)
                        .build();
                // TODO: set expertise, area nếu có
                staffRepository.save(staff);
                break;
            }
            case CUSTOMER: {
                Customer customer = Customer.builder()
                        .customerName(request.getCustomerName() != null ? request.getCustomerName() : request.getUsername())
                        .email(request.getEmail())
                        .phoneNumber(request.getPhone())
                        .address(request.getAddress())
                        .user(savedUser)
                        .build();
                customerRepository.save(customer);
                break;
            }
            default:
                throw new AppException(ErrorCode.INVALID_INPUT);
        }
        return savedUser;
    }

    public List<UserResponse> getAllUsers() {
        return ((List<User>) userRepository.findAll()).stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
