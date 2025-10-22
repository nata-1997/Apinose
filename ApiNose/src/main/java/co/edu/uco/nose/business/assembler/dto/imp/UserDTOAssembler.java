package co.edu.uco.nose.business.assembler.dto.imp;
import static co.edu.uco.nose.business.assembler.dto.imp.CityDTOAssembler.getCityDTOAssembler;
import static co.edu.uco.nose.business.assembler.dto.imp.IdentificationTypeDTOAssembler.getIdentificationTypeDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.UserDTO;
 
public final class UserDTOAssembler implements DTOAssembler<UserDTO, UserDomain> {
	
	private static final DTOAssembler<UserDTO, UserDomain> INSTANCE = new UserDTOAssembler();
	
	private UserDTOAssembler() {	
	}
	
	public static DTOAssembler<UserDTO, UserDomain> getUserDTOAssembler() {
		return INSTANCE;
	}
 
	@Override
	public UserDTO toDTO(UserDomain domain) {
		var DomainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getDefault()));
		var cityDTOTmp = getCityDTOAssembler().toDTO(DomainTmp.getResidenceCity());
		var identificationTypeDTOTmp = getIdentificationTypeDTOAssembler().toDTO(DomainTmp.getIdentificationType());
		return new UserDTO(DomainTmp.getId(), identificationTypeDTOTmp, DomainTmp.getIdentificationNumber(), DomainTmp.getFirstName(), DomainTmp.getMiddleName(), DomainTmp.getLastName(),
				DomainTmp.getSecondLastName(),cityDTOTmp, DomainTmp.getEmail(), DomainTmp.getMobilePhone(), DomainTmp.isEmailConfirmed(), DomainTmp.isMobilePhoneConfirmed());
	}
 
	@Override
	public UserDomain toDomain(UserDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new UserDTO());
		var cityDomainTmp = getCityDTOAssembler().toDomain(dtoTmp.getResidenceCity());
		var identificationTypeDomainTmp = getIdentificationTypeDTOAssembler().toDomain(dtoTmp.getIdentificationType());
		return new UserDomain(dtoTmp.getId(), identificationTypeDomainTmp, dtoTmp.getIdentificationNumber(), dtoTmp.getFirstName(), dtoTmp.getMiddleName(), dtoTmp.getLastName(),
				dtoTmp.getSecondLastName(),cityDomainTmp, dtoTmp.getEmail(), dtoTmp.getMobilePhone(), dtoTmp.isEmailConfirmed(), dtoTmp.isMobilePhoneConfirmed());
	}

	@Override
	public List<UserDTO> toDTO(List<UserDomain> domainList) {
		var userDTOList = new ArrayList<UserDTO>();
		
		for (var domain : domainList) {
			userDTOList.add(toDTO(domain));
		}
		return userDTOList;
	}
 
	
}