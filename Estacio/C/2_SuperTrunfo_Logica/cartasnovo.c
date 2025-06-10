#include <stdio.h>

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
void comparaAtributo(float atributoCarta1, float atributoCarta2, char nomeAtributo[25]){
  
  int vencedor;

  if (atributoCarta1 > atributoCarta2) {
    vencedor = 1;
  } else if (atributoCarta2 > atributoCarta1) {
    vencedor = 2;
  } else {
    vencedor = 0;
  }
  
  if (nomeAtributo == "Densidade Populacional"){ //se for Densidade deve retornar o de menor valor
    if (vencedor == 1){
      printf("%s: ", nomeAtributo);
      printf("Carta 2 venceu com %.2f\n\n", atributoCarta2);
    } else if (vencedor == 2){
      printf("%s: ", nomeAtributo);
      printf("Carta 1 venceu com %.2f\n\n", atributoCarta1);
    } else{
      printf("%s: ", nomeAtributo);
      printf("Empatou!!\n\n");
    }
  } else {
    if (vencedor == 1){
      printf("%s: ", nomeAtributo);
      printf("Carta 1 venceu com %.2f\n\n", atributoCarta1);
    } else if (vencedor == 2){
      printf("%s: ", nomeAtributo);
      printf("Carta 2 venceu com %.2f\n\n", atributoCarta2);
    } else{
      printf("%s: ", nomeAtributo);
      printf("Empatou!!\n\n");
    }
  }
  
  
}

int main (){

  char nomeCarta1[50], nomeCarta2[50], codigoCarta1[3], codigoCarta2[3], estadoCarta1[2], estadoCarta2[2];
  int populacaoCarta1, populacaoCarta2, pontosTuristicosCarta1, pontosTuristicosCarta2;
  float areaCarta1, areaCarta2, pibCarta1, pibCarta2;

  //Recebe Dadoas Carta 1
  printf("\n===================================\n");
  printf("Informe os dados da primeira carta: \n");
  printf("Código da Cidade: \n");
  scanf("%s", codigoCarta1);
  printf("UF da Cidade: \n");
  scanf("%s", estadoCarta1);
  printf("Nome da Cidade: \n");
  scanf("%s", nomeCarta1);
  printf("População: \n");
  scanf("%d", &populacaoCarta1);
  printf("Pontos Turísticos: \n");
  scanf("%d", &pontosTuristicosCarta1);
  printf("Área: \n");
  scanf("%f", &areaCarta1);
  printf("PIB: \n");
  scanf("%f", &pibCarta1);

  //Recebe Dados Carta 2
  printf("\n===================================\n");
  printf("Informe os dados da segunda carta: \n");
  printf("Código da Cidade: \n");
  scanf("%s", codigoCarta2);
  printf("UF da Cidade: \n");
  scanf("%s", estadoCarta2);
  printf("Nome da Cidade: \n");
  scanf("%s", nomeCarta2);
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

  //retorna os vencedores de cada atributo.
  printf("\n===================================\n");
  printf("E os vencedores são:\n\n");
  comparaAtributo((float)populacaoCarta1, (float)populacaoCarta2, "População");
  comparaAtributo((float)pontosTuristicosCarta1, (float)pontosTuristicosCarta2, "Pontos Turísticos");
  comparaAtributo(areaCarta1, areaCarta2, "Área");
  comparaAtributo(pibCarta1, pibCarta2, "PIB");
  comparaAtributo(calculoDensidade(areaCarta1, populacaoCarta1), calculoDensidade(areaCarta2, populacaoCarta2), "Densidade Populacional");
  comparaAtributo(calculoPib(populacaoCarta1, pibCarta1), calculoPib(populacaoCarta2, pibCarta2), "PIB Per Capita");
  comparaAtributo(calculoSuperPoder(populacaoCarta1, areaCarta1, pibCarta1, pontosTuristicosCarta1),
                  calculoSuperPoder(populacaoCarta2, areaCarta2, pibCarta2, pontosTuristicosCarta2), "Super Poder");

}