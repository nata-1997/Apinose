package co.edu.uco.nose.crosscuting.helper;

// Clase final para evitar la herencia
public final class ObjectHelper {
	// Constructor privado para evitar la instanciación
	private ObjectHelper() {
	}
	
	// Método para verificar si un objeto es nulo
	public static <O> boolean isNull(final O object) {
		
	// Retorna true si el objeto es nulo, de lo contrario false
		return object == null; 
	}
	
	// Método para obtener un valor por defecto si el objeto es nulo
	public static <O> O getDefault(final O object, final O defaultValue) {
	// Retorna el valor por defecto si el objeto es nulo, de lo contrario retorna el objeto
		return isNull(object)? defaultValue : object;
	}

}
