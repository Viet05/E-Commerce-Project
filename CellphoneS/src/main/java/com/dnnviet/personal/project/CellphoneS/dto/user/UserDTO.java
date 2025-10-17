package com.dnnviet.personal.project.CellphoneS.dto.user;

import com.dnnviet.personal.project.CellphoneS.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level =AccessLevel.PRIVATE)
public class UserDTO {

    Long userId;
    String username;
    String email;
    String phone;
    LocalDateTime birthday;
    Role role;

}
