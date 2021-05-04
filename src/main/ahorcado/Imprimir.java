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
 */
public class Imprimir {
    
        // Método para imprimir la palabra con espacios
	public static void imprimeRespuesta(char[] tusRespuestas) {

		for (int i = 0; i < tusRespuestas.length; i++) {
			System.out.print(tusRespuestas[i] + " ");
		}
	}
        
     
        //método para comprobar los caracteres introducidos
        //método para volver a jugar novamente
	public static char pregunta(String men, Scanner teclado) {
            
		char respuesta;
		System.out.println(men + " (s/n)");
		respuesta = teclado.next().toLowerCase().charAt(0);
		while (respuesta != 's' && respuesta != 'n') {
			System.out.println("Error! solo se admite S o N");
			respuesta = teclado.next().toLowerCase().charAt(0);
		}
		return respuesta;
	}
	
	@SuppressWarnings("resource")
	public static NivelDificultad preguntaNivel() {
		//mostramos los niveles de dificultad
		System.out.println("**** Seleccion de nivel de dificultad ****");
		System.out.println(" 1 - Nivel básico.");
		System.out.println(" 2 - Nivel medio.");
		System.out.println(" 3 - Nivel alto.");
		System.out.println("Introduzca un numero de nivel: ");
		
		//preguntamos el nivel
		Scanner teclado = new Scanner(System.in);
		int respuesta = teclado.nextInt();
		while (respuesta != 1 && respuesta != 2 && respuesta != 3) {
			System.out.println("Error! solo se admite 1, 2 o 3");
			respuesta = teclado.nextInt();
		}
		
		
		NivelDificultad nivel = new NivelDificultad();
		nivel.setNivelDificultad(respuesta);
		
		return nivel;
		
	}
}
