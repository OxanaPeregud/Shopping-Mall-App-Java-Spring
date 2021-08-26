package com.peregud.shoppingmall.converter;

import com.peregud.shoppingmall.domain.Discount;
import com.peregud.shoppingmall.dto.DiscountWithShopDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiscountWithShopListConverter implements Converter<List<Discount>, List<DiscountWithShopDto>> {

    @Override
    public List<DiscountWithShopDto> convert(List<Discount> discounts) {
        return discounts.stream()
                .map(discount -> DiscountWithShopDto.builder()
                        .id(discount.getId())
                        .discount(discount.getDiscount())
                        .discountStartDate(discount.getDiscountStartDate())
                        .discountEndDate(discount.getDiscountEndDate())
                        .shop(discount.getShop())
                        .build())
                .collect(Collectors.toList());
    }
}
