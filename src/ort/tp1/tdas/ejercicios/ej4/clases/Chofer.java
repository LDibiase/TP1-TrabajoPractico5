package ort.tp1.tdas.ejercicios.ej4.clases;

public class Chofer {
	private int dni;
	private int legajo;
	private String nombre;
	private Vehiculo vehiculo;

	public Chofer(int dni, int legajo, String nombre) {
		this.setDni(dni);
		this.setLegajo(legajo);
		this.setNombre(nombre);
		this.asignarVehiculo(null);
	}

	public int getDni() {
		return dni;
	}

	public int getLegajo() {
		return legajo;
	}

	public String getNombre() {
		return nombre;
	}

	private void setDni(int dni) {
		this.dni = dni;
	}

	private void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void asignarVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public boolean ListoParaViajar() {
		return vehiculo != null && vehiculo.getCargaAsignada() != null;
	}

	@Override
	public String toString() {
		return "Chofer [dni=" + dni + ", legajo=" + legajo + ", nombre=" + nombre + ", vehiculo=" + vehiculo + "]";
	}

}
