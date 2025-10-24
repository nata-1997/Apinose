package co.edu.uco.nose.crosscuting.helper;

public final class TextHelper {
	
	// Constante para representar una cadena vacía
	private static final String EMPTY = "";
	// Constructor privado para evitar la instanciación
	private TextHelper() {
	}
	// Devuelve una cadena vacía como valor predeterminado
	public static String getDefault() {
		return EMPTY;
	}
	// Devuelve el valor proporcionado o la cadena vacía si es nulo
	public static String getDefault(final String value) {
		return ObjectHelper.getDefault(value, getDefault());
	}
	// Devuelve el valor proporcionado o la cadena vacía si es nulo, y elimina los espacios en blanco al inicio y al final
	public static String getDefaultWithTrim(final String value) {
		return getDefault(value).trim();
	}


}
