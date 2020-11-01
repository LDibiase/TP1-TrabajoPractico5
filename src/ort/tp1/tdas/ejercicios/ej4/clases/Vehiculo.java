package ort.tp1.tdas.ejercicios.ej4.clases;

public class Vehiculo {
	private String patente;
	private TipoVehiculo tipoVehiculo;
	private double capacidadDeCarga;
	private Chofer choferACargo;
	private Carga cargaAsignada;

	public Vehiculo(String patente, TipoVehiculo tipoVehiculo, double capacidadDeCarga) {
		this.setPatente(patente);
		this.setTipoVehiculo(tipoVehiculo);
		this.setCapacidadDeCarga(capacidadDeCarga);
		this.asignarChofer(null);
		this.asignarCarga(null);
	}

	public double getCapacidadDeCarga() {
		return capacidadDeCarga;
	}

	public Carga getCargaAsignada() {
		return cargaAsignada;
	}

	public Chofer getChoferACargo() {
		return choferACargo;
	}

	public String getNombreChofer() {
		return (choferACargo == null) ? "Ninguno" : choferACargo.getNombre();
	}

	public String getPatente() {
		return patente;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	private void setCapacidadDeCarga(double capacidadDeCarga) {
		if (capacidadDeCarga <= 0) {
			throw new IllegalArgumentException("La capacidad de carga debe ser mayor a cero.");
		}
		this.capacidadDeCarga = capacidadDeCarga;
	}

	private void asignarCarga(Carga cargaAsignada) {
		this.cargaAsignada = cargaAsignada;
	}

	public Carga liberarCarga() {
		Carga carga = this.cargaAsignada;
		this.cargaAsignada = null;
		return carga;
	}

	public Chofer liberarChofer() {
		Chofer chofer = this.choferACargo;
		this.choferACargo = null;
		return chofer;
	}

	public void asignarChofer(Chofer choferACargo) {
		this.choferACargo = choferACargo;
	}

	private void setPatente(String patente) {
		if (patente == null || patente.isEmpty()) {
			throw new IllegalArgumentException("La patente no puede estar vacia.");
		}
		this.patente = patente;
	}

	private void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", tipoVehiculo=" + tipoVehiculo + ", capacidadDeCarga="
				+ capacidadDeCarga + ", choferACargo=" + choferACargo + ", cargaAsignada=" + cargaAsignada + "]";
	}

}
