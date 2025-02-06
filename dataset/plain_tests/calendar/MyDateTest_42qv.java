import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class MyDateTest_42qv {
    private MyDate date;

    @BeforeEach
    void setUp() {
        date = new MyDate(2024, 9, 16); // Initialize a date
    }

    @Test
    void testToString() {
        assertEquals("2024-09-16", date.toString()); // Test the string representation
    }

    @Test
    void testAddDays() {
        date.addDays(15);
        assertEquals("2024-10-01", date.toString()); // Adding 15 days should result in October 1st
    }

    //@Test
    void testAddDaysCrossingYear() {
        date.addDays(100);
        assertEquals("2025-01-25", date.toString()); // Adding 100 days should result in January 25th, 2025
    }

    @Test
    void testDifferenceSameDate() {
        MyDate date2 = new MyDate(2024, 9, 16);
        assertEquals(0, MyDate.difference(date, date2)); // Difference should be 0 for the same date
    }

    //@Test
    void testDifferenceDifferentDates() {
        MyDate date2 = new MyDate(2024, 9, 30);
        assertEquals(14, MyDate.difference(date, date2)); // Difference should be 14 days
    }

    //@Test
    void testBoundaryDif() {
        MyDate boundary = new MyDate(2020, 1, 1);
        assertEquals(1645, MyDate.boundaryDif(boundary, date)); // Test the boundary difference
    }
}
