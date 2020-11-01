package ort.tp1.tdas.implementaciones;

import ort.tp1.tdas.interfaces.Tda;

public class TdaNodos<T> implements Tda {

	protected Nodo<T> first;
	private int limite;
	private int size;

	protected TdaNodos() {
		this(SIN_LIMITE);
	}

	protected TdaNodos(int limite) {
		if (limite != SIN_LIMITE && limite < LIMITE_MINIMO_POSIBLE) {
			throw new IllegalArgumentException(ERR_TAM_ILEGAL);
		}
		this.limite = limite;
		this.first = null;
		this.size = 0;
	}

	protected void incrementSize() {
		size++;
	}

	protected void decrementSize() {
		size--;
	}

	@Override
	public void checkEmptiness() throws RuntimeException {
		if (isEmpty()) {
			throw new RuntimeException(
					String.format(ERR_ESTRUCTURA_VACIA, this.getClass().getInterfaces()[0].getSimpleName()));
		}
	}

	@Override
	public void checkFullness() throws RuntimeException {
		if (isFull()) {
			throw new RuntimeException(
					String.format(ERR_ESTRUCTURA_LLENA, this.getClass().getInterfaces()[0].getSimpleName()));
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean isFull() {
		return size == limite;
	}

	@Override
	public int size() {
		return size;
	}

}
