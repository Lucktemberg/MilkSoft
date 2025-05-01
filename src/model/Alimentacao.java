package model;

import java.time.LocalDate;

public class Alimentacao {
    private Animal animal;
    private String tipoAlimento;
    private double quantidadeAlimento;
    private LocalDate data;

    public Alimentacao(Animal animal, String tipoAlimento, double quantidadeAlimento, LocalDate data) {
        this.animal = animal;
        this.tipoAlimento = tipoAlimento;
        this.quantidadeAlimento = quantidadeAlimento;
        this.data = data;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public double getQuantidadeAlimento() {
        return quantidadeAlimento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public void setQuantidadeAlimento(double quantidadeAlimento) {
        this.quantidadeAlimento = quantidadeAlimento;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Animal: " + animal.getNome() + "\n" +
                ", Data: " + data +
                ", Tipo de Alimento: " + tipoAlimento +
                ", Quantidade: " + quantidadeAlimento + " ";
    }
}
