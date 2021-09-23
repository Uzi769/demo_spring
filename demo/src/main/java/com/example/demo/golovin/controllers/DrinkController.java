package com.example.demo.golovin.controllers;

import com.example.demo.golovin.dao.model.drink.DrinkInput;
import com.example.demo.golovin.dao.model.drink.DrinkOutput;
import com.example.demo.golovin.service.drinkService.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin
public class DrinkController {

    private final DrinkService drinkService;

    @GetMapping
    public List<DrinkOutput> getAll() {
        return drinkService.findAll();
    }

    @GetMapping("/drink")
    public DrinkOutput getByName(@RequestParam String name) {
        return drinkService.findByName(name);
    }

    @GetMapping("/{id}")
    public DrinkOutput getId(@PathVariable("id") Long id) {
        return drinkService.findById(id);
    }

    @PostMapping
    public DrinkOutput create(@RequestBody DrinkInput drinkInput) {
        return drinkService.create(drinkInput);
    }

    @PutMapping("/{id}")
    public DrinkOutput update(@PathVariable("id") Long id,
                              @RequestBody DrinkInput drinkInput) {
        return drinkService.update(drinkInput, id);
    }


    @DeleteMapping("/{id}")

    public List<DrinkOutput> deleteById(@PathVariable("id") Long id) {
        return drinkService.delete(id);
    }
}
