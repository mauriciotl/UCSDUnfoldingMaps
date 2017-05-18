package com.mauriciotl.week04.overriding;

public class Student extends Person{

	
	private int studentId;
	
	
	public Student(String name, int id) {
		super(name);
		this.studentId = id;
	}
	
	
	public int getSID(){
		return this.studentId;
	}
	
	
	//to get a customized version of toString() method
	
	@Override
	public String toString(){
		
//		return this.studentId + " " + this.getName();
		//but a most losely coupled way to do it is:
		
		return this.getSID() + " "	+ super.toString();
		
	}
	
	
	public boolean isAStudent(){
		return true;
	}
	

}
