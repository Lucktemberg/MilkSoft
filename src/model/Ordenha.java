package model;

import java.time.LocalDate;

public class Ordenha {
    private Animal animal;
    private double quantidadeLitros;
    private LocalDate data;

    public Ordenha(Animal animal, double quantidadeLitros, LocalDate data) {
        this.animal = animal;
        this.quantidadeLitros = quantidadeLitros;
        this.data = data;
    }

    public Animal getAnimal() {
        return animal;
    }

    public double getQuantidadeLitros() {
        return quantidadeLitros;
    }

    public LocalDate getData() {
        return data;
    }
}
