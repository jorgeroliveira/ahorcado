/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.recuperacion.e.juego.ahorcado;

/**
 *
 * @author luPinheiro
 */
public class DescomponerAhorcado {
        
        //En el método hacemos un array de caracteres (letras) para 
        //descomponer las palabras
    	public static char[] descomponer(String palabrasAzar) {
		char[] letras;
		letras = new char[palabrasAzar.length()];
		for (int i = 0; i < palabrasAzar.length(); i++) {
                        //charAt para  acceder a un carácter en concreto de la cadena.
                        //el caractet inicial de la cadena.
			letras[i] = palabrasAzar.charAt(i);
		}
		return letras;
	}
        

}
        
        
      
 