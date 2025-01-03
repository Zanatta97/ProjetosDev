package main;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Olá Marilene");	
		System.out.println("Qual operação deseja realizar?");
		System.out.println("1 - Soma");
		System.out.println("2 - Subtração");
		System.out.println("3 - Multiplicação");
		System.out.println("4 - Divisão");
		boolean operacaoValida = false;
		int operacao = 0;
		while (!operacaoValida) {
			operacao = scanner.nextInt();
			operacaoValida = validaOperacao(operacao);
		}
		
		String descricaoOperacao = "";
		
		if (operacao == 1) {
			descricaoOperacao = "Soma";
		} else if (operacao == 2) {
			descricaoOperacao = "Subtração";
		}else if (operacao == 3) {
			descricaoOperacao = "Multiplicação";
		}else if (operacao == 4) {
			descricaoOperacao = "Divisão";
		}
		
		System.out.println("Sua opração escolhida foi: " + descricaoOperacao);
		
		int resultado = 0;
		int[] numeros = new int[] {};
			
		if (operacao == 4) {
			System.out.println("Informe o primeiro número");
			int primeiroNumeroDivisao = scanner.nextInt();
			System.out.println("");
			System.out.println("Informe o segundo número");
			int segundoNumeroDivisao = scanner.nextInt();
			
			boolean numerosValidos = false;
			
			while (!numerosValidos) {
				System.out.println("Números inválidos, informe outros números");
				System.out.println("Informe o primeiro número");
				primeiroNumeroDivisao = scanner.nextInt();
				System.out.println("");
				System.out.println("Informe o segundo número");
				segundoNumeroDivisao = scanner.nextInt();
				numerosValidos = validaDivisao(primeiroNumeroDivisao, segundoNumeroDivisao);
			}
			
			resultado = primeiroNumeroDivisao / segundoNumeroDivisao;
			
		} else {
			System.out.println("Para quantos números deseja realizar a " + descricaoOperacao);
			int qtdNumeros = scanner.nextInt();
			
			for (int i = 1; i <= qtdNumeros; i++) {
				System.out.println("Informe o seu " + i + "º número");
				numeros[i-1] = scanner.nextInt();
			}
			
			if (operacao == 1) {
				for (int i = 0; i < numeros.length; i++) {
					resultado += numeros[i];
				}
			} else if (operacao == 2) {
				for (int i = 0; i < numeros.length; i++) {
					resultado -= numeros[i];
				}
			} else if ((operacao == 3)) {
				for (int i = 0; i < numeros.length; i++) {
					resultado = 1;
					resultado = resultado * numeros[i];
				}
			}
		}
		
		
		
		System.out.println("O resultad da sua " + descricaoOperacao + " é: " + resultado);
		scanner.close();
				
	}
	
	public static void aguardarEntrada() {
		try {
			System.in.read();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public static boolean validaOperacao(int operacao) {
		
		if (operacao <= 4 && operacao >= 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean validaDivisao(int primeiroNumero, int segundoNumero) {
		
		if (primeiroNumero < segundoNumero) {
			return false;
		} else {
			return true;			
		}
			
		
	}

}
