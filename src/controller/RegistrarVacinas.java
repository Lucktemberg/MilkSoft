package controller;

import model.Animal;
import model.Vacinacao;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class RegistrarVacinas {
    public static void registrarVacinas(List<Vacinacao> vacinacoes, List<Animal> animais) {
        int opcao = 0;

        if (animais.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum animal cadastrado! Não é possível registrar vacinacao.");
            return;
        }

        while (opcao == 0) {
            try {
                StringBuilder listaAnimaisVacinacao = new StringBuilder("Escolha o animal para registrar a vacinacao:\n");
                for (Animal a : animais) {
                    listaAnimaisVacinacao.append("ID: ").append(a.getId()).append(", Nome: ").append(a.getNome()).append("\n");
                }

                String inputId = JOptionPane.showInputDialog(listaAnimaisVacinacao + "Digite o ID do animal:");
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
                    JOptionPane.showMessageDialog(null, "Animal não encontrado com o ID informado.");
                    continue;
                }

                String vacina = JOptionPane.showInputDialog("Digite o nome da vacina aplicada:");
                if (vacina == null || vacina.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nome da vacina não pode ser vazio.");
                    continue;
                }

                LocalDate data = LocalDate.now();
                Vacinacao vacinacao = new Vacinacao(animalEscolhido, vacina.trim(), data);
                vacinacoes.add(vacinacao);

                JOptionPane.showMessageDialog(null, "Vacinacao registrada com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um valor numerico valido para o ID.");
            }

            opcao = JOptionPane.showConfirmDialog(null, "Deseja registrar outra vacinação?", "Registrar Vacina", JOptionPane.YES_NO_OPTION);
        }

        if (!vacinacoes.isEmpty()) {
            StringBuilder listaVacinacoes = new StringBuilder("Todas as vacinações registradas:\n");
            for (Vacinacao v : vacinacoes) {
                listaVacinacoes.append("Animal: ").append(v.getAnimal().getNome())
                        .append(" | Vacina: ").append(v.getVacina())
                        .append(" | Data: ").append(v.getData()).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaVacinacoes.toString());
        }
    }
}
