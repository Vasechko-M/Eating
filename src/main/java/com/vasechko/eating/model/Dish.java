package com.vasechko.eating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "dishes")
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<DishIngredient> ingredients = new HashSet<>();

    // пример помощи: проверить доступность блюда по запасам на кухне
    public boolean isAvailable() {
        return ingredients.stream().allMatch(i ->
                i.getProduct() != null && i.getProduct().getQuantity() >= i.getQuantityRequired()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DishIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<DishIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
