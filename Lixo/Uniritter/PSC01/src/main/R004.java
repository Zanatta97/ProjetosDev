package main;

import java.util.Scanner;

public class R004 {

	public static void main(String[] args) {
		/*Faça um algoritmo que escreva todos os números
		 * múltiplos de 3 entre 1 e N, sendo N um
		 * valor digitado pelo usuário.
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe um número qualquer: ");
		
		int numeroFinal = scanner.nextInt();
		
		for (int i = 1; i <= numeroFinal; ++i) {
			//int resto = i % 3;
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}
		
		scanner.close();

	}

}
