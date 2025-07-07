#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int menuPrincipal (){
  int escolha;
  printf("Por Favor, escolha a opção desejada:\n\n");
  printf("[1] Selecionar Casos para Verificação\n\n");
  printf("[2] Retornar ao menu principal\n\n");
  printf("[3] Finalizar\n\n");
  scanf("%d", &escolha);
  return escolha;
}

int retornaAleatorio(valorMaximo){
    srand(time(NULL));
    return (( rand() % valorMaximo) + 1);
}


int main(){
    int valorMaximo, opcaoSelecionada, aleatorio1, aleatorio2;

    opcaoSelecionada = menuPrincipal();

    do{
        switch (opcaoSelecionada)
        {
        case 1:
            printf("Informar o encerramento previsto de casos dos Analistas para o mês:\n");
            scanf("%d", &valorMaximo);

            aleatorio1 = retornaAleatorio(valorMaximo);
            aleatorio2 = retornaAleatorio(valorMaximo);

            while (aleatorio1 == aleatorio2){
                aleatorio2 = retornaAleatorio(valorMaximo);
            }

            if (aleatorio1 < aleatorio2){
                printf("\n\nOs números sorteados foram: %d e %d\n\n", aleatorio1, aleatorio2);
            } else {
                printf("\n\nOs números sorteados foram: %d e %d\n\n", aleatorio2, aleatorio1);
            }
            
            opcaoSelecionada = menuPrincipal();
            break;
        case 2:
            opcaoSelecionada = menuPrincipal();
            break;
        case 3:
            break;
        default:
            printf("\nOpção Inválida, favor selecionar novamente\n\n");
            menuPrincipal();
            break;
        }
    } while (opcaoSelecionada != 3);

    

    


    int sorteado = rand() % valorMaximo;
    
    printf("Teste Rand: %d", sorteado);

    


}