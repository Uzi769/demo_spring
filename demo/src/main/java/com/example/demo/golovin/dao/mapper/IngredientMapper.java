package com.example.demo.golovin.dao.mapper;


import com.example.demo.golovin.dao.entity.IngredientEntity;
import com.example.demo.golovin.dao.model.ingredient.IngredientInput;
import com.example.demo.golovin.dao.model.ingredient.IngredientOutput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper {
    IngredientOutput toIngredientOutput(IngredientEntity entity);
    IngredientEntity toIngredientEntity(IngredientInput input);
}
