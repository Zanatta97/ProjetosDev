#include <stdio.h>

// ------------------------------
// NÍVEL NOVATO
// ------------------------------

void movimentoTorre_Novato() {
    // Torre movendo 5 casas para a direita usando FOR
    printf("Movimento da Torre (Nível Novato):\n");
    for (int i = 1; i <= 5; i++) {
        printf("Direita\n");
    }
    printf("\n");
}

void movimentoBispo_Novato() {
    // Bispo movendo 5 casas na diagonal (Cima, Direita) usando WHILE
    printf("Movimento do Bispo (Nível Novato):\n");
    int i = 1;
    while (i <= 5) {
        printf("Cima, ");
        printf("Direita\n");
        i++;
    }
    printf("\n");
}

void movimentoRainha_Novato() {
    // Rainha movendo 8 casas para a esquerda usando DO-WHILE
    printf("Movimento da Rainha (Nível Novato):\n");
    int i = 1;
    do {
        printf("Esquerda\n");
        i++;
    } while (i <= 8);
    printf("\n");
}

// ------------------------------
// NÍVEL AVENTUREIRO
// ------------------------------

void movimentoCavalo_Aventureiro() {
    // Cavalo se move duas casas para baixo e uma para a esquerda
    // Usando loops aninhados: FOR (obrigatório) e WHILE

    printf("Movimento do Cavalo (Nível Aventureiro):\n");

    // Loop externo (for) para duas casas para baixo
    for (int i = 0; i < 2; i++) {
        printf("Baixo, ");

        if (i == 1) {
            // Loop interno (while) para uma casa para esquerda
            int j = 0;
            while (j < 1) {
                printf("Esquerda\n");
                j++;
            }
        }
        
    }

    printf("\n");
}

// ------------------------------
// NÍVEL MESTRE
// ------------------------------

// Recursão para Torre (5 passos para a direita)
void movimentoTorre_Mestre(int passos) {
    if (passos == 0) {
        return;
    }

    printf("Direita\n");
    movimentoTorre_Mestre(passos - 1);
}

// Recursão para Bispo (5 passos na diagonal Cima Direita)
void movimentoBispo_Mestre(int passos) {
    if (passos == 0) {
        return;
    }

    printf("Cima, ");
    printf("Direita\n");
    movimentoBispo_Mestre(passos - 1);
}

// Recursão para Rainha (8 passos para a esquerda)
void movimentoRainha_Mestre(int passos) {
    if (passos == 0) {
        return;
    }

    printf("Esquerda\n");
    movimentoRainha_Mestre(passos - 1);
}

// Cavalo Mestre - movimento em "L" para cima e para a direita
void movimentoCavalo_Mestre(int direcao) {
    // Duas casas para cima e uma para direita
    printf("Movimento do Cavalo (Nível Mestre):\n");

    if (direcao == 1) { //Cima

    } else { //Baixo

    }
    for (int i = 0; i < 2; i++) { // Loop externo para CIMA
        if (i == 1) {
            int j = 0;
            do { // Loop interno para DIREITA após duas subidas
                if (direcao == 1) { 
                    printf("Cima\n");
                } else {
                    printf("Baixo\n");
                }
                printf("Direita\n");
                j++;
            } while (j < 1);
        } else {
            if (direcao == 1) { 
                printf("Cima\n");
            } else {
                printf("Baixo\n");
            }
        }
    }

    printf("\n");
}

// Bispo com recursividade + loops aninhados
void movimentoBispo_Mestre_Aninhado(int passos) {
    printf("Movimento do Bispo (Loops Aninhados - Nível Mestre):\n");
    for (int i = 0; i < passos; i++) {       // Movimento vertical (Cima)
        for (int j = 0; j < 1; j++) {         // Movimento horizontal (Direita)
            printf("Cima, ");
            printf("Direita\n");
        }
    }
    printf("\n");
}


// ------------------------------
// FUNÇÃO PRINCIPAL
// ------------------------------

int main() {
    // --- Nível Novato ---
    movimentoTorre_Novato();
    movimentoBispo_Novato();
    movimentoRainha_Novato();

    // --- Nível Aventureiro ---
    movimentoCavalo_Aventureiro();

    // --- Nível Mestre ---
    printf("Movimento da Torre (Recursivo - Nível Mestre):\n");
    movimentoTorre_Mestre(5);
    printf("\n");

    printf("Movimento do Bispo (Recursivo - Nível Mestre):\n");
    movimentoBispo_Mestre(5);
    printf("\n");

    printf("Movimento da Rainha (Recursivo - Nível Mestre):\n");
    movimentoRainha_Mestre(8);
    printf("\n");

    movimentoCavalo_Mestre(1); //cAVALO PRA CIMA
    movimentoCavalo_Mestre(2); //CAVALO PRA BAIXO

    movimentoBispo_Mestre_Aninhado(5);

    return 0;
}
