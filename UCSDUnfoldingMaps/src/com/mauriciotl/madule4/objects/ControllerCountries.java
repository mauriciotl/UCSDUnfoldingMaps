package com.mauriciotl.madule4.objects;

import java.util.LinkedList;
import java.util.List;

public class ControllerCountries {

	
	
	// ===================================== 
	// = Attributes                        = 
	// ===================================== 

	
	private List<Country> countryList;
	
	private int TotalTembloresTierra;
	private int TotalTembloresMar;
	
	private int grandTotalTemblores;
	
	
	
	// ===================================== 
	// = Constructor's                        = 
	// ===================================== 

	
	public ControllerCountries(List<Country> countryList){
		
		//Se inicializa el countryList
		if(countryList == null){
			this.countryList = new LinkedList<Country>();
		}{
			this.countryList = new LinkedList<Country>(countryList);
		}
		
		//Y en base a esta lista también se inicializan los valore totales
		
		
		if(countryList.size() > 0){
			
			for(Country country : countryList){
				
				
				
				
				
			}
			
			
		}
		
		
		
	}
	
	
	
	

}
