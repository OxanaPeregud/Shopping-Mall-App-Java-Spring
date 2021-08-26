package com.peregud.shoppingmall.service.impl;

import com.peregud.shoppingmall.domain.Shop;
import com.peregud.shoppingmall.dto.DiscountDto;
import com.peregud.shoppingmall.dto.ShopDto;
import com.peregud.shoppingmall.feignClient.ShopFeignClient;
import com.peregud.shoppingmall.repository.DiscountInfo;
import com.peregud.shoppingmall.repository.ShopRepository;
import com.peregud.shoppingmall.service.ConvertService;
import com.peregud.shoppingmall.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.peregud.shoppingmall.AppConstants.PAGE_SIZE;
import static com.peregud.shoppingmall.AppConstants.PARAM_ID;
import static com.peregud.shoppingmall.specification.ShopSpecifications.searchShop;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final ConvertService convertService;
    private final ShopFeignClient shopFeignClient;

    @Override
    public Page<ShopDto> getAll(String pageNo) {
        int gotoPageNo = Integer.parseInt(pageNo);
        Page<Shop> shops = shopRepository.findAll(gotoPage(gotoPageNo));
        return shops.map(shop -> convertService.convertEntity(shop, ShopDto.class));
    }

    @Override
    public ShopDto getDtoById(Integer id) {
        return convertService.convertEntity(shopRepository.getById(id), ShopDto.class);
    }

    @Override
    public Shop saveShop(Shop shop) {
        return shopFeignClient.save(shop);
    }

    @Override
    public Shop updateShop(@NonNull Shop shop, Integer id) {
        Shop shopExisting = shopRepository.getById(id);
        shop.setId(shopExisting.getId());
        return shopRepository.save(shop);
    }

    @Override
    public List<ShopDto> findShop(String search) {
        List<Shop> shops = shopRepository.findAll(searchShop(search));
        return convertService.covertList(shops, Shop.class, ShopDto.class);
    }

    @Override
    public List<DiscountDto> displayShopDiscounts(Integer id) {
        return convertService.covertList(
                shopRepository.shopDiscounts(id),
                DiscountInfo.class,
                DiscountDto.class);
    }

    @Override
    public Shop getById(Integer id) {
        return shopRepository.getById(id);
    }

    @Override
    public void deleteShops(String[] idList) {
        for (String id : idList) {
            shopRepository.deleteById(Integer.parseInt(id));
        }
    }

    private PageRequest gotoPage(int page) {
        return PageRequest.of(page, PAGE_SIZE, Sort.Direction.ASC, PARAM_ID);
    }
}
