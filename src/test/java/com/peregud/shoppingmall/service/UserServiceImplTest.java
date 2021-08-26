package com.peregud.shoppingmall.service;

import com.peregud.shoppingmall.domain.Users;
import com.peregud.shoppingmall.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void cleanUp() {
        userRepository.deleteAll();
        userRepository.flush();
    }

    @Test
    void signUp() {
        Users users = Users.builder().build();
        assertEquals(0, userRepository.findAll().size());
        userService.signUp(users);
        assertEquals(1, userRepository.findAll().size());
    }
}
