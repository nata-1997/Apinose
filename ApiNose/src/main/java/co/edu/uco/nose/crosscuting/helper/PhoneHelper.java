package co.edu.uco.nose.crosscuting.helper;

public final class PhoneHelper {
	
	private static final String DEFAULT_PHONE = "0000000000";
	
	private PhoneHelper() {
	}
	
	public static String getDefault() {
		return DEFAULT_PHONE;
	}
	
	public static String getDefault(final String value) {
		return ObjectHelper.getDefault(value, getDefault());
	}
	
	public static String getDefaultWithTrim(final String value) {
		return getDefault(value).trim();
	}
	
	public static boolean isEmpity(final String value) {
		return DEFAULT_PHONE.equals(getDefault(value));
	}
	
	public static boolean isValidPhone(final String value) {
		final String phone = getDefault(value);
		return phone.matches("\\d{10}");
	}
	

}
