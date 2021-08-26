package com.peregud.shoppingmall.service;

import com.peregud.shoppingmall.domain.Shop;
import com.peregud.shoppingmall.dto.ShopDto;
import com.peregud.shoppingmall.payload.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ShopRestService {

    ResponseEntity<Page<ShopDto>> getAll(Pageable pageable);

    ResponseEntity<Shop> save(Shop shop);

    ResponseEntity<ShopDto> getShopById(Integer id);

    ResponseEntity<Shop> update(Integer id, Shop shop);

    ResponseEntity<ApiResponse> delete(Integer id);
}
