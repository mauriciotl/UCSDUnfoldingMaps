package com.mauriciotl.week02;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.*;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class EarthquakeCityMap extends PApplet {
	
	
	private UnfoldingMap map;
	
	@Override
	public void setup(){
		
		size(950, 600, OPENGL);
		
//		map = new UnfoldingMap(this, 200, 50, 700, 500, new Microsoft.RoadProvider());
		
		map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
		
		
		map.zoomLevel(2);
		
		MapUtils.createDefaultEventDispatcher(this, map);
		
		
		//This part will add a point in the UnfoldingMap
		Location valLoc = new Location(-38.14f, -73.03f);
		SimplePointMarker simpleMarker = new SimplePointMarker(valLoc);
		map.addMarker(simpleMarker);
		
		
		
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
	

}
