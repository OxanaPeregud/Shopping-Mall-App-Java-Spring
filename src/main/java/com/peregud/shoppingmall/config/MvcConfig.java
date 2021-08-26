package com.peregud.shoppingmall.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

import static com.peregud.shoppingmall.AppConstants.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean(name = CONFIG_MESSAGE_SOURCE)
    public MessageSource getMessageResource() {
        ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
        messageResource.setBasename(CONFIG_MESSAGES_CLASSPATH);
        messageResource.setDefaultEncoding(CONFIG_ENCODING);
        return messageResource;
    }

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName(PARAM_LANG);
        registry.addInterceptor(localeInterceptor).addPathPatterns(PAGE_ALL);
    }

    @Override
    public void addViewControllers(@NonNull ViewControllerRegistry registry) {
        registry.addViewController(PAGE_MAP).setViewName(VIEW_MAP);
        registry.addViewController(PAGE_CONTACT).setViewName(VIEW_CONTACT);
        registry.addViewController(PAGE_LOGIN).setViewName(VIEW_LOGIN);
        registry.addViewController(PAGE_SHOPS_SEARCH).setViewName(VIEW_SHOPS_SEARCH);
        registry.addViewController(PAGE_SHOPS_FORM).setViewName(VIEW_SHOPS_ADD);
        registry.addViewController(PAGE_DISCOUNTS_SEARCH).setViewName(VIEW_DISCOUNTS_SEARCH);
        registry.addViewController(PAGE_SIGN_UP).setViewName(VIEW_SIGN_UP);
        registry.addViewController(PAGE_SUCCESS).setViewName(VIEW_SUCCESS);
        registry.addViewController(PAGE_ACCESS_DENIED).setViewName(VIEW_ACCESS_DENIED);
        registry.addViewController(PAGE_LOGIN_FAILED).setViewName(VIEW_LOGIN_FAILED);
    }
}
