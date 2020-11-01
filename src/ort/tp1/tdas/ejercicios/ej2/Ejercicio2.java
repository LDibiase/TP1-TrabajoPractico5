package ort.tp1.tdas.ejercicios.ej2;

import ort.tp1.tdas.ejercicios.ej2.clases.BarajaEspaniola;
import ort.tp1.tdas.ejercicios.ej2.clases.Naipe;
import ort.tp1.tdas.ejercicios.ej2.clases.NaipeNumerado;
import ort.tp1.tdas.implementaciones.ColaNodos;
import ort.tp1.tdas.interfaces.Cola;

public class Ejercicio2 {

	public static void main(String[] args) {
		BarajaEspaniola mazo = new BarajaEspaniola(true);
		Cola<Naipe> monton = mazo.extraer(10);
		
		boolean hayComodines = revisar(monton);
		
		if (hayComodines) {
			System.out.println("Se encontraron comodines");
		} else {
			System.out.println("No se encontraron comodines");
		}
	}

	private static boolean revisar(Cola<Naipe> monton) {
		boolean hay = false;
		// creamos un naipe inexistente (con numero 0)
		NaipeNumerado extra = new NaipeNumerado(0, BarajaEspaniola.PaloEspaniol.BASTOS);
		monton.add(extra);

		Naipe naipe = null;

		do {
			naipe = monton.remove();

			if (naipe.getDescripcion().equalsIgnoreCase("Comodin")) {
				hay = true;
			}

			if (!naipe.getDescripcion().equalsIgnoreCase(extra.getDescripcion())) {
				monton.add(naipe);
			}

		} while (!naipe.getDescripcion().equalsIgnoreCase(extra.getDescripcion()));

		return hay;
	}
}