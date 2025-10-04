package co.edu.uco.nose.crosscuting.exception;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;

public final class NoseException extends RuntimeException {

	private static final long serialVersionUID = -433023700129543247L;
	private Throwable rootException;
	private String userMessage;
	private String technicalMessage;
	
	private NoseException(final Throwable rootException, final String userMessage, final String technicalMessage) {
		super();
		setRootException(new Exception());
		setUserMessage(TextHelper.getDefault());
		setTechnicalMessage(TextHelper.getDefault());
	}
	
	public static NoseException Create(final Throwable rootException, final String userMessage, final String technicalMessage) {
		return new NoseException(rootException, userMessage, technicalMessage);
	}
	
	public static NoseException Create(final String userMessage, final String technicalMessage) {
		return new NoseException(new Exception(), userMessage, technicalMessage);
	}
	
	public static NoseException Create(final String userMessage) {
		return new NoseException(new Exception(), userMessage, userMessage);
	}
	
	
	
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
