package com.peregud.shoppingmall.config;

import com.peregud.shoppingmall.converter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {

    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new ShopConverter());
        service.addConverter(new DiscountListConverter());
        service.addConverter(new DiscountConverter());
        service.addConverter(new ShopDiscountListConverter());
        service.addConverter(new ShopListConverter());
        service.addConverter(new ShopSearchListConverter());
        service.addConverter(new DiscountFullListConverter());
        service.addConverter(new DiscountWithShopListConverter());
        service.addConverter(new DiscountStatisticsListConverter());
        return service;
    }
}
