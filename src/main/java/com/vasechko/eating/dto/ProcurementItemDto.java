package com.vasechko.eating.dto;

import lombok.Data;

/**
 * DTO позиции закупки, связанных с блюдом.
 * Используется в ответах после создания блюда для передачи данных о закупке.
 **/
@Data
public class ProcurementItemDto {
    private Long id; // идентификатор закупочной позиции
    private String productName; // название продукта закупки
    private int missingQuantity; // недостающее количество продукта
    private Long dishId; // идентификатор блюда, к которому относится закупка
}
