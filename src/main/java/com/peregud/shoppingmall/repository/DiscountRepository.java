package com.peregud.shoppingmall.repository;

import com.peregud.shoppingmall.domain.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.peregud.shoppingmall.AppConstants.PARAM_LOCAL_DATE;
import static com.peregud.shoppingmall.AppConstants.PARAM_MIN_DISCOUNT;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {

    @Query("select s.name as name, s.location as location, d.discount as discount, " +
            "d.discountStartDate as discountStartDate, d.discountEndDate as discountEndDate from Discount d " +
            "left join Shop s on d.shop.id = s.id where d.discount >= :minimumDiscount")
    List<ShopDiscountInfo> minimumDiscount(@Param(PARAM_MIN_DISCOUNT) Integer minimumDiscount);

    @Query("select s.name as name, s.location as location, d.discount as discount, d.discountStartDate " +
            "as discountStartDate, d.discountEndDate as discountEndDate from Discount d " +
            "left join Shop s on d.shop.id = s.id where d.discountEndDate >= :localDate")
    List<ShopDiscountInfo> actualDiscounts(@Param(PARAM_LOCAL_DATE) LocalDate localDate);
}
