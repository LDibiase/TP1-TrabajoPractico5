package ort.tp1.tdas.ejercicios.ej3.clases;

public class Diccionario {

	private ListaDeIdiomas idiomas;
	
	public Diccionario() {
		idiomas = new ListaDeIdiomas();
	}

	public void agregarIdioma(String clave, String descripcion) {
		Idioma idiomaBuscado = idiomas.search(clave);
		if (idiomaBuscado == null) {
			idiomas.add(new Idioma(clave, descripcion));
		} else {
			throw new RuntimeException("El Idioma ya fue agregado");
		}
	}

	public void agregarTermino(String idioma, String clave, String descripcion) {
		Idioma idiomaBuscado = idiomas.search(idioma);
		if (idiomaBuscado == null) {
			throw new RuntimeException("Idioma no encontrado");
		} else {
			idiomaBuscado.agregarOReemplazarTermino(clave, descripcion);
		}
	}
	
	public Termino eliminarTermino(String idioma, String claveTermino) {
		Idioma idiomaBuscado = idiomas.search(idioma);
		if (idiomaBuscado == null) {
			throw new RuntimeException("Idioma no encontrado");
		} else {
			return idiomaBuscado.eliminarTermino(claveTermino);
		}
	}
	
	public void listar() {
		for (Idioma idioma : idiomas) {
			System.out.println(idioma);
			idioma.listarTerminos();
		}
	}

	public String obtenerTermino(String idioma, String termino) {
		return idiomas.search(idioma).obtenerValorTermino(termino);
	}

	public boolean idiomaValido(String idioma) {
		return idiomas.exists(idioma);
	}

}
