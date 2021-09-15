package com.example.demo.golovin.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recipe")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "drink_recipe",
                joinColumns = {@JoinColumn(name = "drink_id", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "recipe_id", referencedColumnName = "id")})
    private List<DrinkEntity> drinks;
    private String name;
    private String body_recipe;
    private int num_order;

}
