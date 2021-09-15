package com.example.demo.golovin.service.drinkService;

import com.example.demo.golovin.dao.entity.DrinkEntity;
import com.example.demo.golovin.dao.mapper.DrinkMapper;
import com.example.demo.golovin.dao.model.drink.DrinkInput;
import com.example.demo.golovin.dao.model.drink.DrinkOutput;
import com.example.demo.golovin.exception.NoEntityException;
import com.example.demo.golovin.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    //либо @RequiredArgsConstructor и сделать поля final
    private DrinkRepository drinkRepository;

    @Autowired
    private DrinkMapper mapper;

    @Autowired
    private EntityManager manager;

    @Override
    public DrinkOutput findByName(String name) {
        DrinkEntity drink = drinkRepository.findByName(name);
        return mapper.toDrinkOutput(drink);
    }

    @Override
    public DrinkOutput findById(Long id) {
        if (id == null) {
            throw new NoEntityException("id не может быть равен null");
        }
        DrinkEntity drink = drinkRepository.findById(id).orElseThrow(() ->
                new NoEntityException("Сущности с таким id - не существует!"));
        return mapper.toDrinkOutput(drink);
    }

    @Override
    public List<DrinkOutput> findAll() {
        List<DrinkEntity> list = drinkRepository.findAll();
        return list.stream().map(mapper::toDrinkOutput).collect((Collectors.toList()));
    }


    @Override
    public DrinkOutput create(DrinkInput drinkInput) {
        DrinkEntity drink = mapper.toDrinkEntity(drinkInput);
        drinkRepository.save(drink);

        return mapper.toDrinkOutput(drink);
    }

    @Override
    public DrinkOutput update(DrinkInput drinkInput, Long id) {
        DrinkEntity drink = drinkRepository.findById(id).orElseThrow(()->
                new NoEntityException("Сущности с таким id - не существует!"));
        updateDrink(drink, drinkInput);
        drinkRepository.save(drink);
        return mapper.toDrinkOutput(drink);
    }

    private void updateDrink(DrinkEntity drink, DrinkInput drinkInput){
        if(drinkInput.getName() != null) drink.setName(drinkInput.getName());
        if(drinkInput.getAlcohol() != null) drink.setAlcohol(drinkInput.getAlcohol());
    }
    @PreDestroy
    @Override
    public void dropBase(){
        String sql = "drop table drinks";
        Query query = (Query) manager.createNativeQuery(sql);
    }
}
