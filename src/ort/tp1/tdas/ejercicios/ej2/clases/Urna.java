package ort.tp1.tdas.ejercicios.ej2.clases;

import java.util.ArrayList;

/**
 * Una urna es una clase especial que soporta Generics para guardar en ella
 * cualquier tipo de elemento que se necesite guardar. A la hora de extraer un
 * elemento, este elemento sera elegido al azar de entre cualquiera de los
 * elementos que se encuentren en ese momento guardados en la urna.
 * 
 * Internamente, para guardar los elementos, usa un arrayList.
 *
 * @param <E>
 *            El tipo (la clase) de elemento que contendra. Siempre debe ser una
 *            clase porque Generics solo soporta que los elementos sean objetos.
 */
public class Urna<E> {

	private ArrayList<E> elementos;

	public Urna() {
		elementos = new ArrayList<>();
	}

	/**
	 * Agrega un elemento a la estructura
	 * 
	 * @param elemento
	 */
	public void add(E elemento) {
		elementos.add(elemento);
	}

	/**
	 * @return La cantidad de elementos contenidos.
	 */
	public int elementCount() {
		return elementos.size();
	}

	/**
	 * Extrae un elemento al azar de los que se encuentran en la estructura (en
	 * el ArrayList interno).
	 * 
	 * @return El elemento que se extrajo del ArrayList. Si no hay ningun
	 *         elemento devolvera null.
	 */
	public E remove() {
		return (isEmpty()) ? null : elementos.remove((int) (Math.random() * elementos.size()));
	}

	/**
	 * @return Un booleano indicando su hay elementos guardados o no.
	 */
	public boolean isEmpty() {
		return elementos.isEmpty();
	}
}
