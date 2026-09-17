package com.vasechko.eating.dto;

import lombok.Data;

/**
 * Представление ингредиента блюда в ответе.
 **/
@Data
public class DishIngredientResponse {
    private Long productId; // идентификатор продукта
    private String productName; // название продукта
    private int quantity; // количество ингредиента
}
