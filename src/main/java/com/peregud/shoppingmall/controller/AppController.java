package com.peregud.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.peregud.shoppingmall.AppConstants.*;

@Controller
public class AppController {

    @RequestMapping(value = {PAGE_START, PAGE_LOCALE})
    public String staticResource() {
        return VIEW_LOCALE;
    }
}
