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

public class Road_STUDENT_Test{
	private Road road;
	private Town t1, t2;
	
	@Before
	public void setUp() {
		t1= new Town("Hat");
		t2= new Town("Seha");
		
		road= new Road(t1, t2, 50, "HighLine");
	}
	
	@Test
	public void testContains() {
		assertTrue(road.contains(t1));
		assertTrue(road.contains(t2));
		assertFalse(road.contains(new Town("torent")));
	}
	
	@Test
	public void testGetters() {
		assertEquals("HighLine", road.getName());
		assertEquals(50, road.getWeight());
	}
}
