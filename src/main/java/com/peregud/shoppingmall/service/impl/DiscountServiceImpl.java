package com.peregud.shoppingmall.service.impl;

import com.peregud.shoppingmall.domain.Discount;
import com.peregud.shoppingmall.dto.DiscountFullDto;
import com.peregud.shoppingmall.dto.DiscountWithShopDto;
import com.peregud.shoppingmall.dto.ShopDiscountDto;
import com.peregud.shoppingmall.repository.DiscountRepository;
import com.peregud.shoppingmall.repository.ShopDiscountInfo;
import com.peregud.shoppingmall.service.ConvertService;
import com.peregud.shoppingmall.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final ConvertService convertService;

    @Override
    public List<DiscountFullDto> getAll() {
        return convertService.covertList(
                discountRepository.findAll(),
                Discount.class,
                DiscountFullDto.class);
    }

    @Override
    public DiscountFullDto getDtoById(Integer id) {
        return convertService.convertEntity(discountRepository.getById(id), DiscountFullDto.class);
    }

    @Override
    public void saveDiscount(Discount discount) {
        discountRepository.save(discount);
    }

    @Override
    public void updateDiscount(@NonNull Discount discount, Integer id) {
        Discount discountExisting = discountRepository.getById(id);
        discount.setId(discountExisting.getId());
        discountRepository.save(discount);
    }

    @Override
    public List<ShopDiscountDto> displayMinimumDiscounts(Integer minimumDiscount) {
        return convertService.covertList(
                discountRepository.minimumDiscount(minimumDiscount),
                ShopDiscountInfo.class,
                ShopDiscountDto.class);
    }

    @Override
    public List<ShopDiscountDto> displayActualDiscounts() {
        LocalDate localDate = LocalDate.now();
        return convertService.covertList(
                discountRepository.actualDiscounts(localDate),
                ShopDiscountInfo.class,
                ShopDiscountDto.class);
    }

    @Override
    public List<DiscountWithShopDto> getFullDiscount() {
        return convertService.covertList(
                discountRepository.findAll(),
                Discount.class,
                DiscountWithShopDto.class);
    }

    @Override
    public Discount getById(Integer id) {
        return discountRepository.getById(id);
    }

    @Override
    public void deleteDiscounts(String[] idList) {
        for (String id : idList) {
            discountRepository.deleteById(Integer.parseInt(id));
        }
    }
}
