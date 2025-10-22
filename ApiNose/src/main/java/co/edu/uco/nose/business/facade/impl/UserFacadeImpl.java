package co.edu.uco.nose.business.facade.impl;

import java.util.List;
import java.util.UUID;

import static co.edu.uco.nose.business.assembler.dto.imp.UserDTOAssembler.getUserDTOAssembler;
import co.edu.uco.nose.business.business.imp.UserBusinessImp;
import co.edu.uco.nose.business.facade.UserFacade;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.dto.UserDTO;

public final class UserFacadeImpl implements UserFacade{
	

	@Override
	public void registerNewUserInformation(final UserDTO userDTO) {
		
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImp(daoFactory);
		
		try {
			
			daoFactory.initTrasaction();
			
			var userDomain = getUserDTOAssembler().toDomain(userDTO);
	        business.registerNewUserInformation(userDomain);

			daoFactory.commitTransaction();
			
		} catch (final NoseException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			
			var userMessage = "Se ha presentado un problema inesperado al registrar la información del nuevo usuario. Por favor intente nuevamente y si el problema persiste contacte al administrador del sistema.";
			var technicalMessage = "Se ha presentado un problema inesperado al registrar la información del nuevo usuario. Por favor revise el log de errores para mayor detalle del problema.";
			//Implementar en el MessagesEnum
			
			throw NoseException.Create(exception, userMessage, technicalMessage);
					
			
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void dropUserInformacion(UUID ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInformation(UUID id, UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDTO> findALLUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> findUserByFilter(UserDTO userFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findSpecificUser(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
