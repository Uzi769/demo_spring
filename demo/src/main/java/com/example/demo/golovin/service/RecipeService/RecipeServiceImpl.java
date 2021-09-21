package com.example.demo.golovin.service.RecipeService;

import com.example.demo.golovin.dao.entity.RecipeEntity;
import com.example.demo.golovin.dao.mapper.RecipeMapper;
import com.example.demo.golovin.dao.model.recipe.RecipeInput;
import com.example.demo.golovin.dao.model.recipe.RecipeOutput;
import com.example.demo.golovin.exception.ThereIsNoSuchException;
import com.example.demo.golovin.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeMapper mapper;
    @Autowired
    private RecipeRepository repository;

    @Override
    public RecipeOutput create(RecipeInput input) {
        RecipeEntity entity =mapper.toRecipeEntity(input);
        repository.save(entity);
        return mapper.toRecipeOutput(entity);
    }

    @Override
    public List<RecipeOutput> getAll() {
        return repository.findAll().stream().map(mapper::toRecipeOutput).collect(Collectors.toList());
    }

    @Override
    public List<RecipeOutput> delete(Long id) {
        repository.deleteById(id);
        return repository.findAll().stream().map(mapper::toRecipeOutput).collect(Collectors.toList());
    }

    @Override
    public RecipeOutput update(RecipeInput input, Long id) {
        if(repository.findById(id).isPresent()){
            RecipeEntity entity = repository.findById(id).get();
            updateEntity(entity, input);
            repository.save(entity);
            return mapper.toRecipeOutput(entity);
        }
        else throw new ThereIsNoSuchException();

    }

    private void updateEntity(RecipeEntity entity, RecipeInput input){
        if(!(entity.getName().equals(input.getName())) || input.getName() != null){
            entity.setName(input.getName());
        }
        if(entity.getNum_order() == input.getNum_order() || input.getNum_order() != 0){
            entity.setNum_order(input.getNum_order());
        }


    }
}
