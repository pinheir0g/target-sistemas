package targetSistemasTeste.tecnico;

import java.util.Scanner;

public class InverterString {
	
	public static String inverterString(String str) {
		char[] caracteres = str.toCharArray();
		int left = 0;
		int right = caracteres.length - 1;
		
		while (left < right) {
			// Trocar caracteres
			char temp = caracteres[left];
			caracteres[left] = caracteres[right];
			caracteres[right] = temp;
			
			// Mover índices
			left++;
			right--;
		}
		
		return new String(caracteres);
	}
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string para inverter: ");
        String input = scanner.nextLine();
        scanner.close();
        String invertedString = inverterString(input);

        System.out.println("String invertida: " + invertedString);
    }

}