package co.edu.uco.nose.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.domain.UserDomain;

public interface UserBusiness {
	
	void registerNewUserInformation (UserDomain userDomain);
	
	void dropUserInformacion(UUID ID);
	
	void updateUserInformation(UUID id, UserDomain userDomain);
	
	List<UserDomain> findALLUsers();
	
	List<UserDomain> findUserByFilter(UserDomain userFilters);
	
	UserDomain findSpecificUser(UUID userId);
	
	void confirmMobileNumber(UUID id, int confirmationCode);
	
	void confirmedEmail(UUID id, int confirmationCode);
	
	void sendMobileNumberConfirmation(UUID id);
	
	void sendEmailConfirmation(UUID id);
	
	


}
