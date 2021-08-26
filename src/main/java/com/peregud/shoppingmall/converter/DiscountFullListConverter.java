package com.peregud.shoppingmall.converter;

import com.peregud.shoppingmall.domain.Discount;
import com.peregud.shoppingmall.dto.DiscountFullDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiscountFullListConverter implements Converter<List<Discount>, List<DiscountFullDto>> {

    @Override
    public List<DiscountFullDto> convert(List<Discount> discounts) {
        return discounts.stream()
                .map(discount -> DiscountFullDto.builder()
                        .id(discount.getId())
                        .discount(discount.getDiscount())
                        .discountStartDate(discount.getDiscountStartDate())
                        .discountEndDate(discount.getDiscountEndDate())
                        .build())
                .collect(Collectors.toList());
    }
}
