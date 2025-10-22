package co.edu.uco.nose.business.assembler.entity.imp;

import java.util.List;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.IdentificationTypeDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.IdentificationTypeEntity;

public class IdentificationTypeEntityAssembler implements EntityAssembler<IdentificationTypeEntity,IdentificationTypeDomain>{

	private static final EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> INSTANCE = new IdentificationTypeEntityAssembler();
	
	private IdentificationTypeEntityAssembler() {
		
	}
	
	public static final EntityAssembler<IdentificationTypeEntity, IdentificationTypeDomain> getIdentificationTypeEntityAssembler(){
		return INSTANCE;
	}
	
	@Override
	public IdentificationTypeEntity toEntity(IdentificationTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new IdentificationTypeDomain(UUIDHelper.getDefault()));
		return new IdentificationTypeEntity(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public IdentificationTypeDomain toDomain(IdentificationTypeEntity Entity) {
		var EntityTmp = ObjectHelper.getDefault(Entity, new IdentificationTypeEntity());
		return new IdentificationTypeDomain(EntityTmp.getId(), EntityTmp.getName());
	}

	@Override
	public List<IdentificationTypeEntity> toEntityListFromDomainList(List<IdentificationTypeDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
