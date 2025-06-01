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
        return valor >= 0 && valor < limite;
    }
