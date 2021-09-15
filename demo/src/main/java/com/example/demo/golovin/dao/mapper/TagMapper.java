package com.example.demo.golovin.dao.mapper;

import com.example.demo.golovin.dao.entity.TagEntity;
import com.example.demo.golovin.dao.model.tag.TagInput;
import com.example.demo.golovin.dao.model.tag.TagOutput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagEntity toTagEntity(TagInput tagInput);
    TagOutput toTagOutput(TagEntity tagEntity);
}
