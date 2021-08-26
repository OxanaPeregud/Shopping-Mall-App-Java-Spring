package com.peregud.shoppingmall.listener;

import com.peregud.shoppingmall.converter.builder.DiscountStatisticsBuilder;
import com.peregud.shoppingmall.repository.DiscountStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

import static com.peregud.shoppingmall.AppConstants.ATTR_MIN_DISCOUNT;

@WebListener
@Component
@RequiredArgsConstructor
public class DiscountListener implements ServletRequestAttributeListener {

    private final DiscountStatisticsRepository discountStatisticsRepository;

    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        Object attributeValue = servletRequestAttributeEvent.getValue();
        String attributeName = servletRequestAttributeEvent.getName();
        if (StringUtils.isNotBlank(ATTR_MIN_DISCOUNT) && ATTR_MIN_DISCOUNT.equals(attributeName)) {
            discountStatisticsRepository.save(DiscountStatisticsBuilder
                    .insertDiscountStatistics(attributeValue.toString()));
        }
    }
}
