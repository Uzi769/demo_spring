package com.example.demo.golovin.dao.model.drink;

import lombok.*;

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
    private String testGit;

}
