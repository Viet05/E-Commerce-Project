package com.dnnviet.personal.project.CellphoneS.security;

import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import com.dnnviet.personal.project.CellphoneS.repositories.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // username ở đây là email do JwtUtils.set subject = email
        User user = userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return AuthUser.fromUser(user);
    }
}


