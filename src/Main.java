import java.util.Arrays;
import java.util.Random;
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

        String[] nomesDosJogadores = entradaNomes.split(", ");
        String[][] cartelasJogadores = new String[nomesDosJogadores.length][6];
        int qtdNumerosCartela = 5;








    }

    public static int[] sorteiaNumerosCartela(int qtdNumerosCartela){
        int[] numerosSorteados = new int[qtdNumerosCartela];
        for (int i = 0; i < qtdNumerosCartela; i++) {
            numerosSorteados[i] = (int) (Math.random() * 60) + 1;
        }
        return numerosSorteados;
    }


}

