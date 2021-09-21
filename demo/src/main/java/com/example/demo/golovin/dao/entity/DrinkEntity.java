package com.example.demo.golovin.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drinks")
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

    @ManyToMany(mappedBy = "drinks", fetch = FetchType.LAZY)
    private List<IngredientEntity> ingredients;

    private String photo_url;

    @ManyToMany(mappedBy = "drinks",fetch = FetchType.LAZY)
    private List<RecipeEntity> recipes;


}
