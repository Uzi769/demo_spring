package com.example.demo.golovin.service.RecipeService;

import com.example.demo.golovin.dao.model.recipe.RecipeInput;
import com.example.demo.golovin.dao.model.recipe.RecipeOutput;

import java.util.List;

public interface RecipeService {
    RecipeOutput create(RecipeInput input);
    RecipeOutput update(RecipeInput input, Long id);
    List<RecipeOutput> getAll();
    List<RecipeOutput> delete(Long id);
}
