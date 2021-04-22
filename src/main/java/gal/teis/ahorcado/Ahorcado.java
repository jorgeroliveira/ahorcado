package gal.teis.ahorcado;

import java.util.Scanner;

/**
 * Juego del ahorcado
 * 
 *
 */
public class Ahorcado {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		final int INTENTOS_TOTALES = 8; // Constante con el limite de fallos
		// contadores de intentos y aciertos
		int intentos = 0;
		int aciertos = 0;

		Scanner teclado = new Scanner(System.in);
		teclado.useDelimiter("\n");
		
		//donde guardaremos la letra introducida por teclado
		char resp;
		
		//variable para controlar que se ha acertado una o varias letras
		boolean letraAcertada = false;

		do {
			//Seleccionamos una palabra
			String palabraSeleccionada = PalabrasAhorcado.seleccionaPalabra();

			// Descomponemos la palabra seleccionada y la guardamos en un array de caracteres
			char[] palabraDescompuesta = UtilAhorcado.descomponer(palabraSeleccionada);
			
			// Array para guardar resultados parciales(Guiones o letras)
			char[] tusRespuestas = new char[palabraDescompuesta.length];

			// Rellenamos con guiones
			for (int i = 0; i < tusRespuestas.length; i++) {
				tusRespuestas[i] = '_';
			}

			// Empezamos 
			System.out.println("Adivina la palabra seleccionada!");

			// Mientras que no nos pasemos con los intentos y no la acertemos...
			while (intentos < INTENTOS_TOTALES && aciertos != tusRespuestas.length) {
				System.out.println("Nº de intentos:" + intentos + "/" + INTENTOS_TOTALES);
				System.out.println("Nº de aciertos:" + aciertos);
				UtilAhorcado.imprimeRespuesta(tusRespuestas);
				
				// Preguntamos por teclado
				System.out.println("\nIntroduce una letra: ");
				resp = teclado.next().toLowerCase().charAt(0);
				
				// Recorremos el array y comprobamos si se ha producido un acierto
				for (int i = 0; i < palabraDescompuesta.length; i++) {
					if (palabraDescompuesta[i] == resp) {
						tusRespuestas[i] = palabraDescompuesta[i];
						palabraDescompuesta[i] = ' ';
						aciertos++;
						letraAcertada = true;
					}
				}
				
				//Incrementamos el numero de intentos si hemos fallado con la letra
				if (letraAcertada == false) {
					intentos++;
				}
				letraAcertada = false;
			}

			// Si hemos acertado todas imprimimos un mensahe
			if (aciertos == tusRespuestas.length) {
				System.out.print("\nFelicidades!! has acertado la palabra: ");
				UtilAhorcado.imprimeRespuesta(tusRespuestas);
			}
			// Si no otro
			else {
				System.out.print("\nAHORCADO! la palabra era: " + palabraSeleccionada );
			}
			// Reseteamos contadores
			intentos = 0;
			aciertos = 0;
			// Volvemos a preguntarle al usuario si quiere volver a perder el tiempo
			resp = UtilAhorcado.pregunta("\n\nQuieres volver a jugar?", teclado);
		} while (resp != 'n');

	}
}
