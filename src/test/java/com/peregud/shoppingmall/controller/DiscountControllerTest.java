package com.peregud.shoppingmall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static com.peregud.shoppingmall.AppConstants.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DiscountController.class)
class DiscountControllerTest extends MockInit {

    @Test
    void infoDiscount() throws Exception {
        this.mockMvc.perform(get(PAGE_DISCOUNTS_INFO)
                .param(PARAM_ID, "1")
                .with(csrf())
                .with(user(USER)))
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(view().name(VIEW_DISCOUNTS_INFO))
                .andReturn();
    }

    @Test
    void searchMinimumDiscount() throws Exception {
        this.mockMvc.perform(post(PAGE_DISCOUNTS_SEARCH_RESULT)
                .param(PARAM_MIN_DISCOUNT, "1")
                .with(csrf())
                .with(user(USER)))
                .andExpect(status().isOk())
                .andExpect(model().size(2))
                .andExpect(model().attributeExists(ATTR_MIN_DISCOUNT, ATTR_LIST_DISCOUNT_SHOPS))
                .andExpect(view().name(VIEW_SHOPS_AND_DISCOUNTS))
                .andReturn();
    }

    @Test
    void displayActualDiscounts() throws Exception {
        this.mockMvc.perform(get(PAGE_DISCOUNTS_ACTUAL)
                .with(csrf())
                .with(user(USER)))
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attributeExists(ATTR_LIST_DISCOUNT_SHOPS))
                .andExpect(view().name(VIEW_SHOPS_AND_DISCOUNTS))
                .andReturn();
    }

    @Test
    void displayDiscountsFullList() throws Exception {
        this.mockMvc.perform(get(PAGE_DISCOUNTS_FULL_LIST)
                .with(user(USER)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void editDiscount() throws Exception {
        this.mockMvc.perform(get(PAGE_DISCOUNTS_EDIT)
                .with(csrf())
                .with(user(ADMIN)))
                .andExpect(authenticated().withUsername(ADMIN))
                .andExpect(status().isFound())
                .andReturn();
    }

    @Test
    void updateDiscount() throws Exception {
        this.mockMvc.perform(post(PAGE_DISCOUNTS_UPDATE)
                .with(csrf())
                .with(user(ADMIN)))
                .andExpect(authenticated().withUsername(ADMIN))
                .andExpect(status().isFound())
                .andReturn();
    }

    @Test
    void deleteDiscounts() throws Exception {
        this.mockMvc.perform(post(PAGE_DISCOUNTS_DELETE)
                .with(csrf())
                .with(user(ADMIN)))
                .andExpect(authenticated().withUsername(ADMIN))
                .andExpect(status().isFound())
                .andReturn();
    }
}
