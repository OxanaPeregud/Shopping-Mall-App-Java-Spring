package com.peregud.shoppingmall.converter;

import com.peregud.shoppingmall.dto.ShopDiscountDto;
import com.peregud.shoppingmall.repository.ShopDiscountInfo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopDiscountListConverter implements Converter<List<ShopDiscountInfo>, List<ShopDiscountDto>> {

    @Override
    public List<ShopDiscountDto> convert(List<ShopDiscountInfo> shopDiscounts) {
        return shopDiscounts.stream()
                .map(shopDiscount -> ShopDiscountDto.builder()
                        .name(shopDiscount.getName())
                        .location(shopDiscount.getLocation())
                        .discount(shopDiscount.getDiscount())
                        .discountStartDate(shopDiscount.getDiscountStartDate())
                        .discountEndDate(shopDiscount.getDiscountEndDate())
                        .build())
                .collect(Collectors.toList());
    }
}
