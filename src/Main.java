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

		int contador = 1;
		int sumaTotal = 0;

		int tamanoCodigoLimpio = 0;
		
		for (int i = 0; i < codiISBNUsuari.length(); i++) {
			if (codiISBNUsuari.charAt(i) != '-') {
				tamanoCodigoLimpio++;
			}
		}

		for (int i = 0; i < codiISBNUsuari.length(); i++) {
			if (codiISBNUsuari.charAt(i) != '-') {
				sumaTotal += (((int) codiISBNUsuari.charAt(i)) * contador);
				contador++;
			}
		}

		return sumaTotal;

	}

	public static boolean isISBNCorrect(String codiISBNUsuari) {
		int sumaTotalISBN = calcularSumaTotalISBN(codiISBNUsuari);

		if ((sumaTotalISBN % 11) == (Character.getNumericValue(codiISBNUsuari.charAt(codiISBNUsuari.length() - 1)))) {
			return true;
		} else if ((sumaTotalISBN % 11 == 10) && (codiISBNUsuari.charAt(codiISBNUsuari.length() - 1) == 'X')) {
			return true;
		} else {
			return false;
		}
	}

}
