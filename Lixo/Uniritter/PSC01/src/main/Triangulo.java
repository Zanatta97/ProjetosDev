package main;

import java.util.Scanner;

public class Triangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int ladoA, ladoB, ladoC;
		boolean isTirangulo;
		
		System.out.println("Vamos montar a merda de um triângulo: ");
		System.out.println("Informe os 3 lados do triângulo:");
		
		System.out.print("Informe o lado A: ");
		ladoA = scanner.nextInt();
		
		System.out.print("Informe o lado B: ");
		ladoB = scanner.nextInt();
		
		System.out.print("Informe o lado C: ");
		ladoC = scanner.nextInt();
		
		isTirangulo = validaTriangulo(ladoA, ladoB, ladoC);
		
		while (!isTirangulo) {
			System.out.println("Isso não forma um Triângulo, tente novamente: ");
			
			System.out.print("Informe o lado A: ");
			ladoA = scanner.nextInt();
	
			System.out.print("Informe o lado B: ");
			ladoB = scanner.nextInt();
			
			System.out.print("Informe o lado C: ");
			ladoC = scanner.nextInt();
			
			isTirangulo = validaTriangulo(ladoA, ladoB, ladoC);
			
		}
		
		if (ladoA == ladoB && ladoB == ladoC) {
			System.out.println("Seu triângulo é um Equilatero");
		} else if (ladoA != ladoB && ladoA != ladoC && ladoB != ladoC) {
			System.out.println("Seu triângulo é um Escaleno");			
		} else {
			System.out.println("Seu triângulo é um Isóceles");						
		}
		
		scanner.close();
		
	}
	
	private static boolean validaTriangulo(int ladoA, int ladoB, int ladoC) {
		//Valida o triângulo
		if ((ladoA + ladoB) < ladoC) {
			return false;
		} else if ((ladoA + ladoC) < ladoB) {
			return false;		
		} else if ((ladoB + ladoC) < ladoA) {
			return false;					
		} else {			
			return true;
		}
	}


}
