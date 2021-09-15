package com.example.demo.golovin.repository;


import com.example.demo.golovin.dao.entity.IngredientEntity;
import com.example.demo.golovin.dao.model.ingredient.IngredientOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.PreDestroy;


public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
    @PreDestroy
    @Query(value = "drop table ingredients",
            nativeQuery = true)
    void dropTable();
}
