package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.EmailHelper;
import co.edu.uco.nose.crosscuting.helper.PhoneHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class UserDTO  {
	//crear atributos
	private UUID id;
	private UUID identificationTypeId;
	private String identificationNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String secondLastName;
	private UUID residenceCityId;
	private String email;
	private String mobilePhone;
	private boolean emailConfirmed;
	private boolean mobilePhoneConfirmed;
	
	public UserDTO() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setIdentificationTypeId(UUIDHelper.getUUIDHelper().getDefault());
		setIdentificationNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setMiddleName(TextHelper.getDefault());
		
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCityId(UUIDHelper.getUUIDHelper().getDefault());
		setEmail(EmailHelper.getDefault());
		setMobilePhone(PhoneHelper.getDefault());
		setEmailConfirmed(false);
		setMobilePhoneConfirmed(false);
	}
	
	
	//constructor con id
	public UserDTO(final UUID id) {
		setId(id);
		setIdentificationTypeId(UUIDHelper.getUUIDHelper().getDefault());
		setIdentificationNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setMiddleName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCityId(UUIDHelper.getUUIDHelper().getDefault());
		setEmail(EmailHelper.getDefault());
		setMobilePhone(PhoneHelper.getDefault());
		setEmailConfirmed(false);
		setMobilePhoneConfirmed(false);
	}
	
	//constructor con atributos
	public UserDTO(final UUID id, final UUID identificationTypeId, 
			final String identificationNumber, final String firstName, 
			final String middleName, final String lastName, final String secondLastName,
			final UUID residenceCityId, final String email, final String mobilePhone,
			final boolean emailConfirmed, final boolean mobilePhoneConfirmed) {
		setId(id);
		setIdentificationTypeId(identificationTypeId);
		setIdentificationNumber(identificationNumber);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setSecondLastName(secondLastName);
		setResidenceCityId(residenceCityId);
		setEmail(email);
		setMobilePhone(mobilePhone);
		setEmailConfirmed(emailConfirmed);
		setMobilePhoneConfirmed(mobilePhoneConfirmed);
	}
	
	//getters and setters
	public UUID getId() {
		return id;
	}
	
	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	
	public UUID getIdentificationTypeId() {
		return identificationTypeId;
	}
	
	public void setIdentificationTypeId( final UUID identificationTypeId) {
		this.identificationTypeId = UUIDHelper.getUUIDHelper().getDefault(identificationTypeId);
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
	
	public UUID getResidenceCityId() {
		return residenceCityId;
	}
	
	public void setResidenceCityId(final UUID residenceCityId) {
		this.residenceCityId = UUIDHelper.getUUIDHelper().getDefault(residenceCityId);
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
