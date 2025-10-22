package com.dnnviet.personal.project.CellphoneS.mapping.user;

import com.dnnviet.personal.project.CellphoneS.dto.request.user.RegisterRequest;
import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(RegisterRequest registerRequest);
}
