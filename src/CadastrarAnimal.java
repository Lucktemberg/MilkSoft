import javax.swing.*;
import java.util.List;

public class CadastrarAnimal {
    public static void cadastrarAnimal(List<Animal> animais) {
        int opcao = 0;

        while (opcao == 0) {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do animal: "));
            String nome = JOptionPane.showInputDialog("Informe o nome do animal: ");
            String raca = JOptionPane.showInputDialog("Informe a raca do animal: ");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do animal: "));

            Animal animal = new Animal(id, nome, raca, idade);
            animais.add(animal);

            opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro animal?", "Cadastrar", JOptionPane.YES_NO_OPTION);
        }
        String listaAnimais = "Animal cadastrado: \n";

        for (Animal a : animais) {
            listaAnimais += "ID: " + a.getId() +
                    ", Nome: " + a.getNome() +
                    ", Raca: " + a.getRaca() +
                    ", Idade: " + a.getIdade() + " anos\n";
        }

        JOptionPane.showMessageDialog(null, listaAnimais);
    }
}
