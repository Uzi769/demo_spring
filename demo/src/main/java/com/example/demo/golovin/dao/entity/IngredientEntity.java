package com.example.demo.golovin.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ingredients")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "value_ingredient")
    private Long value;
    private String unit;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "drink_ingredient",
            joinColumns = {@JoinColumn(name="drink_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="ingredient_id", referencedColumnName = "id")})
    private List<DrinkEntity> drinks;


}
