package com.example.userapi;

import com.example.userapi.Model.Entity.User;
import com.example.userapi.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Initializer implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        for(int i=0; i<10; i++){
            userRepository.save(
                    User.builder()
                            .username("test user "+i)
                            .registeredBookCount(0)
                            .build());
        }
    }
}
