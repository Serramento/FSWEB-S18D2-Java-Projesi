package com.workintech.s18d2.service;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;
    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit getById(long id) {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        if(optionalFruit.isPresent()){
            return optionalFruit.get();
        }
        throw new PlantException("Plant with given id is not exist"+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPricesAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPricesDesc();
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(long id) {
        Fruit fruit= getById(id);
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}
