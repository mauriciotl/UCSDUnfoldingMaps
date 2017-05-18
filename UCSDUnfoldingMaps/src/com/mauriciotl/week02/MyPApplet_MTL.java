package com.mauriciotl.week02;

import processing.core.PApplet;
import processing.core.PImage;;

public class MyPApplet_MTL extends PApplet {



	@Override
	public void setup(){

		println("Hello World");
				
				size(400, 400);
				stroke(255);
				background(192, 64, 0);
	}


	@Override
	public void draw(){
		
		 line(150, 25, mouseX, mouseY);
	}

}
