package com.peregud.shoppingmall.controller;

import com.peregud.shoppingmall.converter.builder.ShopBuilder;
import com.peregud.shoppingmall.domain.Shop;
import com.peregud.shoppingmall.dto.DiscountDto;
import com.peregud.shoppingmall.dto.ShopDto;
import com.peregud.shoppingmall.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.peregud.shoppingmall.AppConstants.*;

@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping(PAGE_SHOPS_INFO)
    public String displayInfoShop(@RequestParam(PARAM_ID) Integer id, Model model) {
        ShopDto shop = shopService.getDtoById(id);
        model.addAttribute(ATTR_SHOP, shop);
        return VIEW_SHOPS_INFO;
    }

    @PostMapping(PAGE_SHOPS_SEARCH_RESULT)
    public String displaySearchedShops(Model model,
                                       @RequestParam(value = PARAM_SEARCH, required = false) String search) {
        List<ShopDto> listShops = shopService.findShop(search);
        model.addAttribute(ATTR_LIST_SHOPS, listShops);
        return VIEW_SHOPS_DISPLAY_SEARCHED;
    }

    @GetMapping(PAGE_SHOP_DISCOUNTS)
    public String displayShopDiscounts(@RequestParam(PARAM_ID) Integer id, Model model) {
        ShopDto shop = shopService.getDtoById(id);
        List<DiscountDto> listDiscountShops = shopService.displayShopDiscounts(id);
        model.addAttribute(ATTR_SHOP, shop);
        model.addAttribute(ATTR_LIST_DISCOUNT_SHOPS, listDiscountShops);
        return VIEW_SHOP_DISCOUNTS;
    }

    @GetMapping(PAGE_SHOPS_FULL_LIST)
    public String displayShopsFullList(Model model,
                                       @RequestParam(value = PARAM_PAGE_NUMBER, required = false,
                                               defaultValue = PAGE_NUMBER_DEFAULT)
                                               String pageNo) {
        Page<ShopDto> page = shopService.getAll(pageNo);
        List<ShopDto> listShops = page.getContent();
        long totalShopsCount = page.getTotalElements();
        int lastPageNo;
        if (totalShopsCount % PAGE_SIZE != 0) {
            lastPageNo = (int) (totalShopsCount / PAGE_SIZE) + 1;
        } else {
            lastPageNo = (int) (totalShopsCount / PAGE_SIZE);
        }
        model.addAttribute(ATTR_LAST_PAGE, lastPageNo);
        model.addAttribute(ATTR_LIST_SHOPS, listShops);
        return VIEW_SHOPS_FULL_LIST;
    }

    @PostMapping(PAGE_SHOPS_INSERT)
    public ModelAndView insertShop(@RequestParam(required = false, value = PARAM_ID) Integer id,
                                   @RequestParam(PARAM_NAME) String name,
                                   @RequestParam(PARAM_DESCRIPTION) String description,
                                   @RequestParam(PARAM_LOCATION) String location,
                                   @RequestParam(PARAM_EMAIL) String email,
                                   @RequestParam(PARAM_MOBILE) Long mobile,
                                   ModelMap model) {
        Shop shop = ShopBuilder.insertShop(id, name, description, location, email, mobile);
        shopService.saveShop(shop);
        return new ModelAndView(REDIRECT_SHOPS_FULL_LIST, model);
    }

    @GetMapping(PAGE_SHOPS_EDIT)
    public String editShop(@RequestParam(PARAM_ID) Integer id, Model model) {
        Shop shop = shopService.getById(id);
        model.addAttribute(ATTR_SHOP, shop);
        return VIEW_SHOP_FORM;
    }

    @PostMapping(PAGE_SHOPS_UPDATE)
    public ModelAndView updateShop(@RequestParam(PARAM_ID) Integer id,
                                   @RequestParam(PARAM_NAME) String name,
                                   @RequestParam(PARAM_DESCRIPTION) String description,
                                   @RequestParam(PARAM_LOCATION) String location,
                                   @RequestParam(PARAM_EMAIL) String email,
                                   @RequestParam(PARAM_MOBILE) Long mobile,
                                   ModelMap model) {
        Shop shop = ShopBuilder.insertShop(id, name, description, location, email, mobile);
        shopService.updateShop(shop, id);
        return new ModelAndView(REDIRECT_SHOPS_FULL_LIST, model);
    }

    @GetMapping(PAGE_SHOPS_SET_DISCOUNT)
    public String setDiscount(@RequestParam(PARAM_ID) Integer id, ModelMap model) {
        Shop shop = shopService.getById(id);
        model.addAttribute(ATTR_SHOP, shop);
        return VIEW_DISCOUNT_FORM;
    }

    @PostMapping(PAGE_SHOPS_DELETE)
    public ModelAndView deleteShops(@RequestParam(PARAM_DELETE_SHOP) String[] idList, ModelMap model) {
        shopService.deleteShops(idList);
        return new ModelAndView(REDIRECT_SHOPS_FULL_LIST, model);
    }
}
