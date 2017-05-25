package com.mauriciotl.madule4.objects;

public class Country {

/*
 * Esta clase maneja una propiedad general para Country = name, adicionalmente utiliza
 * la clase ObjectSpec para llevar una lista de valores key, value
 */

// ===================================== 
// = Attributes                        = 
// ===================================== 

	private String name;
	private ObjectSpec objectSpec;
	
	
// ===================================== 
// = Constructor's                        = 
// ===================================== 

	
	public Country(String name, ObjectSpec objectSpec){
		
		this.name = name;
		this.objectSpec = objectSpec;
	}
	
	
// ===================================== 
// = g/s                        = 
// ===================================== 


	public String getName(){
		return name;
	}
	
	public ObjectSpec getObjectSpec(){
		
		return this.objectSpec;
	}
	
}
