package com.peregud.shoppingmall.service;

import com.peregud.shoppingmall.dto.DiscountStatisticsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountStatisticsService {

    List<DiscountStatisticsDto> displayDiscountSearchStatistics();
}
