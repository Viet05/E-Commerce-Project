package com.dnnviet.personal.project.CellphoneS.dto.user;

import com.dnnviet.personal.project.CellphoneS.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level =AccessLevel.PRIVATE)
public class UserDTO {

    Long userId;
    String username;
    String password;
    Role role;
}
