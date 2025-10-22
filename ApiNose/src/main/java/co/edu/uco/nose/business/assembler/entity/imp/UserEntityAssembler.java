package co.edu.uco.nose.business.assembler.entity.imp;
import static co.edu.uco.nose.business.assembler.entity.imp.CityEntityAssembler.getCityEntityAssembler;
import static co.edu.uco.nose.business.assembler.entity.imp.IdentificationTypeEntityAssembler.getIdentificationTypeEntityAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.UserEntity;
 
public final class UserEntityAssembler implements EntityAssembler<UserEntity, UserDomain> {
	
	private static final EntityAssembler<UserEntity, UserDomain> INSTANCE = new UserEntityAssembler();
	
	private UserEntityAssembler() {	
	}
	
	public static EntityAssembler<UserEntity, UserDomain> getUserEntityAssembler() {
		return INSTANCE;
	}
 
	@Override
	public UserEntity toEntity(UserDomain domain) {
		var DomainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getDefault()));
		var cityEntityTmp = getCityEntityAssembler().toEntity(DomainTmp.getResidenceCity());
		var identificationTypeEntityTmp = getIdentificationTypeEntityAssembler().toEntity(DomainTmp.getIdentificationType());
		return new UserEntity(DomainTmp.getId(), identificationTypeEntityTmp, DomainTmp.getIdentificationNumber(), DomainTmp.getFirstName(), DomainTmp.getMiddleName(), DomainTmp.getLastName(),
				DomainTmp.getSecondLastName(),cityEntityTmp, DomainTmp.getEmail(), DomainTmp.getMobilePhone(), DomainTmp.isEmailConfirmed(), DomainTmp.isMobilePhoneConfirmed());
	}
 
	@Override
	public UserDomain toDomain(UserEntity Entity) {
		var EntityTmp = ObjectHelper.getDefault(Entity, new UserEntity());
		var cityDomainTmp = getCityEntityAssembler().toDomain(EntityTmp.getResidenceCity());
		var identificationTypeDomainTmp = getIdentificationTypeEntityAssembler().toDomain(EntityTmp.getIdentificationType());
		return new UserDomain(EntityTmp.getId(), identificationTypeDomainTmp, EntityTmp.getIdentificationNumber(), EntityTmp.getFirstName(), EntityTmp.getMiddleName(), EntityTmp.getLastName(),
				EntityTmp.getSecondLastName(),cityDomainTmp, EntityTmp.getEmail(), EntityTmp.getMobilePhone(), EntityTmp.isEmailConfirmed(), EntityTmp.isMobilePhoneConfirmed());
	}


	@Override
	public List<UserEntity> toEntityListFromDomainList(List<UserDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
 
	
}