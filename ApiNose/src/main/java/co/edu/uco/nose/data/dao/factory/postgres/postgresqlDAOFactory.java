package co.edu.uco.nose.data.dao.factory.postgres;

public class postgresqlDAOFactory extends DAOFactory {
	
	
	protected void openConnection() {
		try {
			this.coonection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/nose", "usuario", "contraseña");
			} catch (final SQLException exception) {
				var userMessage ="";
				var technicalMessage = "  ";
				throw NoseException.Create(exception, userMessage, technicalMessage);	
			} catch (final Exception exception) {
				var userMessage = " ";
				var technicalMessage = " ";
				throw NoseException.Create(exception, userMessage, technicalMessage);
	}

	@Override
	public CityDAO getCityDAO() {
		// TODO Auto-generated method stub
		return  new CityPostgresqlDAO(connection);
	}
	
	@Override
	public CountryDAO getCountryDAO() {
		// TODO Auto-generated method stub
		return new CountryPostgresqlDAO(connection);
	}
	
	@Override
	public IdentificationTypeDAO getIdentificationTypeDAO() {
		// TODO Auto-generated method stub
		return new IdentificationTypePostgresqlDAO(connection);
	}
	
	@Override
	public DeparmentDAO getDepartmentDAO() {
		// TODO Auto-generated method stub
		return new DeparmentPostgresqlDAO(connection);
	
	}
	
	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		return new UserPostgresqlDAO(connection);
	}
	
	
	
	
}
