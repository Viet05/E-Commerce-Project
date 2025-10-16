package com.dnnviet.personal.project.CellphoneS.dto.customer;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @Size(min = 10, max = 30, message = "USERNAME_INVALID")
    String username;

    @Size(min = 8)
    String password;


}
