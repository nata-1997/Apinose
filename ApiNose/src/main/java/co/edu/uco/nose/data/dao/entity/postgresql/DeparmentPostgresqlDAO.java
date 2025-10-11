package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.data.dao.entity.DeparmentDAO;
import co.edu.uco.nose.entity.DeparmentEntity;

public class DeparmentPostgresqlDAO extends SqlConnectionHelper implements DeparmentDAO {

	protected DeparmentPostgresqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DeparmentEntity> finALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeparmentEntity> findByIdFilter(DeparmentEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeparmentEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
