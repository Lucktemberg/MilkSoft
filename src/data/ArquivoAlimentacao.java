package data;

import model.Alimentacao;
import model.Animal;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArquivoAlimentacao {


    public static final String NOME_ARQUIVO = "alimentacao.txt";

    public static void salvarAlimentacoes(List<Alimentacao> alimentacoes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Alimentacao a : alimentacoes) {
                bw.write(a.getAnimal().getId() + " - " + a.getTipoAlimento() + " - " + a.getQuantidadeAlimento() + "KG - " + a.getData());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar alimentação! " + e.getMessage());
        }
    }

    public static List<Alimentacao> lerAlimentacoes(List<Animal> animais) {
        List<Alimentacao> alimentacoes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" - ");
                int idAnimal = Integer.parseInt(partes[0]);
                String tipoAlimento = partes[1];
                double quantidadeKg =  Double.parseDouble(partes[2].replace("KG", "").trim());
                LocalDate data = LocalDate.parse(partes[3]);

                Animal animal = buscarAnimalPorId(animais, idAnimal);
                if (animal != null) {
                    Alimentacao alimentacao = new Alimentacao(animal, tipoAlimento, quantidadeKg, data);
                    alimentacoes.add(alimentacao);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler alimentações: " + e.getMessage());
        }
        return alimentacoes;
    }

    private static Animal buscarAnimalPorId(List<Animal> animais, int id) {
        for (Animal a : animais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
}

