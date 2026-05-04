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
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class Graph_STUDENT_Test {
    private Graph graph;
    private Town t1, t2, t3;

    @Before
    public void setUp() {
    	graph= new Graph();
    	t1= new Town("Naru");
    	t2= new Town("jaki");
    	t3= new Town("Saunder");
    	
    	graph.addVertex(t1);
    	graph.addVertex(t2);
    	graph.addVertex(t3);
    	
    	graph.addEdge(t1, t2, 10, "Route A");
    	graph.addEdge(t2, t3, 5, "Route B");
    }

    @Test
    public void testShortestPath() {
    	ArrayList<String> path = graph.shortestPath(t1, t3);
    	assertNotNull(path);
    	assertEquals(2, path.size());
    	assertTrue(path.get(0).contains("Naru via Route A to jaki 10 mi"));
    }
    
}
