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
import co.edu.uco.nose.data.dao.entity.DeparmentDAO;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.DeparmentEntity;

public final class DeparmentPostgresqlDAO extends SqlConnectionHelper implements DeparmentDAO {

    public DeparmentPostgresqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<DeparmentEntity> findAll() {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<DeparmentEntity> deparments = new ArrayList<>();
        final String sql = "SELECT * FROM departamento";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                deparments.add(mapResultSetToDeparmentEntity(resultSet));
            }

        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_DEPARMENT_FIND_ALL.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_DEPARMENT_FIND_ALL.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	final String userMessage = MessagesEnum.USER_ERROR_DEPARMENT_FIND_ALL_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_DEPARMENT_FIND_ALL_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }
        
        return deparments;
    }

    @Override
    public List<DeparmentEntity> findByIdFilter(DeparmentEntity filterEntity) {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<DeparmentEntity> deparments = new ArrayList<>();
        final StringBuilder sql = new StringBuilder("SELECT * FROM departamento WHERE 1=1");

        if (filterEntity.getName() != null && !filterEntity.getName().isEmpty()) {
            sql.append(" AND nombre = ?");
        }

        if (filterEntity.getCountry() != null && filterEntity.getCountry().getId() 
        		
        		!= null) {
            sql.append(" AND pais_id = ?");
        }

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            int paramIndex = 1;

            if (filterEntity.getName() != null && !filterEntity.getName().isEmpty()) {
                preparedStatement.setString(paramIndex++, filterEntity.getName());
            }

            if (filterEntity.getCountry() != null && filterEntity.getCountry().getId() != null) {
                preparedStatement.setObject(paramIndex++, filterEntity.getCountry().getId());
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    deparments.add(mapResultSetToDeparmentEntity(resultSet));
                }
            }

        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_DEPARMENT_FIND_BY_FILTER.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_DEPARMENT_FIND_BY_FILTER.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	final String userMessage = MessagesEnum.USER_ERROR_DEPARMENT_FIND_BY_FILTER_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_DEPARMENT_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }

        return deparments;
    }

    @Override
    public DeparmentEntity findById(UUID id) {
        SqlConnectionHelper.validateConnection(getConnection());

        final String sql = "SELECT * FROM departamento WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setObject(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToDeparmentEntity(resultSet);
                }
                return null;
            }

        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_DEPARMENT_FIND_BY_ID.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_DEPARMENT_FIND_BY_ID.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	final String userMessage = MessagesEnum.USER_ERROR_DEPARMENT_FIND_BY_ID_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_DEPARMENT_FIND_BY_ID_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }
    }

    // Mapeo del ResultSet al objeto DeparmentEntity
    private DeparmentEntity mapResultSetToDeparmentEntity(ResultSet resultSet) throws SQLException {
        return new DeparmentEntity(
            (UUID) resultSet.getObject("id"),
            new CountryEntity( // relación con país (clave foránea)
                (UUID) resultSet.getObject("pais_id"),
                null // no traemos el nombre del país aquí, solo el ID
            ),
            resultSet.getString("nombre")
        );
    }
}
