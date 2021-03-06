package com.peregud.shoppingmall;

public class AppConstants {
    public static final String PARAM_LANG = "lang";
    public static final String PARAM_ID = "id";
    public static final String PARAM_DISCOUNT = "discount";
    public static final String PARAM_START_DATE = "discountStartDate";
    public static final String PARAM_END_DATE = "discountEndDate";
    public static final String PARAM_SHOP_ID = "shopId";
    public static final String PARAM_NAME = "name";
    public static final String PARAM_DESCRIPTION = "description";
    public static final String PARAM_LOCATION = "location";
    public static final String PARAM_MOBILE = "mobile";
    public static final String PARAM_EMAIL = "email";
    public static final String PARAM_USERNAME = "username";
    public static final String PARAM_PASSWORD = "password";
    public static final String PARAM_ROLE = "role";
    public static final String PARAM_DELETE_DISCOUNT = "deleteDiscount";
    public static final String PARAM_DELETE_SHOP = "deleteShop";
    public static final String PARAM_MIN_DISCOUNT = "minimumDiscount";
    public static final String PARAM_SEARCH = "search";
    public static final String PARAM_LOCAL_DATE = "localDate";
    public static final String PARAM_PAGE_NUMBER = "pageNo";

    public static final String ATTR_MIN_DISCOUNT = "minimumDiscount";
    public static final String ATTR_LIST_DISCOUNTS = "listDiscounts";
    public static final String ATTR_LIST_SHOPS = "listShops";
    public static final String ATTR_DISCOUNT = "discount";
    public static final String ATTR_SHOP = "shop";
    public static final String ATTR_LIST_DISCOUNT_SHOPS = "listDiscountShops";
    public static final String ATTR_LIST_STATISTICS = "listStatistics";
    public static final String ATTR_LAST_PAGE = "lastPageNo";

    public static final String PAGE_START = "/";
    public static final String PAGE_ALL = "/*";
    public static final String PAGE_ID = "/{id}";
    public static final String PAGE_MAP = "/map";
    public static final String PAGE_CONTACT = "/contact";
    public static final String PAGE_LOGIN = "/login";
    public static final String PAGE_LOGOUT = "/logout";
    public static final String PAGE_SHOPS_SEARCH = "/user/shops/search";
    public static final String PAGE_SHOPS_FORM = "/admin/shops/add";
    public static final String PAGE_DISCOUNTS_SEARCH = "/user/discounts/search";
    public static final String PAGE_SIGN_UP = "/sign-up-page";
    public static final String PAGE_SUCCESS = "/user/success";
    public static final String PAGE_ACCESS_DENIED = "/access-denied";
    public static final String PAGE_LOGIN_FAILED = "/login-failed";
    public static final String PAGE_LOCALE = "/locale";
    public static final String PAGE_USER_SIGN_UP = "/sign-up-new";
    public static final String PAGE_DISCOUNTS_DISPLAY = "/user/discounts/display";
    public static final String PAGE_DISCOUNTS_INFO = "/user/discounts/info";
    public static final String PAGE_DISCOUNTS_SEARCH_RESULT = "/user/discounts/search-result";
    public static final String PAGE_DISCOUNTS_ACTUAL = "/user/discounts/actual";
    public static final String PAGE_DISCOUNTS_INSERT = "/admin/discounts/insert";
    public static final String PAGE_DISCOUNTS_FULL_LIST = "/user/discounts/full-list";
    public static final String PAGE_DISCOUNTS_EDIT = "/admin/discounts/edit";
    public static final String PAGE_DISCOUNTS_UPDATE = "/admin/discounts/update";
    public static final String PAGE_DISCOUNTS_DELETE = "/admin/discounts/delete-list";
    public static final String PAGE_SHOPS_INFO = "/user/shops/info";
    public static final String PAGE_SHOPS_SEARCH_RESULT = "/user/shops/search-result";
    public static final String PAGE_SHOPS_INSERT = "/admin/shops/insert";
    public static final String PAGE_SHOPS_FULL_LIST = "/user/shops/full-list";
    public static final String PAGE_SHOPS_EDIT = "/admin/shops/edit";
    public static final String PAGE_SHOPS_UPDATE = "/admin/shops/update";
    public static final String PAGE_SHOPS_DELETE = "/admin/shops/delete-list";
    public static final String PAGE_SHOPS_SET_DISCOUNT = "/admin/shops/set-discount";
    public static final String PAGE_SHOP_DISCOUNTS = "/user/shops/discounts";
    public static final String PAGE_USERS_ACCESS = "/user/**";
    public static final String PAGE_ADMIN_ACCESS = "/admin/**";
    public static final String PAGE_DISCOUNT_STATISTICS = "/user/discounts/discount-statistics";
    public static final String PAGE_SHOPS_DISPLAY = "/user/shops/display";

    public static final String VIEW_MAP = "map";
    public static final String VIEW_CONTACT = "contact";
    public static final String VIEW_LOGIN = "login";
    public static final String VIEW_SHOPS_SEARCH = "search-shop";
    public static final String VIEW_SHOPS_ADD = "shop-form";
    public static final String VIEW_DISCOUNTS_SEARCH = "search-discount";
    public static final String VIEW_SIGN_UP = "sign-up";
    public static final String VIEW_SUCCESS = "success";
    public static final String VIEW_ACCESS_DENIED = "access-denied";
    public static final String VIEW_LOGIN_FAILED = "login-failed";
    public static final String VIEW_LOCALE = "locale";
    public static final String VIEW_DISCOUNTS_DISPLAY = "display-discounts";
    public static final String VIEW_DISCOUNTS_INFO = "discount-information";
    public static final String VIEW_SHOPS_AND_DISCOUNTS = "display-discount-shops";
    public static final String VIEW_DISCOUNTS_FULL_LIST = "discounts-list";
    public static final String VIEW_DISCOUNT_FORM = "discount-form";
    public static final String VIEW_DISCOUNT_EDIT_FORM = "edit-discount-form";
    public static final String VIEW_SHOPS_DISPLAY_SEARCHED = "display-searched-shops";
    public static final String VIEW_SHOPS_INFO = "shop-information";
    public static final String VIEW_SHOP_DISCOUNTS = "display-shop-discounts";
    public static final String VIEW_SHOPS_FULL_LIST = "shops-list";
    public static final String VIEW_SHOP_FORM = "shop-form";
    public static final String VIEW_DISCOUNT_STATISTICS = "display-statistics";

    public static final String REDIRECT_SHOPS_FULL_LIST = "redirect:/user/shops/full-list";
    public static final String REDIRECT_DISCOUNTS_FULL_LIST = "redirect:/user/discounts/full-list";

    public static final String CONFIG_MESSAGE_SOURCE = "messageSource";
    public static final String CONFIG_MESSAGES_CLASSPATH = "classpath:i18n/messages";
    public static final String CONFIG_ENCODING = "UTF-8";

    public static final String ID = "id";
    public static final String USER = "user";
    public static final String ADMIN = "admin";
    public static final String PAGE = "page";
    public static final String SIZE = "size";
    public static final Integer PAGE_SIZE = 4;
    public static final String PAGE_NUMBER_DEFAULT = "0";
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "30";
    public static final Integer MAX_PAGE_SIZE = 30;
    public static final String DELETE_SUCCESS = "You successfully deleted shop";

    public static final String ERROR_NEGATIVE_PAGE = "Page number cannot be less than zero";
    public static final String ERROR_NEGATIVE_SIZE = "Size number cannot be less than zero";
    public static final String ERROR_OVERSIZE = "Page size must not be greater than ";
}
