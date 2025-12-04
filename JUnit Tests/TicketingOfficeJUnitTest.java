package cur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketingOfficeJUnitTest {
    private TicketingOffice office;

    @BeforeEach
    void setUp() {
        office = new TicketingOffice("White", 50.0, 30.0);
    }

    @Test
    void testConstructor() {
        assertEquals("White", office.getColor());
        assertEquals(50.0, office.getLength(), 0.001);
        assertEquals("Ticketing Office", office.getBuildingType());
    }

    @Test
    void testSetSize() {
        office.setSize(80.0, 40.0);
        assertEquals(80.0, office.getLength(), 0.001);
    }

    @Test
    void testSetColor() {
        office.setColor("Blue");
        assertEquals("Blue", office.getColor());
    }
}