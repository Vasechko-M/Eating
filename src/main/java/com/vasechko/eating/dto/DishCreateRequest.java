package com.vasechko.eating.dto;

import lombok.Data;
import java.util.List;
/**
 * Используется для передачи данных при создании блюда через API.
 **/
@Data
public class DishCreateRequest {
    private String name; // Название блюда
    private List<DishIngredientRequest> ingredients; //Список ингредиентов для этого блюда
}
