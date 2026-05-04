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


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test{
	private Town town;
	
	@Before
	public void setUp() {
		town= new Town("TimeSqure");
	
	}
	@Test
	public void testGetName() {
		assertEquals("TimeSqure", town.getName());
	}
	
	@Test
	public void testEquals() {
		Town town2= new Town("TimeSqure");
		assertTrue(town.equals(town2));
	}
	
	@Test
	public void testCompareTo() {
		Town town2 =new Town("Besti");
		assertTrue(town.compareTo(town2)>0);
	}
}
