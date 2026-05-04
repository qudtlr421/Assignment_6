/*
 * Class: CMSC204 
 * Instructor: professor Thai, Gary
 * Description: Project<6>
 * Due: 5/3/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Giran Park
*/

package proj6;

import java.util.*;


import java.io.*;

public class TownGraphManager implements TownGraphManagerInterface{

	private Graph graph= new Graph();
	

	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town t1= new Town(town1);
		Town t2= new Town(town2);
		graph.addVertex(t1);
		graph.addVertex(t2);
		graph.addEdge(t1,t2, weight, roadName);
		return true;
}
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
	Road road= graph.getEdge(new Town(town1), new Town(town2));
	return (road!=null)? road.getName(): null;
	}
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}
	
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		for(Town t: graph.vertexSet()) {
			if(t.getName().equalsIgnoreCase(name)) return t;
		}
		return null;
	}
	
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}
	
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
	}
	
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads(){
		ArrayList<String> roads= new ArrayList<>();
		for(Road r: graph.edgeSet()) {
			roads.add(r.getName());
			
		}
		Collections.sort(roads);
		return roads;
	}
	
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		return graph.removeEdge(new Town(town1), new Town(town2), -1, road)!=null;
	}
	
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns(){
		ArrayList<String> towns= new ArrayList<>();
		for(Town t: graph.vertexSet()) {
			towns.add(t.getName());
		}
		Collections.sort(towns);
		return towns;
	}
	
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2){
		return graph.shortestPath(new Town(town1), new Town(town2));
	}
	
	public void populateTownGraph(File file) throws FileNotFoundException {
	    Scanner sc = new Scanner(file);
	    while (sc.hasNextLine()) {
	        String line = sc.nextLine();

	        String[] parts = line.split("[,;]");
	        if (parts.length == 4) {
	            addRoad(parts[2], parts[3], Integer.parseInt(parts[1]), parts[0]);
	        }
	    }
	    sc.close();
	}
	
}
