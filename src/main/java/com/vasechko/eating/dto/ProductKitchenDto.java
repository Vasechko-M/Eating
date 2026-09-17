package com.vasechko.eating.dto;

import lombok.Data;
import java.math.BigDecimal;

/**
 * DTO продукта на кухне. Представляет продукт в контексте кухни
 **/
@Data
public class ProductKitchenDto {
    private Long id; // идентификатор продукта
    private String name; // название продукта
    private int quantity; // количество на кухне
}
