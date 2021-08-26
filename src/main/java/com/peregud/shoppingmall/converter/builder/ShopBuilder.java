package com.peregud.shoppingmall.converter.builder;

import com.peregud.shoppingmall.domain.Shop;

import java.util.Optional;

public class ShopBuilder {

    public static Shop insertShop(Integer id, String name, String description, String location, String email, Long mobile) {
        Shop.ShopBuilder builder = Shop.builder();
        Optional.ofNullable(id)
                .ifPresent(builder::id);
        return Shop.builder()
                .name(name)
                .description(description)
                .location(location)
                .email(email)
                .mobile(mobile)
                .build();
    }
}
