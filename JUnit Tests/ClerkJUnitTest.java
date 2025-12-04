package cur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClerkJUnitTest {

    @Test
    public void testConstructorAndGetters() {
        Clerk clerk = new Clerk("Emma Jones", 40, 15, "Ticket Manager");
        assertEquals("Emma Jones", clerk.getName());
        assertEquals(40, clerk.getAge());
        assertEquals(15, clerk.getYearsWorked());
        assertEquals("Ticket Manager", clerk.getJob());
    }

    @Test
    public void testToString() {
        Clerk clerk = new Clerk("Mark Davis", 35, 8, "Office Clerk");
        String expected = "Name: Mark Davis\nAge: 35\nYears Worked: 8\nJob: Office Clerk";
        assertEquals(expected.trim(), clerk.toString().trim());
    }
}
