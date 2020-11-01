package ort.tp1.tdas.ejercicios.ej2.clases;

import java.util.ArrayList;

import ort.tp1.tdas.implementaciones.ColaNodos;
import ort.tp1.tdas.implementaciones.PilaNodos;
import ort.tp1.tdas.interfaces.Cola;
import ort.tp1.tdas.interfaces.Pila;

public abstract class Baraja {

	protected Pila<Naipe> naipes;

	public Baraja(boolean mezclado) {
		naipes = new PilaNodos<Naipe>();
		cargarNaipes();
		if (mezclado) {
			mezclar();
		}
	}

	public void agregar(ArrayList<Naipe> nuevosNaipes) {
		while (!nuevosNaipes.isEmpty()) {
			naipes.push(nuevosNaipes.remove(0));			
		}
	}

	public void agregar(Cola<Naipe> nuevosNaipes) {
		while (!nuevosNaipes.isEmpty()) {
			naipes.push(nuevosNaipes.remove());			
		}
	}

	public void agregar(Naipe naipe) {
		naipes.push(naipe);
	}

	public void agregar(Pila<Naipe> nuevosNaipes) {
		while (!nuevosNaipes.isEmpty()) {
			naipes.push(nuevosNaipes.pop());			
		}
	}

	protected abstract void cargarNaipes();

	public Naipe extraer() {
		return naipes.pop();
	}

	public Cola<Naipe> extraer(int cuantos) {
		Cola<Naipe> queue = new ColaNodos<>();
		int count = 1;

		while (count <= cuantos) {
			queue.add(this.extraer());
			count++;
		}

		return queue;
	}

	public int getCantidadNaipes() {
		return naipes.size();
	}

	/**
	 * Explicar aca que hace y como funciona
	 */
	protected void mezclar() {
		//La clase urna tiene la particularidad que le podes cargar cualquier tipo de dato
		Urna<Naipe> mezclador = new Urna<>();

		while (!naipes.isEmpty()) {
			//Se desencola los naipes y se los agrega al mezclador/urna
			mezclador.add(naipes.pop());
		}
		while (!mezclador.isEmpty()) {
			//Se vuelve a cargar la pila de naipes, con la particularidad que el remove() de urna devuelve
			// los elementos en un orden aleatorio.
			naipes.push(mezclador.remove());
		}
	}
}