package com.mauriciotl.madule4.objects;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CountrySpec {

	// =====================================
	// = Notas, algunas de las propidedades que se tienen comtempladas son:
	/*
	 * cuentaTembloresTierra cuentaTembloresMar fechaTemblorMasReciente.
	 * 
	 * La principal función de esta clase es llevar el crud del countryList
	 */
	// =====================================

	// =====================================
	// = Attributes =
	// =====================================

	private HashMap<String, Object> properties = new HashMap<>();

	private int cuentaTembloresTierra = 0;
	private int cuentaTembloresMar = 0;
	private int cuentaTembloresTotales = cuentaTembloresTierra + cuentaTembloresMar;

	private Date fechaTemblorMasReciente;

	// =====================================
	// = Constructor's =
	// =====================================

	// En el constructor se crean las propiedades
	// básicas necesarias con las que nacerá el CountrySpec

	public CountrySpec() {

		this.properties.put("cuentaTembloresTierra", cuentaTembloresTierra);
		this.properties.put("cuentaTembloresMar", cuentaTembloresMar);
		this.properties.put("cuentaTembloresTotales", cuentaTembloresTotales);

		this.properties.put("fechaTemblorMasReciente", fechaTemblorMasReciente);
	}

	// =====================================
	// = g/s =
	// =====================================

	public HashMap<String, Object> getProperties() {
		return this.properties;
	}

	public Object getPropertyValueFromKey(String key) {

		return this.properties.get(key);
	}

	// =====================================
	// = CRUD basic properties =
	// =====================================

	public void addTembloresTierra(int numTembloresTierra) {
		cuentaTembloresTierra += numTembloresTierra;

		// La propiedad anterior ya se ha impactado en la variable de instancia,
		// pero ahora hay que plancharla en el HashMap.
		// Esta parte se deberá factorizar más tarde para que quede más
		// loosly-coupled
		this.properties.put("cuentaTembloresTierra", cuentaTembloresTierra);

		// Tambien se deberá planchar la siguiente propiedad por los mismos
		// motivos
		this.properties.put("cuentaTembloresTotales", cuentaTembloresTierra + cuentaTembloresMar);
	}

	public void addTembloresMar(int numTembloresMar) {
		cuentaTembloresMar += numTembloresMar;

		// La propiedad anterior ya se ha impactado en la variable de instancia,
		// pero ahora hay que plancharla en el HashMap.
		// Esta parte se deberá factorizar más tarde para que quede más
		// loosly-coupled
		this.properties.put("cuentaTembloresMar", cuentaTembloresMar);

		// Tambien se deberá planchar la siguiente propiedad por los mismos
		// motivos
		this.properties.put("cuentaTembloresTotales", cuentaTembloresTierra + cuentaTembloresMar);
	}

	public void addFechaTemblorMasReciente(Date dateLastTemblor) {

		this.fechaTemblorMasReciente = dateLastTemblor;

		// Tambien se deberá planchar la siguiente propiedad por los mismos
		// motivos
		this.properties.put("fechaTemblorMasReciente", fechaTemblorMasReciente);
	}

}
