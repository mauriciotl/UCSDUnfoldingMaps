package com.mauriciotl.week04.visibillityMembers2;

import com.mauriciotl.week04.visibilityMembers.Sample;

public class Sub2 extends Sample{

	public Sub2() {


		//Testing "protected" visibility
		int suma = x + 1;

		//Testing "default/package" visibility
		//We can prove that there's no access to y variable
//						int suma2 = y +2;
		
		
		//Testing "private" visibility
				//Here's the prove that private variable can't be accessed
//				int suma3 = z + 3;
		
		
	}

}
