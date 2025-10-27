package com.dnnviet.personal.project.CellphoneS.service.user;

import com.dnnviet.personal.project.CellphoneS.dto.request.user.RegisterRequest;
import com.dnnviet.personal.project.CellphoneS.entities.user.Customer;
import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import com.dnnviet.personal.project.CellphoneS.enums.ErrorCode;
import com.dnnviet.personal.project.CellphoneS.enums.UserRole;
import com.dnnviet.personal.project.CellphoneS.exception.user.AppException;
import com.dnnviet.personal.project.CellphoneS.mapping.user.UserMapper;
import com.dnnviet.personal.project.CellphoneS.repositories.user.CustomerRepo;
import com.dnnviet.personal.project.CellphoneS.repositories.user.UserRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthService {

    UserRepo userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    CustomerRepo customerRepo;

    //Service Register(Đăng ký)
    public User registerUser(RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(registerRequest);
        //Strength đc config trong SecurityConfig
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //Set role
        user.setRole(UserRole.CUSTOMER);

        User savedUser = userRepository.save(user);

        Customer customer = new Customer();
        customer.setUser(user);
        customer.setPhoneNumber(registerRequest.getPhone());
        customer.setCustomerName(registerRequest.getUsername());
        customer.setEmail(registerRequest.getEmail());

        customerRepo.save(customer);

        return savedUser;
    }

}
