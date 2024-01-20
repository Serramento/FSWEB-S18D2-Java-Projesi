package com.workintech.s18d2.service;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{

    private VegetableRepository vegetableRepository;
    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }


    @Override
    public Vegetable getById(long id) {
        Optional<Vegetable> vegetableOptional= vegetableRepository.findById(id);
        if(vegetableOptional.isPresent()){
            return vegetableOptional.get();
        }
        throw new PlantException("Vegetable is not found with id: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPricesAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPricesDesc();
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(long id) {
        Vegetable vegetable= getById(id);
        vegetableRepository.delete(vegetable);
        return vegetable;
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
}
