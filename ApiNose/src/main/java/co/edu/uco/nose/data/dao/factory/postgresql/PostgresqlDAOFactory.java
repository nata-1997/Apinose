package co.edu.uco.nose.data.dao.factory.postgresql;

import java.sql.Connection;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.DeparmentDAO;
import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.CityPostgresqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.CountryPostgresqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.DeparmentPostgresqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.IdentificationTypePostgresqlDAO;
import co.edu.uco.nose.data.dao.entity.postgresql.UserPostgresqlDAO;
import co.edu.uco.nose.data.dao.factory.DAOFactory;


public final class PostgresqlDAOFactory extends DAOFactory {
	
	protected Connection connection;
	
	public PostgresqlDAOFactory() {
		this.connection = null;
		openConnection();
	}
	
	@Override
	public CityDAO getCityDAO() {
		SqlConnectionHelper.validateConnection(connection);
		return new CityPostgresqlDAO(connection);
	}	

	@Override
	public CountryDAO getCountryDAO() {
		SqlConnectionHelper.validateConnection(connection);
		return new CountryPostgresqlDAO(connection);
	}

	@Override
	public IdentificationTypeDAO getIdentificationTypeDAO() {
		SqlConnectionHelper.validateConnection(connection);
		return new IdentificationTypePostgresqlDAO(connection);
	}

	@Override
	public DeparmentDAO getDepartmentDAO() {
		SqlConnectionHelper.validateConnection(connection);
		return new DeparmentPostgresqlDAO(connection);
	}

	@Override
	public UserDAO getUserDAO() {
		SqlConnectionHelper.validateConnection(connection);
		return new UserPostgresqlDAO(connection);
	}

	@Override
	protected void openConnection() {
		var url= "";
		var user="";
		var password="";
		try {
			connection=SqlConnectionHelper.openConnection(url, user, password);
		}catch(Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_CONNECTION_OPEN_FAILED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CONNECTION_OPEN_FAILED.getContent();
			throw NoseException.Create(exception, userMessage, technicalMessage);
		}
	
	}
	
	
}
