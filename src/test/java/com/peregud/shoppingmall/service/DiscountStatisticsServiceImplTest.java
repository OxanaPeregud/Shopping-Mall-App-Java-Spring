package com.peregud.shoppingmall.service;

import com.peregud.shoppingmall.domain.DiscountStatistics;
import com.peregud.shoppingmall.repository.DiscountStatisticsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DiscountStatisticsServiceImplTest {

    @Autowired
    private DiscountStatisticsService discountStatisticsService;

    @Autowired
    private DiscountStatisticsRepository discountStatisticsRepository;

    @BeforeEach
    void setUp() {
        DiscountStatistics discountStatistics = DiscountStatistics.builder()
                .discount("10")
                .build();
        discountStatisticsRepository.save(discountStatistics);
    }

    @AfterEach
    void cleanUp() {
        discountStatisticsRepository.deleteAll();
        discountStatisticsRepository.flush();
    }

    @Test
    void displayDiscountSearchStatistics() {
        assertEquals("10", discountStatisticsService.displayDiscountSearchStatistics().get(0).getDiscount());
    }
}
