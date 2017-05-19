package com.mauriciotl.madule4.objects;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestCountries {

	private static List<Country> countrieList = new LinkedList<>();

	public static void main(String[] args) {

		// Se créa la lista inicial de Countries
		createCountries();

		// Se listan todas las propiedades iniciales
		printListProperties();

		// Se realizarán algunas modificaciones y se verifica
		modifyCountryProperties("México", 1, 1, new Date(System.currentTimeMillis()));

		// Se listan todas las propiedades modificadas
		System.out.println("\n\nLista propiedades modificadas");
		printListProperties();

	}

	// =====================================
	// = Helper methods =
	// =====================================

	private static void createCountries() {

		// Se crea el Country x ================
		Country country = new Country("México");

		countrieList.add(country);

		// Se crea el Country x ================
		country = new Country("Panamá");

		countrieList.add(country);

		// Se crea el Country x ================
		country = new Country("Alemania");

		countrieList.add(country);

	}

	private static void printListProperties() {

		for (Country country : countrieList) {

			System.out.println("\n\nCountry name: " + country.getName());

			for (Map.Entry<String, Object> entry : country.getCountrySpec().getProperties().entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();

				System.out.println("\t Key: " + key + "\t Value: " + value);
			}
		}
	}

	private static void modifyCountryProperties(String countryName, int temblorTierra, int temblorMar,
			Date fechaUltimoTemblor) {

		// En México
		for (Country country : countrieList) {

			// Selecciona el Country
			if (country.getName().equals(countryName)) {

				country.getCountrySpec().addTembloresTierra(temblorTierra);
				country.getCountrySpec().addTembloresMar(temblorMar);
				country.getCountrySpec().addFechaTemblorMasReciente(fechaUltimoTemblor);
			}
		}
	}

}
