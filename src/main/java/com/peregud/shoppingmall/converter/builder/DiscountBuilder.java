package com.peregud.shoppingmall.converter.builder;

import com.peregud.shoppingmall.domain.Discount;
import com.peregud.shoppingmall.domain.Shop;

import java.time.LocalDate;
import java.util.Optional;

public class DiscountBuilder {

    public static Discount insertDiscount(Integer id, Integer discount, LocalDate discountStartDate,
                                          LocalDate discountEndDate, Shop shop) {
        Discount.DiscountBuilder builder = Discount.builder();
        Optional.ofNullable(id)
                .ifPresent(builder::id);
        return Discount.builder()
                .discount(discount)
                .discountStartDate(discountStartDate)
                .discountEndDate(discountEndDate)
                .shop(shop)
                .build();
    }
}
