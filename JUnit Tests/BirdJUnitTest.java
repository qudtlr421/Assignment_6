package cur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BirdJUnitTest {
    private Bird bird;

    @BeforeEach
    void setUp() {
        bird = new Bird("Tweety", 2, "Canary", "Yellow");
    }

    @Test
    void testGetNameAndAge() {
        assertEquals("Tweety", bird.getName());
        assertEquals(2, bird.getAge());
    }

    @Test
    void testEqualsWithSameAttributes() {
        Bird same = new Bird("Tweety", 2, "Canary", "Yellow");
        assertEquals(bird, same);
    }

    @Test
    void testNotEqualsDifferentName() {
        Bird diff = new Bird("Polly", 2, "Parrot", "Green");
        assertNotEquals(bird, diff);
    }
}