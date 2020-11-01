package ort.tp1.tdas.ejercicios.ej4.clases;

import ort.tp1.tdas.implementaciones.ColaNodos;
import ort.tp1.tdas.interfaces.Cola;

public class CompaniaDeTransportes {
	private static int ultimoLegajo = 0;

	private ListaChoferes staff;
	private ListaVehiculos flota;
	private Cola<Vehiculo> viajesListos;

	// 1 - Crear las estructuras propuestas
	public CompaniaDeTransportes() {
		this.staff = new ListaChoferes();
		this.flota = new ListaVehiculos();
		this.viajesListos = new ColaNodos<>();
	}

	public void altaChofer(int dni, String nombre) {
		Chofer chofer = staff.search(dni);
		if (chofer != null) {
			throw new RuntimeException("Chofer existente!");
		}
		staff.add(new Chofer(dni, proximoLegajo(), nombre));
	}

	public Chofer bajaChofer(int dni) {
		Chofer chofer = staff.search(dni);
		if (chofer != null) {
			if (chofer.getVehiculo() == null)
				staff.remove(chofer);
			else
				throw new RuntimeException("No se puede despedir a un chofer en viaje!");
		}
		return chofer;
	}

	public void altaVehiculo(String patente, TipoVehiculo tipoVehiculo, double capacidadDeCarga) {
		Vehiculo vehiculo = flota.search(patente);
		if (vehiculo != null) {
			throw new RuntimeException("Vehiculo existente!");
		}
		flota.add(new Vehiculo(patente, tipoVehiculo, capacidadDeCarga));
	}

	private static int proximoLegajo() {
		return ++ultimoLegajo;
	}

	public void listarChoferes() {
		for (Chofer chofer : staff) {
			System.out.println(chofer);
		}
	}

	public void listarVehiculos() {
		for (Vehiculo vehiculo : flota) {
			System.out.println(vehiculo);
		}
	}

	// 2 - Asignar un vehiculo a un chofer (utilizando Excepciones)
	public void asignarVehiculo(String patenteVehiculo, int dniChofer) {
		Vehiculo vehiculo = this.flota.search(patenteVehiculo);

		if (vehiculo == null) {
			throw new RuntimeException("Vehiculo no encontrado");
		}

		Chofer chofer = staff.search(dniChofer);

		if (chofer == null) {
			throw new RuntimeException("Chofer no encontrado");
		}

		vehiculo.asignarChofer(chofer);
		chofer.asignarVehiculo(vehiculo);
	}

	// 3 - Asignar una carga (utilizando Excepciones) al vehiculo que más se
	// adapte al peso de la carga.
	// a - Vehiculo con conductor asignado.
	// b - No debe tener carga asignada.
	// c - Su capacidad debe ser mayor o igual al peso de la carga.
	// De todos los vehículos posibles debe quedarse con el menor de todos
	// ellos.
	//
	// Si se logra asignar la carga el vehiculo debe agregarse a la cola de
	// vehiculos listos para partir.
	public void asignarCarga(Carga carga) {
		System.out.println("\n*** ASIGNACION DE CARGA ***");

		VehiculosPorCarga vehiculosConConductorYCargaDisponible = new VehiculosPorCarga();

		flota.forEach(x-> {
			if (x.getChoferACargo() != null && x.getCargaAsignada() == null && x.getCapacidadDeCarga() >= carga.getPeso()) {
				vehiculosConConductorYCargaDisponible.add(x);
			}
		});

		if (vehiculosConConductorYCargaDisponible.isEmpty()) {
			throw new RuntimeException("No hay vehiculo disponible para la carga");
		}

		//Si están ordenados por capacidad de carga, el primero va a ser el de carga mas "optima"
		System.out.println("Carga a transportar: " + carga.toString());
		viajesListos.add(vehiculosConConductorYCargaDisponible.get(0));
	}

	// 4 - Listar choferes libres (que no estan de viaje)
	public void listarChoferesLibres() {
		System.out.println("\n--- Choferes Libres ---");

		for (Chofer chofer : staff) {
			if (chofer.getVehiculo() == null) {
				System.out.println(chofer.toString());
			}
		}
	}

	// 5 - Listar los vehiculos listos para salir de viaje (la estructura debe
	// quedar en el orden inicial).
	public void listarVehiculosListosParaPartir() {
		System.out.println("\n--- Vehiculos listos ---");
		Cola<Vehiculo> colaAux = new ColaNodos<>();

		while(!viajesListos.isEmpty()) {
			Vehiculo vehiculo = viajesListos.remove();
			System.out.println(vehiculo.getPatente());
			colaAux.add(vehiculo);
		}

		while(!colaAux.isEmpty()) {
			Vehiculo vehiculo = colaAux.remove();
			viajesListos.add(vehiculo);
		}
	}

}