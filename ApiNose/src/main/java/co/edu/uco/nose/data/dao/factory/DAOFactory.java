package co.edu.uco.nose.data.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.DeparmentDAO;
import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.factory.postgresql.PostgresqlDAOFactory;

public abstract class DAOFactory {
	
	protected Connection connection;
	protected  static FactoryEnum factory = FactoryEnum.POSTGRESQL;
	
	public static DAOFactory getFactory () {
		switch (factory) {
		case POSTGRESQL:
			return new PostgresqlDAOFactory();

		default: 
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			throw NoseException.Create(new IllegalArgumentException(), userMessage, technicalMessage);
		}
	}

	
	public abstract CityDAO getCityDAO();
	
	public abstract CountryDAO getCountryDAO();
	
	public abstract IdentificationTypeDAO getIdentificationTypeDAO();
	
	public abstract DeparmentDAO getDepartmentDAO();
	
	public abstract UserDAO getUserDAO();
		
	
	protected abstract void openConnection();
	
	public final void  initTrasaction(){
		SqlConnectionHelper.validateConnection(connection);
		SqlConnectionHelper.validateIfTransactionNotAlreadyInitiated(connection);
		try {
			connection.setAutoCommit(false);
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_TRANSACTION_INIT_FAILED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_INIT_FAILED.getContent();
			throw NoseException.Create(exception, userMessage, technicalMessage);
			}
		
	}
	
	public final void commitTransaction(){
		SqlConnectionHelper.validateConnection(connection);
		SqlConnectionHelper.validateIfTransactionWasInitiated(connection);
		try {
			connection.commit();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_TRANSACTION_COMMIT_FAILED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_COMMIT_FAILED.getContent();
			throw NoseException.Create(exception, userMessage, technicalMessage);
			}
	}
		
	
	public final void rollbackTransaction(){
		SqlConnectionHelper.validateConnection(connection);
		SqlConnectionHelper.validateIfTransactionWasInitiated(connection);
		try {
			connection.rollback();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_TRANSACTION_ROLLBACK_FAILED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_ROLLBACK_FAILED.getContent();
			throw NoseException.Create(exception, userMessage, technicalMessage);
			}
	}
		
	
	public final void closeConnection(){
		SqlConnectionHelper.validateConnection(connection);
		SqlConnectionHelper.validateIfTransactionWasInitiated(connection);
		try {
			connection.close();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_CONNECTION_CLOSE_FAILED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CONNECTION_CLOSE_FAILED.getContent();
			throw NoseException.Create(exception, userMessage, technicalMessage);
			}
	}
}
		
			
				
	