package targetSistemasTeste.tecnico;

import java.util.Scanner;

public class SequenciaFibonacci {

	public static boolean isFibonacci(int num) {
		// Função para calcular a sequência de Fibonacci até encontrar o número ou
		// ultrapassá-lo

		int a = 0, b = 1;
		while (a < num) {
			int temp = a;
			a = b;
			b = temp + b;
		}
		return a == num;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Informe um número: ");
		int numero = scanner.nextInt();

		if (isFibonacci(numero)) {
			System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
		} else {
			System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
		}

		scanner.close();

	}

}