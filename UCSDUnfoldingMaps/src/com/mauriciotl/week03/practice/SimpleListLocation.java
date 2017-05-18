package com.mauriciotl.week03.practice;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class SimpleListLocation extends PApplet {

	/*
	 * En esta clase ya se está utilizando PointFeature,
	 * con el objetivo de agregar lista de características a cada Location
	 */



	// ===================================== 
	// = Attributes                        = 
	// ===================================== 

	private static final long serialVersionUID = 1L;

	private UnfoldingMap myMap;

	private List<Marker> markers;
	private List<Location> locations;



	// ===================================== 
	// = Other methods                     = 
	// ===================================== 


	public void setup () {


		//Setup canvas and create a map
		size(800, 600, OPENGL);
		myMap = new UnfoldingMap(this, 50, 50, 700, 500, new Microsoft.RoadProvider());
		//		myMap = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());

		//It's an build in method from the UnfoldingMap library
		//To allow zoom in with double click and panning around, 
		//allow the map to interact with the user
		MapUtils.createDefaultEventDispatcher(this, myMap);

		//Create locations
		this.populatesLocations();

		//Format SimplePoints and adds to Map
		this.formatPoints();


	}//End method.


	public void draw () {


		background(GRAY);

		myMap.draw();

	}//End method.


	// ===================================== 
	// = Helper methods                    = 
	// ===================================== 

	private void populatesLocations () {


		markers = new ArrayList<>();


		//This part will add x point in the UnfoldingMap ==========================01
		Location valLoc = new Location(19.4, -99.2);

		Feature featureValLoc = new PointFeature(valLoc);
		featureValLoc.addProperty("title", "Mauricio location");
		featureValLoc.addProperty("magnitude", "7.8");
		featureValLoc.addProperty("date", "Sep 11, 1985");
		featureValLoc.addProperty("year", "1985");

		//IMPORTANTE, en este punto se puede ver como se copian las propiedades del 
		//HASHMAP del Future al Marker, pues son las mismas.
		Marker valMarker = new SimplePointMarker(valLoc, featureValLoc.getProperties());

		//Adds marker to the list
		this.markers.add(valMarker);


		//This part will add x point in the UnfoldingMap ==========================01
		valLoc = new Location(-38.14f, -73.03f);

		featureValLoc = new PointFeature(valLoc);
		featureValLoc.addProperty("title", "Valdivia, Chile");
		featureValLoc.addProperty("magnitude", "9.5");
		featureValLoc.addProperty("date", "May 22, 1960");
		featureValLoc.addProperty("year", "1960");

		//IMPORTANTE, en este punto se puede ver como se copian las propiedades del 
		//HASHMAP del Future al Marker, pues son las mismas.
		valMarker = new SimplePointMarker(valLoc, featureValLoc.getProperties());

		//Adds marker to the list
		this.markers.add(valMarker);


		//This part will add x point in the UnfoldingMap =========================02
		valLoc = new Location(61.02f, -147.65f);

		featureValLoc = new PointFeature(valLoc);
		featureValLoc.addProperty("title", "Alaska, US");
		featureValLoc.addProperty("magnitude", "9.2");
		featureValLoc.addProperty("date", "March 28, 1964");
		featureValLoc.addProperty("year", "1964");

		valMarker = new SimplePointMarker(valLoc, featureValLoc.getProperties());

		//Adds marker to the list
		this.markers.add(valMarker);


		//This part will add x point in the UnfoldingMap =========================03
		valLoc = new Location(3.30f, 95.78f);

		featureValLoc = new PointFeature(valLoc);
		featureValLoc.addProperty("title", "Northern Sumatra, Sumatra");
		featureValLoc.addProperty("magnitude", "9.1");
		featureValLoc.addProperty("date", "December 26, 2004");
		featureValLoc.addProperty("year", "2004");

		valMarker = new SimplePointMarker(valLoc, featureValLoc.getProperties());

		//Adds marker to the list
		this.markers.add(valMarker);


	}//End method.


	private void formatPoints () {


		//Markers color setting and added to the map
		//To set up the color 
		int yellow = color(255, 255, 0);
		int gray = color(150, 150, 150);

		for(Marker marker: markers){

			int year = Integer.parseInt((marker.getProperty("year").toString()));

			if( year > 2000){
				marker.setColor(yellow);
			}else{
				marker.setColor(gray);
			}

			//Aquí se esta aprovechando este loop para ir metiendo cada Marker al Map
			this.myMap.addMarker(marker);
		}


		//Debugging, lo siguiente es para trabajar alrevez, es decir del UnfoldingMap,
		//encontrar los Marker que tenga guardados
		System.out.println("Print myMap.Markers list: =============");
		for(int i = 0; i < myMap.getMarkers().size(); i++){
			Location mapLocation = myMap.getMarkers().get(i).getLocation();
			System.out.println(mapLocation);
		}
		

	}//End method.






}
