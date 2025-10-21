package com.dnnviet.personal.project.CellphoneS.dto.request.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRequest {

    @NotBlank(message = "Username is required")
    @Size(min = 8, max = 20)
    private String username;

    @Size(min = 8, max = 20, message = "Password must be least 8 characters")
    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank
    private String confirmPassword;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank
    private String phone;
}
