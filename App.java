import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner p1 = new Scanner(System.in);
        List<Personagem> personagens = new ArrayList<>();

        while (true) {
            System.out.println("Digite o nome do personagem (ou 'sair' para encerrar): ");
            String nome = p1.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("Digite o bônus do personagem: ");
            int bonus = p1.nextInt();
            p1.nextLine();

            Personagem personagem = new Personagem(nome, bonus);
            personagens.add(personagem);

            System.out.println("Personagem adicionado com sucesso!\n");
        }

        List<Integer> iniciativas = new ArrayList<>();

        System.out.println("\n--- Iniciativas ---");
        for (Personagem personagem : personagens) {
            System.out.println("Digite o valor do dado para " + personagem.getNome() + ": ");
            int dado = p1.nextInt();
            p1.nextLine(); 
            int iniciativa = personagem.calcularIniciativa(dado);
            iniciativas.add(iniciativa);
            System.out.println(personagem.toString() + ", Dado: " + dado + ", Iniciativa: " + iniciativa);
        }

        ordenarPorIniciativa(personagens, iniciativas);

        System.out.println("\n--- Ordem de Iniciativa (Maior para Menor) ---");
        for (int i = 0; i < personagens.size(); i++) {
            Personagem personagem = personagens.get(i);
            int iniciativa = iniciativas.get(i);
            System.out.println(personagem.toString() + ", Iniciativa: " + iniciativa);
        }

        p1.close();
    }

    private static void ordenarPorIniciativa(List<Personagem> personagens, List<Integer> iniciativas) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < personagens.size(); i++) {
            indices.add(i);
        }

        Collections.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return iniciativas.get(i2).compareTo(iniciativas.get(i1));
            }
        });

        List<Personagem> personagensOrdenados = new ArrayList<>();
        List<Integer> iniciativasOrdenadas = new ArrayList<>();
        for (int i : indices) {
            personagensOrdenados.add(personagens.get(i));
            iniciativasOrdenadas.add(iniciativas.get(i));
        }

        personagens.clear();
        personagens.addAll(personagensOrdenados);
        iniciativas.clear();
        iniciativas.addAll(iniciativasOrdenadas);
    }
}