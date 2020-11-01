package ort.tp1.tdas.ejercicios.ej1;

import ort.tp1.tdas.ejercicios.ej1.clases.FabricanteDePelotas;
import ort.tp1.tdas.ejercicios.ej1.clases.PelotaDeTenis;
import ort.tp1.tdas.ejercicios.ej1.clases.TuboPelotasDeTenis;
import ort.tp1.tdas.implementaciones.PilaNodos;
import ort.tp1.tdas.interfaces.Pila;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Obtener un tubo de pelotas de tenis del Fabricante
		TuboPelotasDeTenis tuboDePelotas = FabricanteDePelotas.fabricarTubo();

		// Sacar una pelota del tubo, usara una vez y volverla la guardar.
		PelotaDeTenis pelota = tuboDePelotas.extraer();
		pelota.usar();
		tuboDePelotas.guardar(pelota);
		
		// Desarrollar el metodo nombrado a continuacion.
		// Debe quedar tal como estaba al recibirlo.
		listarContenidoTubo(tuboDePelotas);
	}

	private static void listarContenidoTubo(TuboPelotasDeTenis tuboDePelotas) {
		TuboPelotasDeTenis tuboAux = new TuboPelotasDeTenis(3);

		//MUESTRO EL CONTENIDO DEL TUBO Y GUARDO EN UNA PILA AUXILIAR
		while (!tuboDePelotas.estaVacio()) {
			PelotaDeTenis pelotaDeTenis = tuboDePelotas.extraer();
			System.out.println(pelotaDeTenis.toString());

			tuboAux.guardar(pelotaDeTenis);
		}

		//VUELVO A DEJAR LA PILA COMO LA ENCONTRE
		swapStacks(tuboAux, tuboDePelotas);

	}

	private static void swapStacks(TuboPelotasDeTenis stack1, TuboPelotasDeTenis stack2) {
		while (!stack1.estaVacio()) {
			stack2.guardar(stack1.extraer());
		}
	}
}
