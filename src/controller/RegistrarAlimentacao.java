package controller;

import model.Alimentacao;
import model.Animal;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class RegistrarAlimentacao {
    public static void registrarAlimentacao(List<Alimentacao> alimentacoes, List<Animal> animais) {

        int opcao = 0;
        while (opcao == 0) {
            StringBuilder listaAlimentacao = new StringBuilder("Escolha o animal para registrar a alimentação:\n");
            for (Animal a : animais) {
                listaAlimentacao.append("ID: ").append(a.getId()).append(", Nome: ").append(a.getNome()).append("\n");
            }

            String inputId = JOptionPane.showInputDialog(listaAlimentacao + "Digite o ID do animal:");
            if (inputId == null || inputId.trim().isEmpty()) return;

            int idAnimalEscolhido;
            try {
                idAnimalEscolhido = Integer.parseInt(inputId.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID inválido. Digite apenas números.");
                continue;
            }

            Animal animalEscolhido = null;
            for (Animal a : animais) {
                if (a.getId() == idAnimalEscolhido) {
                    animalEscolhido = a;
                    break;
                }
            }

            if (animalEscolhido != null) {
                String tipoAlimento;
                do {
                    tipoAlimento = JOptionPane.showInputDialog("Digite o tipo de alimento:");
                    if (tipoAlimento == null) return;
                    if (tipoAlimento.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Tipo de alimento não pode estar vazio.");
                    }
                } while (tipoAlimento.trim().isEmpty());

                double quantidadeAlimento = 0;
                boolean quantidadeValida = false;
                while (!quantidadeValida) {
                    String inputQuantidade = JOptionPane.showInputDialog("Digite a quantidade de alimento (em kg):");
                    if (inputQuantidade == null) return;

                    try {
                        quantidadeAlimento = Double.parseDouble(inputQuantidade.replace(",", ".").trim());
                        if (quantidadeAlimento <= 0) {
                            JOptionPane.showMessageDialog(null, "A quantidade deve ser maior que zero.");
                        } else {
                            quantidadeValida = true;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Digite um número válido (ex: 5.5).");
                    }
                }

                Alimentacao alimentacao = new Alimentacao(animalEscolhido, tipoAlimento, quantidadeAlimento, LocalDate.now());
                alimentacoes.add(alimentacao);
                JOptionPane.showMessageDialog(null, "Alimentação registrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Animal não encontrado!");
            }

            opcao = JOptionPane.showConfirmDialog(null, "Deseja registrar outra alimentação?", "Registrar Alimentação", JOptionPane.YES_NO_OPTION);
        }

        StringBuilder listaAlimentacoes = new StringBuilder("Todas as alimentações registradas:\n");
        for (Alimentacao a : alimentacoes) {
            listaAlimentacoes.append("• Animal: ").append(a.getAnimal().getNome())
                    .append(" | Alimento: ").append(a.getTipoAlimento())
                    .append(" | Quantidade: ").append(a.getQuantidadeAlimento()).append("kg")
                    .append(" | Data: ").append(a.getData()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaAlimentacoes.toString());
    }
}
