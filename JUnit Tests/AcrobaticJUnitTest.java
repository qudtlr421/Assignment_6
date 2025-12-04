package cur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AcrobaticJUnitTest {

    @Test
    public void testConstructorAndInheritedGetters() {
        Acrobatic acrobatic = new Acrobatic("Sky Walker", 28, 5, "Trapeze Artist");
        assertEquals("Sky Walker", acrobatic.getName());
        assertEquals(28, acrobatic.getAge());
        assertEquals(5, acrobatic.getYearsWorked());
        assertEquals("Trapeze Artist", acrobatic.getJob());
    }

    @Test
    public void testToString() {
        Acrobatic acrobatic = new Acrobatic("Luna Fire", 32, 10, "Fire Dancer");
        String expected = "Name: Luna Fire\nAge: 32\nYears Worked: 10\nJob: Fire Dancer";
        assertEquals(expected.trim(), acrobatic.toString().trim());
    }
}