package com.example.demo.golovin.controllers;


import com.example.demo.golovin.dao.model.ingredient.IngredientInput;
import com.example.demo.golovin.dao.model.ingredient.IngredientOutput;
import com.example.demo.golovin.service.ingredientService.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientServiceImpl service;

    @PostMapping()
    public IngredientOutput create(@RequestBody IngredientInput input) {
        return service.create(input);
    }

    @GetMapping("/{id}")
    public IngredientOutput getById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping()
    public List<IngredientOutput> getAll() {
        return service.findAll();
    }

    @PatchMapping("/{id}")
    public IngredientOutput update(@RequestBody IngredientInput input, @PathVariable("id") Long id) {
        return service.update(input, id);
    }

    @DeleteMapping("/{id}")
    public List<IngredientOutput> delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

}
