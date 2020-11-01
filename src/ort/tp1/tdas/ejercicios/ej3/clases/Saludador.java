package ort.tp1.tdas.ejercicios.ej3.clases;

import java.util.Scanner;

/**
 * Esta clase debe:
 * - Cargar uno o mas diccionarios (uno en cada idioma, al menos dos) para que pueda:
 *    -- Mostrar errores
 *    -- Dar la bienvenida
 *    -- Solicitar un nombre (para que el Saludador lo pida por teclado).
 *    -- Decirle que tiene un lindo nombre
 *    -- Mostrar un saludo de despedida usando el nombre pedido por teclado.
 * - Elegir un idioma
 * - Ejecutar una rutima que:
 *   -- Salude
 *   -- Pida el nombre
 *   -- Lo cargue por teclado
 *   -- Diga que es un lindo nombre
 *   -- Despedir usando el nombre
 */
public class Saludador {
	private static final String ES = "ES";
	private static final String ESPANIOL = "Español";
	private static final String EN = "EN";
	private static final String INGLES = "Inglés";

	private static final String BIENVENIDA = "BIENVENIDA";
	private static final String DESPEDIDA = "DESPEDIDA";
	private static final String AFIRMATIVO = "AFIRMATIVO";
	private static final String NEGATIVO = "NEGATIVO";
	private static final String NOMBRE = "NOMBRE";
	private static final String IDIOMA_INVALIDO = "IDIOMA_INVALIDO";

	private static final String ES_BIENVENIDA_DESC = "¡Hola!";
	private static final String ES_DESPEDIDA_DESC = "¡Adios!";
	private static final String ES_AFIRMATIVO_DESC = "Si";
	private static final String ES_NEGATIVO_DESC = "No";
	private static final String ES_NOMBRE_DESC = "Ingresa tu nombre por favor: ";
	private static final String ES_IDIOMA_INVALIDO_DESC = "Idioma invalido";

	private static final String EN_BIENVENIDA_DESC = "Hello!";
	private static final String EN_DESPEDIDA_DESC = "Bye!";
	private static final String EN_AFIRMATIVO_DESC = "Yes";
	private static final String EN_NEGATIVO_DESC = "No";
	private static final String EN_NOMBRE_DESC = "Enter your name, please: ";
	private static final String EN_IDIOMA_INVALIDO_DESC = "Invalid language";

	private Diccionario diccionario;
	private String idioma;
	private Scanner input;

	public Saludador(String idioma) {
		this.diccionario = new Diccionario();
		this.cargarDiccionario(diccionario);
		this.idioma = idioma;
		this.input = new Scanner(System.in);
	}

	private void cargarDiccionario(Diccionario diccionario) {
		diccionario.agregarIdioma(ES, ESPANIOL);
		diccionario.agregarIdioma(EN, INGLES);

		diccionario.agregarTermino(ES, BIENVENIDA, ES_BIENVENIDA_DESC);
		diccionario.agregarTermino(ES, DESPEDIDA, ES_DESPEDIDA_DESC);
		diccionario.agregarTermino(ES, AFIRMATIVO, ES_AFIRMATIVO_DESC);
		diccionario.agregarTermino(ES, NEGATIVO, ES_NEGATIVO_DESC);
		diccionario.agregarTermino(ES, NOMBRE, ES_NOMBRE_DESC);
		diccionario.agregarTermino(ES, IDIOMA_INVALIDO, ES_IDIOMA_INVALIDO_DESC);

		diccionario.agregarTermino(EN, BIENVENIDA, EN_BIENVENIDA_DESC);
		diccionario.agregarTermino(EN, DESPEDIDA, EN_DESPEDIDA_DESC);
		diccionario.agregarTermino(EN, AFIRMATIVO, EN_AFIRMATIVO_DESC);
		diccionario.agregarTermino(EN, NEGATIVO, EN_NEGATIVO_DESC);
		diccionario.agregarTermino(EN, NOMBRE, EN_NOMBRE_DESC);
		diccionario.agregarTermino(EN, IDIOMA_INVALIDO, EN_IDIOMA_INVALIDO_DESC);
	}

	public void elegirIdioma(String idioma) throws RuntimeException {
		if (diccionario.idiomaValido(idioma)) {
			this.idioma = idioma;
		} else {
			throw new RuntimeException(diccionario.obtenerTermino(this.idioma, IDIOMA_INVALIDO));
		}
	}

	private String solicitarNombre() {
		System.out.print(diccionario.obtenerTermino(this.idioma.toUpperCase(), NOMBRE));
		return input.nextLine();
	}

	public void run() {
		System.out.println(diccionario.obtenerTermino(this.idioma, BIENVENIDA));
		String nombre = this.solicitarNombre();
		System.out.println(diccionario.obtenerTermino(this.idioma, DESPEDIDA));
	}
}
