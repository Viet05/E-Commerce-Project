package com.dnnviet.personal.project.CellphoneS.mapping.user;

import com.dnnviet.personal.project.CellphoneS.dto.request.user.RegisterRequest;
import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-23T10:13:38+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( registerRequest.getUsername() );
        user.password( registerRequest.getPassword() );
        user.email( registerRequest.getEmail() );

        return user.build();
    }
}
