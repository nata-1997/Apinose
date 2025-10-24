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
import co.edu.uco.nose.data.dao.entity.IdentificationTypeDAO;
import co.edu.uco.nose.entity.IdentificationTypeEntity;

public final class IdentificationTypePostgresqlDAO extends SqlConnectionHelper implements IdentificationTypeDAO {

	public IdentificationTypePostgresqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	 @Override
	    public List<IdentificationTypeEntity> findAll() {
	        SqlConnectionHelper.validateConnection(getConnection());

	        final List<IdentificationTypeEntity> identificationTypes = new ArrayList<>();
	        final String sql = "SELECT * FROM public.tipoidentificacion";

	        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                identificationTypes.add(mapResultSetToIdentificationTypeEntity(resultSet));
	            }

	        } catch (final SQLException exception) {
	            final String userMessage = MessagesEnum.USER_ERROR_IDENTIFICATIONTYPE_FIND_ALL.getContent();
	            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_IDENTIFICATIONTYPE_FIND_ALL.getContent();
	            throw NoseException.Create(exception, userMessage, technicalMessage);
	        } catch (final Exception exception) {
	        	final String userMessage = MessagesEnum.USER_ERROR_IDENTIFICATIONTYPE_FIND_ALL_UNEXPECTED.getContent();
	            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_IDENTIFICATIONTYPE_FIND_ALL_UNEXPECTED.getContent();
	            throw NoseException.Create(exception, userMessage, technicalMessage);
	        }

	        return identificationTypes;
	    }

	    @Override
	    public List<IdentificationTypeEntity> findByIdFilter(IdentificationTypeEntity filterEntity) {
	        SqlConnectionHelper.validateConnection(getConnection());

	        final List<IdentificationTypeEntity> identificationTypes = new ArrayList<>();
	        final StringBuilder sql = new StringBuilder("SELECT * FROM tipo_identificacion WHERE 1=1");

	        if (filterEntity.getName() != null && !filterEntity.getName().isEmpty()) {
	            sql.append(" AND nombre = ?");
	        }

	        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
	            int paramIndex = 1;

	            if (filterEntity.getName() != null && !filterEntity.getName().isEmpty()) {
	                preparedStatement.setString(paramIndex++, filterEntity.getName());
	            }

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    identificationTypes.add(mapResultSetToIdentificationTypeEntity(resultSet));
	                }
	            }

	        } catch (final SQLException exception) {
	            final String userMessage = MessagesEnum.USER_ERROR_IDENTIFICATIONTYPE_FIND_BY_FILTER.getContent();
	            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_IDENTIFICATIONTYPE_FIND_BY_FILTER.getContent();
	            throw NoseException.Create(exception, userMessage, technicalMessage);
	        } catch (final Exception exception) {
	        	final String userMessage = MessagesEnum.USER_ERROR_IDENTIFICATIONTYPE_FIND_BY_FILTER_UNEXPECTED.getContent();
	            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_IDENTIFICATIONTYPE_FIND_BY_FILTER_UNEXPECTED.getContent();
	            throw NoseException.Create(exception, userMessage, technicalMessage);
	        }

	        return identificationTypes;
	    }

	    @Override
	    public IdentificationTypeEntity findById(UUID id) {
	        SqlConnectionHelper.validateConnection(getConnection());

	        final String sql = "SELECT * FROM tipo_identificacion WHERE id = ?";

	        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
	            preparedStatement.setObject(1, id);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    return mapResultSetToIdentificationTypeEntity(resultSet);
	                }
	                return null;
	            }

	        } catch (final SQLException exception) {
	            final String userMessage = MessagesEnum.USER_ERROR_IDENTIFICATIONTYPE_FIND_BY_ID.getContent();
	            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_IDENTIFICATIONTYPE_FIND_BY_ID.getContent();
	            throw NoseException.Create(exception, userMessage, technicalMessage);
	        } catch (final Exception exception) {
	        	final String userMessage = MessagesEnum.USER_ERROR_IDENTIFICATIONTYPE_FIND_BY_ID_UNEXPECTED.getContent();
	            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_IDENTIFICATIONTYPE_FIND_BY_ID_UNEXPECTED.getContent();
	            throw NoseException.Create(exception, userMessage, technicalMessage);
	        }
	    }

	    // Mapeo del ResultSet al objeto IdentificationTypeEntity
	    private IdentificationTypeEntity mapResultSetToIdentificationTypeEntity(ResultSet resultSet) throws SQLException {
	        return new IdentificationTypeEntity(
	            (UUID) resultSet.getObject("id"),
	            resultSet.getString("nombre")
	        );
	    }
   
}
