package co.edu.uco.nose.business.business.imp;

import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.assembler.entity.imp.UserEntityAssembler;
import co.edu.uco.nose.business.business.UserBusiness;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.entity.UserEntity;

public final class UserBusinessImp implements UserBusiness {

    private final DAOFactory daoFactory;

    public UserBusinessImp(final DAOFactory factoryDAO) {
        this.daoFactory = factoryDAO;
    }

    @Override
    public void registerNewUserInformation(UserDomain userDomain) {
        var id = UUIDHelper.getUUIDHelper().generateNewUUID();
        var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);

        userEntity.setId(id);

        daoFactory.getUserDAO().create(userEntity);
    }


    // Otros métodos aún no implementados
    @Override
    public void dropUserInformacion(UUID ID) {}

    @Override
    public void updateUserInformation(UUID id, UserDomain userDomain) {}

    @Override
    public List<UserDomain> findALLUsers() { return null; }

    @Override
    public List<UserDomain> findUserByFilter(UserDomain userFilters) { return null; }

    @Override
    public UserDomain findSpecificUser(UUID userId) { return null; }

    @Override
    public void confirmMobileNumber(UUID id, int confirmationCode) {}

    @Override
    public void confirmedEmail(UUID id, int confirmationCode) {}

    @Override
    public void sendMobileNumberConfirmation(UUID id) {}

    @Override
    public void sendEmailConfirmation(UUID id) {}
}
