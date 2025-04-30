import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class RegistrarOrdenha {
    public static void registrarOrdenha(List<Ordenha> ordenhas, List<Animal> animais) {

        int opcao = 0;

        while (opcao == 0) {
            String listaAnimaisEscolher = "Escolha o animal para registrar a ordenha: \n";
            for (Animal a : animais) {
                listaAnimaisEscolher += "ID: " + a.getId() + ", Nome: " + a.getNome() + "\n";
            }

            int idAnimalEscolhido = Integer.parseInt(JOptionPane.showInputDialog(listaAnimaisEscolher + "Digite o ID do animal: "));

            Animal animalEscolhido = null;
            for (Animal a : animais) {
                if (a.getId() == idAnimalEscolhido) {
                    animalEscolhido = a;
                    break;
                }
            }
            if (animalEscolhido != null) {
                double quantidadeLitros = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de litros: "));
                LocalDate data = LocalDate.now();
                Ordenha ordenha = new Ordenha(animalEscolhido, quantidadeLitros, data);
                ordenhas.add(ordenha);
                JOptionPane.showMessageDialog(null, "Ordenha registrada com sucesso!");

            } else {
                JOptionPane.showMessageDialog(null, "Animal nao encontrado!");
            }
            opcao = JOptionPane.showConfirmDialog(null, "Deseja registrar outra ordenha? ", "Registrar Ordenha", JOptionPane.YES_NO_OPTION);
        }

        String listaOrdenhas = "Todas as ordnhas registradas: \n";
        for (Ordenha o : ordenhas) {
            listaOrdenhas += "Animal: " + o.getAnimal().getNome() + " | " +
                    "Data: " + o.getData() + " | " +
                    "Leite Produzido: " + o.getQuantidadeLitros() + "litros \n";
        }
    }
}
