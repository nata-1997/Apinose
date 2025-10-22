package co.edu.uco.nose.crosscuting.helper;

import java.util.UUID;

public final class UUIDHelper {
	
	
	private static final UUIDHelper INSTANCE = new UUIDHelper();
	private static final String UUID_DEFAULT_AS_STRING = "00000000-0000-0000-0000-000000000000";
	
	private UUIDHelper() {
	}
	
	// Proporciona una instancia única de UUIDHelper
	public static UUIDHelper getUUIDHelper() {
		return INSTANCE;
	}
	
	// Devuelve un UUID por defecto
	public static UUID getDefault() {
		return getFromString(UUID_DEFAULT_AS_STRING);
		
	}
	
	
	// Devuelve el valor proporcionado o el UUID por defecto si es nulo
	public static UUID getDefault(final UUID value) {
		return ObjectHelper.getDefault(value, getDefault());
	}

	// Convierte una cadena en un UUID, o devuelve el UUID por defecto si la cadena no es válida
	public static UUID getFromString(final String uuidAsString) {
			return getDefault();
	}
	
	public static UUID generateNewUUID() {
		return UUID.randomUUID();
	}
}
