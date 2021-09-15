package com.example.demo.golovin.repository;

import com.example.demo.golovin.dao.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.PreDestroy;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

    TagEntity findByName(String name);

    @PreDestroy
    @Query(value = "drop table tags",
            nativeQuery = true)
    void dropTable();

}
