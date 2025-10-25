package com.dnnviet.personal.project.CellphoneS.controller.user;

import com.dnnviet.personal.project.CellphoneS.dto.request.user.RegisterRequest;
import com.dnnviet.personal.project.CellphoneS.dto.respone.ApiResponse;
import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import com.dnnviet.personal.project.CellphoneS.service.user.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<User>> register(@Valid @RequestBody RegisterRequest request) {
        User newUser = authService.registerUser(request);
        ApiResponse<User> response = ApiResponse.<User>builder()
                .code(200)
                .message("Successfully registered")
                .data(newUser)
                .build();
        return ResponseEntity.ok(response);
    }


}
