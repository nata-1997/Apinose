package co.edu.uco.nose.business.assembler.entity.imp;

import static co.edu.uco.nose.business.assembler.entity.imp.CountryEntityAssembler.getCountryEntityAssembler;

import java.util.List;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.DeparmentDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.DeparmentEntity;

public final class DeparmentEntityAssembler implements EntityAssembler<DeparmentEntity, DeparmentDomain>{
	
	private static final EntityAssembler <DeparmentEntity, DeparmentDomain> instance =
		new DeparmentEntityAssembler();
	
	private DeparmentEntityAssembler () {
		
	}
	
	public static EntityAssembler <DeparmentEntity, DeparmentDomain> getDeparmentEntityAssembler(){
		return instance;
	}

	@Override
	public DeparmentEntity toEntity(final DeparmentDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new DeparmentDomain(UUIDHelper.getDefault()));
		var countryEntityTmp = getCountryEntityAssembler().toEntity(domainTmp.getCountry());
		return new DeparmentEntity(domainTmp.getId(),countryEntityTmp, domainTmp.getName());
	}

	@Override
	public DeparmentDomain toDomain(final DeparmentEntity Entity) {
		var EntityTmp = ObjectHelper.getDefault(Entity, new DeparmentEntity());
		var countryDomainTmp = getCountryEntityAssembler().toDomain(EntityTmp.getCountry());
		return new DeparmentDomain(EntityTmp.getId(), EntityTmp.getName(), countryDomainTmp);
	}


	@Override
	public List<DeparmentEntity> toEntityListFromDomainList(List<DeparmentDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
