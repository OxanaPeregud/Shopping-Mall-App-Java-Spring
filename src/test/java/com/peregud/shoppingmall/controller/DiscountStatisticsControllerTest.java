package com.peregud.shoppingmall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static com.peregud.shoppingmall.AppConstants.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DiscountStatisticsController.class)
class DiscountStatisticsControllerTest extends MockInit {

    @Test
    void displayDiscountStatistics() throws Exception {
        this.mockMvc.perform(get(PAGE_DISCOUNT_STATISTICS)
                .with(csrf())
                .with(user(USER)))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_DISCOUNT_STATISTICS))
                .andExpect(model().size(1))
                .andExpect(model().attributeExists(ATTR_LIST_STATISTICS))
                .andReturn();
    }
}
