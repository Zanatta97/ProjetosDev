#include <stdio.h>

//calcula do PIB per capita da cidade
float calculoPib (int pop, float pib){

  return pib / pop;

};

//calcula da densidade populacional da cidade
float calculoDensidade (float area, int pop){

  return pop / area;

};

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
  printf("Área: %f\n", area);
  printf("PIB: %f\n", pib);
  printf("Densidade Populacional: %f\n", calculoDensidade(area, populacao));
  printf("PIB Per Capita: %f\n\n", calculoPib(populacao, pib));

};

float calculoSuperPoder(){

};

int main (){

  char nomeCarta1[50], nomeCarta2[50], codigoCarta1[3], codigoCarta2[3], estadoCarta1[2], estadoCarta2[2];
  int populacaoCarta1, populacaoCarta2, pontosTuristicosCarta1, pontosTuristicosCarta2;
  float areaCarta1, areaCarta2, pibCarta1, pibCarta2;

  //Recebe Dadoas Carta 1
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

  exibirDadosCarta(codigoCarta1, estadoCarta1, nomeCarta1, 
                  populacaoCarta1, pontosTuristicosCarta1, areaCarta1, pibCarta1, 1);

  exibirDadosCarta(codigoCarta2, estadoCarta2, nomeCarta2, 
                  populacaoCarta2, pontosTuristicosCarta2, areaCarta2, pibCarta2, 2);

  /*
  int idade = 20;
  char* resultado;
  
  //exemplo de Operador Ternario.
  resultado = (idade >= 18) ? "Maior de idade" : "Menor de idade";

  printf("Resultado: %s\n", resultado);
  */

}