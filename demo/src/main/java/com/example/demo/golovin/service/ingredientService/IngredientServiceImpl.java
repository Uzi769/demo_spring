package com.example.demo.golovin.service.ingredientService;

import com.example.demo.golovin.dao.entity.IngredientEntity;
import com.example.demo.golovin.dao.mapper.IngredientMapper;
import com.example.demo.golovin.dao.model.ingredient.IngredientInput;
import com.example.demo.golovin.dao.model.ingredient.IngredientOutput;
import com.example.demo.golovin.exception.ThereIsNoSuchException;
import com.example.demo.golovin.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {


    private final IngredientRepository ingredientRepo;

    private final IngredientMapper mapper;


    @Override
    public IngredientOutput create(IngredientInput input) {
        IngredientEntity entity = mapper.toIngredientEntity(input);
        ingredientRepo.save(entity);
        return mapper.toIngredientOutput(entity);
    }

    @Override
    public IngredientOutput findById(Long id) {
        if(ingredientRepo.findById(id).isEmpty()){
            throw new ThereIsNoSuchException();
        }
        return mapper.toIngredientOutput(ingredientRepo.findById(id).get());
    }
    @Transactional
    @Override
    public List<IngredientOutput> findAll() {
        return ingredientRepo.findAll().stream().map(mapper::toIngredientOutput).collect(Collectors.toList());
    }

    @Override
    public IngredientOutput update(IngredientInput input, Long id) {
        IngredientEntity entity = ingredientRepo.findById(id).get();
        updateIng(input, entity);
        ingredientRepo.save(entity);
        return mapper.toIngredientOutput(entity);
    }

    private void updateIng(IngredientInput input, IngredientEntity entity) {
        if (!(input.getName() == null || entity.getName().equals(input.getName()))) {
            entity.setName(input.getName());
        }
        if (!(input.getUnit() == null || entity.getUnit().equals(input.getUnit()))) {
            entity.setUnit(input.getUnit());
        }
        if ((input.getValue() != 0 || entity.getValue() != input.getValue())) {
            entity.setValue(input.getValue());
        }
    }

    @Override
    public List<IngredientOutput> delete(Long id) {
        ingredientRepo.deleteById(id);
        return ingredientRepo.findAll().stream().map(mapper::toIngredientOutput).collect(Collectors.toList());
    }
}
