package com.peregud.shoppingmall.repository;

import com.peregud.shoppingmall.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.peregud.shoppingmall.AppConstants.PARAM_ID;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer>, JpaSpecificationExecutor<Shop> {

    @Query("select distinct d.discount as discount, d.discountStartDate as discountStartDate, d.discountEndDate " +
            "as discountEndDate from Shop s left join Discount d on d.shop.id = :id")
    List<DiscountInfo> shopDiscounts(@Param(PARAM_ID) Integer id);
}
