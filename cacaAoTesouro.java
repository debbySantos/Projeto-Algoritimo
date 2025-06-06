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
    //função para imprimir e rodar o jogo 
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int iniciar;
    // do - while para exibir o menu e reexibir se o usuario digitar uma opção inválida
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
                       
                    //do-while para definir o tamanho da matriz do tabuleiro
                    do {
                            System.out.print("Digite o tamanho do mapa, sendo (5 a 7): ");
                            tamanho = input.nextInt();
                            if (tamanho < 5 || tamanho > 7) {
                                System.out.println("Tamanho inválido! Digite um número entre 5 e 7.");
                            }
                        } while (tamanho < 5 || tamanho > 7);
                       
                    //definir a posição do tesouro
                    
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

                    //enquanto o usuário tiver tentativas, vai poder digitar linha e coluna. Quando as tentativas acabarem ele perde o jogo
                    //pegar os inputs do usuario
                    
                        while (achou == 0 && tentativas < maxTentativas) {
                            
                            System.out.print("\nEscolha a linha (0 a " + (tamanho - 1) + "): ");
                                int linha = input.nextInt();
                            
                                System.out.print("Escolha a coluna (0 a " + (tamanho - 1) + "): ");
                                int coluna = input.nextInt();
                            
                                if (!validarEntrada(linha, tamanho) || !validarEntrada(coluna, tamanho)) {
                                    System.out.println("Essa posição não existe, não quer tentar outra?");
                                } else if (mapa[linha][coluna] == '*') {
                                    System.out.println("Você já tentou essa antes!");
                                } else {
                                    tentativas++;
                            
                                    if (linha == posicaoTesouro[0] && coluna == posicaoTesouro[1]) {
                                        mapa[linha][coluna] = 'X';
                                        achou = 1;
                                        System.out.println("\nParabéns! Você conseguiu achar o tesouro");
                                    } else {
                                        mapa[linha][coluna] = '*';
                                        System.out.println("Poxa, não foi dessa vez, continue procurando...");
                                    }
                                }
                            
                                mostrarMapa(mapa);
                                System.out.println("Suas tentativas agora são: " + (maxTentativas - tentativas));
                            }
                            
                            if (achou == 0) {
                                System.out.println("<< O tesouro estava na posição: Linha " + posicaoTesouro[0] + ", Coluna " + posicaoTesouro[1] + " >>");
                                System.out.println("\n<< Você não encontrou o tesouro, mas pode jogar novamente! >>\n");
                            } else {
                                System.out.println("\n<< Você encontrou o tesouro em " + tentativas + " tentativas! >>");
                                System.out.println("Jogo reiniciado, por que não joga novamente?");
                            }
                    break;

                case 2:
                        System.out.println("Opa, tudo bem?, nós somos o grupo 04 e esse é o nosso projeto," +
                            " nosso grupo é composto por:\n Daniel Augusto Magalhães França \n" +
                            " Débora dos Santos da Silva\n Vanessa Ferreira de Melo Balbino Silva\n Kauan Jota\n\n Esperamos que gostem do jogo ^-^ !");
                    break;
                  //mensagem final exibida ao finalizar o jogo
                case 3:
                      System.out.println("\n \"███████╗██╗  ███╗ ███╗\n" +
                                            " \"██╔════╝██║ ████╗ ████║\n" +
                                            " \"█████╗  ██║ ██╔████╔██║\n" +
                                            " \"██╔══╝  ██║ ██║╚██╔╝██║\n" +
                                            " \"██║     ██║ ██║ ╚═╝ ██║+\n" +
                                            " \"╚═╝     ╚═╝ ╚═╝     ╚═╝\n" + "<=============================>\n Obrigado por jogar!\n");
                    break;

                default:
                    System.out.println("<< Opção inválida. Por favor, escolha uma opção entre 1 e 3. >>");
            }

        } while (iniciar != 3);
    }
}
