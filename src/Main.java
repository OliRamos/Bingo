import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------- ");
        System.out.println(" B I N G O  D O S  'J U N I N'  5 0 + ");
        System.out.println("---------------------------------------- \n");
        System.out.println("Entre com os nomes dos participantes separados por hífen ','.");
        System.out.println("Exemplo: Fulano-Cicrana-Beltrana");
        System.out.print("Digite os nomes aqui: >> ");
        String entradaNomes = sc.nextLine();
        String[] nomesDosJogadores = pegarNomesJogadores(entradaNomes);
        int qtdNumerosCartela = 5;
        String opcaoInicio;

        do {
            System.out.println("Digite a opção desejada:");
            System.out.println(" '1' para - automático | " +
                    "'2' - para manual |" +
                    " '3' - para sair => ");
            opcaoInicio = sc.next();

            if (opcaoInicio.equals("1")) {
                System.out.println("Opção escolhida: automática");
                jogarAutomatico(qtdNumerosCartela, nomesDosJogadores);
            } else if (opcaoInicio.equals("2")) {
                System.out.println("Opção escolhida: manual");
                //executarJogoManual;
            } else if (opcaoInicio.equals("3")) {
                System.out.println("Opção escolhida: sair");
                System.exit(0);
            } else {
                System.out.println("Opção inválida. Escolha entre 1, 2 ou 3.");
            }

        } while (!opcaoInicio.equals("1") && !opcaoInicio.equals("2") && !opcaoInicio.equals("3"));


    }

    public static void jogarAutomatico(int qtdNumerosCartela, String[] nomesDosJogadores) {
        Scanner sc = new Scanner(System.in);
        int rodadas = 0;
        String[][] cartelasJogadores = gerarCartelasDosJogadores(nomesDosJogadores, qtdNumerosCartela);
        imprimirCartelasSorteadas(nomesDosJogadores, qtdNumerosCartela, cartelasJogadores);
        int[] numerosSorteadosAcumulativo = new int[0];

        do {
            rodadas++;
            System.out.println("\n--- Rodada " + rodadas + " ---");
            int[] numerosSorteadosRodada = sortearNumeros(qtdNumerosCartela);
            numerosSorteadosAcumulativo = concatenarArrays(numerosSorteadosAcumulativo, numerosSorteadosRodada);
            imprimirListaNumerosSorteados(numerosSorteadosAcumulativo);
            imprimirCartelasSorteadas(nomesDosJogadores, qtdNumerosCartela, cartelasJogadores);

            // Verifica se o usuário deseja continuar para a próxima rodada
            System.out.println("\nDeseja jogar a próxima rodada? (Digite 's' para sim, 'n' para não): ");
            String escolha = sc.next().toLowerCase();

            if (escolha.equals("n")) {
                System.out.println("Jogo encerrado. Obrigado por jogar!");
                System.exit(0);
            }

        } while (true); // Modifique conforme necessário para encerrar o jogo

    }




    public static String[] pegarNomesJogadores(String entradaNomes) {
        String[] nomesDosJogadores = entradaNomes.split("-");
        return nomesDosJogadores;
    }


    public static void imprimirCartelasSorteadas
            (String[] nomesDosJogadores, int qtdNumerosCartela, String[][] cartelasJogadores) {
        for (int i = 0; i < nomesDosJogadores.length; i++) {
            System.out.println();
            System.out.printf("%s = {", nomesDosJogadores[i]);
            for (int j = 0; j < qtdNumerosCartela; j++) {
                System.out.printf("%s", cartelasJogadores[i][j]);
                if(j < qtdNumerosCartela -1){
                    System.out.print(", ");
                }
            }
            System.out.print("}");
        }
    }

    public static String[][] gerarCartelasDosJogadores
            (String[] nomesDosJogadores, int qtdNumerosCartela) {
        String[][] cartelasJogadores = new String[nomesDosJogadores.length][qtdNumerosCartela];
        for (int i = 0; i < nomesDosJogadores.length; i++) {
            cartelasJogadores[i][0] = nomesDosJogadores[i];
            int[] cartela = sortearNumerosCartelas(qtdNumerosCartela);
            for(int j = 0; j < qtdNumerosCartela; j++){
                   cartelasJogadores[i][j] = Integer.toString(cartela[j]);
            }
        }
        return cartelasJogadores;

    }

    public static int[] sortearNumerosCartelas(int qtdNumerosCartela) {
        int[] numerosSorteadosCartelas = new int[qtdNumerosCartela];
        for(int i = 0; i < qtdNumerosCartela; i++){
            while (true){
                int numeroTeste = (int) (Math.random() * 60 + 1);
                if (verificarRepitidosCartela(numeroTeste,numerosSorteadosCartelas)){
                    numerosSorteadosCartelas[i] = numeroTeste;
                    break;
                }
            }
        }
        return numerosSorteadosCartelas;
    }

    public static int[] sortearNumeros(int qtdNumerosCartela) {
        int[] numerosSorteados = new int[qtdNumerosCartela];
        for(int i = 0; i < qtdNumerosCartela; i++){
            while (true){
                int numeroTeste = (int) (Math.random() * 60 + 1);
                if (verificarRepitidos(numeroTeste,numerosSorteados)){
                    numerosSorteados[i] = numeroTeste;
                    break;
                }
            }
        }
        return numerosSorteados;
    }

    public static boolean verificarRepitidosCartela(int numeroTeste, int[] numerosSorteados) {
        for (int i = 0; i < numerosSorteados.length; i++) {
            if (numerosSorteados[i] == numeroTeste) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificarRepitidos(int numeroTeste, int[] numerosSorteados) {
        for (int i = 0; i < numerosSorteados.length; i++) {
            if (numerosSorteados[i] == numeroTeste) {
                return false;
            }
        }
        return true;
    }

    public static void imprimirListaNumerosSorteados(int[] numerosSorteados) {
        System.out.print("Números sorteados: ");
        for (int numero : numerosSorteados) {
            System.out.print(numero + " - ");
        }
        System.out.println();
    }

    public static int[] concatenarArrays(int[] array1, int[] array2) {
        int[] resultado = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, resultado, 0, array1.length);
        System.arraycopy(array2, 0, resultado, array1.length, array2.length);
        return resultado;
    }

}




