package com.epam.spring.homework1.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Pet {
    @Autowired
    List<Animal> animalList;

    public void printPets() {
        for (var animal : animalList) {
            System.out.println(animal);
        }
    }
}
