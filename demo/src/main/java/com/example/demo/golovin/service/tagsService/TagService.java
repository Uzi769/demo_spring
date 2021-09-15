package com.example.demo.golovin.service.tagsService;

import com.example.demo.golovin.dao.model.tag.TagInput;
import com.example.demo.golovin.dao.model.tag.TagOutput;

import java.util.List;


public interface TagService {
    TagOutput findByName(String name);

    List<TagOutput> getAll();

    TagOutput create(TagInput tagInput);

    TagOutput update(TagInput tagInput, Long id);

    void delete(Long id);

}
