package com.ufv.userAPI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertFalse;

@SpringBootTest
class Tests_Users {

	@Test
	void Prueba_Ciudad_Erroneo() {
		User user = new User(1, "Daniel Ojeda", "Datamining", "123456789",
							"daniel@gmail.com", "Desembarco del rey");

		assertFalse("No has puesto una ciudad válida", user.getUbicacion() != "Madrid" &&
																		user.getUbicacion() != "Sevilla" &&
																		user.getUbicacion() != "Valencia" &&
																		user.getUbicacion() != "Barcelona" &&
																		user.getUbicacion() != "Bilbao");
	}

	@Test
	void Prueba_Email_Erroneo() {
		User user = new User(1, "Daniel Ojeda", "Datamining", "123456789",
				"danielgmail.com", "Desembarco del rey");

		assertFalse("No has puesto un email válido", user.getEmail().contains("@"));
	}

}
