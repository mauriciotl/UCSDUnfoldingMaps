package com.mauriciotl.week04.overriding;

public class Person {
	
	
	private String name;

	
	
	public Person(String name) {
		this.name = name;
	}

	
	public String getName(){
		
		return this.name;
	}
	
	
	//Se realizará un overriding del método toString() que nace en Objeto
	
	@Override
	public String toString(){
		
		return getName();
	}
	
	
}
