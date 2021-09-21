package com.example.demo.golovin.controllers;

import com.example.demo.golovin.dao.model.recipe.RecipeInput;
import com.example.demo.golovin.dao.model.recipe.RecipeOutput;
import com.example.demo.golovin.service.RecipeService.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService service;

    @PostMapping()
    public RecipeOutput create(@RequestBody RecipeInput input) {
        return service.create(input);
    }

    @GetMapping()
    public List<RecipeOutput> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public RecipeOutput update(@RequestBody RecipeInput input, @PathVariable Long id) {
        return service.update(input, id);
    }

    @DeleteMapping("/{id}")
    public List<RecipeOutput> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
