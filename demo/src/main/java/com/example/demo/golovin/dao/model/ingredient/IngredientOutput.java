package com.example.demo.golovin.dao.model.ingredient;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientOutput {
    private String name;
    private Long value;
    private String unit;
}
