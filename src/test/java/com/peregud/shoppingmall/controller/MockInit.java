package com.peregud.shoppingmall.controller;

import com.peregud.shoppingmall.repository.DiscountRepository;
import com.peregud.shoppingmall.repository.DiscountStatisticsRepository;
import com.peregud.shoppingmall.repository.ShopRepository;
import com.peregud.shoppingmall.repository.UserRepository;
import com.peregud.shoppingmall.security.CustomAuthSuccessHandler;
import com.peregud.shoppingmall.security.DBUserDetailsService;
import com.peregud.shoppingmall.service.DiscountService;
import com.peregud.shoppingmall.service.DiscountStatisticsService;
import com.peregud.shoppingmall.service.ShopService;
import com.peregud.shoppingmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManagerFactory;

@WebMvcTest
public class MockInit {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected DiscountService discountService;

    @MockBean
    protected ShopService shopService;

    @MockBean
    protected DBUserDetailsService dbUserDetailsService;

    @MockBean
    protected CustomAuthSuccessHandler customAuthSuccessHandler;

    @MockBean
    protected EntityManagerFactory entityManagerFactory;

    @MockBean
    protected DiscountRepository discountRepository;

    @MockBean
    protected DiscountStatisticsRepository discountStatisticsRepository;

    @MockBean
    protected ShopRepository shopRepository;

    @MockBean
    protected UserRepository userRepository;

    @MockBean
    protected DiscountStatisticsService discountStatisticsService;

    @MockBean
    protected UserService userService;
}
