package com.vasechko.eating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    // количество доступное в соответствующем отделе (кухня/склад)
    private int quantity;

    // цена за штуку (для склада; на кухне может быть null)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ProductLocation location;
}