package com.peregud.shoppingmall.converter;

import com.peregud.shoppingmall.domain.Discount;
import com.peregud.shoppingmall.dto.DiscountFullDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DiscountConverter implements Converter<Discount, DiscountFullDto> {

    @Override
    public DiscountFullDto convert(Discount discount) {
        DiscountFullDto.DiscountFullDtoBuilder builder = DiscountFullDto.builder();
        Optional.ofNullable(discount.getId())
                .ifPresent(builder::id);
        return builder
                .discount(discount.getDiscount())
                .discountStartDate(discount.getDiscountStartDate())
                .discountEndDate(discount.getDiscountEndDate())
                .build();
    }
}
