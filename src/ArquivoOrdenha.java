import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArquivoOrdenha {

    public static final String NOME_ARQUIVO = "ordenha.txt";

    public static void salvarOrdenhas(List<Ordenha> ordenhas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Ordenha o : ordenhas) {
                bw.write(o.getAnimal().getId() + " - " + o.getQuantidadeLitros() + " - " + o.getData());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar ordenha! " + e.getMessage());
        }
    }

    public static List<Ordenha> lerOrdenhas(List<Animal> animais) {
        List<Ordenha> ordenhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" - ");
                int idAnimal = Integer.parseInt(partes[0]);
                double litrosLeite = Double.parseDouble(partes[1]);
                LocalDate data = LocalDate.parse(partes[2]);

                Animal animal = buscarAnimalPorId(animais, idAnimal);
                if (animal != null) {
                    Ordenha ordenha = new Ordenha(animal, litrosLeite, data);
                    ordenhas.add(ordenha);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler ordenhas: " + e.getMessage());
        }
        return ordenhas;
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


