package com.example.demo.golovin.service.drinkService;

import com.example.demo.golovin.dao.entity.DrinkEntity;
import com.example.demo.golovin.dao.mapper.DrinkMapper;
import com.example.demo.golovin.dao.model.drink.DrinkInput;
import com.example.demo.golovin.dao.model.drink.DrinkOutput;
import com.example.demo.golovin.exception.ExistsException;
import com.example.demo.golovin.exception.ShorNameException;
import com.example.demo.golovin.exception.ThereIsNoSuchException;
import com.example.demo.golovin.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    //либо @RequiredArgsConstructor и сделать поля final
    private DrinkRepository drinkRepository;

    @Autowired
    private DrinkMapper mapper;

    @Override
    public DrinkOutput findByName(String name) {
        DrinkEntity drink = drinkRepository.findByName(name);
        if (drink == null) {
            throw new ThereIsNoSuchException();
        }
        return mapper.toDrinkOutput(drink);
    }

    @Override
    public DrinkOutput findById(Long id) {
        if (drinkRepository.findById(id).isEmpty()) {
            throw new ExistsException();
        }
        DrinkEntity drink = drinkRepository.findById(id).orElseThrow(() ->
                new ExistsException());
        return mapper.toDrinkOutput(drink);
    }

    @Override
    public List<DrinkOutput> findAll() {
        List<DrinkEntity> list = drinkRepository.findAll();
        return list.stream().map(mapper::toDrinkOutput).collect((Collectors.toList()));
    }


    @Override
    public DrinkOutput create(DrinkInput drinkInput) {
        if (drinkInput.getName().length() > 30 || drinkInput.getName().length() < 2) {
            throw new ExistsException();
        }

        DrinkEntity drink = mapper.toDrinkEntity(drinkInput);
        drinkRepository.save(drink);

        return mapper.toDrinkOutput(drink);
    }

    @Override
    public DrinkOutput update(DrinkInput drinkInput, Long id) {
        DrinkEntity drink = drinkRepository.findById(id).orElseThrow(ExistsException::new);
        updateDrink(drink, drinkInput);
        drinkRepository.save(drink);
        return mapper.toDrinkOutput(drink);
    }

    @Override
    public List<DrinkOutput> delete(Long id) {
        if (drinkRepository.findById(id).isEmpty()) {
            throw new ThereIsNoSuchException();
        }
        drinkRepository.deleteById(id);
        return drinkRepository.findAll().stream().map(mapper::toDrinkOutput).collect(Collectors.toList());
    }

//    @Override
//    public void delete(Long id) {
//        if (drinkRepository.findById(id).isEmpty()) {
//            throw new ThereIsNoSuchException();
//        }
//        drinkRepository.deleteById(id);
//    }

    private void updateDrink(DrinkEntity drink, DrinkInput drinkInput) {
        if (drinkInput.getName() != null) {
            drink.setName(drinkInput.getName());
        } else throw new ShorNameException();
        if (drinkInput.getAlcohol() != null) {
            drink.setAlcohol(drinkInput.getAlcohol());
        } else throw new ShorNameException();
    }


}
