package co.edu.uco.nose.crosscuting.helper;

public class EmailHelper {
	
	private static final String DEFAULT_EMAIL = "default@email.com";
	
	private EmailHelper() {
		
	}
	
	public static String getDefault() {
		return DEFAULT_EMAIL;
	}
	// Devuelve el valor proporcionado o el valor predeterminado si el valor es nulo o vacío, además convierte a minúsculas y elimina espacios en blanco al inicio y al final
	public static String getDefault(final String value) {
		return ObjectHelper.getDefault(value, getDefault()).toLowerCase().trim();
	}
	
	public static String getDefaultWithTrim(final String value) {
		return getDefault(value).trim();
	}
	
	// Verifica si el valor proporcionado es igual al valor predeterminado (correo electrónico por defecto)
	public static boolean isEmpity(final String value) {
		return DEFAULT_EMAIL.equals(getDefault(value));
	}
	
	// Validación básica de formato de correo electrónico
	public static boolean isValidEmail(final String value) {
		final String email = getDefault(value);
		return email.contains("@") && email.contains(".");
	}
	
	
	
}
