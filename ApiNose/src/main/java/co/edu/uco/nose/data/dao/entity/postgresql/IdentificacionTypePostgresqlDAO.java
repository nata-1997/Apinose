package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.entity.IdentificationTypeEntity;

public class IdentificacionTypePostgresqlDAO extends SqlConnectionHelper implements IdentificationTypeDAO {

	protected IdentificacionTypePostgresqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<IdentificationTypeEntity> finALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IdentificationTypeEntity> findByIdFilter(IdentificationTypeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentificationTypeEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
