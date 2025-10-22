package co.edu.uco.nose.business.assembler.dto.imp;

import static co.edu.uco.nose.business.assembler.dto.imp.CountryDTOAssembler.getCountryDTOAssembler;

import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.DeparmentDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.DeparmentDTO;

public final class DeparmentDTOAssembler implements DTOAssembler<DeparmentDTO, DeparmentDomain> {
	
	private static final DTOAssembler<DeparmentDTO, DeparmentDomain> instance = new DeparmentDTOAssembler();
	
	private DeparmentDTOAssembler() { }
	
	public static DTOAssembler<DeparmentDTO, DeparmentDomain> getDeparmentDTOAssembler() {
		return instance;
	}

	@Override
	public DeparmentDTO toDTO(final DeparmentDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new DeparmentDomain(UUIDHelper.getDefault()));
		var countryDTOTmp = getCountryDTOAssembler().toDTO(domainTmp.getCountry());
		return new DeparmentDTO(domainTmp.getId(), domainTmp.getName(), countryDTOTmp);
	}

	@Override
	public DeparmentDomain toDomain(final DeparmentDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new DeparmentDTO());
		var countryDomainTmp = getCountryDTOAssembler().toDomain(dtoTmp.getCountry());
		return new DeparmentDomain(dtoTmp.getId(), dtoTmp.getName(), countryDomainTmp);
	}


	@Override
	public List<DeparmentDTO> toDTO(List<DeparmentDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
