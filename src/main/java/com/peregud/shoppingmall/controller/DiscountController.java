package com.peregud.shoppingmall.controller;

import com.peregud.shoppingmall.converter.builder.DiscountBuilder;
import com.peregud.shoppingmall.domain.Discount;
import com.peregud.shoppingmall.domain.Shop;
import com.peregud.shoppingmall.dto.DiscountFullDto;
import com.peregud.shoppingmall.dto.DiscountWithShopDto;
import com.peregud.shoppingmall.dto.ShopDiscountDto;
import com.peregud.shoppingmall.service.DiscountService;
import com.peregud.shoppingmall.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

import static com.peregud.shoppingmall.AppConstants.*;

@Controller
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;
    private final ShopService shopService;

    @GetMapping(PAGE_DISCOUNTS_INFO)
    public String infoDiscount(@RequestParam(PARAM_ID) Integer id, Model model) {
        DiscountFullDto discount = discountService.getDtoById(id);
        model.addAttribute(ATTR_DISCOUNT, discount);
        return VIEW_DISCOUNTS_INFO;
    }

    @PostMapping(PAGE_DISCOUNTS_SEARCH_RESULT)
    public String searchMinimumDiscount(@RequestParam(PARAM_MIN_DISCOUNT) Integer minimumDiscount, Model model) {
        List<ShopDiscountDto> listDiscountShops = discountService.displayMinimumDiscounts(minimumDiscount);
        model.addAttribute(ATTR_MIN_DISCOUNT, minimumDiscount);
        model.addAttribute(ATTR_LIST_DISCOUNT_SHOPS, listDiscountShops);
        return VIEW_SHOPS_AND_DISCOUNTS;
    }

    @GetMapping(PAGE_DISCOUNTS_ACTUAL)
    public String displayActualDiscounts(Model model) {
        List<ShopDiscountDto> listDiscountShops = discountService.displayActualDiscounts();
        model.addAttribute(ATTR_LIST_DISCOUNT_SHOPS, listDiscountShops);
        return VIEW_SHOPS_AND_DISCOUNTS;
    }

    @PostMapping(PAGE_DISCOUNTS_INSERT)
    public ModelAndView insertDiscount(@RequestParam(required = false, value = PARAM_ID) Integer id,
                                       @RequestParam(PARAM_DISCOUNT) Integer discount,
                                       @RequestParam(PARAM_START_DATE)
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate discountStartDate,
                                       @RequestParam(PARAM_END_DATE)
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate discountEndDate,
                                       @RequestParam(PARAM_SHOP_ID) Integer shopId,
                                       ModelMap model) {
        Shop shop = shopService.getById(shopId);
        Discount discountInsert = DiscountBuilder.insertDiscount(id, discount, discountStartDate, discountEndDate, shop);
        discountService.saveDiscount(discountInsert);
        return new ModelAndView(REDIRECT_SHOPS_FULL_LIST, model);
    }

    @GetMapping(PAGE_DISCOUNTS_FULL_LIST)
    public String displayDiscountsFullList(Model model) {
        List<DiscountWithShopDto> listDiscounts = discountService.getFullDiscount();
        model.addAttribute(ATTR_LIST_DISCOUNTS, listDiscounts);
        return VIEW_DISCOUNTS_FULL_LIST;
    }

    @GetMapping(PAGE_DISCOUNTS_EDIT)
    public String editDiscount(@RequestParam(PARAM_ID) Integer id, Model model) {
        Discount discount = discountService.getById(id);
        model.addAttribute(ATTR_DISCOUNT, discount);
        Shop shop = shopService.getById(id);
        model.addAttribute(ATTR_SHOP, shop);
        return VIEW_DISCOUNT_EDIT_FORM;
    }

    @PostMapping(PAGE_DISCOUNTS_UPDATE)
    public ModelAndView updateDiscount(@RequestParam(PARAM_ID) Integer id,
                                       @RequestParam(PARAM_DISCOUNT) Integer discount,
                                       @RequestParam(PARAM_START_DATE)
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate discountStartDate,
                                       @RequestParam(PARAM_END_DATE)
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate discountEndDate,
                                       @RequestParam(PARAM_SHOP_ID) Integer shopId,
                                       ModelMap model) {
        Shop shop = shopService.getById(shopId);
        Discount discountNew = DiscountBuilder.insertDiscount(id, discount, discountStartDate, discountEndDate, shop);
        discountService.updateDiscount(discountNew, id);
        return new ModelAndView(REDIRECT_DISCOUNTS_FULL_LIST, model);
    }

    @PostMapping(PAGE_DISCOUNTS_DELETE)
    public ModelAndView deleteDiscounts(@RequestParam(PARAM_DELETE_DISCOUNT) String[] idList, ModelMap model) {
        discountService.deleteDiscounts(idList);
        return new ModelAndView(REDIRECT_DISCOUNTS_FULL_LIST, model);
    }
}
