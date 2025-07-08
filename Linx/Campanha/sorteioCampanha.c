#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>

int main() {
    int numeroMaximo;
    int numero1, numero2;
    FILE *logFile;

    // Configura o console para UTF-8 no Windows
    SetConsoleOutputCP(CP_UTF8);
    SetConsoleCP(CP_UTF8);

    // Introdução
    printf("=============================================================\n");
    printf("      Sorteador de Casos para Revisão na campanha do RC      \n");
    printf("=============================================================\n");
    printf("Este programa sorteia dois números aleatórios diferentes\n");
    printf("para que você selecione casos a serem analisados.\n\n");

    // Inicializa gerador aleatório
    srand(time(NULL));

    // Solicita número válido
    do {
        printf("Digite a quandade prevista de casos encerrados para o mês (mínimo 2): ");
        scanf("%d", &numeroMaximo);

        if (numeroMaximo < 2) {
            printf("O número máximo deve ser 2 ou maior para sortear dois casos diferentes.\n\n");
        }
    } while (numeroMaximo < 2);
    printf("\n");
    printf("Gerando dois casos aleatórios entre 1 e %d...\n", numeroMaximo);
    printf("\n");
    // Gera os dois números
    numero1 = rand() % numeroMaximo + 1;
    do {
        numero2 = rand() % numeroMaximo + 1;
    } while (numero2 == numero1);

    // Ordena os números
    int menor = (numero1 < numero2) ? numero1 : numero2;
    int maior = (numero1 > numero2) ? numero1 : numero2;

    // Exibe no console
    printf("Posição dos casos a serem analisados: %d e %d\n", menor, maior);
    printf("============================================\n");
    printf("Obrigado por utilizar o sorteador e até a próxima!\n");

    // Abre o arquivo de log em modo append (acrescentar)
    logFile = fopen("log.txt", "a");
    if (logFile == NULL) {
        printf("Não foi possível abrir o arquivo de log.\n");
        return 1;
    }

    // Obtem data/hora atual
    time_t agora = time(NULL);
    struct tm *dataHora = localtime(&agora);

    // Escreve no log
    fprintf(logFile, "===== NOVO SORTEIO =====\n");
    fprintf(logFile, "Data/Hora: %02d/%02d/%04d %02d:%02d:%02d\n",
            dataHora->tm_mday, dataHora->tm_mon + 1, dataHora->tm_year + 1900,
            dataHora->tm_hour, dataHora->tm_min, dataHora->tm_sec);
    fprintf(logFile, "Número máximo informado: %d\n", numeroMaximo);
    fprintf(logFile, "Posição dos casos sorteados: %d e %d\n\n", menor, maior);

    fclose(logFile); // Fecha o arquivo

    // Pausa o programa para o usuário ver o resultado
    printf("\n");
    printf("Pressione qualquer tecla para fechar o programa...");
    system("pause > nul"); // > nul esconde a mensagem padrão do pause

    return 0;
}
