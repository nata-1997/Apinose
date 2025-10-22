package co.edu.uco.nose.business.assembler.dto.imp;

import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.IdentificationTypeDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.IdentificationTypeDTO;

public class IdentificationTypeDTOAssembler implements DTOAssembler<IdentificationTypeDTO,IdentificationTypeDomain>{

	private static final DTOAssembler<IdentificationTypeDTO, IdentificationTypeDomain> INSTANCE = new IdentificationTypeDTOAssembler();
	
	private IdentificationTypeDTOAssembler() {
		
	}
	
	public static final DTOAssembler<IdentificationTypeDTO, IdentificationTypeDomain> getIdentificationTypeDTOAssembler(){
		return INSTANCE;
	}
	
	@Override
	public IdentificationTypeDTO toDTO(IdentificationTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new IdentificationTypeDomain(UUIDHelper.getDefault()));
		return new IdentificationTypeDTO(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public IdentificationTypeDomain toDomain(IdentificationTypeDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new IdentificationTypeDTO());
		return new IdentificationTypeDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<IdentificationTypeDTO> toDTO(List<IdentificationTypeDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}

}
