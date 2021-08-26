package com.peregud.shoppingmall.repository;

import java.time.LocalDate;

public interface ShopDiscountInfo {

    String getName();

    String getLocation();

    Integer getDiscount();

    LocalDate getDiscountStartDate();

    LocalDate getDiscountEndDate();
}
