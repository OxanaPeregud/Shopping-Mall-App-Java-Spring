package com.peregud.shoppingmall.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountFullDto {
    private Integer id;
    private Integer discount;
    private LocalDate discountStartDate;
    private LocalDate discountEndDate;
}
