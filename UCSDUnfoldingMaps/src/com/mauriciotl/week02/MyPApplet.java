package com.mauriciotl.week02;

import processing.core.PApplet;
import processing.core.PImage;;

public class MyPApplet extends PApplet {


	private String URL = "http://www.dw.com/image/38484069_301.jpg";
	private PImage backgroundImage;

	@Override
	public void setup(){

				size(200, 200);
				backgroundImage = loadImage(URL, "jpg");
				
				backgroundImage.resize(0, height);
				image(backgroundImage, 0, 0);
	}

	@Override
	public void draw(){
		
		//Las siguientes dos sentencias se están repitiendo para no perder la 
		//imgen de fondo cada que se realize un resize
		backgroundImage.resize(0, height);
		image(backgroundImage, 0, 0);
		
		
		//Add drawing code for myPApplet
		//second() method is a built in method
		//Creo que se invoca automáticamente cada segundo
		int[] colorsRGB = sunColorSec(second());
		
		//The sun
		fill(colorsRGB[0], colorsRGB[1], colorsRGB[2]);
		ellipse(width/4, height/5, width/5, height/5);
	}

	
	
	public int[] sunColorSec (float seconds) {
		
		
		int[] rGB = new int[3]; 
		
		//Scale the brightness of the yellow, based on the seconds. 
		//30 seconds is black.
		//0 seconds is bright yellow.
		
		float diffFrom30 = Math.abs(30-seconds);
		float ratio = diffFrom30/30;
		
		rGB[0] = (int) (255*ratio);
		rGB[1] = (int) (255*ratio);
		rGB[2] = (int) (0);
		
		println("rGB[0]= " + rGB[0] + "  rGB[1]= " + rGB[1] + "  rGB[2]=" + rGB[2]);
		
		return rGB;
		
	}
	
	
	
	
}
