package com.mauriciotl.week03.practice;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;



public class SimpleLocation extends PApplet {

	// ===================================== 
	// = Attributes                        = 
	// ===================================== 

	private static final long serialVersionUID = 1L;
	
	private UnfoldingMap myMap;
	private Location myLocation;
	private Marker myMarker;


	// ===================================== 
	// = Other methods                     = 
	// ===================================== 

	@Override
	public void setup () {


		//Setup canvas and create a map
		size(800, 600, OPENGL);
		myMap = new UnfoldingMap(this, 50, 50, 700, 500, new Microsoft.RoadProvider());
		//		myMap = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());

		//It's an build in method from the UnfoldingMap library
		//To allow zoom in with double click and panning around, 
		//allow the map to interact with the user
		MapUtils.createDefaultEventDispatcher(this, myMap);

		myLocation = new Location(19.4, -99.2);
		myMarker = new SimplePointMarker(myLocation);

		//Format SimplePoint
		int yellow = color(255, 255, 0);
		myMarker.setColor(yellow);

		//Add to Map
		myMap.addMarker(myMarker);


	}//End method.

	@Override
	public void draw () {


		background(GRAY);

		myMap.draw();

	}//End method.




}
