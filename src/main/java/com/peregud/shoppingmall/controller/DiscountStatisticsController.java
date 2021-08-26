package com.peregud.shoppingmall.controller;

import com.peregud.shoppingmall.dto.DiscountStatisticsDto;
import com.peregud.shoppingmall.service.DiscountStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.peregud.shoppingmall.AppConstants.*;

@Controller
@RequiredArgsConstructor
public class DiscountStatisticsController {

    private final DiscountStatisticsService discountStatisticsService;

    @GetMapping(PAGE_DISCOUNT_STATISTICS)
    public String displayDiscountStatistics(Model model) {
        List<DiscountStatisticsDto> listStatistics = discountStatisticsService.displayDiscountSearchStatistics();
        model.addAttribute(ATTR_LIST_STATISTICS, listStatistics);
        return VIEW_DISCOUNT_STATISTICS;
    }
}
