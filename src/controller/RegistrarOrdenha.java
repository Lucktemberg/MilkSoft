package controller;

import model.Animal;
import model.Ordenha;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class RegistrarOrdenha {
    public static void registrarOrdenha(List<Ordenha> ordenhas, List<Animal> animais) {

        int opcao = 0;

        if (animais.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum animal cadastrado! Nao e possivel registrar ordenha!");
            return;
        }
        while (opcao == 0) {
            try {

                StringBuilder listaAnimaisEscolher = new StringBuilder("Escolha o animal para registrar a ordenha: \n");
                for (Animal a : animais) {
                    listaAnimaisEscolher.append("ID: ").append(a.getId()).append(", Nome: ").append(a.getNome()).append("\n");
                }

                String inputId = JOptionPane.showInputDialog(listaAnimaisEscolher + "Digite o ID do animal:");
                if (inputId == null) return;
                int idAnimalEscolhido = Integer.parseInt(inputId.trim());

                Animal animalEscolhido = null;
                for (Animal a : animais) {
                    if (a.getId() == idAnimalEscolhido) {
                        animalEscolhido = a;
                        break;
                    }
                }
                if (animalEscolhido == null) {
                    JOptionPane.showMessageDialog(null, "Animal nao encontrado com o ID informado.");
                    continue;
                }
                String inputLitros = JOptionPane.showInputDialog("Digite a quantidade de litros de leite: ");
                if (inputLitros == null) return;
                double quantidadeLitros = Double.parseDouble(inputLitros.trim());
                if (quantidadeLitros <= 0) throw new IllegalArgumentException("Quantidade deve ser maior que zero");

                LocalDate data = LocalDate.now();
                Ordenha ordenha = new Ordenha(animalEscolhido, quantidadeLitros, data);
                ordenhas.add(ordenha);

                JOptionPane.showMessageDialog(null, "Ordenha registrada com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite valores numericos validos para ID e quantidade de leite.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            opcao = JOptionPane.showConfirmDialog(null, "Deseja registrar outra ordenha? ", "Registrar model.Ordenha", JOptionPane.YES_NO_OPTION);
        }

        if (!ordenhas.isEmpty()) {
            StringBuilder listaOrdenhas = new StringBuilder("Todas as ordenhas registradas:\n");
            for (Ordenha o : ordenhas) {
                listaOrdenhas.append("Animal: ").append(o.getAnimal().getNome())
                        .append(" | Data: ").append(o.getData())
                        .append(" | Leite Produzido: ").append(o.getQuantidadeLitros()).append(" litros\n");
            }
            JOptionPane.showMessageDialog(null, listaOrdenhas.toString());
        }
    }
}