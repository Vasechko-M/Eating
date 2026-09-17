package com.vasechko.eating.dto;

import lombok.Data;
/**
 * Передача ингредиента в запросе на создание блюда.
 **/
@Data
public class DishIngredientRequest {
    private Long productId; // идентификатор продукта
    private int quantity; // количество ингредиента
}
