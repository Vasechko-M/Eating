package com.vasechko.eating.mapper;

import com.vasechko.eating.dto.*;
import com.vasechko.eating.model.*;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DishMapper {

    /**
     * Преобразование сущности Dish в DTO DishResponse для ответа API.
     *
     * @param dish исходная сущность блюда
     * @return DTO, представляющий блюдо в ответе
     */
    @Mapping(target = "available", source = "available")
    DishResponse toDishResponse(Dish dish);

    /**
     * Преобразование DTO DishCreateRequest в сущность Dish для создания.
     * Примечание: список ингредиентов маппится отдельно (ingredients игнорируются здесь).
     *
     * @param dto данные запроса на создание блюда
     * @return новая сущность Dish (без связанных ингредиентов)
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ingredients", ignore = true)
    Dish toDish(DishCreateRequest dto);

    /**
     * Преобразование сущности DishIngredient в DTO DishIngredientResponse.
     *
     * @param di исходная сущность DishIngredient
     * @return DTO ингредиента блюда
     */
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "quantity", source = "quantityRequired")
    DishIngredientResponse toDishIngredientResponse(DishIngredient di);

    /**
     * Создание связанного DishIngredient из DTO DishIngredientRequest и контекста Dish.
     * Используется при сборке списка ингредиентов блюда во время создания.
     * Product заполняется только id; полную сущность нужно подгрузить в сервисе.
     *
     * @param req данные ингредиента из запроса
     * @param dish родительское блюдо, к которому принадлежит ингредиент
     * @return новая сущность DishIngredient, привязанная к переданному блюду
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dish", expression = "java(dish)")
    @Mapping(target = "product", source = "req.productId")
    @Mapping(target = "quantityRequired", source = "req.quantity")
    DishIngredient toDishIngredient(DishIngredientRequest req, @Context Dish dish);

    /**
     * Преобразование коллекции DishIngredient в список DTO DishIngredientResponse.
     *
     * @param list коллекция ингредиентов блюда
     * @return список DTO-ингредиентов
     */
    List<DishIngredientResponse> toIngredientResponseList(Collection<DishIngredient> list);

    /**
     * Преобразование сущности ProcurementItem в DTO ProcurementItemDto.
     *
     * @param pi исходная закупочная позиция
     * @return DTO закупочной позиции
     */
    @Mapping(target = "dishId", source = "relatedDishId")
    ProcurementItemDto toProcurementItemDto(ProcurementItem pi);

    /**
     * Преобразование коллекции ProcurementItem в список DTO ProcurementItemDto.
     *
     * @param list коллекция закупочных позиций
     * @return список DTO закупочных позиций
     */
    List<ProcurementItemDto> toProcurementItemDtoList(Collection<ProcurementItem> list);

    default Product mapProductId(Long productId) {
        if (productId == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productId);
        return product;
    }
}
