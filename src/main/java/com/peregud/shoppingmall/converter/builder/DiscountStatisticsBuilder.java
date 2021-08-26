package com.peregud.shoppingmall.converter.builder;

import com.peregud.shoppingmall.domain.DiscountStatistics;

public class DiscountStatisticsBuilder {

    public static DiscountStatistics insertDiscountStatistics(String discount) {
        return DiscountStatistics.builder()
                .discount(discount)
                .build();
    }
}
