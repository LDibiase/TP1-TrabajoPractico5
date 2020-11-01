package ort.tp1.tdas.ejercicios.ej3.clases;

public class Termino {

	private String clave;
	private String valor;

	public Termino(String clave, String valor) {
		setClave(clave);
		setValor(valor);
	}
	
	public String getClave() {
		return clave;
	}

	public String getValor() {
		return valor;
	}

	private void setClave(String clave) {
		if (clave == null || clave.isEmpty())
			throw new RuntimeException("Clave invalida");
		this.clave = clave;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Termino [clave=" + clave + ", valor=" + valor + "]";
	}

}
