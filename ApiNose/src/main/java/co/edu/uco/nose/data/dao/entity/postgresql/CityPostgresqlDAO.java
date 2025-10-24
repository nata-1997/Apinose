

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

import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.DeparmentEntity;

public final class CityPostgresqlDAO extends SqlConnectionHelper implements CityDAO {

    public CityPostgresqlDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public List<CityEntity> findAll() {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<CityEntity> cities = new ArrayList<>();
        final String sql = "SELECT id, departamento, nombre FROM public.ciudad";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                cities.add(mapResultSetToCityEntity(resultSet));
            }

        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_CITY_FIND_ALL.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_ALL.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	final String userMessage = MessagesEnum.USER_ERROR_CITY_FIND_ALL_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_ALL_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }

        return cities;
    }

    @Override
    public CityEntity findById(final UUID id) {
        SqlConnectionHelper.validateConnection(getConnection());

        final String sql = "SELECT id, departamento, nombre FROM ciudad WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setObject(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToCityEntity(resultSet);
                }
                return null;
            }

        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_ID.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_ID.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	final String userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_ID_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_ID_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<CityEntity> findByIdFilter(final CityEntity filterEntity) {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<CityEntity> cities = new ArrayList<>();
        final StringBuilder sql = new StringBuilder("SELECT id, departamento, nombre FROM ciudad WHERE 1=1");

        if (filterEntity.getName() != null && !filterEntity.getName().isEmpty()) {
            sql.append(" AND nombre ILIKE ?");
        }

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            int index = 1;

            if (filterEntity.getName() != null && !filterEntity.getName().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getName() + "%");
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(mapResultSetToCityEntity(resultSet));
                }
            }

        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_FILTER.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_FILTER.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
        	final String userMessage = MessagesEnum.USER_ERROR_CITY_FIND_BY_FILTER_UNEXPECTED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw NoseException.Create(exception, userMessage, technicalMessage);
        }

        return cities;
    }

    private CityEntity mapResultSetToCityEntity(ResultSet resultSet) throws SQLException {
        return new CityEntity(
            (UUID) resultSet.getObject("id"),
            new DeparmentEntity((UUID) resultSet.getObject("departamento"), null, null),
            resultSet.getString("nombre")
        );
    }
}
