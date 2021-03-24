package com.codecool.farm;

import com.codecool.farm.animal.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Farm {
    private List<Animal> animals;

    public Farm(List<Animal> animals) {
        this.animals = animals;
    }

    void feedAnimals() {
        for (Animal animal: animals) {
            animal.feed();
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    void butcher(Butcher butcher) {
        animals = animals.stream().filter(animal -> !butcher.canButcher(animal)).collect(Collectors.toList());
    }

    boolean isEmpty() {
        return animals.size() == 0;
    }

    List<String> getStatus() {
        List<String> status = new ArrayList<>();

        for (Animal animal: animals) {
            status.add("There is a " + animal.getSize() + " sized " + animal.getClass().getSimpleName().toLowerCase() + " in the farm.");
        }

        return status;
    }

}
