package com.peregud.shoppingmall.service.impl;

import com.peregud.shoppingmall.domain.Users;
import com.peregud.shoppingmall.repository.UserRepository;
import com.peregud.shoppingmall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public void signUp(Users users) {
        userRepository.save(users);
    }
}
