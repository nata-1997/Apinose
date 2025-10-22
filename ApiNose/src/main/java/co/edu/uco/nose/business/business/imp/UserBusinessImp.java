package co.edu.uco.nose.business.business.imp;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.assembler.entity.imp.UserEntityAssembler;
import co.edu.uco.nose.business.business.UserBusiness;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.dao.factory.DAOFactory;


public final  class UserBusinessImp  implements UserBusiness{
	
	private DAOFactory daoFactory;
	
	public UserBusinessImp(final DAOFactory factoryDAO) {
		this.daoFactory = factoryDAO;
	}
	


	@Override
	public void registerNewUserInformation(UserDomain userDomain) {
		var id = UUIDHelper.generateNewUUID();
		var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
		daoFactory.getUserDAO().create(userEntity);

		userEntity.setId(id);

		daoFactory.getUserDAO().create(userEntity);

	}

	// 1. Validar que la informacion sea consistente a nivel de tipo de dato,
		// longitud , obligatoriedad, formato, rango, reglas propias del objeto.
		// 2. Validar que no exista previamente otro usuario con el mismo tipo de
		// documento y nombre de identificacion.
		// 3. Validar que no exista previamente otro usuario con el mismo correo
		// electronico
		// 4. Validar que no exista previamente otro usuario con el mismo numero de
		// telefono celular
		// 5. Generar un identificador para el nuevo usuario, asegurando que no exista.

		// 6. Registrar la informacin del nuevo usuario.

	@Override
	public void dropUserInformacion(UUID ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInformation(UUID id, UserDomain userDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDomain> findALLUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDomain> findUserByFilter(UserDomain userFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDomain findSpecificUser(UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmMobileNumber(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmedEmail(UUID id, int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMobileNumberConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmailConfirmation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	

	

}
