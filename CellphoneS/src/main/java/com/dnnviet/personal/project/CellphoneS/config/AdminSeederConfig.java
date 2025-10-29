package com.dnnviet.personal.project.CellphoneS.config;

import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import com.dnnviet.personal.project.CellphoneS.enums.UserRole;
import com.dnnviet.personal.project.CellphoneS.repositories.user.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminSeederConfig {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initAdmin() {
        return args -> {
            String adminUsername = System.getenv().getOrDefault("ADMIN_USERNAME", "admin123");
            String adminEmail    = System.getenv().getOrDefault("ADMIN_EMAIL", "admin@local.dev");
            String adminPassword = System.getenv().getOrDefault("ADMIN_PASSWORD", "Admin@123456");

            boolean exists = userRepo.existsByUsername(adminUsername) || userRepo.existsByEmail(adminEmail);
            if (!exists) {
                User admin = User.builder()
                        .username(adminUsername)
                        .email(adminEmail)
                        .password(passwordEncoder.encode(adminPassword))
                        .role(UserRole.ADMIN)
                        .isActive(true)
                        .build();
                userRepo.save(admin);
            }
        };
    }
}
