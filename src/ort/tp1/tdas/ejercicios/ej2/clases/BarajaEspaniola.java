package ort.tp1.tdas.ejercicios.ej2.clases;

public class BarajaEspaniola extends Baraja {

	public enum PaloEspaniol implements Palo {
		ESPADAS, COPAS, ORO, BASTOS
	}
	
	private static final int CANTIDAD_COMODINES = 2;
	private static final int CANT_NAIPES_X_PALO = 12;
	
	public BarajaEspaniola() {
		this(false);
	}

	public BarajaEspaniola(boolean mezclado) {
		super(mezclado);
	}

	@Override
	protected void cargarNaipes() {
		cargarPalos();
		cargarComodines();
	}

	private void cargarComodines() {
		for (int i = 0; i < CANTIDAD_COMODINES; i++) {
			naipes.push(new Comodin());
		}
	}
	
	private void cargarPalos() {
		for (Palo palo : PaloEspaniol.values()) {
			for (int n = 0; n < CANT_NAIPES_X_PALO; n++) {
				naipes.push(new NaipeNumerado(n + 1, palo));
			}
		}
	}

	public boolean estaVacio() {
		return naipes.isEmpty();
	}

}