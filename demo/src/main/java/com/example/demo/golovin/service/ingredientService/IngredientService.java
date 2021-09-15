package com.example.demo.golovin.service.ingredientService;


import com.example.demo.golovin.dao.model.ingredient.IngredientInput;
import com.example.demo.golovin.dao.model.ingredient.IngredientOutput;

import java.util.List;

public interface IngredientService{
    IngredientOutput create(IngredientInput input);
    IngredientOutput update(IngredientInput input, Long id);
    List<IngredientOutput> getAll();
    List<IngredientOutput> delete(Long id);

}
