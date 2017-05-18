package module3;

//Java utilities libraries
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;
import java.util.Map;

//Processing library
import processing.core.PApplet;

//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;

//Parsing library
import parsing.ParseFeed;

/** EarthquakeCityMap
 * An application with an interactive map displaying earthquake data.
 * Author: UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 * Date: July 17, 2015
 * */
public class EarthquakeCityMapMTL extends PApplet {
	
	
	private UnfoldingMap map;
	
	 //Use provided parser to collect properties for each earthquake
    //PointFeatures have a getLocation method
    private List<PointFeature> earthquakes;
	
	 // The List you will populate with new SimplePointMarkers
	private List<Marker> markers;

   
	
	
	
	Map<String, Float> lifeExpByCountry;
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	

	// You can ignore this.  It's to keep eclipse from generating a warning.
	private static final long serialVersionUID = 1L;

	// IF YOU ARE WORKING OFFLINE, change the value of this variable to true
	private static final boolean offline = true;
	
	// Less than this threshold is a light earthquake
	public static final float THRESHOLD_MODERATE = 5;
	// Less than this threshold is a minor earthquake
	public static final float THRESHOLD_LIGHT = 4;

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
//	// The map
//	private UnfoldingMap map;
	
	//feed with magnitude 2.5+ Earthquakes
	private String earthquakesURL = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";

	
	
	
	
	
	
	public void setup() {
		
		size(950, 600, OPENGL);

		if (offline) {
			
			
			map = new UnfoldingMap(this, 200, 50, 700, 500, new Microsoft.RoadProvider());
			
//		    map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
		    earthquakesURL = "2.5_week.atom"; 	// Same feed, saved Aug 7, 2015, for working offline
		}
		else {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
			// IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
			//earthquakesURL = "2.5_week.atom";
		}
		
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this, map);	
			
	    // The List you will populate with new SimplePointMarkers
	    List<Marker> markers = new ArrayList<Marker>();

	    //Use provided parser to collect properties for each earthquake
	    //PointFeatures have a getLocation method
	    List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
	    
	    
	    println("Testing by MTL: " + earthquakes.size() + earthquakes.toString());
	    
	    
	    //TODO: Add code here as appropriate
	    
	    //Copia PointFeatures al Marker y adiciona al Map
	    
	    for (PointFeature pointFeature : earthquakes) {
			
	    	Marker marker = new SimplePointMarker(pointFeature.location, pointFeature.getProperties());
	    	
	    	markers.add(marker);
	    	
		}
	    
	    
	    
	  //Markers color setting and added to the map
	  		//To set up the color 
	  		int yellow = color(255, 255, 0);
	  		int gray = color(150, 150, 150);

	  		for(Marker marker: markers){
	  			
	  			
	  			
	  			for (Map.Entry<String, Object> entry : marker.getProperties().entrySet()) {
	  			    String key = entry.getKey();
	  			    Object value = entry.getValue();
	  			    System.out.println("key: " + key + "  value: " + value);
	  			}
	  			
	  			

	  			
	  			
	  			
	  			double number = Double.parseDouble(marker.getProperty("magnitude").toString());
	  			float number2 = Float.parseFloat(marker.getProperty("magnitude").toString());
	  			
	  			
//	  			int magnitude = Integer.parseInt((marker.getProperty("magnitude").toString()));

//	  			if( magnitude > 5){
//	  				marker.setColor(yellow);
//	  			}else{
//	  				marker.setColor(gray);
//	  			}

	  			//Aquí se esta aprovechando este loop para ir metiendo cada Marker al Map
	  			this.map.addMarker(marker);
	  		}

	    
	    
	    
	}//setup
	
	
	
	
	public void draw() {
	    background(10);
	    map.draw();
	    addKey();
	}
	
	
	
	// A suggested helper method that takes in an earthquake feature and 
	// returns a SimplePointMarker for that earthquake
	// TODO: Implement this method and call it from setUp, if it helps
	private SimplePointMarker createMarker(PointFeature feature)
	{
		// finish implementing and use this method, if it helps.
		return new SimplePointMarker(feature.getLocation());
	}
	
	


	// helper method to draw key in GUI
	// TODO: Implement this method to draw the key
	private void addKey() 
	{	
		// Remember you can use Processing's graphics methods here
	
	}
}
