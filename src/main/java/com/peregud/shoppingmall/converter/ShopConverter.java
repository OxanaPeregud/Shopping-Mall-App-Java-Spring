package com.peregud.shoppingmall.converter;

import com.peregud.shoppingmall.domain.Shop;
import com.peregud.shoppingmall.dto.ShopDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShopConverter implements Converter<Shop, ShopDto> {

    @Override
    public ShopDto convert(Shop shop) {
        ShopDto.ShopDtoBuilder builder = ShopDto.builder();
        Optional.ofNullable(shop.getId())
                .ifPresent(builder::id);
        return builder
                .name(shop.getName())
                .description(shop.getDescription())
                .location(shop.getLocation())
                .email(shop.getEmail())
                .mobile(shop.getMobile())
                .build();
    }
}
