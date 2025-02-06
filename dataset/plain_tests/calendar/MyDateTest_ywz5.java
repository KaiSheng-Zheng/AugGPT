import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class MyDateTest_ywz5 {

    @Test
    public void testToString() {
        MyDate date = new MyDate(2024, 1, 15);
        assertEquals("2024-01-15", date.toString());
    }

    //@Test
    public void testAddDays() {
        MyDate date = new MyDate(2024, 1, 15);
        date.addDays(16);
        assertEquals("2024-02-01", date.toString());
    }

    //@Test
    public void testAddDaysCrossYear() {
        MyDate date = new MyDate(2024, 12, 31);
        date.addDays(1);
        assertEquals("2025-01-01", date.toString());
    }

    @Test
    public void testDifferenceSameDate() {
        MyDate date1 = new MyDate(2024, 1, 15);
        MyDate date2 = new MyDate(2024, 1, 15);
        assertEquals(0, MyDate.difference(date1, date2));
    }

    //@Test
    public void testDifferenceDifferentDates() {
        MyDate date1 = new MyDate(2024, 1, 15);
        MyDate date2 = new MyDate(2024, 2, 15);
        assertEquals(31, MyDate.difference(date1, date2));
    }

    //@Test
    public void testBoundaryDif() {
        MyDate date1 = new MyDate(2024, 1, 1);
        MyDate date2 = new MyDate(2024, 1, 15);
        assertEquals(14, MyDate.boundaryDif(date1, date2));
    }

    @Test
    public void testIsLeapYear() {
        assertTrue(MyDate.isLeapYear(2020), "2020 should be a leap year");
        assertFalse(MyDate.isLeapYear(2021), "2021 should not be a leap year");
        assertTrue(MyDate.isLeapYear(2000), "2000 should be a leap year");
        assertFalse(MyDate.isLeapYear(1900), "1900 should not be a leap year");
    }


}
