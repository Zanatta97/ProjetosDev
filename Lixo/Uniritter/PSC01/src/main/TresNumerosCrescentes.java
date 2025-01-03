package main;

import java.util.Scanner;

public class TresNumerosCrescentes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		int num1, num2, num3;
		
		System.out.println("Por favo informe seus 3 números para eu ordenar: ");
		
		System.out.print("Informe o 1º número: ");
		num1 = scanner.nextInt();
		
		System.out.print("Informe o 2º número: ");
		num2 = scanner.nextInt();
		
		System.out.print("Informe o 3º número: ");
		num3 = scanner.nextInt();
		
		if (num1 < 0 || num2 < 0 || num3 < 0) {
			System.out.println("Informado um número negativo.");
			System.out.println("Encerrando o programa...");
		} else {
			if (num1 <= num2 && num1 <= num3) {
				if (num2 <= num3) {
					System.out.println(retornaNumeros(num1, num2, num3));
				} else {
					System.out.println(retornaNumeros(num1, num3, num2));
				}
				
			} else if (num2 <= num3 && num2 <= num1) {
				if (num3 <= num1) {
					System.out.println(retornaNumeros(num2, num3, num1));
				} else {
					System.out.println(retornaNumeros(num2, num1, num3));
				}
			} else if (num3 <= num1 && num3 <= num2) {
				if (num2 <= num1) {
					System.out.println(retornaNumeros(num3, num2, num1));
				} else {
					System.out.println(retornaNumeros(num3, num1, num2));
				}
			}
		}

	}
	
	public static String retornaNumeros (int num1, int num2, int num3) {
		return "Segue os números informados em ordem: " + num1 + ", " + num2 + ", " + num3;
	}

}
