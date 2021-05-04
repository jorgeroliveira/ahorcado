/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.recuperacion.e.juego.ahorcado;

import java.util.Random;

/**
 *
 * @author luPinheiro
 */
public class PalabrasAhorcado {

	// método para selecionar las palabras por medio de Random
	public static String seleccionaPalabra(int nivelDificultad) {

		// Arrays de palabras

		String[] listaPalabrasBasico = new String[10];
		listaPalabrasBasico[0] = "ACEBO";
		listaPalabrasBasico[1] = "BANCO";
		listaPalabrasBasico[2] = "BARCO";
		listaPalabrasBasico[3] = "CABRA";
		listaPalabrasBasico[4] = "CISNE";
		listaPalabrasBasico[5] = "ETICA";
		listaPalabrasBasico[6] = "GALLO";
		listaPalabrasBasico[7] = "MEDIA";
		listaPalabrasBasico[8] = "QUESO";
		listaPalabrasBasico[9] = "ULTRA";

		String[] listaPalabrasMedio = new String[10];
		listaPalabrasMedio[0] = "ABUELOS";
		listaPalabrasMedio[1] = "BATALLA";
		listaPalabrasMedio[2] = "BOTIGAS";
		listaPalabrasMedio[3] = "CERRADO";
		listaPalabrasMedio[4] = "DISFRAZ";
		listaPalabrasMedio[5] = "ECLIPSE";
		listaPalabrasMedio[6] = "FRUTERA";
		listaPalabrasMedio[7] = "GEMELOS";
		listaPalabrasMedio[8] = "JABONES";
		listaPalabrasMedio[9] = "VIAJERO";

		String[] listaPalabrasAlto = new String[10];
		listaPalabrasAlto[0] = "ANOCHECER";
		listaPalabrasAlto[1] = "BUROCRATA";
		listaPalabrasAlto[2] = "CUCURUCHO";
		listaPalabrasAlto[3] = "EXIGENCIA";
		listaPalabrasAlto[4] = "ROBUSTEZA";
		listaPalabrasAlto[5] = "SUFRIDORA";
		listaPalabrasAlto[6] = "TRIANGULO";
		listaPalabrasAlto[7] = "TUBERCULO";
		listaPalabrasAlto[8] = "VITICOLAS";
		listaPalabrasAlto[9] = "ZAPATILLA";

		// Usamos Random para selecionar las palabras al azar
		Random random = new Random();
		int aleatorio = random.nextInt(listaPalabrasBasico.length);

		switch (nivelDificultad) {
		case 1:
			return listaPalabrasBasico[aleatorio].toLowerCase();

		case 2:
			return listaPalabrasMedio[aleatorio].toLowerCase();

		default:
			return listaPalabrasAlto[aleatorio].toLowerCase();
		}

	}
}
