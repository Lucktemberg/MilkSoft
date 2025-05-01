package controller;

import model.Animal;

import javax.swing.*;
import java.util.List;

public class CadastrarAnimal {
    public static void cadastrarAnimal(List<Animal> animais) {
        int opcao = 0;

        while (opcao == 0) {
            try {
                String inputId = JOptionPane.showInputDialog("Informe o ID do animal: ");
                if (inputId == null) return;
                int id = Integer.parseInt(inputId.trim());
                if (id <= 0) throw new IllegalArgumentException("ID deve ser maior que zero.");

                String nome = JOptionPane.showInputDialog("Informe o nome do animal: ");
                if (nome == null || nome.trim().isEmpty())
                    throw new IllegalArgumentException("Nome nao pode estar vazio.");

                String raca = JOptionPane.showInputDialog("Informe a raca do animal: ");
                if (raca == null || raca.trim().isEmpty())
                    throw new IllegalArgumentException("Raca nao pode ser vazia.");

                String inputIdade = JOptionPane.showInputDialog("Informe a inputIdade do animal: ");
                if (inputIdade == null) return;
                int idade = Integer.parseInt(inputIdade.trim());
                if (idade < 0) throw new IllegalArgumentException("Idade nao pode ser menor que zero.");

                Animal animal = new Animal(id, nome, raca, idade);
                animais.add(animal);

                JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite valores numericos para o ID e idade.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro animal?", "Cadastrar", JOptionPane.YES_NO_OPTION);
        }

        StringBuilder listaAnimais = new StringBuilder("Animais cadastrados:\n");
        for (Animal a : animais) {
            listaAnimais.append("ID: ").append(a.getId())
                    .append(", Nome: ").append(a.getNome())
                    .append(", Raça: ").append(a.getRaca())
                    .append(", Idade: ").append(a.getIdade()).append(" anos\n");
        }

        JOptionPane.showMessageDialog(null, listaAnimais.toString());
    }
}
