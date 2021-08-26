package com.peregud.shoppingmall.converter;

import com.peregud.shoppingmall.domain.Shop;
import com.peregud.shoppingmall.dto.ShopSearchDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopSearchListConverter implements Converter<List<Shop>, List<ShopSearchDto>> {

    @Override
    public List<ShopSearchDto> convert(List<Shop> shops) {
        return shops.stream()
                .map(shop -> ShopSearchDto.builder()
                        .id(shop.getId())
                        .name(shop.getName())
                        .description(shop.getDescription())
                        .location(shop.getLocation())
                        .email(shop.getEmail())
                        .mobile(shop.getMobile())
                        .build())
                .collect(Collectors.toList());
    }
}
