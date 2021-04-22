package gal.teis.ahorcado;

import java.util.Scanner;

public class UtilAhorcado {
	
	/**
	 * Descompone el String en un array de caracteres
	 * 
	 * @return array de letras.
	 */
	public static char[] descomponer(String palAzar) {
		char[] letras;
		letras = new char[palAzar.length()];
		for (int i = 0; i < palAzar.length(); i++) {
			letras[i] = palAzar.charAt(i);
		}
		return letras;
	}
	
	/**
	 * Imprime la palabra con espacios
	 * 
	 * @param tusRespuestas el array de caracteres
	 */
	public static void imprimeRespuesta(char[] tusRespuestas) {

		for (int i = 0; i < tusRespuestas.length; i++) {
			System.out.print(tusRespuestas[i] + " ");
		}
	}

	/**
	 * Esto nos pregunta si queremos volver a jugar y comprueba los caracteres
	 * introducidos
	 * 
	 * @param men texto para mostrar al usuario
	 * @return caracter de respuesta (s/n)
	 */
	public static char pregunta(String men, Scanner teclado) {
		char resp;
		System.out.println(men + " (s/n)");
		resp = teclado.next().toLowerCase().charAt(0);
		while (resp != 's' && resp != 'n') {
			System.out.println("Error! solo se admite S o N");
			resp = teclado.next().toLowerCase().charAt(0);
		}
		return resp;
	}

}
