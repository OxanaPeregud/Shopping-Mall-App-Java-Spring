package com.peregud.shoppingmall.dto;

import com.peregud.shoppingmall.domain.Shop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountWithShopDto {
    private Integer id;
    private Integer discount;
    private LocalDate discountStartDate;
    private LocalDate discountEndDate;
    private Shop shop;
}
