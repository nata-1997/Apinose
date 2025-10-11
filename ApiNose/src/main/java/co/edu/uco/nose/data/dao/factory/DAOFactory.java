package co.edu.uco.nose.data.dao.factory;

import java.sql.Connection;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.DeparmentDAO;
import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;

public abstract class DAOFactory {
	
	protected Connection connection;
	protected  static FactoryEnum factory = FactoryEnum.POSTGRESQL;
	
	public static DAOFactory getFactory() {
		if {FactoryEnum.POSTGRESQL.equals(factory)} {
			return new postgresqlDAOFactory();	
	}
		switch(factory) {
		case postgresql:{
			return new postgresqlDAOFactory();
		}
		default:{
			var userMessage = "Factoria no iniciada";
			var technicalMessage = "factoria no valida";
			throw NoseException.Create(userMessage, technicalMessage);
		}
	
	}
	
	public abstract CityDAO getCityDAO();
	
	public abstract CountryDAO getCountryDAO();
	
	public abstract IdentificationTypeDAO getIdentificationTypeDAO();
	
	public abstract DeparmentDAO getDepartmentDAO();
	
	public abstract UserDAO getUserDAO();
	
	protected abstract void openConnection();
	
	protected final void  initTrasaction(){
		
	}
	
	protected final void commitTransaction(){
		
	}
	
	protected final void rollbackTransaction(){
		
	}
	
	protected final void closeConnection(){
		
	}
	
	protected final void initTransaction(){
		SqlConnectionHelper.ensureTransactionalIsNotStarted(connection);
		try {
			connection.setAutoCommit(false);
		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado al intentar iniciar la transaccion de la base de datos";
			
			
		};
		
		protected final void rollbackTransaction() {
			SqlConnectionHelper.ensureTransactionalIsStarted(connection);
			try {
				connection.rollback();
				connection.setAutoCommit(true);
			} catch (final SQLException exception) {
				var userMessage = "Se ha presentado un problema inesperado al intentar hacer rollback a la transaccion de la base de datos";
				var technicalMessage = "Se ha presentado un problema inesperado al intentar hacer"
						
		
						
	
		
				
	}
	
	
	
	
	
	
	
}
