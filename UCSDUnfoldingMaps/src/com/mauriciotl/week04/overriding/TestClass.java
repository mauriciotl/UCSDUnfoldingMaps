package com.mauriciotl.week04.overriding;

public class TestClass {

	public TestClass() {
	}

	public static void main(String[] args) {
		
		
		Person p = new Person("Tim");
		
		
		System.out.println(p.toString());
		
		//Above sentence is not necessary since println method automatically calls toString() method
		System.out.println(p);
		
		
		
		Person ps = new Student( "Tim", 123);
		
		System.out.println(ps);
		
		
		Student student = (Student) ps;
		System.out.println(student.isAStudent());
		

	}

}
