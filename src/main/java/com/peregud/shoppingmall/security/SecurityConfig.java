package com.peregud.shoppingmall.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import static com.peregud.shoppingmall.AppConstants.*;

@Configuration
@EnableConfigurationProperties
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DBUserDetailsService DBUserDetailsService;
    private final CustomAuthSuccessHandler customAuthSuccessHandler;

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(PAGE_START, PAGE_LOCALE, PAGE_MAP, PAGE_CONTACT, PAGE_SIGN_UP, PAGE_LOGIN,
                        PAGE_USER_SIGN_UP, PAGE_LOGIN_FAILED, PAGE_ACCESS_DENIED).permitAll()
                .antMatchers(PAGE_USERS_ACCESS).authenticated()
                .antMatchers(PAGE_ADMIN_ACCESS).hasAuthority(ADMIN)
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and().formLogin().loginPage(PAGE_LOGIN)
                .successHandler(customAuthSuccessHandler)
                .failureUrl(PAGE_LOGIN_FAILED).usernameParameter(PARAM_USERNAME)
                .passwordParameter(PARAM_PASSWORD)
                .and().logout().logoutUrl(PAGE_LOGOUT).logoutSuccessUrl(PAGE_LOCALE);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(DBUserDetailsService);
    }
}
