import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class MyDateTest_q6pw {
    @Test
    public void testToString() {
        MyDate date = new MyDate(2024, 9, 16);
        assertEquals("2024-09-16", date.toString()); // Check the string representation
    }

    @Test
    public void testAddDays() {
        MyDate date = new MyDate(2024, 9, 16);
        date.addDays(10);
        assertEquals("2024-09-26", date.toString()); // Check if days are added correctly
    }

    @Test
    public void testAddDaysCrossingMonth() {
        MyDate date = new MyDate(2024, 9, 30);
        date.addDays(5);
        assertEquals("2024-10-05", date.toString()); // Check month change
    }

    //@Test
    public void testDifference() {
        MyDate date1 = new MyDate(2024, 9, 16);
        MyDate date2 = new MyDate(2024, 9, 20);
        assertEquals(4, MyDate.difference(date1, date2)); // Should return 4 days difference
    }

    //@Test
    public void testBoundaryDifference() {
        MyDate date1 = new MyDate(2024, 9, 16);
        MyDate date2 = new MyDate(2024, 10, 16);
        assertEquals(30, MyDate.difference(date1, date2)); // Should return 30 days difference
    }
}
