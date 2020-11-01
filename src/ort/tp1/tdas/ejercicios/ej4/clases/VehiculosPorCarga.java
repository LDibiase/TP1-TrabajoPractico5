package ort.tp1.tdas.ejercicios.ej4.clases;

import ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class VehiculosPorCarga extends ListaOrdenadaNodos<String, Vehiculo> {
	@Override
	public int compare(Vehiculo dato1, Vehiculo dato2) {
		return (int)(dato1.getCapacidadDeCarga() - dato2.getCapacidadDeCarga());
	}

	@Override
	public int compareByKey(String clave, Vehiculo elemento) {
		return 0;
	}
}
