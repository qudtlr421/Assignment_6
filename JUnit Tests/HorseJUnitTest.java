package cur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HorseJUnitTest {

    @Test
    void testGetters() {
        Horse horse = new Horse("Thunder", 7, "Arabian", "White");
        assertEquals("Thunder", horse.getName());
        assertEquals(7, horse.getAge());
    }

    @Test
    void testToStringContainsFields() {
        Horse horse = new Horse("Spirit", 6, "Mustang", "Brown");
        String output = horse.toString();
        assertTrue(output.contains("Spirit") && output.contains("Mustang"));
    }
}