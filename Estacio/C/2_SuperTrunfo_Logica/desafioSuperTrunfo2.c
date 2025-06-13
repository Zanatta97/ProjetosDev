/*Desafio Aula 2*/
#include <stdio.h>
#include <string.h>

//calcula do PIB per capita da cidade
float calculoPib (int pop, float pib){

  return pib / pop;

};

//calcula da densidade populacional da cidade
float calculoDensidade (float area, int pop){

  return pop / area;

};

//calcula o super poder das cartas
float calculoSuperPoder(int populacao, float area, float pib, int pontosTuristicos){

  float densidade = calculoDensidade(area, populacao);
  float perCapta = calculoPib(populacao, pib);
  float total = populacao + area + pib + pontosTuristicos + (densidade * -1) + perCapta;
  return total;

};

//exibe os dados das cartas
void exibirDadosCarta(char codigo[3],
                      char estado[2],
                      char nome[50],
                      int populacao,
                      int pontosTuristicos,
                      float area,
                      float pib,
                      int numCarta){

  printf("Carta %d\n\n", numCarta);
  printf("Código da Cidade: %s\n", codigo);
  printf("UF da Cidade: %s\n", estado);
  printf("Nome da Cidade: %s\n", nome);
  printf("População: %d\n", populacao);
  printf("Pontos Turísticos: %d\n", pontosTuristicos);
  printf("Área: %.2f\n", area);
  printf("PIB: %.2f\n", pib);
  printf("Densidade Populacional: %.2f\n", calculoDensidade(area, populacao));
  printf("PIB Per Capita: %.2f\n", calculoPib(populacao, pib));
  printf("Super Poder: %.2f\n\n\n", calculoSuperPoder(populacao, area, pib, pontosTuristicos));

};

//compara os atributos das cartas e retorna o vencedor
void comparaAtributo(float atributoCarta1, float atributoCarta2, char nomeAtributo[25], char nomeCarta1[50], char nomeCarta2[50], char uf1[3], char uf2[3]){
  
  int vencedor;

  if (atributoCarta1 > atributoCarta2) {
    vencedor = 1;
  } else if (atributoCarta2 > atributoCarta1) {
    vencedor = 2;
  } else {
    vencedor = 0;
  }
  printf("==================================\n\n");
  if (nomeAtributo == "Densidade Populacional"){ //se for Densidade deve retornar o de menor valor
    if (vencedor == 1){
      printf("%s: \n", nomeAtributo);
      printf("Carta 1 %.2f - %s (%s)\n", atributoCarta1, nomeCarta1, uf1);
      printf("Carta 2 %.2f - %s (%s)\n", atributoCarta2, nomeCarta2, uf2);
      printf("Carta 2 (%s) venceu com %.2f\n\n", nomeCarta2, atributoCarta2);
    } else if (vencedor == 2){
      printf("%s: \n", nomeAtributo);
      printf("Carta 1 %.2f - %s (%s)\n", atributoCarta1, nomeCarta1, uf1);
      printf("Carta 2 %.2f - %s (%s)\n", atributoCarta2, nomeCarta2, uf2);
      printf("Carta 1 (%s) venceu com %.2f\n\n", nomeCarta1, atributoCarta1);
    } else{
      printf("%s: \n", nomeAtributo);
      printf("Carta 1 %.2f - %s (%s)\n", atributoCarta1, nomeCarta1, uf1);
      printf("Carta 2 %.2f - %s (%s)\n", atributoCarta2, nomeCarta2, uf2);
      printf("Empatou!!\n\n");
    }
  } else {
    if (vencedor == 1){
      printf("%s: \n", nomeAtributo);
      printf("Carta 1 %.2f - %s (%s)\n", atributoCarta1, nomeCarta1, uf1);
      printf("Carta 2 %.2f - %s (%s)\n", atributoCarta2, nomeCarta2, uf2);
      printf("Carta 1 (%s) venceu com %.2f\n\n", nomeCarta1, atributoCarta1);
    } else if (vencedor == 2){
      printf("%s: \n", nomeAtributo);
      printf("Carta 1 %.2f - %s (%s)\n", atributoCarta1, nomeCarta1, uf1);
      printf("Carta 2 %.2f - %s (%s)\n", atributoCarta2, nomeCarta2, uf2);
      printf("Carta 2 (%s) venceu com %.2f\n\n", nomeCarta2, atributoCarta2);
    } else{
      printf("%s: \n", nomeAtributo);
      printf("Carta 1 %.2f - %s (%s)\n", atributoCarta1, nomeCarta1, uf1);
      printf("Carta 2 %.2f - %s (%s)\n", atributoCarta2, nomeCarta2, uf2);
      printf("Empatou!!\n\n");
    }
  }
}

int menuPrincipal (){
  int escolha;
  printf("Por Favor, escolha a opção desejada:\n\n");
  printf("[1] Cadastrar Cartas\n\n");
  printf("[2] Comparar Atributos\n\n");
  printf("[3] Comparar Dois Atributos\n\n");
  printf("[4] Retornar ao menu principal\n\n");
  printf("[5] Finalizar\n\n");
  scanf("%d", &escolha);
  return escolha;
}

int menuAtributos(){
  int escolha;
  printf("Por Favor, escolha o atributo a ser comparado:\n\n");
  printf("[1] População\n\n");
  printf("[2] Pontos Turísticos\n\n");
  printf("[3] Área\n\n");
  printf("[4] PIB\n\n");
  printf("[5] Densidade Populacional\n\n");
  printf("[6] PIB per Capita\n\n");
  printf("[7] Super Poder\n\n");
  scanf("%d", &escolha);
  return escolha;
}

int main (){

  char nomeCarta1[50], nomeCarta2[50], codigoCarta2[4], estadoCarta1[3], estadoCarta2[3];
  int populacaoCarta1, populacaoCarta2, pontosTuristicosCarta1, pontosTuristicosCarta2, opcaoSelecionada;
  float areaCarta1, areaCarta2, pibCarta1, pibCarta2, somaAtributosCarta1, somaAtributosCarta2;
  char codigoCarta1[4] = "";


  opcaoSelecionada = menuPrincipal();

  do {
    switch (opcaoSelecionada)
    {
    case 1: //Cadastrar Cartas

      //Valida se a carta já está cadastrada e questiona o usuário
      if (codigoCarta1[0] != '\0') {

        printf("\n===================================\n\n");
        printf("Cartas já cadastradas, deseja recadastrar as cartas?\n");
        printf("Digite [1] para Sim\n");
        printf("Digite [0] para Não (retornar ao menu principal)\n\n");
        int escolhaCadastro = 0;
        scanf("%d", &escolhaCadastro);

        //se o usuário escolher não, retorna para o menu principal
        if (escolhaCadastro == 0) {
          opcaoSelecionada = menuPrincipal();
          break;
        } else if (escolhaCadastro == 1)
        {
          continue;
        } else {
          printf("\n\nEscolha inválida, por favor, selecione novamente!!\n\n");
          escolhaCadastro = 1;
          break;
        }
        

      } 
      
      //Recebe Dadoas Carta 1
      printf("\n===================================\n\n");
      printf("Informe os dados da primeira carta: \n");
      printf("Código da Cidade: \n");
      scanf("%s", codigoCarta1);
      printf("UF da Cidade: \n");
      scanf("%s", estadoCarta1);
      printf("Nome da Cidade: \n");
      
      //remove buffer e recebe nome da cidade completo se tiver espaços também.
      getchar();
      fgets(nomeCarta1, sizeof(nomeCarta1), stdin);
      
      //remove a quebra de linha do final do nome da Cidade
      nomeCarta1[strcspn(nomeCarta1, "\n")] = '\0';
      
      printf("População: \n");
      scanf("%d", &populacaoCarta1);
      printf("Pontos Turísticos: \n");
      scanf("%d", &pontosTuristicosCarta1);
      printf("Área: \n");
      scanf("%f", &areaCarta1);
      printf("PIB: \n");
      scanf("%f", &pibCarta1);

      //Recebe Dados Carta 2
      printf("\n===================================\n\n");
      printf("Informe os dados da segunda carta: \n");
      printf("Código da Cidade: \n");
      scanf("%s", codigoCarta2);
      printf("UF da Cidade: \n");
      scanf("%s", estadoCarta2);
      printf("Nome da Cidade: \n");
      
      //remove buffer e recebe nome da cidade completo se tiver espaços também.
      getchar();
      fgets(nomeCarta2, sizeof(nomeCarta2), stdin);
      
      //remove a quebra de linha do final do nome da Cidade
      nomeCarta2[strcspn(nomeCarta2, "\n")] = '\0';

      printf("População: \n");
      scanf("%d", &populacaoCarta2);
      printf("Pontos Turísticos: \n");
      scanf("%d", &pontosTuristicosCarta2);
      printf("Área: \n");
      scanf("%f", &areaCarta2);
      printf("PIB: \n");
      scanf("%f", &pibCarta2);

      printf("Segue abaixo os dados das Cartas informados \n\n");

      //imprime os dados da carta 1
      exibirDadosCarta(codigoCarta1, estadoCarta1, nomeCarta1, 
                      populacaoCarta1, pontosTuristicosCarta1, areaCarta1, pibCarta1, 1);

      //imprime os dados da carta 2
      exibirDadosCarta(codigoCarta2, estadoCarta2, nomeCarta2, 
                      populacaoCarta2, pontosTuristicosCarta2, areaCarta2, pibCarta2, 2);
      
      opcaoSelecionada = menuPrincipal();
      break;

    case 2: //Comparar Atributos
      printf("Escolha qual atributo quer comparar:");
      int opcaoAtributo = menuAtributos();

      switch (opcaoAtributo)
      {
      case 1: //População
        comparaAtributo((float)populacaoCarta1, (float)populacaoCarta2, "População", nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
        opcaoSelecionada = menuPrincipal();
        break;
      case 2: // Pontos Turisticos
        comparaAtributo((float)pontosTuristicosCarta1, (float)pontosTuristicosCarta2, "Pontos Turísticos", nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
        opcaoSelecionada = menuPrincipal();
        break;
      case 3: //Area
        comparaAtributo(areaCarta1, areaCarta2, "Área", nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
        opcaoSelecionada = menuPrincipal();
        break;
      case 4: //PIB
        comparaAtributo(pibCarta1, pibCarta2, "PIB", nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
        opcaoSelecionada = menuPrincipal();
        break;
      case 5: // Densidade Populacional
        comparaAtributo(calculoDensidade(areaCarta1, populacaoCarta1), calculoDensidade(areaCarta2, populacaoCarta2), "Densidade Populacional",
                                         nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
        opcaoSelecionada = menuPrincipal();
        break;
      case 6: //PIB per Capita
        comparaAtributo(calculoPib(populacaoCarta1, pibCarta1), calculoPib(populacaoCarta2, pibCarta2), "PIB Per Capita", 
                                   nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
          opcaoSelecionada = menuPrincipal();
        break;
      case 7: //Super Poder
        comparaAtributo(calculoSuperPoder(populacaoCarta1, areaCarta1, pibCarta1, pontosTuristicosCarta1),
                      calculoSuperPoder(populacaoCarta2, areaCarta2, pibCarta2, pontosTuristicosCarta2), 
                      "Super Poder", nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
        opcaoSelecionada = menuPrincipal();
        break;
      default:
        printf("Opção selecionada inválida, favor escolher novamente: \n");
        opcaoSelecionada = menuAtributos();
        break;
      }

      break;
    case 3: //Comparar 2 atributos
      
      printf("Escolha dois atributos para realizar a comparação:\n\n");

      int escolha[] = {0,0};
      char nomeAtributo[2][25];

      somaAtributosCarta1 = 0;
      somaAtributosCarta2 = 0;
      
      printf("Atributo 1:\n");
      do {
          escolha[0] = menuAtributos();
          if (escolha[0] < 1 || escolha[0] > 7) {
              printf("Opção selecionada inválida, favor escolher novamente: \n");
          }
      } while (escolha[0] < 1 || escolha[0] > 7);


      printf("Atributo 2:\n");
      do {
          escolha[1] = menuAtributos();
          if (escolha[1] < 1 || escolha[1] > 7) {
              printf("Opção selecionada inválida, favor escolher novamente: \n");
          }
      } while (escolha[1] < 1 || escolha[1] > 7);


      for (int i = 0; i < 2; i++){
        switch (escolha[i])
        {
        case 1: //População
          
          comparaAtributo((float)populacaoCarta1, (float)populacaoCarta2, "População", nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
          
          somaAtributosCarta1 += populacaoCarta1;
          somaAtributosCarta2 += populacaoCarta2;
          strcpy(nomeAtributo[i], "População");

          break;

        case 2: // Pontos Turisticos
          
          comparaAtributo((float)pontosTuristicosCarta1, (float)pontosTuristicosCarta2, "Pontos Turísticos", nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
          
          somaAtributosCarta1 += pontosTuristicosCarta1;
          somaAtributosCarta2 += pontosTuristicosCarta2;
          strcpy(nomeAtributo[i], "Pontos Turísticos");

          break;

        case 3: //Area
          
          comparaAtributo(areaCarta1, areaCarta2, "Área", nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
          
          somaAtributosCarta1 += areaCarta1;
          somaAtributosCarta2 += areaCarta2;
          strcpy(nomeAtributo[i],"Área");
          break;

        case 4: //PIB
          
          comparaAtributo(pibCarta1, pibCarta2, "PIB", nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
          
          somaAtributosCarta1 += pibCarta1;
          somaAtributosCarta2 += pibCarta2;
          strcpy(nomeAtributo[i],"PIB");
          break;

        case 5: // Densidade Populacional
          
          comparaAtributo(calculoDensidade(areaCarta1, populacaoCarta1), calculoDensidade(areaCarta2, populacaoCarta2), "Densidade Populacional",
                                          nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
          
          somaAtributosCarta1 -= calculoDensidade(areaCarta1, populacaoCarta1);
          somaAtributosCarta2 -= calculoDensidade(areaCarta2, populacaoCarta2);
          strcpy(nomeAtributo[i],"Densidade Populacional");
          break;

        case 6: //PIB per Capita
          
          comparaAtributo(calculoPib(populacaoCarta1, pibCarta1), calculoPib(populacaoCarta2, pibCarta2), "PIB Per Capita", 
                                    nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
          
          somaAtributosCarta1 += calculoPib(populacaoCarta1, pibCarta1);
          somaAtributosCarta2 += calculoPib(populacaoCarta2, pibCarta2);
          strcpy(nomeAtributo[i],"PIB Per Capita");
          break;

        case 7: //Super Poder
          
          comparaAtributo(calculoSuperPoder(populacaoCarta1, areaCarta1, pibCarta1, pontosTuristicosCarta1),
                        calculoSuperPoder(populacaoCarta2, areaCarta2, pibCarta2, pontosTuristicosCarta2), 
                        "Super Poder", nomeCarta1, nomeCarta2, estadoCarta1, estadoCarta2);
          
          somaAtributosCarta1 += calculoSuperPoder(populacaoCarta1, areaCarta1, pibCarta1, pontosTuristicosCarta1);
          somaAtributosCarta2 += calculoSuperPoder(populacaoCarta2, areaCarta2, pibCarta2, pontosTuristicosCarta2);
          strcpy(nomeAtributo[i],"Super Poder");
          break;

        default:
          break;
        }
      }

      printf("As somas dos atributos %s e %s são: \n\n", nomeAtributo[0], nomeAtributo[1]);
      printf("Carta 1 - %s: \n %.2f\n\n",nomeCarta1, somaAtributosCarta1);
      printf("Carta 2 - %s: \n %.2f\n\n",nomeCarta2, somaAtributosCarta2);
      
      if (somaAtributosCarta1 > somaAtributosCarta2){
        printf("Carta 1 (%s) venceu com %.2f\n\n", nomeCarta1, somaAtributosCarta1);
      } else if (somaAtributosCarta1 < somaAtributosCarta2)
      {
        printf("Carta 2 (%s) venceu com %.2f\n\n", nomeCarta2, somaAtributosCarta2);
      } else {
        printf("Empatou!!\n\n");
      }

      printf("\n===================================\n\n");

      opcaoSelecionada = menuPrincipal();
      break;

    case 4: //Voltar ao Menu Principal
      opcaoSelecionada = menuPrincipal();
      break;
    case 5: //Finalizar
      break;
    default:
      printf("Opção selecionada inválida, favor escolher novamente: \n");
      opcaoSelecionada = menuPrincipal();
      break;
    }
  } while (opcaoSelecionada != 5);
}