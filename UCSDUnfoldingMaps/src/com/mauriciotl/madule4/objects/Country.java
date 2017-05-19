package com.mauriciotl.madule4.objects;

public class Country {



// ===================================== 
// = Attributes                        = 
// ===================================== 

	private String name;
	private CountrySpec countrySpec;
	
	
// ===================================== 
// = Constructor's                        = 
// ===================================== 

	
	public Country(String name, CountrySpec countrySpec) {
		super();
		this.name = name;
		this.countrySpec = countrySpec;
	}
	
// ===================================== 
// = g/s                        = 
// ===================================== 


	public String getName(){
		return name;
	}
	
	public CountrySpec getCountrySpec(){
		
		return this.countrySpec;
	}


	
	
}
