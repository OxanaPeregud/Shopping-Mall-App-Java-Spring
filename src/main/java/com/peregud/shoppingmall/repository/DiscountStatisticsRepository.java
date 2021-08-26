package com.peregud.shoppingmall.repository;

import com.peregud.shoppingmall.domain.DiscountStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountStatisticsRepository extends JpaRepository<DiscountStatistics, Integer> {

    @Query("select d.discount as discount, count(*) as count from DiscountStatistics d group by discount")
    List<DiscountStatInfo> displayStatistics();
}
