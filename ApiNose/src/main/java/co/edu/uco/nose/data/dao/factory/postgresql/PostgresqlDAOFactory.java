package co.edu.uco.nose.data.dao.factory.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

        try {

            //Datos de conexion
            String url = "jdbc:postgresql://localhost:5432/proyectoclaseDOO";
            String user = "postgres";
            String password = "1997";

            //CONEXION
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión correctamente a PostgreSQ");

        } catch (final SQLException exception) {
            var userMessage = "MessagesEnum.getContent()";//pendiente mensajes
            var technicalMessage = "MessagesEnum.getContent()";
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "MessagesEnum.getContent()";
            var technicalMessage = "MessagesEnum.getContent()";
            throw NoseException.Create(exception, userMessage, technicalMessage);

        }

    }
}