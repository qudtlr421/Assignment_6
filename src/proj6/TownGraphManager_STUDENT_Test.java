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

public class TownGraphManager_STUDENT_Test{
    private TownGraphManager manager;

    @Before
    public void setUp(){
        manager= new TownGraphManager();
        manager.addTown("Seoul");
        manager.addTown("Busan");
        manager.addTown("Incheon");
        manager.addRoad("Seoul","Busan",325,"Bada");
    }

    @Test
    public void testGetRoad(){
         assertEquals("Bada",manager.getRoad("Seoul","Busan"));
    }

    @Test
    public void testAllTowns(){
        assertTrue(manager.allTowns().contains("Seoul"));
        assertTrue(manager.allTowns().contains("Busan"));
        assertTrue(manager.allTowns().contains("Incheon"));
    }

    @Test
    public void testDeleteRoad(){
        assertTrue(manager.containsRoadConnection("Seoul","Busan"));
        
        manager.deleteRoadConnection("Seoul","Busan","Bada");
        
        assertFalse(manager.containsRoadConnection("Seoul","Busan"));
    }
}