/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.recuperacion.e.juego.ahorcado;

import java.util.Scanner;

/**
 *
 * @author luPinheiro
 *
 *         /* Reglas: Juego ahorcado Adivinar palabras poniendo letras
 *
 *         Adivinar palabras poniendo letras:
 * 
 *         1- cada letra que se inserte se comprueba si la letra está está en la
 *         palabra buscada. 2- Si el usuario acierta con una letra sacamos por
 *         pantalla la la posición donde está letra en la palabra. Ej. palabra
 *         buscar CASA. Si se introduce la "A" sacamos por pantalla: __A__A. 3-
 *         Si el usuario no acierta con la letra vamos rellenando un array de
 *         caracteres con la palabra ahorcado. Ej. si el usuario introduce una
 *         letra que no exista en la palabra y es la 1a que falla sacamos por
 *         pantalla: estado: A__ __ __ . 4- Si el usuario vuelve a fallar vamos
 *         rellenando el estado con el resto de letras de la palabra AHORCADO.
 * 
 *         ? Cuando gana el usuario y cuando pierde? 5- Gana cuando acierta
 *         todas las letras de la palabra buscada. 6- El juego constará de 8
 *         intentos. Pierde cuando completa el estado con todas las letras dela
 *         palabra AHORCADO.
 */
public class PrincipalAhorcado {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		// ****************************Juego Ahorcado***************************//
		// ******Declaracion de Variables******
		// Constante con el limite de fallos
		int fallosTotales = 0;

		// contadores de fallos y aciertos
		int fallos = 0;
		int aciertos = 0;

		// donde guardaremos la letra introducida por teclado
		char respuesta;

		// variable para controlar que se ha acertado una o varias letras
		boolean letraAcertada = false;

		Scanner teclado = new Scanner(System.in);
		// Delimitador de cadena, por lo que aceptara espacios.
		teclado.useDelimiter("\n");

		// ******Métodos usados en el Juego******
		do {
			// preguntamos el nivel de dificultad
			NivelDificultad nivel = Imprimir.preguntaNivel();
			// actualizamos el numero de fallos según el nivel de dificultad.
			fallosTotales = nivel.getNumeroFallos();

			// 1-Seleccionamos una palabra
			// llamamos al método seleccionaPalabra() con el nivel de dificultad y guardamos
			// las respuestas en la variable palabraSelecionada de la clase PalabrasAhorcado
			String palabraSeleccionada = PalabrasAhorcado.seleccionaPalabra(nivel.getNivelDificultad());

			// 2- Descomponemos la palabra seleccionada y la guardamos
			// en un array de caracteres
			// Se usa el método descomponer() de clase DescomponerAhorcado
			char[] palabraDescompuesta = DescomponerAhorcado.descomponer(palabraSeleccionada);

			// 3- Array para guardar los resultados parciales(Guiones o letras)
			char[] tusRespuestas = new char[palabraDescompuesta.length];

			// 4- Rellenamos con guiones
			for (int i = 0; i < tusRespuestas.length; i++) {
				tusRespuestas[i] = '_';
			}

			// 5- ******Se inicia por consola******
			// Reglas para los usuarios:
			// No se debe pasar de los 8 intentos
			System.out.println("Juego Ahorcado: Advina cúal es la palabra");
			System.out.println();
			System.out.println("Dame una letra");

			// Mientras que no nos pasemos con los intentos y no la acertemos...
			while (fallos < fallosTotales && aciertos != tusRespuestas.length) {
				System.out.println("Nº de intentos:" + fallos + "/" + fallosTotales);
				System.out.println("Nº de aciertos:" + aciertos);
				// Se usa el método imprimeRespuesta
				Imprimir.imprimeRespuesta(tusRespuestas);

				// Preguntamos por teclado
				System.out.println("\nIntroduce una letra: ");
				respuesta = teclado.next().toLowerCase().charAt(0);

				// Recorremos el array y comprobamos si se ha producido un acierto
				for (int i = 0; i < palabraDescompuesta.length; i++) {
					if (palabraDescompuesta[i] == respuesta) {
						tusRespuestas[i] = palabraDescompuesta[i];
						palabraDescompuesta[i] = ' ';
						aciertos++;
						letraAcertada = true;
					}
				}

				// Incrementamos el numero de intentos si hemos fallado con la letra
				if (letraAcertada == false) {
					fallos++;
				}
				letraAcertada = false;
			}

			// Si hemos acertado todas imprimimos un mensaje
			if (aciertos == tusRespuestas.length) {
				System.out.print("\nFelicidades!! has acertado la palabra: ");
				Imprimir.imprimeRespuesta(tusRespuestas);
			}
			// Si no otro
			else {
				System.out.print("\nAHORCADO! la palabra era: " + palabraSeleccionada);
			}
			// Reseteamos los contadores
			fallos = 0;
			aciertos = 0;

			// Volvemos a preguntarle al usuario si quiere volver a jugar
			// Método pues si queremos jugar novamente: "s/n"
			respuesta = Imprimir.pregunta("\n\nQuieres volver a jugar?", teclado);

			if (respuesta == 'n') {
				System.out.println("Hasta Luego!!!");
			}

		} while (respuesta != 'n');

	}

}
