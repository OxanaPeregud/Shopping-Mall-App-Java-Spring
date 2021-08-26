package com.peregud.shoppingmall.service.impl;

import com.peregud.shoppingmall.domain.Shop;
import com.peregud.shoppingmall.dto.ShopDto;
import com.peregud.shoppingmall.exception.ResourceNotFoundException;
import com.peregud.shoppingmall.payload.ApiResponse;
import com.peregud.shoppingmall.repository.DiscountRepository;
import com.peregud.shoppingmall.repository.ShopRepository;
import com.peregud.shoppingmall.service.ConvertService;
import com.peregud.shoppingmall.service.ShopRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.peregud.shoppingmall.AppConstants.DELETE_SUCCESS;
import static com.peregud.shoppingmall.AppConstants.ID;

@Service
@RequiredArgsConstructor
public class ShopRestServiceImpl implements ShopRestService {

    private final ShopRepository shopRepository;
    private final DiscountRepository discountRepository;
    private final ConvertService convertService;

    @Override
    public ResponseEntity<Page<ShopDto>> getAll(Pageable pageable) {
        Page<Shop> shops = shopRepository.findAll(pageable);
        Page<ShopDto> shopDtoPage = shops.map(shop ->
                convertService.convertEntity(shop, ShopDto.class));
        return new ResponseEntity<>(shopDtoPage, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Shop> save(Shop shop) {
        Shop newShop = shopRepository.save(shop);
        return new ResponseEntity<>(newShop, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ShopDto> getShopById(Integer id) {
        Shop shop = shopRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Shop", ID, id));
        ShopDto shopDto = convertService.convertEntity(shop, ShopDto.class);
        return new ResponseEntity<>(shopDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Shop> update(Integer id, Shop newShop) {
        Shop shop = shopRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Shop", ID, id));
        shop.setId(newShop.getId());
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> delete(Integer id) {
        shopRepository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, DELETE_SUCCESS), HttpStatus.OK);
    }
}
