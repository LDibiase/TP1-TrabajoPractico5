package ort.tp1.tdas.ejercicios.ej1.clases;

public class PelotaDeTenis {
	public enum EstadoPelota {
		NUEVA, USADA, GASTADA
	}

	private static final int TOPE_USO = 7;

	private int usos;

	public PelotaDeTenis() {
		usos = 0;
	}

	public int getUsos() {
		return usos;
	}

	public void usar() {
		usos++;
	}

	public EstadoPelota getEstado() {
		return (usos == 0) ? EstadoPelota.NUEVA : (usos <= TOPE_USO) ? EstadoPelota.USADA : EstadoPelota.GASTADA;
	}

	@Override
	public String toString() {
		return "PelotaDeTenis [usos=" + usos + ", estado=" + getEstado() + "]";
	}
}

