package cur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicketJUnitTest {

    @Test
    void testChildOnWeekdayLowerLevel() {
        Ticket t = new Ticket(50.0, DayOfWeek.MONDAY, "child", 1, 2);
        assertEquals(81.0, t.getTotal(), 0.01); 
    }

    @Test
    void testTLevelDoublePriceNoDiscount() {
        Ticket t = new Ticket(50.0, DayOfWeek.SATURDAY, "adult", 2, 1);
        assertEquals(100.0, t.getTotal(), 0.01);
    }

    @Test
    void testSeniorUpperLevelFriday() {
        Ticket t = new Ticket(100.0, DayOfWeek.FRIDAY, "senior", 3, 1);
        assertEquals(85.5, t.getTotal(), 0.01); 
    }
}
