package com.example.demo.golovin.service.tagsService;

import com.example.demo.golovin.dao.entity.TagEntity;
import com.example.demo.golovin.dao.mapper.TagMapper;
import com.example.demo.golovin.dao.model.tag.TagInput;
import com.example.demo.golovin.dao.model.tag.TagOutput;
import com.example.demo.golovin.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService{


    private final TagRepository tagRepository;

    private final TagMapper mapper;

    @Override
    public TagOutput findByName(String name) {
        return mapper.toTagOutput(tagRepository.findByName(name));
    }

    @Override
    public List<TagOutput> getAll() {
        List<TagEntity> list = tagRepository.findAll();
        return list.stream().map(mapper::toTagOutput).collect(Collectors.toList());
    }

    @Override
    public TagOutput create(TagInput tagInput) {
        TagEntity tag = tagRepository.save(mapper.toTagEntity(tagInput));
        return mapper.toTagOutput(tag);
    }

    @Override
    public TagOutput update(TagInput tagInput, Long id) {
        TagEntity tagEntity = tagRepository.findById(id).get();
        updateTag(tagInput, tagEntity);
        tagRepository.save(tagEntity);
        return mapper.toTagOutput(tagEntity);
    }

    private void updateTag(TagInput tagInput, TagEntity tag){
           if(tag.getName() != tagInput.getName() && tagInput.getName() != null){
               tag.setName(tagInput.getName());
           }
    }

    @Override
    public void delete(Long id) {
        tagRepository.delete(tagRepository.findById(id).get());
    }
}
