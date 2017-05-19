package com.mauriciotl.madule4.objects;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CountrySpec {
	
	// ===================================== 
	// = Notas, algunas de las propidedades que se tienen comtempladas son:
	/*
	 * cuentaTembloresTierra
	 * cuentaTembloresMar
	 * fechaTemblorMasReciente 
	 */
	// ===================================== 

	
// ===================================== 
// = Attributes                        = 
// ===================================== 
	
	
	private HashMap<String, Object> properties = new HashMap<>();
	
	
	private int cuentaTembloresTierra = 0;
	private int cuentaTembloresMar = 0;
	private int cuentaTembloresTotales = cuentaTembloresTierra + cuentaTembloresMar;
	
	private Date fechaTemblorMasReciente;
	
	
	
// ===================================== 
// = Constructor's                        = 
// ===================================== 
	
	//En el constructor se crean las propiedades
	//básicas necesarias con las que nacerá el CountrySpec
	
	public CountrySpec(){
		
		this.properties.put("cuentaTembloresTierra", cuentaTembloresTierra);
		this.properties.put("cuentaTembloresMar", cuentaTembloresMar);
		this.properties.put("cuentaTembloresTotales", cuentaTembloresTotales);
		
		this.properties.put("fechaTemblorMasReciente", fechaTemblorMasReciente);
	}
	
	// ===================================== 
	// = g/s = 
	// ===================================== 

	
	public HashMap<String, Object> getProperties(){
		return this.properties;
	}
	
	public Object getPropertyValueFromKey(String key){
		
		return this.properties.get(key);
	}
	
	
	// ===================================== 
	// = CRUD basic properties                        = 
	// ===================================== 

	public void addTembloresTierra(int numTembloresTierra){
		cuentaTembloresTierra += numTembloresTierra;
	}
	
	public void addTembloresMar(int numTembloresMar){
		cuentaTembloresMar += numTembloresMar;
	}
	
	public void addFechaTemblorMasReciente(Date dateLastTemblor){
		
		this.fechaTemblorMasReciente = dateLastTemblor;
	}
	
	
	
}
