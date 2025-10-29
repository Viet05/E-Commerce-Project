package com.dnnviet.personal.project.CellphoneS.service.user;

import com.dnnviet.personal.project.CellphoneS.dto.request.user.LoginRequest;
import com.dnnviet.personal.project.CellphoneS.dto.request.user.RegisterRequest;
import com.dnnviet.personal.project.CellphoneS.dto.respone.LoginResponse;
import com.dnnviet.personal.project.CellphoneS.entities.user.Customer;
import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import com.dnnviet.personal.project.CellphoneS.enums.ErrorCode;
import com.dnnviet.personal.project.CellphoneS.enums.UserRole;
import com.dnnviet.personal.project.CellphoneS.exception.AppException;
import com.dnnviet.personal.project.CellphoneS.mapping.user.UserMapper;
import com.dnnviet.personal.project.CellphoneS.repositories.user.CustomerRepo;
import com.dnnviet.personal.project.CellphoneS.repositories.user.UserRepo;
import com.dnnviet.personal.project.CellphoneS.security.JwtUtils;
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
    JwtUtils JWToken;

    //Service Register
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

    //Service login
    public LoginResponse login(LoginRequest request) {
        //Kiểm tra email
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        //kểm tra password
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!authenticated)
            throw new AppException(ErrorCode.UNAUTHENTICATED);

        //tạo token cho những request sau
        var token = JWToken.generateToken(request.getUsername());

        return LoginResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

}
