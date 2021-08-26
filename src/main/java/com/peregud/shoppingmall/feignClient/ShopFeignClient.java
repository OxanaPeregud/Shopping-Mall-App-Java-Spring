package com.peregud.shoppingmall.feignClient;

import com.peregud.shoppingmall.domain.Shop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "shopFeign", url = "http://localhost:8181/api/v1/shops")
public interface ShopFeignClient {

    @PostMapping
    Shop save(Shop shop);
}
