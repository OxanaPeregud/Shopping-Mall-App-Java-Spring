package com.peregud.shoppingmall.converter;

import com.peregud.shoppingmall.domain.Shop;
import com.peregud.shoppingmall.dto.ShopDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopListConverter implements Converter<List<Shop>, List<ShopDto>> {

    @Override
    public List<ShopDto> convert(List<Shop> shops) {
        return shops.stream()
                .map(shop -> ShopDto.builder()
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
