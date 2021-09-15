package com.example.demo.golovin.dao.model.recipe;

import com.example.demo.golovin.dao.entity.DrinkEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeInput {
    private String name;
    private String body_recipe;
    private int num_order;
}
