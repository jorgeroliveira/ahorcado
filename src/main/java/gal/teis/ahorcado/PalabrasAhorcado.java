package gal.teis.ahorcado;

import java.util.ArrayList;
import java.util.Random;

public class PalabrasAhorcado {

	public static String seleccionaPalabra() {

		// Creamos unas palabras y le asignamos una aleatoria a una varibale
		ArrayList<String> listaPalabras = new ArrayList<>();
		listaPalabras.add("hola");
		listaPalabras.add("adios");
		listaPalabras.add("vehiculo");
		listaPalabras.add("casa");
		listaPalabras.add("mesa");
		listaPalabras.add("ventana");
		listaPalabras.add("holocausto");
		listaPalabras.add("color");

		// Random para pillar una palabra al azar
		Random rnd = new Random();
		int aleatorio = rnd.nextInt(listaPalabras.size());
		return listaPalabras.get(aleatorio);

	}

}
