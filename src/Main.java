import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.print("Introdueix un codi ISBN: ");

		String codiISBNUsuari = sc.next();

		sc.close();

		System.out.println(codiISBNUsuari.length());

		System.out.println("Es correcte? -> " + isISBNCorrect(codiISBNUsuari));

	}

	public static int calcularSumaTotalISBN(String codiISBNUsuari) {

		char[] codiArray = codiISBNUsuari.toCharArray();

		int sumaTotal = 0;
		int contador = 1;

		for (int i = 0; i < (codiArray.length - 2); i++) {

			if (codiArray[i] != '-') {
				sumaTotal += codiArray[i] * contador;
				System.out.println();
				contador++;
			}

		}

		System.out.println("sumaTotal = " + sumaTotal);

		return sumaTotal;

	}

	public static boolean isISBNCorrect(String codiISBNUsuari) {
		int sumaTotalISBN = calcularSumaTotalISBN(codiISBNUsuari);
		char ultimoCaracter = codiISBNUsuari.charAt(codiISBNUsuari.length() - 1);

		if ((sumaTotalISBN % 11) == (Character.getNumericValue(ultimoCaracter))) {
			return true;
		} else if ((sumaTotalISBN % 11 == 10) && ultimoCaracter == 'X') {
			return true;
		} else {
			return false;
		}
	}

}
