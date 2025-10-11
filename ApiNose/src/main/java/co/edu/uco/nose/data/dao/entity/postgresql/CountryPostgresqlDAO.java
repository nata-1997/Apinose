package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.entity.CountryEntity;

public class CountryPostgresqlDAO  extends SqlConnectionHelper implements CountryDAO {

	protected CountryPostgresqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CountryEntity> finALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryEntity> findByIdFilter(CountryEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
