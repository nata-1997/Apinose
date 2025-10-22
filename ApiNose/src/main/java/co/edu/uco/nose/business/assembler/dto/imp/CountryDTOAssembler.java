package co.edu.uco.nose.business.assembler.dto.imp;

import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CountryDTO;

public final class CountryDTOAssembler implements DTOAssembler<CountryDTO, CountryDomain> {

    private static final DTOAssembler<CountryDTO, CountryDomain> instance = new CountryDTOAssembler();

    private CountryDTOAssembler() { }

    public static DTOAssembler<CountryDTO, CountryDomain> getCountryDTOAssembler() {
        return instance;
    }

    @Override
    public CountryDTO toDTO(final CountryDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getDefault()));
        return new CountryDTO(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public CountryDomain toDomain(final CountryDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new CountryDTO());
        return new CountryDomain(dtoTmp.getId(), dtoTmp.getName());
    }


	@Override
	public List<CountryDTO> toDTO(List<CountryDomain> domainList) {
		// TODO Auto-generated method stub
		return null;
	}
}
