package com.peregud.shoppingmall.service;

import com.peregud.shoppingmall.domain.Discount;
import com.peregud.shoppingmall.dto.DiscountFullDto;
import com.peregud.shoppingmall.dto.DiscountWithShopDto;
import com.peregud.shoppingmall.dto.ShopDiscountDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountService {

    List<DiscountFullDto> getAll();

    DiscountFullDto getDtoById(Integer id);

    void saveDiscount(Discount discount);

    void updateDiscount(Discount discount, Integer id);

    List<ShopDiscountDto> displayMinimumDiscounts(Integer minimumDiscount);

    List<ShopDiscountDto> displayActualDiscounts();

    List<DiscountWithShopDto> getFullDiscount();

    Discount getById(Integer id);

    void deleteDiscounts(String[] idList);
}
