package co.edu.uco.nose.business.facade;

import java.util.List;
import java.util.UUID;


import co.edu.uco.nose.dto.UserDTO;

public interface UserFacade {
	
	void registerNewUserInformation(UserDTO userDTO);
	
	void dropUserInformacion(UUID id);
	
	void updateUserInformation(UUID id, UserDTO userDTO);
	
	List<UserDTO> findALLUsers();
	
	List<UserDTO> findUserByFilter(UserDTO userFilters);
	
	UserDTO findSpecificUser(UUID id);

}
