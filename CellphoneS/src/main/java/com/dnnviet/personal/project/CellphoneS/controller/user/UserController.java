package com.dnnviet.personal.project.CellphoneS.controller.user;

import com.dnnviet.personal.project.CellphoneS.dto.request.user.UserCreateRequest;
import com.dnnviet.personal.project.CellphoneS.dto.respone.ApiResponse;
import com.dnnviet.personal.project.CellphoneS.dto.respone.UserResponse;
import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import com.dnnviet.personal.project.CellphoneS.enums.ApiStatus;
import com.dnnviet.personal.project.CellphoneS.service.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<ApiResponse<User>> createUser(@Valid @RequestBody UserCreateRequest request) {
        User createdUser = userService.createUser(request);
        ApiResponse<User> response = ApiResponse.<User>builder()
                .code(201)
                .status(ApiStatus.SUCCESS)
                .message("User created successfully")
                .data(createdUser)
                .build();
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers();
        ApiResponse<List<UserResponse>> response = ApiResponse.<List<UserResponse>>builder()
                .code(200)
                .status(ApiStatus.SUCCESS)
                .message("Fetched users successfully")
                .data(users)
                .build();
        return ResponseEntity.ok(response);
    }
}