package com.example.demo.golovin.dao.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drinks")
@Builder
public class DrinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty(message = "Поле имя - не может быть пустым!")
    private String name;

    @OneToMany(mappedBy = "drink",fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH} )
    private List<TagEntity> tags;

    @NonNull
    @Min(2)
    @Max(120)
    private Long alcohol;

    private String comment;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "drink_ingredient",
            joinColumns = {@JoinColumn(name="drink_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="ingredient_id", referencedColumnName = "id")})
    private List<IngredientEntity> ingredients;

    private String photo_url;

    @ManyToMany(mappedBy = "drinks",fetch = FetchType.LAZY)
    private List<RecipeEntity> recipes;


}
