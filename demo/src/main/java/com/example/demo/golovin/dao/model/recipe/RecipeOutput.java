package com.example.demo.golovin.dao.model.recipe;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeOutput {
    private String name;
    private String body_recipe;
    private int num_order;

}
