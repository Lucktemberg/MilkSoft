package app;

import controller.CadastrarAnimal;
import controller.RegistrarAlimentacao;
import controller.RegistrarOrdenha;
import controller.RegistrarVacinas;
import data.ArquivoAlimentacao;
import data.ArquivoAnimal;
import data.ArquivoOrdenha;
import data.ArquivoVacinacao;
import model.Alimentacao;
import model.Animal;
import model.Ordenha;
import model.Vacinacao;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criação das listas
        List<Animal> animais = new ArrayList<>();
        List<Ordenha> ordenhas = new ArrayList<>();
        List<Vacinacao> vacinacoes = new ArrayList<>();
        List<Alimentacao> alimentacoes = new ArrayList<>();


        animais = ArquivoAnimal.lerAnimais();
        alimentacoes = ArquivoAlimentacao.lerAlimentacoes(animais);
        ordenhas = ArquivoOrdenha.lerOrdenhas(animais);
        vacinacoes = ArquivoVacinacao.lerVacinacoes(animais);

        String[] opcoes = {
                "Cadastrar Animal",
                "Registrar Alimentacao",
                "Registrar Ordenha",
                "Registrar Vacinacao",
                "Ver animais",
                "Ver alimentacoes",
                "Ver ordenhas",
                "Ver vacinacoes",
                "Sair"
        };

        int opcao;
        do {
            // Exibir o menu
            opcao = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu Principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (opcao) {
                case 0:
                    CadastrarAnimal.cadastrarAnimal(animais);
                    ArquivoAnimal.salvarAnimais(animais);
                    break;
                case 1:
                    RegistrarAlimentacao.registrarAlimentacao(alimentacoes, animais);
                    ArquivoAlimentacao.salvarAlimentacoes(alimentacoes);
                    break;
                case 2:
                    RegistrarOrdenha.registrarOrdenha(ordenhas, animais);
                    ArquivoOrdenha.salvarOrdenhas(ordenhas);
                    break;
                case 3:
                    RegistrarVacinas.registrarVacinas(vacinacoes, animais);
                    ArquivoVacinacao.salvarVacinacoes(vacinacoes);
                    break;
                case 4:
                    StringBuilder sbAnimais = new StringBuilder("Animais cadastrados: \n");
                    for (Animal a : animais) {
                        sbAnimais.append("ID: ").append(a.getId())
                                .append(" | Nome: ").append(a.getNome())
                                .append(" | Raca: ").append(a.getRaca())
                                .append(" | Idade: ").append(a.getIdade()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sbAnimais.toString());
                    break;
                case 5:
                    StringBuilder sbAlimentacao = new StringBuilder("Alimentacoes Registradas: \n");
                    for (Alimentacao al : alimentacoes) {
                        sbAlimentacao.append("Animal: ").append(al.getAnimal().getNome())
                                .append(" | Racao: ").append(al.getTipoAlimento())
                                .append(" | Quantidade: ").append(al.getQuantidadeAlimento())
                                .append(" | Data: ").append(al.getData()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, alimentacoes.toString());
                    break;
                case 6:
                    StringBuilder sbOrdenha = new StringBuilder("Ordenhas Registradas:\n");
                    for (Ordenha o : ordenhas) {
                        sbOrdenha.append("Animal: ").append(o.getAnimal().getNome())
                                .append(" | Litros: ").append(o.getQuantidadeLitros())
                                .append(" | Data: ").append(o.getData()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sbOrdenha.toString());
                    break;
                case 7:
                    StringBuilder sbVacinacao = new StringBuilder("Vacinacoes Registradas:\n");
                    for (Vacinacao v : vacinacoes) {
                        sbVacinacao.append("Animal: ").append(v.getAnimal().getNome())
                                .append(" | Vacina: ").append(v.getVacina())
                                .append(" | Data: ").append(v.getData()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sbVacinacao.toString());
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    break;
                default:
                    break;
            }
        } while (opcao != 8);
    }
}