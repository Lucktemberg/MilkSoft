package model;

import java.time.LocalDate;

public class Vacinacao {
    private Animal animal;
    private String vacina;
    private LocalDate data;

    public Vacinacao(Animal animal, String vacina, LocalDate data) {
        this.animal = animal;
        this.vacina = vacina;
        this.data = data;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getVacina() {
        return vacina;
    }

    public LocalDate getData() {
        return data;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
