package com.example.demo.golovin.dao.model.drink;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrinkInput {
    private String name;
    private Long alcohol;
    private String comment;
    private String photoUrl;
    private List<Long> idIngredients;


}
