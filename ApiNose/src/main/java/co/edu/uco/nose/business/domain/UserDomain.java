package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.EmailHelper;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.PhoneHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class UserDomain extends Domain {
	//crear atributos
	private IdentificationTypeDomain identificationType;
	private String identificationNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String secondLastName;
	private	CityDomain residenceCity;
	private String email;
	private String mobilePhone;
	private boolean emailConfirmed;
	private boolean mobilePhoneConfirmed;
	
	public UserDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setIdentificationType(new IdentificationTypeDomain());
		setIdentificationNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setMiddleName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCity(new CityDomain());
		setEmail(EmailHelper.getDefault());
		setMobilePhone(PhoneHelper.getDefault());
		setEmailConfirmed(false);
		setMobilePhoneConfirmed(false);
	}
	
	
	//constructor con id
	public UserDomain(final UUID id) {
		super(id);
		setIdentificationType(new IdentificationTypeDomain());
		setIdentificationNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setMiddleName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCity(new CityDomain());
		setEmail(EmailHelper.getDefault());
		setMobilePhone(PhoneHelper.getDefault());
		setEmailConfirmed(false);
		setMobilePhoneConfirmed(false);
	}
	
	//constructor con atributos
	public UserDomain(final UUID id, final IdentificationTypeDomain identificationType, 
			final String identificationNumber, final String firstName, 
			final String middleName, final String lastName, final String secondLastName,
			final CityDomain residenceCity, final String email, final String mobilePhone,
			final boolean emailConfirmed, final boolean mobilePhoneConfirmed) {
		super(id);
		setIdentificationType(identificationType);
		setIdentificationNumber(identificationNumber);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setSecondLastName(secondLastName);
		setResidenceCity(residenceCity);
		setEmail(email);
		setMobilePhone(mobilePhone);
		setEmailConfirmed(emailConfirmed);
		setMobilePhoneConfirmed(mobilePhoneConfirmed);
	}
	
	//getters and setters
	public IdentificationTypeDomain getIdentificationType() {
		return identificationType;
	}
	
	public void setIdentificationType( final IdentificationTypeDomain identificationType) {
		this.identificationType = ObjectHelper.getDefault(identificationType, new IdentificationTypeDomain());
	}
	
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	
	public void setIdentificationNumber(final String identificationNumber) {
		this.identificationNumber = TextHelper.getDefaultWithTrim(identificationNumber);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(final String firstName) {
		this.firstName = TextHelper.getDefaultWithTrim(firstName);
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(final String middleName) {
		this.middleName = TextHelper.getDefaultWithTrim(middleName);
	}
	
	public String getLastName() {
		return lastName;
	}
		
	public void setLastName(final String lastName) {
		this.lastName = TextHelper.getDefaultWithTrim(lastName);
	}
	
	public String getSecondLastName() {
		return secondLastName;
	}
	
	public void setSecondLastName(final String secondLastName) {
		this.secondLastName = TextHelper.getDefaultWithTrim(secondLastName);
	}
	
	public CityDomain getResidenceCity() {
		return residenceCity;
	}
	
	public void setResidenceCity(final CityDomain residenceCity) {
		this.residenceCity = ObjectHelper.getDefault(residenceCity, new CityDomain());
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(final String email) {
		this.email = EmailHelper.getDefaultWithTrim(email);
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	public void setMobilePhone ( final String mobilePhone) {
		this.mobilePhone = PhoneHelper.getDefaultWithTrim(mobilePhone);
	}
	
	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}
	
	public void setEmailConfirmed(final boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	
	public boolean isMobilePhoneConfirmed() {
		return mobilePhoneConfirmed;
	}
	
	public void setMobilePhoneConfirmed(final boolean mobilePhoneConfirmed) {
		this.mobilePhoneConfirmed = mobilePhoneConfirmed;
	}

}
