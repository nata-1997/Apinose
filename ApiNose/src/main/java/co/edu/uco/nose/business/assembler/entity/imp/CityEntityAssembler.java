package co.edu.uco.nose.business.assembler.entity.imp;

import static co.edu.uco.nose.business.assembler.entity.imp.DeparmentEntityAssembler.getDeparmentEntityAssembler;

import java.util.List;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CityEntity;

public final class CityEntityAssembler implements EntityAssembler<CityEntity, CityDomain> {
	
	private static final EntityAssembler<CityEntity, CityDomain> INSTANCE = new CityEntityAssembler();
	
	private CityEntityAssembler() {	
	}
	
	public static EntityAssembler<CityEntity, CityDomain> getCityEntityAssembler() {
		return INSTANCE;
	}
	
	

	@Override
	public CityEntity toEntity(CityDomain domain) {
		var DomainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getDefault()));
		var deparmentEntityTmp = getDeparmentEntityAssembler().toEntity(DomainTmp.getDeparment());
		return new CityEntity(DomainTmp.getId(), deparmentEntityTmp, DomainTmp.getName());
	}

	@Override
	public CityDomain toDomain(CityEntity Entity) {
		var EntityTmp = ObjectHelper.getDefault(Entity, new CityEntity());
		var deparmentDomainTmp = getDeparmentEntityAssembler().toDomain(EntityTmp.getDeparment());
		return new CityDomain(EntityTmp.getId(), EntityTmp.getName(), deparmentDomainTmp);
	}

	@Override
	public List<CityEntity> toEntityListFromDomainList(List<CityDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}