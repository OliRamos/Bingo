import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------- ");
        System.out.println(" B I N G O  D O S  'J U N I N'  5 0 + ");
        System.out.println("---------------------------------------- \n");

        String opcaoInicio;

        do {
            System.out.println(" - Menu Inicial - ");
            System.out.println("Digite a opção desejada:");
            System.out.println(" 1 para automático | 2 para manual | 3 para sair => ");
            opcaoInicio = sc.next();

            if (opcaoInicio.equals("1")) {
                System.out.println("Opção escolhida: automática");
                jogarJogoAutomatico(sc);
            } else if (opcaoInicio.equals("2")) {
                System.out.println("Opção escolhida: manual");
                // executarJogoManual;
            } else if (opcaoInicio.equals("3")) {
                System.out.println("Opção escolhida: sair");
                System.exit(0);
            } else {
                System.out.println("Opção inválida. Escolha entre 1, 2 ou 3.");
            }

        } while (!opcaoInicio.equals("1") && !opcaoInicio.equals("2") && !opcaoInicio.equals("3"));





//        String[] nomesDosJogadores = pegarNomesJogadores(sc);
//        int qtdNumerosCartela = 5;

//        gerarNumerosCartela(qtdNumerosCartela);
//        String[][] cartelasJogadores =
//                gerarCartelasDosJogadores(nomesDosJogadores, qtdNumerosCartela);
//
//        imprimirCartelasSorteadas(nomesDosJogadores,
//                qtdNumerosCartela, cartelasJogadores);


        //System.out.println("numeros sorteados = " + Arrays.toString(cartela));

    }

    private static void jogarJogoAutomatico(Scanner sc) {
        sc.nextLine();
        String[] nomesDosJogadores = pegarNomesJogadores(sc);
        int qtdNumerosCartela = 5;

        gerarNumerosCartela(qtdNumerosCartela);
        String[][] cartelasJogadores =
                gerarCartelasDosJogadores(nomesDosJogadores, qtdNumerosCartela);

        imprimirCartelasSorteadas(nomesDosJogadores,
                qtdNumerosCartela, cartelasJogadores);
    }

    private static String[] pegarNomesJogadores(Scanner sc) {
        System.out.println("Entre com os nomes dos participantes separados por hífen ','.");
        System.out.println("Exemplo: Fulano-Cicrana-Beltrana");
        System.out.print("Digite os nomes aqui: >> ");
        String entradaNomes = sc.nextLine();
        String[] nomesDosJogadores = entradaNomes.split("-");
        return nomesDosJogadores;
    }


    private static void imprimirCartelasSorteadas(String[] nomesDosJogadores,
                                                  int qtdNumerosCartela,
                                                  String[][] cartelasJogadores) {
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

    private static String[][] gerarCartelasDosJogadores
            (String[] nomesDosJogadores, int qtdNumerosCartela) {
        String[][] cartelasJogadores = new String[nomesDosJogadores.length][qtdNumerosCartela];
        for (int i = 0; i < nomesDosJogadores.length; i++) {
            cartelasJogadores[i][0] = nomesDosJogadores[i];
            int[] cartela = gerarNumerosCartela(qtdNumerosCartela);
            for(int j = 0; j < qtdNumerosCartela; j++){
                   cartelasJogadores[i][j] = Integer.toString(cartela[j]);
            }
        }
        return cartelasJogadores;

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




