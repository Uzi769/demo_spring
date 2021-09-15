package com.example.demo.golovin.service.drinkService;

import com.example.demo.golovin.dao.model.drink.DrinkInput;
import com.example.demo.golovin.dao.model.drink.DrinkOutput;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DrinkService {

    DrinkOutput findByName(String name);

    DrinkOutput findById(Long id);

    List<DrinkOutput> findAll();

    DrinkOutput create(DrinkInput drinkInput);

    DrinkOutput update(DrinkInput drinkInput, Long id);

    void dropBase();
}
