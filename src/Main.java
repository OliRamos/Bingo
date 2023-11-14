import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------- ");
        System.out.println(" B I N G O  D O S  'J U N I N'  5 0 + ");
        System.out.println("---------------------------------------- \n");

        System.out.println("Entre com os nomes dos participantes separadas por vírgula ','.");
        System.out.println("Exemplo: Fulano, Cicrana, Beltrana:");
        System.out.print("Digite os nomes aqui: -> ");
        String entradaNomes = sc.nextLine();

        String[] nomesDosJogadores = entradaNomes.split(",");

        for (int i = 0; i < nomesDosJogadores.length; i++) {
            System.out.println("Nome do Jogador (a): " + nomesDosJogadores[i]);

        }






    }
}
