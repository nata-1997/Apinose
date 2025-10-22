package co.edu.uco.nose.business.assembler.dto.imp;

import java.util.List;

import static co.edu.uco.nose.business.assembler.dto.imp.DeparmentDTOAssembler.getDeparmentDTOAssembler;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CityDTO;

public final class CityDTOAssembler implements DTOAssembler<CityDTO, CityDomain> {
	
	private static final DTOAssembler<CityDTO, CityDomain> INSTANCE = new CityDTOAssembler();
	
	private CityDTOAssembler() {	
	}
	
	public static DTOAssembler<CityDTO, CityDomain> getCityDTOAssembler() {
		return INSTANCE;
	}
	
	

	@Override
	public CityDTO toDTO(CityDomain domain) {
		var DomainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getDefault()));
		var deparmentDTOTmp = getDeparmentDTOAssembler().toDTO(DomainTmp.getDeparment());
		return new CityDTO(DomainTmp.getId(), DomainTmp.getName(), deparmentDTOTmp);
	}

	@Override
	public CityDomain toDomain(CityDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new CityDTO());
		var deparmentDomainTmp = getDeparmentDTOAssembler().toDomain(dtoTmp.getDeparment());
		return new CityDomain(dtoTmp.getId(), dtoTmp.getName(), deparmentDomainTmp);
	}

	@Override
	public List<CityDTO> toDTO(List<CityDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}