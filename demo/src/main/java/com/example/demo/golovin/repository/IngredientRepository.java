package com.example.demo.golovin.repository;


import com.example.demo.golovin.dao.entity.IngredientEntity;
import com.example.demo.golovin.dao.model.ingredient.IngredientOutput;
import lombok.NonNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
//    @Override
//    Optional<IngredientEntity> findById(Long aLong);

//    @Override
//    List<IngredientEntity> findAllById(@NonNull Iterable<Long> iterable);
}
