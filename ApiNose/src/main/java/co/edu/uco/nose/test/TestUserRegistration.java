package co.edu.uco.nose.test;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.factory.postgresql.PostgresqlDAOFactory;
import co.edu.uco.nose.dto.IdentificationTypeDTO;
import co.edu.uco.nose.dto.UserDTO;

import java.util.UUID;

public class TestUserRegistration {

	public static void main(String[] args) {
		try {
            new PostgresqlDAOFactory();
            var user = new UserDTO();


            System.out.println("Gané el semestre.");


		
			var facade = new UserFacadeImpl();
			facade.registerNewUserInformation(user);

			System.out.println("Gané el semestre.");
		
		} catch (NoseException e) {
			System.err.println(e.getUserMessage());
			System.err.println(e.getTechnicalMessage());
		} catch (Exception e) {
			System.err.println("Ocurrió un error inesperado: " + e.getMessage());
		}
	}
}