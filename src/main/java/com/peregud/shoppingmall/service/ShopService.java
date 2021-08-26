package com.peregud.shoppingmall.service;

import com.peregud.shoppingmall.domain.Shop;
import com.peregud.shoppingmall.dto.DiscountDto;
import com.peregud.shoppingmall.dto.ShopDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {

    Page<ShopDto> getAll(String pageNo);

    ShopDto getDtoById(Integer id);

    Shop saveShop(Shop shop);

    Shop updateShop(Shop shop, Integer id);

    List<ShopDto> findShop(String search);

    List<DiscountDto> displayShopDiscounts(Integer id);

    Shop getById(Integer id);

    void deleteShops(String[] idList);
}
