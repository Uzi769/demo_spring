package com.example.demo.golovin.repository;

import com.example.demo.golovin.dao.entity.DrinkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface DrinkRepository extends JpaRepository<DrinkEntity, Long> {

    DrinkEntity findByName(String name);

    Optional<DrinkEntity> findById(Long id);

//    @Transactional
//    @Modifying
//    @Query(value = "drop table drinks; ",
////            "drop table databasechangelog;" +
////            "drop table databasechangeloglock;" +
////            "drop table drink_ingredient;" +
////            "drop table drink_recipe;",
//            nativeQuery = true)
//    void dropTable();

}
