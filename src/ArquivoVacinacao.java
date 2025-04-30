import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArquivoVacinacao {

    public static final String NOME_ARQUIVO = "vacinacoes.txt";

    public static void salvarVacinacoes(List<Vacinacao> vacinacoes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Vacinacao v : vacinacoes) {
                bw.write(v.getAnimal().getId() + " - " + v.getVacina() + " - " + v.getData());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar vacinação! " + e.getMessage());
        }
    }

    public static List<Vacinacao> lerVacinacoes(List<Animal> animais) {
        List<Vacinacao> vacinacoes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" - ");
                int idAnimal = Integer.parseInt(partes[0]);
                String nomeVacina = partes[1];
                LocalDate data = LocalDate.parse(partes[2]);

                Animal animal = buscarAnimalPorId(animais, idAnimal);
                if (animal != null) {
                    Vacinacao vacinacao = new Vacinacao(animal, nomeVacina, data);
                    vacinacoes.add(vacinacao);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler vacinações: " + e.getMessage());
        }
        return vacinacoes;
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

