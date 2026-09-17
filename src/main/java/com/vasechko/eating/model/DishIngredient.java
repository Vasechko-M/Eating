package com.vasechko.eating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "dish_ingredients")
@NoArgsConstructor
@AllArgsConstructor
public class DishIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // сколько единиц продукта требуется для блюда
    private int quantityRequired;
}
