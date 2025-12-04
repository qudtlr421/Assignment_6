package cur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArenaJUnitTest {
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena("Red", 200.0, 100.0);
    }

    @Test
    void testConstructorAndInitialValues() {
        assertEquals("Red", arena.getColor());
        assertEquals(200.0, arena.getLength(), 0.001);
        assertEquals(100.0, arena.getWidth(), 0.001);
        assertEquals("Arena", arena.getBuildingType());
    }

    @Test
    void testSetSize() {
        arena.setSize(300.0, 150.0);
        assertEquals(300.0, arena.getLength(), 0.001);
        assertEquals(150.0, arena.getWidth(), 0.001);
    }

    @Test
    void testSetColorAndBuildingType() {
        arena.setColor("Gold");
        arena.setBuildingType("Grand Arena");
        assertEquals("Gold", arena.getColor());
        assertEquals("Grand Arena", arena.getBuildingType());
    }

    @Test
    void testToString() {
        String str = arena.toString();
        assertTrue(str.contains("Red") && str.contains("200.0") && str.contains("Arena"));
    }
}