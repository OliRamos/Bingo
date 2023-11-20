import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------- ");
        System.out.println(" B I N G O  D O S  'J U N I N'  5 0 + ");
        System.out.println("---------------------------------------- \n");
        System.out.println("Entre com os nomes dos participantes separadas por vírgula ','.");
        System.out.println("Exemplo: Fulano-Cicrana-Beltrana");
        System.out.print("Digite os nomes aqui: >> ");
        String entradaNomes = sc.nextLine();

        String[] nomesDosJogadores = entradaNomes.split("-");
        int qtdNumerosCartela = 5;

        String[][] cartelasJogadores = new String[nomesDosJogadores.length][qtdNumerosCartela];
        for (int i = 0; i < nomesDosJogadores.length; i++) {
            cartelasJogadores[i][0] = nomesDosJogadores[i];
            int[] cartela = gerarNumerosCartela(qtdNumerosCartela);
            for(int j = 0; j < qtdNumerosCartela; j++){
                   cartelasJogadores[i][j] = Integer.toString(cartela[j]);
            }
        }
        for (String[] cartela : cartelasJogadores){
            System.out.println(Arrays.toString(cartela));
        }


        int[] cartela = gerarNumerosCartela(qtdNumerosCartela);
        System.out.println("numeros sorteados = " + Arrays.toString(cartela));

    }


    public static int[] gerarNumerosCartela(int qtdNumerosCartela) {
        int[] numerosGerados = new int[qtdNumerosCartela];
        for(int i = 0; i < qtdNumerosCartela; i++){
            while (true){
                int numeroTeste = (int) (Math.random() * 60 + 1);
                if (verificarRepitidos(numeroTeste,numerosGerados)){
                    numerosGerados[i] = numeroTeste;
                    break;
                }
            }
        }
        return numerosGerados;
    }

    public static boolean verificarRepitidos(int numeroTeste, int[] numerosGerados) {
        for (int i = 0; i < numerosGerados.length; i++) {
            if (numerosGerados[i] == numeroTeste) {
                return false;
            }
        }
        return true;
    }


}




