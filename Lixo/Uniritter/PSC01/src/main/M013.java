package main;

import java.util.Scanner;

public class M013 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Ler um vetor A de 15 números.
		 * Após, ler mais um número e guardar em uma variável X.
		 * Armazenar em um vetor M o resultado de cada elemento de 
		 * A multiplicado pelo valor X.
		 * Logo após, imprimir o vetor M. 
		*/
		
		Scanner scanner = new Scanner(System.in);
		
		int[] vetorA = new int[15];
		int[] vetorM = new int[15];
		
		for (int i = 0; i < vetorA.length; i++) {
			int contagem = i + 1;
			System.out.print("Informe o " + contagem + "º número: ");
			vetorA[i] = scanner.nextInt();
		}
		
		System.out.print("Agora informe o número pelo qual será multiplicado: ");
		int numero = scanner.nextInt();
		
		for (int i = 0; i < vetorA.length; i++) {
			vetorM[i] = vetorA[i] * numero;
		}
		
		System.out.println("Seguem os resultados:");
		
		for (int i = 0; i < vetorA.length; i++) {
			System.out.println(vetorA[i] + " X " + numero + " é igual a " + vetorM[i]);
		}
		
		scanner.close();
		
	}

}
