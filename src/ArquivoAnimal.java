import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoAnimal {

    private static final String NOME_ARQUIVO = "animais.txt";

    public static void salvarAnimais(List<Animal> animais) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Animal a : animais) {
                bw.write(a.getId() + " - " + a.getNome() + " - " + a.getRaca() + " - " + a.getIdade());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar animal!" + e.getMessage());
        }
    }


    public static List<Animal> lerAnimais() {
        List<Animal> animais = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" - ");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String raca = partes[2];
                int idade = Integer.parseInt(partes[3]);

                Animal animal = new Animal(id, nome, raca, idade);
                animais.add(animal);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler animais: " + e.getMessage());
        }
        return animais;
    }
}


