package co.edu.uco.nose.test;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.dto.UserDTO;

public class TestUserRegistration {

	public static void main(String[] args) {
		try {
			var user = new UserDTO();
			//Colocar todos los parametros
		
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