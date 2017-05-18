package com.mauriciotl.week02.guiModule;

import processing.core.PApplet;

public class MyDisplay extends PApplet {
	
	public void setup(){
		
		size(400, 400);
		background(255, 255, 255);
		
		
		
	}
	
	public void draw(){
		
		//The head
		fill(71, 141, 255);
		ellipse(200, 200, 390, 390);
		
		//The eyes
		fill(255, 255, 255);
		ellipse(90, 120, 70, 50);
		ellipse(400-90, 120, 70, 50);
		
		//The smile
		noFill();
		arc(200,300, 200, 120, 0, PI );
		
	}
	

}
