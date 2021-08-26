package com.peregud.shoppingmall.controller;

import com.peregud.shoppingmall.domain.Users;
import com.peregud.shoppingmall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.peregud.shoppingmall.AppConstants.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(PAGE_USER_SIGN_UP)
    public String signUpNew(@RequestParam(PARAM_USERNAME) String username,
                            @RequestParam(PARAM_PASSWORD) String password,
                            @RequestParam(PARAM_ROLE) String role) {
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(passwordEncoder.encode(password));
        users.setRole(role);
        userService.signUp(users);
        return VIEW_SUCCESS;
    }
}
