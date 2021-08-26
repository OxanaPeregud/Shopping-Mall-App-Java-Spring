package com.peregud.shoppingmall.converter;

import com.peregud.shoppingmall.dto.DiscountDto;
import com.peregud.shoppingmall.repository.DiscountInfo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiscountListConverter implements Converter<List<DiscountInfo>, List<DiscountDto>> {

    @Override
    public List<DiscountDto> convert(List<DiscountInfo> discounts) {
        return discounts.stream()
                .map(discount -> DiscountDto.builder()
                        .discount(discount.getDiscount())
                        .discountStartDate(discount.getDiscountStartDate())
                        .discountEndDate(discount.getDiscountEndDate())
                        .build())
                .collect(Collectors.toList());
    }
}
