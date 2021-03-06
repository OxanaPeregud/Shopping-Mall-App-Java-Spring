package com.peregud.shoppingmall.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDto {
    private Integer id;
    private String name;
    private String description;
    private String location;
    private String email;
    private Long mobile;
}
