package com.dnnviet.personal.project.CellphoneS.service.user;

import com.dnnviet.personal.project.CellphoneS.repositories.user.UserRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthService {

    UserRepo userRepository;
}
