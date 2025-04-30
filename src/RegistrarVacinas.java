import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class RegistrarVacinas {
    public static void registrarVacinas(List<Vacinacao> vacinacoes, List<Animal> animais) {

        int opcao = 0;

        while (opcao == 0) {
            String listaAnimaisVacinacao = "Escolha o animal para registrar a vacinação: \n";
            for (Animal a : animais) {
                listaAnimaisVacinacao += "ID: " + a.getId() + ", Nome: " + a.getNome() + "\n";
            }

            int idAnimalEscolhido = Integer.parseInt(JOptionPane.showInputDialog(listaAnimaisVacinacao + "Digite o ID do animal: "));
            Animal animalEscolhido = null;

            for (Animal a : animais) {
                if (a.getId() == idAnimalEscolhido) {
                    animalEscolhido = a;
                    break;
                }
            }

            if (animalEscolhido != null) {
                String vacina = JOptionPane.showInputDialog("Digite a vacina aplicada: ");
                LocalDate data = LocalDate.now();
                Vacinacao vacinacao = new Vacinacao(animalEscolhido, vacina, data);
                vacinacoes.add(vacinacao);
                JOptionPane.showMessageDialog(null, "Vacinação registrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Animal não encontrado!");
            }

            opcao = JOptionPane.showConfirmDialog(null, "Deseja registrar outra vacinação?", "Registrar Vacina", JOptionPane.YES_NO_OPTION);
        }

        String listaVacinacoes = "Todas as vacinações registradas: \n";
        for (Vacinacao v : vacinacoes) {
            listaVacinacoes += "Animal: " + v.getAnimal().getNome() + " | Vacina: " + v.getVacina() + " | Data: " + v.getData() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaVacinacoes);
    }
}
