package com.peregud.shoppingmall.converter;

import com.peregud.shoppingmall.dto.DiscountStatisticsDto;
import com.peregud.shoppingmall.repository.DiscountStatInfo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiscountStatisticsListConverter implements Converter<List<DiscountStatInfo>, List<DiscountStatisticsDto>> {

    @Override
    public List<DiscountStatisticsDto> convert(List<DiscountStatInfo> discountStatInfos) {
        return discountStatInfos.stream()
                .map(discount -> DiscountStatisticsDto.builder()
                        .discount(discount.getDiscount())
                        .count(discount.getCount())
                        .build())
                .collect(Collectors.toList());
    }
}
