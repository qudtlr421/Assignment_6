package cur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DogJUnitTest {

    @Test
    void testGetters() {
        Dog dog = new Dog("Rex", 5, "German Shepherd", "Black");
        assertEquals("Rex", dog.getName());
        assertEquals(5, dog.getAge());
    }

    @Test
    void testEqualsSameObject() {
        Dog d1 = new Dog("Buddy", 4, "Lab", "Yellow");
        Dog d2 = new Dog("Buddy", 4, "Lab", "Yellow");
        assertEquals(d1, d2);
    }
}


