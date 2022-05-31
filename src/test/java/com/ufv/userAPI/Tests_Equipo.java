package com.ufv.userAPI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
class Tests_Equipo {

	@Test
	void Prueba_Marca() {

		Equipo equipo = new Equipo(1,"Portatil", "HP", "RRHH", "Windows 11", "12", "IntelI7", 8, 3, "HDD", 250, 13,
									"4K", "Word", "12", "Volume",
									"Adobe Photoshop", "10");

		assertFalse("No existe esta marca", equipo.getMarca() != "Apple" &&
															equipo.getMarca() != "ASUS" &&
															equipo.getMarca() != "HP");
	}

	@Test
	void Prueba_SO_nombre() {

		Equipo equipo = new Equipo(1,"Portatil", "HP", "RRHH", "Windows", "11",
				"IntelI7", 8, 4, "HDD", 250, 13,
				"4K", "Word", "12", "Volume",
				"Adobe Photoshop", "10");

		assertFalse("No existe este sistema operativo", equipo.getSo_nombre()== "null");
	}
}
