package cur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayOfWeekTest {

    @Test
    void testAllEnumValuesHaveCorrectDiscounts() {
        assertEquals(0.10, DayOfWeek.MONDAY.getDiscount(), 0.0001);
        assertEquals(0.10, DayOfWeek.TUESDAY.getDiscount(), 0.0001);
        assertEquals(0.10, DayOfWeek.WEDNESDAY.getDiscount(), 0.0001);
        assertEquals(0.10, DayOfWeek.THURSDAY.getDiscount(), 0.0001);
        assertEquals(0.10, DayOfWeek.FRIDAY.getDiscount(), 0.0001);
        assertEquals(0.00, DayOfWeek.SATURDAY.getDiscount(), 0.0001);
        assertEquals(0.00, DayOfWeek.SUNDAY.getDiscount(), 0.0001);
    }

    @Test
    void testEnumValuesAreCorrectlyDefined() {
        DayOfWeek[] days = DayOfWeek.values();
        assertEquals(7, days.length);
        assertEquals(DayOfWeek.MONDAY, days[0]);
        assertEquals(DayOfWeek.TUESDAY, days[1]);
        assertEquals(DayOfWeek.WEDNESDAY, days[2]);
        assertEquals(DayOfWeek.THURSDAY, days[3]);
        assertEquals(DayOfWeek.FRIDAY, days[4]);
        assertEquals(DayOfWeek.SATURDAY, days[5]);
        assertEquals(DayOfWeek.SUNDAY, days[6]);
    }

    @Test
    void testValueOfReturnsCorrectEnum() {
        assertEquals(DayOfWeek.MONDAY, DayOfWeek.valueOf("MONDAY"));
        assertEquals(DayOfWeek.SATURDAY, DayOfWeek.valueOf("SATURDAY"));
        assertEquals(DayOfWeek.SUNDAY, DayOfWeek.valueOf("SUNDAY"));
    }

    @Test
    void testValueOfThrowsExceptionForInvalidName() {
        // These still correctly expect IllegalArgumentException for non-matching strings
        assertThrows(IllegalArgumentException.class, () -> {
            DayOfWeek.valueOf("Monday"); // lowercase
        });
        assertThrows(IllegalArgumentException.class, () -> {
            DayOfWeek.valueOf("FRIDAYY");
        });
        
        // FIX: The standard Java Enum.valueOf(null) throws NullPointerException.
        assertThrows(NullPointerException.class, () -> {
            DayOfWeek.valueOf(null); 
        });
    }

    @Test
    void testToStringReturnsDayName() {
        assertEquals("MONDAY", DayOfWeek.MONDAY.toString());
        assertEquals("FRIDAY", DayOfWeek.FRIDAY.toString());
        assertEquals("SUNDAY", DayOfWeek.SUNDAY.toString());
    }

    @Test
    void testGetDiscountReturnsExactStoredValue() {
        // Test that the private field is correctly assigned via constructor
        assertEquals(0.10, DayOfWeek.MONDAY.getDiscount());
        assertEquals(0.10, DayOfWeek.TUESDAY.getDiscount());
        assertEquals(0.00, DayOfWeek.SATURDAY.getDiscount());
    }

    @Test
    void testEnumConstantsAreImmutableAndUnique() {
        DayOfWeek monday1 = DayOfWeek.MONDAY;
        DayOfWeek monday2 = DayOfWeek.valueOf("MONDAY");
        assertSame(monday1, monday2); // Enums are singletons

        assertNotSame(DayOfWeek.MONDAY, DayOfWeek.TUESDAY);
    }

    @Test
    void testWeekdayHasDiscount_WeekendHasNoDiscount() {
        // Weekdays
        assertTrue(DayOfWeek.MONDAY.getDiscount() >  0);
        assertTrue(DayOfWeek.TUESDAY.getDiscount() > 0);
        assertTrue(DayOfWeek.WEDNESDAY.getDiscount() > 0);
        assertTrue(DayOfWeek.THURSDAY.getDiscount() > 0);
        assertTrue(DayOfWeek.FRIDAY.getDiscount() > 0);

        // Weekends
        assertEquals(0.0, DayOfWeek.SATURDAY.getDiscount(), 0.0001);
        assertEquals(0.0, DayOfWeek.SUNDAY.getDiscount(), 0.0001);
    }
}