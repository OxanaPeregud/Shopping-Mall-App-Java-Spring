package com.peregud.shoppingmall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static com.peregud.shoppingmall.AppConstants.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(UserController.class)
class UserControllerTest extends MockInit {

    @Test
    void signUpNew() throws Exception {
        this.mockMvc.perform(post(PAGE_USER_SIGN_UP)
                .param(PARAM_USERNAME, "1")
                .param(PARAM_PASSWORD, "1")
                .param(PARAM_ROLE, "1"))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_SUCCESS))
                .andReturn();
    }
}
