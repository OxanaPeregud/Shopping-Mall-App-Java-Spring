package com.peregud.shoppingmall.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "discount")
public class Discount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer discount;

    @Column(name = "start_date")
    private LocalDate discountStartDate;

    @Column(name = "end_date")
    private LocalDate discountEndDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    @ToString.Exclude
    private Shop shop;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return id.equals(discount.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
