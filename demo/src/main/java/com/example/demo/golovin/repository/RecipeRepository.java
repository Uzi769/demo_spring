package com.example.demo.golovin.repository;

import com.example.demo.golovin.dao.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.PreDestroy;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    @PreDestroy
    @Query(value = "drop table recipe",
            nativeQuery = true)
    void dropTable();
}
