#include <stdio.h>

// Tamanho do tabuleiro
#define TAM 10

// ------------------------------
// Função para exibir o tabuleiro
// ------------------------------
void exibirTabuleiro(int tabuleiro[TAM][TAM]) {
    for (int i = 0; i < TAM; i++) {
        for (int j = 0; j < TAM; j++) {
            printf("%d ", tabuleiro[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}

// ------------------------------
// NÍVEL NOVATO
// ------------------------------
void posicionarNaviosNovato(int tabuleiro[TAM][TAM]) {
    // Inicializar o tabuleiro com 0 (água)
    for (int i = 0; i < TAM; i++) {
        for (int j = 0; j < TAM; j++) {
            tabuleiro[i][j] = 0;
        }
    }

    // Vetores representando os navios (tamanho fixo 3)
    int navioHorizontal[3] = {3, 3, 3};
    int navioVertical[3] = {3, 3, 3};

    // Posições iniciais definidas no código
    int linhaH = 3, colunaH = 1;  // Navio na horizontal
    int linhaV = 5, colunaV = 7;  // Navio na vertical

    // Posiciona navio horizontal
    for (int i = 0; i < 3; i++) {
        tabuleiro[linhaH][colunaH + i] = navioHorizontal[i];
    }

    // Posiciona navio vertical
    for (int i = 0; i < 3; i++) {
        tabuleiro[linhaV + i][colunaV] = navioVertical[i];
    }
}

// ------------------------------
// NÍVEL AVENTUREIRO
// ------------------------------
void posicionarNaviosAventureiro(int tabuleiro[TAM][TAM]) {
    // Vetores dos navios adicionais (tamanho 3)
    int navioDiagonal1[3] = {3, 3, 3};  // Diagonal
    int navioDiagonal2[3] = {3, 3, 3};  // Diagonal

    // Posições iniciais definidas
    int linhaD1 = 0, colunaD1 = 0;  // Diagonal (cresce linha e coluna)
    int linhaD2 = 1, colunaD2 = 9;  // Diagonal (cresce linha, diminui coluna)

    // Navio diagonal ↘
    for (int i = 0; i < 3; i++) {
        tabuleiro[linhaD1 + i][colunaD1 + i] = navioDiagonal1[i];
    }

    // Navio diagonal ↙
    for (int i = 0; i < 3; i++) {
        tabuleiro[linhaD2 + i][colunaD2 - i] = navioDiagonal2[i];
    }
}

// ------------------------------
// NÍVEL MESTRE - Habilidades
// ------------------------------

// Função para aplicar habilidade no formato de Cruz
void aplicarCruz(int tabuleiro[TAM][TAM], int linha, int coluna) {
    for (int i = 0; i < TAM; i++) {
            // Linha da cruz
            if (linha >= 0 && linha < TAM) {
                if (tabuleiro[linha][i] != 3) {
                    tabuleiro[linha][i] = 5;
                }
            }
            // Coluna da cruz
            if (coluna >= 0 && coluna < TAM) {
                if (tabuleiro[i][coluna] != 3) {
                    tabuleiro[i][coluna] = 5;
                }
            }
    }
}

// Função para aplicar habilidade no formato de Cone (expande para baixo)
void aplicarCone(int tabuleiro[TAM][TAM], int linha, int coluna) {
    // Matriz de habilidade (5x5) - forma de cone
    int cone[5][5] = {
        {0, 0, 1, 0, 0},
        {0, 1, 1, 1, 0},
        {1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    // Aplicar a matriz cone no tabuleiro, centrando na origem
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            int lin = linha + (i - 1);
            int col = coluna + (j - 2);
            if (lin >= 0 && lin < TAM && col >= 0 && col < TAM) {
                if (cone[i][j] == 1 && tabuleiro[lin][col] != 3) {
                    tabuleiro[lin][col] = 5;
                }
            }
        }
    }
}

// Função para aplicar habilidade no formato de Octaedro (losango)
void aplicarOctaedro(int tabuleiro[TAM][TAM], int linha, int coluna) {
    // Matriz de habilidade (5x5) - forma de losango
    int octaedro[5][5] = {
        {0, 0, 1, 0, 0},
        {0, 1, 1, 1, 0},
        {1, 1, 1, 1, 1},
        {0, 1, 1, 1, 0},
        {0, 0, 1, 0, 0}
    };

    // Aplicar a matriz octaedro no tabuleiro
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            int lin = linha + (i - 2);
            int col = coluna + (j - 2);
            if (lin >= 0 && lin < TAM && col >= 0 && col < TAM) {
                if (octaedro[i][j] == 1 && tabuleiro[lin][col] != 3) {
                    tabuleiro[lin][col] = 5;
                }
            }
        }
    }
}

// ------------------------------
// FUNÇÃO PRINCIPAL
// ------------------------------
int main() {
    int tabuleiro[TAM][TAM];

    // Nível Novato
    posicionarNaviosNovato(tabuleiro);

    printf("Legenda:\n0 = Água | 3 = Navio\n\n");
    printf("Tabuleiro Novato:\n");
    exibirTabuleiro(tabuleiro);

    // Nível Aventureiro
    posicionarNaviosAventureiro(tabuleiro);
    printf("Legenda:\n0 = Água | 3 = Navio\n\n");
    printf("Tabuleiro Aventureiro:\n");
    exibirTabuleiro(tabuleiro);

    // Aplicar habilidades (Nível Mestre)
    posicionarNaviosNovato(tabuleiro);
    posicionarNaviosAventureiro(tabuleiro);
    aplicarCruz(tabuleiro, 4, 4);         // Centro

    // Exibir tabuleiro
    printf("Legenda:\n0 = Água | 3 = Navio | 5 = Área de Habilidade\n\n");
    printf("Tabuleiro Cruz:\n");
    exibirTabuleiro(tabuleiro);

    posicionarNaviosNovato(tabuleiro);
    posicionarNaviosAventureiro(tabuleiro);
    aplicarCone(tabuleiro, 1, 5);         // Topo meio

    // Exibir tabuleiro
    printf("Legenda:\n0 = Água | 3 = Navio | 5 = Área de Habilidade\n\n");
    printf("Tabuleiro Cone:\n");
    exibirTabuleiro(tabuleiro);

    posicionarNaviosNovato(tabuleiro);
    posicionarNaviosAventureiro(tabuleiro);
    aplicarOctaedro(tabuleiro, 7, 2);     // Canto inferior esquerdo

    // Exibir tabuleiro
    printf("Legenda:\n0 = Água | 3 = Navio | 5 = Área de Habilidade\n\n");
    printf("Tabuleiro Octaedro:\n");
    exibirTabuleiro(tabuleiro);

    
    //Tabuleiro completo
    posicionarNaviosNovato(tabuleiro);
    posicionarNaviosAventureiro(tabuleiro);
    aplicarCruz(tabuleiro, 4, 4);         // Cruz
    aplicarCone(tabuleiro, 1, 5);         // Cone
    aplicarOctaedro(tabuleiro, 7, 2);     // Lozango

    // Exibir tabuleiro
    printf("Legenda:\n0 = Água | 3 = Navio | 5 = Área de Habilidade\n\n");
    printf("Tabuleiro Completo:\n");
    exibirTabuleiro(tabuleiro);

    return 0;
}
