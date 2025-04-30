import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class RegistrarAlimentacao {
    public static void registrarAlimentacao(List<Alimentacao> alimentacoes, List<Animal> animais) {

        int opcao = 0;
        while (opcao == 0) {
            String listaAlimentacao = "Escolha o animal para registrar a alimentação: \n";
            for (Animal a : animais) {
                listaAlimentacao += "ID: " + a.getId() + ", Nome: " + a.getNome() + "\n";
            }

            int idAnimalEscolhido = Integer.parseInt(JOptionPane.showInputDialog(listaAlimentacao + "Digite o ID do animal: "));
            Animal animalEscolhido = null;
            for (Animal a : animais) {
                if (a.getId() == idAnimalEscolhido) {
                    animalEscolhido = a;
                    break;
                }
            }
            if (animalEscolhido != null) {
                String tipoAlimento = JOptionPane.showInputDialog("Digite o tipo de alimento: ");
                double quantidadeAlimento = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de alimento (em kg): "));
                LocalDate data = LocalDate.now();
                Alimentacao alimentacao = new Alimentacao(animalEscolhido, tipoAlimento, quantidadeAlimento, data);
                alimentacoes.add(alimentacao);
                JOptionPane.showMessageDialog(null, "Alimentação registrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Animal não encontrado!");
            }

            opcao = JOptionPane.showConfirmDialog(null, "Deseja registrar outra alimentação?", "Registrar Alimentação", JOptionPane.YES_NO_OPTION);
        }

        String listaAlimentacoes = "Todas as alimentações registradas: \n";
        for (
                Alimentacao a : alimentacoes) {
            listaAlimentacoes += "Animal: " + a.getAnimal().getNome() + " | Tipo de Alimento: " + a.getTipoAlimento() + " | Quantidade: " + a.getQuantidadeAlimento() + "kg | Data: " + a.getData() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaAlimentacoes);
    }
}

