package com.mauriciotl.module4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.AbstractShapeMarker;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.MultiMarker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import parsing.ParseFeed;
import processing.core.PApplet;

/** EarthquakeCityMap
 * An application with an interactive map displaying earthquake data.
 * Author: UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 * Date: July 17, 2015
 * */
public class EarthquakeCityMap_forDebuging extends PApplet {


	// ===================================== 
	// = Attributes                        = 
	// ===================================== 


	// We will use member variables, instead of local variables, to store the data
	// that the setUp and draw methods will need to access (as well as other methods)
	// You will use many of these variables, but the only one you should need to add
	// code to modify is countryQuakes, where you will store the number of earthquakes
	// per country.

	// You can ignore this.  It's to get rid of eclipse warnings
	private static final long serialVersionUID = 1L;

	// IF YOU ARE WORKING OFFILINE, change the value of this variable to true
	private static final boolean offline = false;

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "blankLight-1-d3.mbtiles";



	//feed with magnitude 2.5+ Earthquakes
	//	private String earthquakesURL = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";
	private String earthquakesURL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";


	// The files containing city names and info and country names and info
	private String cityFile = "city-data.json";
	private String countryFile = "countries.geo.json";

	// The map
	private UnfoldingMap unfoldingMap;

	// Markers for each city
	private List<Marker> cityMarkers;
	// Markers for each earthquake
	private List<Marker> earthquakeMarkers;

	// A List of country markers
	private List<Marker> countryMarkers;

	
	
	private List<Marker> markers;
	private List<Location> locations;

	
	


	// ===================================== 
	// = Other methods                        = 
	// ===================================== 

	
	
	


	public void setup() {		
		// (1) Initializing canvas and map tiles
		size(900, 700, OPENGL);
		if (offline) {
			unfoldingMap = new UnfoldingMap(this, 200, 50, 650, 600, new MBTilesMapProvider(mbTilesString));
			earthquakesURL = "2.5_week.atom";  // The same feed, but saved August 7, 2015
		}
		else {
			//			map = new UnfoldingMap(this, 200, 50, 650, 600, new Google.GoogleMapProvider());
			unfoldingMap = new UnfoldingMap(this, 200, 50, 650, 600, new Microsoft.RoadProvider());
			// IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
			//earthquakesURL = "2.5_week.atom";
		}
		MapUtils.createDefaultEventDispatcher(this, unfoldingMap);

		// FOR TESTING: Set earthquakesURL to be one of the testing files by uncommenting
		// one of the lines below.  This will work whether you are online or offline
		//earthquakesURL = "test1.atom";
		//earthquakesURL = "test2.atom";

		// WHEN TAKING THIS QUIZ: Uncomment the next line
		//earthquakesURL = "quiz1.atom";


		// (2) Reading in earthquake data and geometric properties
		//     STEP 1: load country features and markers
		List<Feature> countriesFeatures = GeoJSONReader.loadData(this, countryFile);
		countryMarkers = MapUtils.createSimpleMarkers(countriesFeatures);

		//     STEP 2: read in city data
		List<Feature> citiesFeatures = GeoJSONReader.loadData(this, cityFile);

		//debugging
		//Note Feature has a property that is a HashMap, 
		//but Future itself is not a HashMap
		System.out.println("Print citiesFeatures");
		for(Feature cityFeature : citiesFeatures){
			//De cada cityFeature se están obteniendo las propiedades del 
			//HashMap
			System.out.println();
			for(Map.Entry<String, Object> entry : cityFeature.properties.entrySet()  ){
				String key = entry.getKey();
				Object value = entry.getValue();
				System.out.println("key: " + key +"  value: " + value.toString());
			}

		}


		cityMarkers = new ArrayList<Marker>();
		for(Feature city : citiesFeatures) {
			cityMarkers.add(new CityMarker(city));
		}

		//     STEP 3: read in earthquake RSS feed
		List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);


		System.out.println("\n");
		//Debugging
		for(PointFeature pointFeature : earthquakes){

			float x = pointFeature.location.x;
			float y = pointFeature.location.y;

			System.out.println();
			System.out.println("Location: " + x + y);

			for(Map.Entry<String, Object> entry : pointFeature.properties.entrySet()){

				String key = entry.getKey();
				Object value = entry.getValue();

				System.out.println("key: " + key +"  value: " + value.toString());
			}
		}


		earthquakeMarkers = new ArrayList<Marker>();

		for(PointFeature feature : earthquakes) {
			//check if LandQuake
			if(isLand(feature)) {
				earthquakeMarkers.add(new LandQuakeMarker(feature));
			}
			// OceanQuakes
			else {
				earthquakeMarkers.add(new OceanQuakeMarker(feature));
			}
		}

		//Debugging
		System.out.println("Print earthquakeMarkers =====================");
		for(Marker earthquakeMarker : earthquakeMarkers){

			float x = earthquakeMarker.getLocation().x;
			float y = earthquakeMarker.getLocation().y;

			System.out.println();
			System.out.println("Location (earthquakeMarker) : " + x + y);

			for(Map.Entry<String, Object> entry : earthquakeMarker.getProperties().entrySet()){

				String key = entry.getKey();
				Object value = entry.getValue();

				System.out.println("key: " + key +"  value: " + value.toString());	
			}
		}

		
		
		//Format will be applied before be added to unfoldingMap

		
		int blue = color(0, 0, 255);

		for(Marker marker: earthquakeMarkers){
			marker.setColor(blue);
		}
		
		


		// could be used for debugging
		printQuakes();

		// (3) Add markers to map
		//     NOTE: Country markers are not added to the map.  They are used
		//           for their geometric properties
		unfoldingMap.addMarkers(earthquakeMarkers);
		unfoldingMap.addMarkers(cityMarkers);



		//Debugging, lo siguiente es para trabajar alrevez, es decir del UnfoldingMap,
		//encontrar los Marker que tenga guardados

		System.out.println("Print myMap.Markers list: =============");
		for(int i = 0; i < unfoldingMap.getMarkers().size(); i++){

			Location mapLocation = unfoldingMap.getMarkers().get(i).getLocation();
			System.out.println(mapLocation);
		}

		
		//Create locations
				this.populatesLocations();

				//Format SimplePoints and adds to Map
				this.formatPoints();



	}  // End setup


	public void draw() {
		
		background(GRAY);

		//		background(0);
		unfoldingMap.draw();
		addKey();

	}


	// ===================================== 
	// = Helper methods                        = 
	// ===================================== 



	// helper method to draw key in GUI
	// TODO: Update this method as appropriate
	private void addKey() {	
		// Remember you can use Processing's graphics methods here
		fill(255, 250, 240);
		rect(25, 50, 150, 250);

		fill(0);
		textAlign(LEFT, CENTER);
		textSize(12);
		text("Earthquake Key", 50, 75);

		fill(color(255, 0, 0));
		ellipse(50, 125, 15, 15);
		fill(color(255, 255, 0));
		ellipse(50, 175, 10, 10);
		fill(color(0, 0, 255));
		ellipse(50, 225, 5, 5);

		fill(0, 0, 0);
		text("5.0+ Magnitude", 75, 125);
		text("4.0+ Magnitude", 75, 175);
		text("Below 4.0", 75, 225);
	}



	// Checks whether this quake occurred on land.  If it did, it sets the 
	// "country" property of its PointFeature to the country where it occurred
	// and returns true.  Notice that the helper method isInCountry will
	// set this "country" property already.  Otherwise it returns false.
	private boolean isLand(PointFeature earthquake) {

		// IMPLEMENT THIS: loop over all countries to check if location is in any of them

		// TODO: Implement this method using the helper method isInCountry

		// not inside any country
		return false;
	}

	// prints countries with number of earthquakes
	// You will want to loop through the country markers or country features
	// (either will work) and then for each country, loop through
	// the quakes to count how many occurred in that country.
	// Recall that the country markers have a "name" property, 
	// And LandQuakeMarkers have a "country" property set.
	private void printQuakes() 
	{
		// TODO: Implement this method

	}



	// helper method to test whether a given earthquake is in a given country
	// This will also add the country property to the properties of the earthquake 
	// feature if it's in one of the countries.
	// You should not have to modify this code
	private boolean isInCountry(PointFeature earthquake, Marker country) {
		// getting location of feature
		Location checkLoc = earthquake.getLocation();

		// some countries represented it as MultiMarker
		// looping over SimplePolygonMarkers which make them up to use isInsideByLoc
		if(country.getClass() == MultiMarker.class) {

			// looping over markers making up MultiMarker
			for(Marker marker : ((MultiMarker)country).getMarkers()) {

				// checking if inside
				if(((AbstractShapeMarker)marker).isInsideByLocation(checkLoc)) {
					earthquake.addProperty("country", country.getProperty("name"));

					// return if is inside one
					return true;
				}
			}
		}

		// check if inside country represented by SimplePolygonMarker
		else if(((AbstractShapeMarker)country).isInsideByLocation(checkLoc)) {
			earthquake.addProperty("country", country.getProperty("name"));

			return true;
		}
		return false;
	}
	
	
	// ===================================== 
	// = Debugging methods                        = 
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
			this.unfoldingMap.addMarker(marker);
		}


		//Debugging, lo siguiente es para trabajar alrevez, es decir del UnfoldingMap,
		//encontrar los Marker que tenga guardados
		System.out.println("Print myMap.Markers list: =============");
		for(int i = 0; i < unfoldingMap.getMarkers().size(); i++){
			Location mapLocation = unfoldingMap.getMarkers().get(i).getLocation();
			System.out.println(mapLocation);
		}
		

	}//End method.


	
	
	
	

}
