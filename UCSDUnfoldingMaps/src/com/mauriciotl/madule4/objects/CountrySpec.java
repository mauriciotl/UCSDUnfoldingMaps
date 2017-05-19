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
	
	private Map properties;
	
	
	int cuentaTembloresTierra = 0;
	int cuentaTembloresMar = 0;
	Date fechaTemblorMasReciente = null;
	

// ===================================== 
// = Constructor's                        = 
// ===================================== 
	
	/*
	 * CountryProperties must arrive as Map (Interface)
	 * which allows more flexibility and more loosely coupleness
	 */
	
	public CountrySpec(Map countryProperties){
		
		//Constructor handles null possibility
		
		if(countryProperties == null){
			this.properties = new HashMap();
		}else{
			this.properties = countryProperties;
		}
		
	}
	
	
	// ===================================== 
	// = g/s = 
	// ===================================== 

	public Map getProperties(){
		return this.properties;
	}
	
	
	public Object getPropertyValueFromKey(String key){
		
		return this.properties.get(key);
	}
	
	
	
	
}
