package ort.tp1.tdas.ejercicios.ej1.clases;

public class FabricanteDePelotas {
	
	private static final int CANTIDAD_PELOTAS = 3;

	public static TuboPelotasDeTenis fabricarTubo() {
		TuboPelotasDeTenis tuboDePelotas = new TuboPelotasDeTenis(CANTIDAD_PELOTAS);
		while(!tuboDePelotas.estaLleno()) {
			tuboDePelotas.guardar(new PelotaDeTenis());
		}
		return tuboDePelotas;
	}

}
