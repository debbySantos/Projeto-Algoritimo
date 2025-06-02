import java.util.Scanner;
import java.util.Random;
public class cacaAoTesouro {
// Função para mostrar o mapa
    public static void mostrarMapa(char[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Função para validar entradas
    public static boolean validarEntrada(int valor, int limite) {
        return valor >= 0 && valor <limite;
}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int iniciar;

        do {
            System.out.println("\n<<===============================================================>>"
                    + "\n>> Bem vindo a caça ao tesouro, esperamos que se divirta jogando! <<\n"
                    + "<<===============================================================>>\n");
            System.out.println(" >> (Menu do jogo) <<\n"
                    + "\n <<= (1-Iniciar | 2-Créditos | 3-Fechar jogo) =>>");
            iniciar = input.nextInt();
            switch (iniciar) {
                case 1:
                    
                        System.out.println("\n>> O jogo começou! <<");
                        int tamanho;
                        do {
                            System.out.print("Digite o tamanho do mapa, sendo (5 a 7): ");
                            tamanho = input.nextInt();
                            if (tamanho < 5 || tamanho > 7) {
                                System.out.println("Tamanho inválido! Digite um número entre 5 e 7.");
                            }
                        } while (tamanho < 5 || tamanho > 7);
                        
                        char[][] mapa = new char[tamanho][tamanho];
                        int[] posicaoTesouro = new int[2];
                        
                        for (int i = 0; i < tamanho; i++) {
                            for (int j = 0; j < tamanho; j++) {
                                mapa[i][j] = '-';
                            }
                        }
                        
                        Random rand = new Random();
                        posicaoTesouro[0] = rand.nextInt(tamanho);
                        posicaoTesouro[1] = rand.nextInt(tamanho);
                        
                        int achou = 0;
                        int tentativas = 0;
                        int maxTentativas = 5;
                        
                        System.out.println("\n<== Começou o jogo, boa sorte! ==>\n");
                        mostrarMapa(mapa);
                    
                    break;

                case 2:
                    // créditos aqui (vazio por enquanto)
                    break;

                case 3:
                    // encerramento aqui (vazio por enquanto)
                    break;

                default:
                    System.out.println("<< Opção inválida. Por favor, escolha uma opção entre 1 e 3. >>");
            }

        } while (iniciar != 3);
    }
}
