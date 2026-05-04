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

public class Town implements Comparable<Town>{
	private String name;
	public Town(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	@Override 
	public int compareTo(Town o) {
		return name.compareToIgnoreCase(o.name);
	}
	@Override 
	public String toString() { 
		return name; }
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Town)) return false;
		return name.equalsIgnoreCase(((Town) obj).name);
	}
	@Override 
	public int hashCode() {
		return name.toLowerCase().hashCode();
	}

}
