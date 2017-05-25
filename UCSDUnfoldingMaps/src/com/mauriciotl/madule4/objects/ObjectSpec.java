package com.mauriciotl.madule4.objects;

import java.util.HashMap;
import java.util.Map;

public class ObjectSpec {
	
	/*
	 * Esta clase sirve para llevar una lista de valores pares (key, value) = Map
	 * Su nombre viene de ObjectSpecification 
	 * 
	 * Note. Map had to be parametrized since some trouble to iterate over properties
	 * was found in Test_ObjectSpec class
	 */


	// =====================================
	// = Attributes =
	// =====================================

	private Map<String, Object> properties;

	// =====================================
	// = Constructor's =
	// =====================================

	
	public ObjectSpec(Map<String, Object> properties){
		
		//Se maneja el posible valor de null en el properties
		//Me parece que no se realiza la parametrización del HashMap
		//para que quede más flexible
		
		if(properties == null){
			this.properties = new HashMap<String, Object>();
		}else{
			this.properties = new HashMap<String, Object>(properties);
		}
	}
	

	// =====================================
	// = g/s =
	// =====================================

	
	public Map<String, Object> getProperties(){
		return this.properties;
	}
	
	public Object getPropertyValueByKey(String key){
		return properties.get(key);
	}


}
