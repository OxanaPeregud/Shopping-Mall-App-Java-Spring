package com.peregud.shoppingmall.repository;

import java.time.LocalDate;

public interface DiscountInfo {

    Integer getDiscount();

    LocalDate getDiscountStartDate();

    LocalDate getDiscountEndDate();
}
