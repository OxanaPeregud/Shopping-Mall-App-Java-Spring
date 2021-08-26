package com.peregud.shoppingmall.service.impl;

import com.peregud.shoppingmall.dto.DiscountStatisticsDto;
import com.peregud.shoppingmall.repository.DiscountStatInfo;
import com.peregud.shoppingmall.repository.DiscountStatisticsRepository;
import com.peregud.shoppingmall.service.ConvertService;
import com.peregud.shoppingmall.service.DiscountStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountStatisticsServiceImpl implements DiscountStatisticsService {

    private final DiscountStatisticsRepository discountStatisticsRepository;
    private final ConvertService convertService;

    @Override
    public List<DiscountStatisticsDto> displayDiscountSearchStatistics() {
        return convertService.covertList(
                discountStatisticsRepository.displayStatistics(),
                DiscountStatInfo.class,
                DiscountStatisticsDto.class);
    }
}
