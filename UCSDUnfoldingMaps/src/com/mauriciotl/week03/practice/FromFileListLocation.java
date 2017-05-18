package com.mauriciotl.week03.practice;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
//import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import parsing.ParseFeed;
import processing.core.PApplet;

public class FromFileListLocation extends PApplet {

	/*
	 * En esta clase ya se está utilizando PointFeature,
	 * con el objetivo de agregar lista de características a cada Location
	 */



	// ===================================== 
	// = Attributes                        = 
	// ===================================== 

	private static final long serialVersionUID = 1L;

	private UnfoldingMap myMap;

	private List<PointFeature> earthquakePoints;
	private List<Marker> markers;
	

	
	//feed with magnitude 2.5+ Earthquakes
		private String earthquakesURL;
	


	// ===================================== 
	// = Other methods                     = 
	// ===================================== 


	public void setup () {


		//Setup canvas and create a map
		size(950, 600, OPENGL);
//		myMap = new UnfoldingMap(this, 200, 50, 700, 500, new Microsoft.RoadProvider());
		myMap = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
		
	    earthquakesURL = "2.5_week.atom"; 	// Same feed, saved Aug 7, 2015, for working offline
		

	    
		//It's an build in method from the UnfoldingMap library
		//To allow zoom in with double click and panning around, 
		//allow the map to interact with the user
	    myMap.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, myMap);

		//Create locations
		this.populatesLocations();

		//Format SimplePoints and adds to Map
		this.formatMarkerPoints();


	}//End method.


	public void draw () {


		background(GRAY);

		myMap.draw();
		this.addKey();

	}//End method.


	// ===================================== 
	// = Helper methods                    = 
	// ===================================== 

	private void populatesLocations () {


		 //Use provided parser to collect properties for each earthquake
	    //PointFeatures have a getLocation method
		earthquakePoints = ParseFeed.parseEarthquake(this, earthquakesURL);
		
		
		markers = new ArrayList<>();
		
		
		//Copia los PoitFeature a Marker para poderlos 
		//agregar al Map
		for (PointFeature earthquakePoint : earthquakePoints) {
			
			//IMPORTANTE, en este punto se puede ver como se copian las propiedades del 
			//HASHMAP del Future al Marker, pues son las mismas.
			Marker valMarker = new SimplePointMarker(earthquakePoint.location, earthquakePoint.getProperties());
			
			markers.add(valMarker);
			
		}
		
		
	

	}//End method.


	private void formatMarkerPoints () {


		//Markers color setting and added to the map
		//To set up the color 
		int red = color(250, 0, 0);
		int green = color(0, 250, 0);
		int blue = color(0,0,250);

		for(Marker marker: markers){

			
			float magnitude = Float.parseFloat(marker.getProperty("magnitude").toString());

			if( magnitude < 4.0f){
				marker.setColor(blue);
				
			}else if(magnitude > 5.0f){
				marker.setColor(red);
			}else{
				marker.setColor(blue);
			}
			
			//Aquí se esta aprovechando este loop para ir metiendo cada Marker al Map
			this.myMap.addMarker(marker);
		}



	}//End method.



	// helper method to draw key in GUI
		// TODO: Implement this method to draw the key
		private void addKey() 
		{	
			fill(150, 150 ,150);
			rect(20, 50, 160, 250, 7);
		
		}



}
