package com.example.demo.golovin.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drinks")
public class DrinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "drink",fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH} )
    private List<TagEntity> tags;

    private Long alcohol;

    private String comment;

    @ManyToMany(mappedBy = "drinks", fetch = FetchType.LAZY)
    private List<IngredientEntity> ingredients;

    private String photo_url;

    @ManyToMany(mappedBy = "drinks",fetch = FetchType.LAZY)
    private List<RecipeEntity> recipes;

    public void dropBase(){

    }

}
