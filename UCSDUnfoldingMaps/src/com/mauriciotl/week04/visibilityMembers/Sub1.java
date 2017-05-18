package com.mauriciotl.week04.visibilityMembers;

public class Sub1 extends Sample{

	public Sub1() {

	//Testing "protected" visibility
	int suma = x + 1;
	
	
	//Testing "default/package" visibility
	int suma2 = y +2;
	
	
	//Testing "private" visibility
	//Here's the prove that private variable can't be accessed
//	int suma3 = z + 3;
	
	
	
	}

}
