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

import java.util.Objects;



public class Road implements Comparable<Road>{

	private Town source;
	private Town destination;
	private int weight;
	private String name;
	
	public Road(Town source, Town destination, int weight, String name) {
		this.source= source;
		this.destination= destination;
		this.weight= weight;
		this.name= name;
	}
	
	public boolean contains(Town town) {
		return source.equals(town)|| destination.equals(town);
	}
	
	
	public String getName() {
		return name;
	}
	
	public Town getSource() {
		return source;
	}
	
	public int getWeight() {
		return weight;
	}
	
	@Override
	public int compareTo(Road r) {
		return this.name.compareTo(r.name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(!(obj instanceof Road)) return false;
		Road other =(Road) obj;
		
		return(source.equals(other.source)&& destination.equals(other.destination))||(source.equals(other.destination)&& destination.equals(other.source));
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public String toString() {
		return name +","+weight+";"+source.getName()+";"+destination.getName();
	}
	
}
