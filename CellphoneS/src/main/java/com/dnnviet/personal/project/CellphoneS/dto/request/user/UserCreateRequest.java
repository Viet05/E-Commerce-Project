package com.dnnviet.personal.project.CellphoneS.dto.request.user;


import com.dnnviet.personal.project.CellphoneS.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreateRequest {

    @NotBlank(message = "Username is required")
    @Size(min = 8, max = 20)
    private String username;

    @Size(min = 8, max = 20, message = "Password must be at least 8 characters")
    @NotBlank(message = "Password is required")
    private String password;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotNull(message = "Role is required")
    private UserRole role;

    // Thông tin bổ sung cho Staff (optional)
    private String staffName;
    private Long expertiseId;
    private Long areaId;

    // Thông tin bổ sung cho Customer (optional)
    private String customerName;
    private String address;

}
