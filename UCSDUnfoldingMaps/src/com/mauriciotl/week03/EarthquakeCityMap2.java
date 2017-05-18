package com.mauriciotl.week03;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.*;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class EarthquakeCityMap2 extends PApplet {
	
	
	private UnfoldingMap map;
	
	private List<Marker> listMarkers;
	
	

	@Override
	public void setup(){
		
		size(950, 600, OPENGL);
		
		
		map = new UnfoldingMap(this, 200, 50, 700, 500, new Microsoft.RoadProvider());
		
//		map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
		map.zoomLevel(2);
		
		
		MapUtils.createDefaultEventDispatcher(this, map);
		
		populatesMarkers();
	}
	
	
	@Override
	public void draw(){
		
		background(GRAY);
		
		map.draw();
		
		addKey();
		
	}

	
	private void addKey() {
		// TODO Auto-generated method stub
	}
	
	
	
	private void populatesMarkers(){
		
		listMarkers = new ArrayList<>();

		//This part will add x point in the UnfoldingMap ==========================01
		Location valLoc = new Location(-38.14f, -73.03f);

		Feature featureValLoc = new PointFeature(valLoc);
		featureValLoc.addProperty("title", "Valdivia, Chile");
		featureValLoc.addProperty("magnitude", "9.5");
		featureValLoc.addProperty("date", "May 22, 1960");
		featureValLoc.addProperty("year", "1960");

		//IMPORTANTE, en este punto se puede ver como se copian las propiedades del 
		//HASHMAP del Future al Marker, pues son las mismas.
		Marker valMarker = new SimplePointMarker(valLoc, featureValLoc.getProperties());

		//The Marker is been added to the listMarkers
		this.listMarkers.add(valMarker);


		//This part will add x point in the UnfoldingMap =========================02
		valLoc = new Location(61.02f, -147.65f);

		featureValLoc = new PointFeature(valLoc);
		featureValLoc.addProperty("title", "Alaska, US");
		featureValLoc.addProperty("magnitude", "9.2");
		featureValLoc.addProperty("date", "March 28, 1964");
		featureValLoc.addProperty("year", "1964");

		valMarker = new SimplePointMarker(valLoc, featureValLoc.getProperties());

		//The Marker is been added to the listMarkers
		this.listMarkers.add(valMarker);


		//This part will add x point in the UnfoldingMap =========================03
		valLoc = new Location(3.30f, 95.78f);

		featureValLoc = new PointFeature(valLoc);
		featureValLoc.addProperty("title", "Northern Sumatra, Sumatra");
		featureValLoc.addProperty("magnitude", "9.1");
		featureValLoc.addProperty("date", "December 26, 2004");
		featureValLoc.addProperty("year", "2004");

		valMarker = new SimplePointMarker(valLoc, featureValLoc.getProperties());

		//The Marker is been added to the listMarkers
		this.listMarkers.add(valMarker);
		
		
		//Markers color setting and added to the map
		//To set up the color 
		int yellow = color(255, 255, 0);
		int gray = color(150, 150, 150);
		
		for(Marker marker: listMarkers){
			
			int year = Integer.parseInt((marker.getProperty("year").toString()));
			
			if( year > 2000){
				marker.setColor(yellow);
			}else{
				marker.setColor(gray);
			}
			
			//Aquí se esta aprovechando este loop para ir metiendo cada Marker al Map
			this.map.addMarker(marker);
		}
	}
	

}
