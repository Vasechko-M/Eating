package com.vasechko.eating.dto;

import lombok.Data;
import java.util.List;

/**
 * Представление блюда в ответе API.
 **/
@Data
public class DishResponse {
    private Long id; // идентификатор блюда
    private String name; // название блюда
    private List<DishIngredientResponse> ingredients; // ингредиенты блюда
    private boolean available; // доступно ли блюдо (напр., есть ли ингредиенты в наличии)
}
