package com.peregud.shoppingmall.service;

import com.peregud.shoppingmall.domain.Discount;
import com.peregud.shoppingmall.dto.DiscountFullDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ConvertServiceImplTest {

    @Autowired
    private ConvertService convertService;

    @Test
    void convertEntity() {
        DiscountFullDto discountFullDto = new DiscountFullDto();
        Discount discount = new Discount();
        assertEquals(discountFullDto, convertService.convertEntity(discount, DiscountFullDto.class));
    }

    @Test
    void covertList() {
        List<DiscountFullDto> discountFullDto = new ArrayList<>();
        List<Discount> discountList = new ArrayList<>();
        assertEquals(discountFullDto, convertService.covertList(discountList, Discount.class, DiscountFullDto.class));
    }
}
