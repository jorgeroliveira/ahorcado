package gal.teis.recuperacion.e.juego.ahorcado;

public class NivelDificultad {
	
	private int numeroFallos;
	private int nivelDificultad;

	public NivelDificultad() {
		super();
	}

	public int getNumeroFallos() {
		return numeroFallos;
	}

	public int getNivelDificultad() {
		return nivelDificultad;
	}
	
	public void setNivelDificultad(int nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
		switch (nivelDificultad) {
		case 1:
			this.numeroFallos = 15;
			break;
			
		case 2:
			this.numeroFallos = 13;
			break;

		default:
			this.numeroFallos = 10;
			break;
		}
	}

}
