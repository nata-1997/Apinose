package co.edu.uco.nose.data.dao.entity;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;

public abstract class SqlConnection {
	
	private Connection connection;
	
	protected SqlConnection() {
		setConnection(connection);
		
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		if(ObjectHelper.isNull(connection)) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
			throw NoseException.Create(userMessage, technicalMessage);
			
	}
		
	try {
		if (connection.isClosed()) {
			
		}
		
	} catch (final SQLException exception) {
		var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
		var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
		throw NoseException.Create(exception,userMessage, technicalMessage);
	}
	this.connection = connection;
	}
		
}
