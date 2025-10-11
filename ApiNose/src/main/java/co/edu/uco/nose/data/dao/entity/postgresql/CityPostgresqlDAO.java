package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.entity.CityEntity;

public class CityPostgresqlDAO extends SqlConnectionHelper implements CityDAO {

	protected CityPostgresqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CityEntity> finALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findByIdFilter(CityEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
