package com.mauriciotl.week04.visibillityMembers2;

import com.mauriciotl.week04.visibilityMembers.Sample;

public class Other2 {

	public Other2() {

		Sample s = new Sample();

		//Testing "protected" visibility
		//We can prove that there's no access to x variable
//		int suma = s.x + 1;

		
		//Testing "default/package" visibility
		//We can prove that there's no access to y variable
//		int suma2 = s.y +2;
		
		
		//Testing "private" visibility
				//Here's the prove that private variable can't be accessed
//				int suma3 = s.z + 3;

	}

}
