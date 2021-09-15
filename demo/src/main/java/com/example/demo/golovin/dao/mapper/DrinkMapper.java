package com.example.demo.golovin.dao.mapper;

import com.example.demo.golovin.dao.entity.DrinkEntity;
import com.example.demo.golovin.dao.model.drink.DrinkInput;
import com.example.demo.golovin.dao.model.drink.DrinkOutput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DrinkMapper {
    DrinkEntity toDrinkEntity(DrinkInput drinkInput);
    DrinkOutput toDrinkOutput(DrinkEntity drinkEntity);
}
