package com.vasechko.eating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "procurement_items")
@NoArgsConstructor
@AllArgsConstructor
public class ProcurementItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private int missingQuantity;

    // ссылка на создаваемое блюдо, если есть на момент фиксации
    private Long relatedDishId;

    private LocalDateTime createdAt;

    private boolean fulfilled;
}
