package com.mauriciotl.week04.visibilityMembers;

public class Other1 {

	public Other1() {
		
		Sample s = new Sample();
		
		//Testing "protected" visibility
		int suma = s.x + 1;
		
		
		//Testing "default/package" visibility
		int suma2 = s.y +2;
		
		//Testing "private" visibility
		//Here's the prove that private variable can't be accessed
//		int suma3 = s.z + 3;
		
		
	}

}
