package ort.tp1.tdas.ejercicios.ej3;

import ort.tp1.tdas.ejercicios.ej3.clases.Saludador;

public class Ejercicio3 {

	private static Saludador saludador;
	
	public static void main(String[] args) {
		saludador = new Saludador("ES");
		saludador.run();
		
		cambiarIdiomaYEjecutar("EN");
		cambiarIdiomaYEjecutar("FR");
	}

	private static void cambiarIdiomaYEjecutar(String idioma) {
		try {
			saludador.elegirIdioma(idioma);
			saludador.run();
		} catch (RuntimeException re) {
			System.out.println("Upss... hubo un error:");
			System.out.println(re.getMessage());
		}
	}
}