package ort.tp1.tdas.ejercicios.ej3.clases;

public class Idioma {

	private String clave;
	private String descripcion;
	private ListaDeTerminos terminos;

	public Idioma(String clave, String descripcion) {
		this.setClave(clave);
		this.setDescripcion(descripcion);
		terminos = new ListaDeTerminos();
	}

	public void agregarOReemplazarTermino(String clave, String descripcion) {
		Termino termino = terminos.search(clave);
		if (termino == null) {
			terminos.add(new Termino(clave, descripcion));
		} else {
			termino.setValor(descripcion);
		}
	}

	public Termino eliminarTermino(String claveTermino) {
		return terminos.removeByKey(claveTermino);
	}

	public String getClave() {
		return clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void listarTerminos() {
		for (Termino termino : terminos) {
			System.out.println(termino);
		}
	}

	public String obtenerValorTermino(String termino) {
		return terminos.search(termino).getValor();
	}

	private void setClave(String clave) {
		if (clave == null || clave.isEmpty())
			throw new RuntimeException("Clave invalida");
		this.clave = clave;
	}

	public void setDescripcion(String descripcion) {
		if (descripcion == null || descripcion.isEmpty())
			throw new RuntimeException("Descripcion invalida");
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Idioma [clave=" + clave + ", descripcion=" + descripcion + "]";
	}


}