package com.example.demo.golovin.dao.model.drink;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrinkOutput {
    private String name;
    private Long alcohol;
}
