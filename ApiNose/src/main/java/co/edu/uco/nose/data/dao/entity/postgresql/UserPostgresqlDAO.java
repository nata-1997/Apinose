package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.entity.UserEntity;

public final class UserPostgresqlDAO extends SqlConnectionHelper implements UserDAO {

    public UserPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(final UserEntity entity) {
        SqlConnectionHelper.validateConnection(getConnection());
        SqlConnectionHelper.validateIfTransactionWasInitiated(getConnection());

        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO usuario (id, tipo_identificacion_id, numero_identificacion, primer_nombre, ");
        sql.append("segundo_nombre, primer_apellido, segundo_apellido, ciudad_residencia_id, correo_electronico, ");
        sql.append("numero_telefono_movil, correo_electronico_confirmado, numero_telefono_movil_confirmado) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getIdentificationType().getId());
            preparedStatement.setString(3, entity.getIdentificationNumber());
            preparedStatement.setString(4, entity.getFirstName());
            preparedStatement.setString(5, entity.getMiddleName());
            preparedStatement.setString(6, entity.getLastName());
            preparedStatement.setString(7, entity.getSecondLastName());
            preparedStatement.setObject(8, entity.getResidenceCity().getId());
            preparedStatement.setString(9, entity.getEmail());
            preparedStatement.setString(10, entity.getMobilePhone());
            preparedStatement.setBoolean(11, entity.isEmailConfirmed());
            preparedStatement.setBoolean(12, entity.isMobilePhoneConfirmed());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_USER_CREATE.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_CREATE.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        		final String userMessage = MessagesEnum.USER_ERROR_USER_CREATE_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_CREATE_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<UserEntity> findAll() {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<UserEntity> users = new ArrayList<>();
        final String sql = "SELECT * FROM usuario";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                users.add(mapResultSetToUserEntity(resultSet));
            }
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_USER_FIND_ALL.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_ALL.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	final String userMessage = MessagesEnum.USER_ERROR_USER_FIND_ALL_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_ALL_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }

        return users;
    }

    @Override
    public List<UserEntity> findByIdFilter(UserEntity filterEntity) {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<UserEntity> users = new ArrayList<>();
        final StringBuilder sql = new StringBuilder("SELECT * FROM usuario WHERE 1=1");

        if (filterEntity.getIdentificationNumber() != null && !filterEntity.getIdentificationNumber().isEmpty()) {
            sql.append(" AND numero_identificacion = ?");
        }

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            int paramIndex = 1;

            if (filterEntity.getIdentificationNumber() != null && !filterEntity.getIdentificationNumber().isEmpty()) {
                preparedStatement.setString(paramIndex++, filterEntity.getIdentificationNumber());
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    users.add(mapResultSetToUserEntity(resultSet));
                }
            }
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_FILTER.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_FILTER.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	final String userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_FILTER_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }

        return users;
    }

    //
    @Override
    public UserEntity findById(UUID id) {
        SqlConnectionHelper.validateConnection(getConnection());

        final String sql = "SELECT * FROM usuario WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setObject(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToUserEntity(resultSet);
                }
                return null;
            }
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_ID.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_ID.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	final String userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_ID_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_ID_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void update(UserEntity entity) {
        SqlConnectionHelper.validateConnection(getConnection());
        SqlConnectionHelper.validateIfTransactionWasInitiated(getConnection());

        final StringBuilder sql = new StringBuilder("UPDATE usuario SET ");
        sql.append("tipo_identificacion_id = ?, numero_identificacion = ?, primer_nombre = ?, ");
        sql.append("segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, ciudad_residencia_id = ?, ");
        sql.append("correo_electronico = ?, numero_telefono_movil = ?, correo_electronico_confirmado = ?, ");
        sql.append("numero_telefono_movil_confirmado = ? WHERE id = ?");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getIdentificationType().getId());
            preparedStatement.setString(2, entity.getIdentificationNumber());
            preparedStatement.setString(3, entity.getFirstName());
            preparedStatement.setString(4, entity.getMiddleName());
            preparedStatement.setString(5, entity.getLastName());
            preparedStatement.setString(6, entity.getSecondLastName());
            preparedStatement.setObject(7, entity.getResidenceCity().getId());
            preparedStatement.setString(8, entity.getEmail());
            preparedStatement.setString(9, entity.getMobilePhone());
            preparedStatement.setBoolean(10, entity.isEmailConfirmed());
            preparedStatement.setBoolean(11, entity.isMobilePhoneConfirmed());
            preparedStatement.setObject(12, entity.getId());

            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_USER_UPDATE.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_UPDATE.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	final String userMessage = MessagesEnum.USER_ERROR_USER_UPDATE_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_UPDATE_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }

       
    }

    @Override
    public void delete(int id) {
        SqlConnectionHelper.validateConnection(getConnection());
        SqlConnectionHelper.validateIfTransactionWasInitiated(getConnection());

        final String sql = "DELETE FROM usuario WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_USER_DELETE.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_DELETE.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	final String userMessage = MessagesEnum.USER_ERROR_USER_DELETE_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_DELETE_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }

      
    }

    // Mapeo auxiliar
    private UserEntity mapResultSetToUserEntity(ResultSet resultSet) throws SQLException {
        return new UserEntity(
            (UUID) resultSet.getObject("id"),
            null, // identificationType (se podría llenar con otra consulta)
            resultSet.getString("numero_identificacion"),
            resultSet.getString("primer_nombre"),
            resultSet.getString("segundo_nombre"),
            resultSet.getString("primer_apellido"),
            resultSet.getString("segundo_apellido"),
            null, // residenceCity
            resultSet.getString("correo_electronico"),
            resultSet.getString("numero_telefono_movil"),
            resultSet.getBoolean("correo_electronico_confirmado"),
            resultSet.getBoolean("numero_telefono_movil_confirmado")
        );
    }
}
