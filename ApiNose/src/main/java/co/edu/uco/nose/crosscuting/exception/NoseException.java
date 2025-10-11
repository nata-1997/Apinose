package co.edu.uco.nose.crosscuting.exception;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;

// Excepción personalizada para la aplicación
public final class NoseException extends RuntimeException {

	// Serial version UID para la serialización
	private static final long serialVersionUID = -433023700129543247L;
	private Throwable rootException;
	private String userMessage;
	private String technicalMessage;
	
	// Constructor privado para forzar el uso de los métodos estáticos de creación
	private NoseException(final Throwable rootException, final String userMessage, final String technicalMessage) {
		super();
		setRootException(new Exception());
		setUserMessage(TextHelper.getDefault());
		setTechnicalMessage(TextHelper.getDefault());
	}
	
	// Métodos estáticos para crear instancias de NoseException con diferentes niveles de detalle
	
	public static NoseException Create(final Throwable rootException, final String userMessage, final String technicalMessage) {
		return new NoseException(rootException, userMessage, technicalMessage);
	}
	
	public static NoseException Create(final String userMessage, final String technicalMessage) {
		return new NoseException(new Exception(), userMessage, technicalMessage);
	}
	
	public static NoseException Create(final String userMessage) {
		return new NoseException(new Exception(), userMessage, userMessage);
	}
	
	
	
	// Getters y Setters
	public Throwable getRootException() {
		return rootException;
	}
	public void setRootException(final Throwable rootException) {
		this.rootException = ObjectHelper.getDefault(rootException, new Exception());
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(final String userMessage) {
		this.userMessage = TextHelper.getDefaultWithTrim(userMessage);
	}
	public String getTechnicalMessage() {
		return technicalMessage;
	}
	public void setTechnicalMessage(final String technicalMessage) {
		this.technicalMessage = TextHelper.getDefaultWithTrim(technicalMessage);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
