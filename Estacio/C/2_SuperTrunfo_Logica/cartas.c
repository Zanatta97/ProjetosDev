#include <stdio.h>

int main (){

  char nome[50], codigo[3] ;
  int pop, pontosTuristicos;
  float area, pib;

  printf("Informe os dados da primeira carta: \n");
  printf("Nome da Cidade: \n");
  scanf("%s", nome);
  printf("População: \n");
  scanf("%d", &pop);
  printf("Pontos Turísticos: \n");
  scanf("%d", &pontosTuristicos);
  printf("Área: \n");
  scanf("%f", &area);
  printf("PIB: \n");
  scanf("%f", &pib);

  printf("Abaixo dados da Carta 1:\nCarta: 1\nCódigo: A01\n");
  printf("Nome da Cidade: %s\n", nome);
  printf("População: %d\n", pop);
  printf("Pontos Turísticos: %d\n", pontosTuristicos);
  printf("Área: %f\n", area);
  printf("PIB: %f\n", pib);
}