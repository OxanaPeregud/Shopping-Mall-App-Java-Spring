package com.peregud.shoppingmall.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static com.peregud.shoppingmall.AppConstants.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ShopController.class)
class ShopControllerTest extends MockInit {

    @Test
    void displayInfoShop() throws Exception {
        this.mockMvc.perform(get(PAGE_SHOPS_INFO)
                .param(PARAM_ID, "1")
                .with(csrf())
                .with(user(USER)))
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(view().name(VIEW_SHOPS_INFO))
                .andReturn();
    }

    @Test
    void displayShopDiscounts() throws Exception {
        this.mockMvc.perform(get(PAGE_SHOP_DISCOUNTS)
                .param(PARAM_ID, "1")
                .with(csrf())
                .with(user(ADMIN)))
                .andExpect(status().isOk())
                .andExpect(model().size(2))
                .andExpect(model().attributeExists(ATTR_LIST_DISCOUNT_SHOPS))
                .andExpect(view().name(VIEW_SHOP_DISCOUNTS))
                .andReturn();
    }

    @Test
    void insertShop() throws Exception {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ADMIN);
        this.mockMvc.perform(post(PAGE_SHOPS_INSERT)
                .param(PARAM_NAME, "1")
                .param(PARAM_DESCRIPTION, "1")
                .param(PARAM_LOCATION, "1")
                .param(PARAM_EMAIL, "1")
                .param(PARAM_MOBILE, "1")
                .with(csrf())
                .with(user(ADMIN).authorities(grantedAuthority)))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(PAGE_SHOPS_FULL_LIST))
                .andReturn();
    }

    @Test
    void editShop() throws Exception {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ADMIN);
        this.mockMvc.perform(get(PAGE_SHOPS_EDIT)
                .param(PARAM_ID, "1")
                .with(csrf())
                .with(user(ADMIN).authorities(grantedAuthority)))
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(view().name(VIEW_SHOP_FORM))
                .andReturn();
    }

    @Test
    void updateShop() throws Exception {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ADMIN);
        this.mockMvc.perform(post(PAGE_SHOPS_UPDATE)
                .param(PARAM_ID, "1")
                .param(PARAM_NAME, "1")
                .param(PARAM_DESCRIPTION, "1")
                .param(PARAM_LOCATION, "1")
                .param(PARAM_EMAIL, "1")
                .param(PARAM_MOBILE, "1")
                .with(csrf())
                .with(user(ADMIN).authorities(grantedAuthority)))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(PAGE_SHOPS_FULL_LIST))
                .andReturn();
    }

    @Test
    void setDiscount() throws Exception {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ADMIN);
        this.mockMvc.perform(get(PAGE_SHOPS_SET_DISCOUNT)
                .param(PARAM_ID, "1")
                .with(csrf())
                .with(user(ADMIN).authorities(grantedAuthority)))
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(view().name(VIEW_DISCOUNT_FORM))
                .andReturn();
    }

    @Test
    void deleteShops() throws Exception {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ADMIN);
        this.mockMvc.perform(post(PAGE_SHOPS_DELETE)
                .param(PARAM_DELETE_SHOP, "1")
                .with(csrf())
                .with(user(ADMIN).authorities(grantedAuthority)))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(PAGE_SHOPS_FULL_LIST))
                .andReturn();
    }
}
