package ort.tp1.tdas.ejercicios.ej4.clases;

import ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaVehiculos extends ListaOrdenadaNodos<String, Vehiculo> {

	@Override
	public int compare(Vehiculo vehiculo1, Vehiculo vehiculo2) {
		return vehiculo1.getPatente().compareTo(vehiculo2.getPatente());
	}

	@Override
	public int compareByKey(String patente, Vehiculo vehiculo) {
		return patente.compareTo(vehiculo.getPatente());
	}

}
