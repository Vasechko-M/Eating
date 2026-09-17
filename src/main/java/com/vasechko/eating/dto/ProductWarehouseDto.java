package com.vasechko.eating.dto;

import lombok.Data;
import java.math.BigDecimal;

/**
 * DTO продукта на складе
 **/
@Data
public class ProductWarehouseDto {
    private Long id; // идентификатор продукта
    private String name; // название продукта
    private int quantity; // доступное количество на складе
    private BigDecimal price; // цена за единицу
}
