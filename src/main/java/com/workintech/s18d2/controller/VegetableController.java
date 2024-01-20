package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.VegetableResponse;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.service.VegetableService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private VegetableService vegetableService;
    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> findAll(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public VegetableResponse get(@Positive @PathVariable long id){
        return new VegetableResponse("succeed", vegetableService.getById(id));
    }

    @GetMapping("/desc")
    public List<Vegetable> findAllDesc(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable save(@Validated @PathVariable Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @GetMapping("/{name}")
    public List<Vegetable> searchByName(@Size(min=2, max=45) @PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@Positive @PathVariable long id){
        return vegetableService.delete(id);
    }
}
