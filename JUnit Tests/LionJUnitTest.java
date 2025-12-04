package cur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LionJUnitTest {

    @Test
    void testGetters() {
        Lion lion = new Lion("Simba", 8, "African Lion", "Golden");
        assertEquals("Simba", lion.getName());
        assertEquals(8, lion.getAge());
    }

    @Test
    void testEquals() {
        Lion l1 = new Lion("Leo", 10, "Panthera leo", "Golden");
        Lion l2 = new Lion("Leo", 10, "Panthera leo", "Golden");
        assertEquals(l1, l2);
    }
}