package ort.tp1.tdas.ejercicios.ej4;

import ort.tp1.tdas.ejercicios.ej4.clases.Carga;
import ort.tp1.tdas.ejercicios.ej4.clases.CompaniaDeTransportes;
import ort.tp1.tdas.ejercicios.ej4.clases.TipoVehiculo;

public class Ejercicio4 {
	private static CompaniaDeTransportes ct;

	public static void main(String[] args) {
		// Creacion de la compania
		ct = new CompaniaDeTransportes();
		
		System.out.println("Carga de choferes...");
		altaChofer(12345678, "Aparicio Luna");
		altaChofer(23456789, "Marcos Gravevoz");
		altaChofer(34127856, "Kosher Waters");
		altaChofer(31426758, "Greta Barbol");
		altaChofer(24785236, "Esteban Quete");

		System.out.println("Carga de vehiculos...");
		altaVehiculo("AA 000 ZZ", TipoVehiculo.CAMION, 12000);
		altaVehiculo("FDE999", TipoVehiculo.CAMION_CON_TOLVA, 24000);
		altaVehiculo("CD 222 DC", TipoVehiculo.CAMIONETA, 3500);
		altaVehiculo("EF 333 FE", TipoVehiculo.CAMION, 9000);
		altaVehiculo("HG 444 GH", TipoVehiculo.CAMION_ACOPLADO, 20500);

		System.out.println("Baja de un chofer...");
		bajaChofer(24785236);
		altaChofer(91684500, "Rex Mifune");

		ct.listarChoferes();
		ct.listarVehiculos();

		// Procesar viajes

		System.out.println("Se asignan los vehiculos");
		asignarVehiculo(null, 12345678);
		asignarVehiculo("AA 000 ZZ", -1);
		asignarVehiculo("AA 000 ZZ", 12345678);
		asignarVehiculo("AA 000 ZZ", 12345678);
		asignarVehiculo("HG 444 GH", 31426758);
		asignarVehiculo("CD 222 DC", 91684500);
		asignarVehiculo("FDE999", 34127856);

		System.out.println("Se asignan las cargas");
		asignarCargaAVehiculo("Muebles", 3402.3);
		asignarCargaAVehiculo("Harina de trigo", 22402.98);
		asignarCargaAVehiculo("Acero", 18744);

		ct.listarChoferesLibres();
		ct.listarVehiculosListosParaPartir();
	}

	// Desarrollar todos los metodos que aparecen a continuacion teniendo en
	// cuenta la captura de excepciones.
	
	private static void bajaChofer(int dni) {
		try {
			ct.bajaChofer(dni);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void asignarCargaAVehiculo(String descripcionCarga, double peso) {
		try {
			ct.asignarCarga(new Carga(descripcionCarga, peso));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void altaVehiculo(String patente, TipoVehiculo tipoVehiculo, double cargaMaxima) {
		try {
			ct.altaVehiculo(patente, tipoVehiculo, cargaMaxima);
		} catch (Exception e) {
			System.out.println("Error al cargar el vehiculo - " + e.getMessage());
		}
	}

	private static void altaChofer(int dniChofer, String nombreCompleto) {
		try {
			ct.altaChofer(dniChofer, nombreCompleto);
		} catch (Exception e) {
			System.out.println("Error al cargar el chofer - " + e.getMessage());
		}
	}

	private static void asignarVehiculo(String patente, int dniChofer) {
		try {
			ct.asignarVehiculo(patente, dniChofer);
		} catch (Exception e) {
			System.out.println("Error al asignar el vehiculo - " + e.getMessage());
		}
	}

}