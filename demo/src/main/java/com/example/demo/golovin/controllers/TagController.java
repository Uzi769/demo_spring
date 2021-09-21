package com.example.demo.golovin.controllers;

import com.example.demo.golovin.dao.model.tag.TagInput;
import com.example.demo.golovin.dao.model.tag.TagOutput;
import com.example.demo.golovin.service.tagsService.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService service;

    @GetMapping
    public List<TagOutput> getAll() {
        return service.getAll();
    }

    @PostMapping
    public TagOutput create(@RequestBody TagInput tagInput) {
        return service.create(tagInput);
    }

    @PutMapping("/{id}")
    public TagOutput update(@RequestBody TagInput tagInput, @PathVariable Long id) {
        return service.update(tagInput, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
