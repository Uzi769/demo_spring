package com.example.demo.golovin.dao.mapper;

import com.example.demo.golovin.dao.entity.RecipeEntity;
import com.example.demo.golovin.dao.model.recipe.RecipeInput;
import com.example.demo.golovin.dao.model.recipe.RecipeOutput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    RecipeEntity toRecipeEntity(RecipeInput input);
    RecipeOutput toRecipeOutput(RecipeEntity entity);
}
