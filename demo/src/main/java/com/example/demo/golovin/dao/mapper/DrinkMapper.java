package com.example.demo.golovin.dao.mapper;

import com.example.demo.golovin.dao.entity.DrinkEntity;
import com.example.demo.golovin.dao.entity.IngredientEntity;
import com.example.demo.golovin.dao.model.drink.DrinkInput;
import com.example.demo.golovin.dao.model.drink.DrinkOutput;
import com.example.demo.golovin.dao.model.ingredient.IngredientInput;
import com.example.demo.golovin.dao.model.ingredient.IngredientOutput;
import com.example.demo.golovin.repository.IngredientRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
abstract public class DrinkMapper {

    @Autowired
    protected IngredientRepository ingredientRepository;

    @Autowired
    protected IngredientMapper ingredientMapper;

    public abstract DrinkOutput toDrinkOutput(DrinkEntity entity);

    @Mapping(target = "ingredients", expression = "java(ingredientRepository.findAllById(input.getIdIngredients()))")
    public abstract DrinkEntity toDrinkEntity(DrinkInput input);
}
