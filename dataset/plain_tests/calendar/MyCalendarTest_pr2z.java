import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class MyCalendarTest_pr2z {
    private MyCalendar myCalendar;
    private MyDate date1;
    private MyDate date2;

    @BeforeEach
    public void setUp() {
        myCalendar = new MyCalendar(3); // Set capacity to 3 for testing
        date1 = new MyDate(2024, 9, 16);
        date2 = new MyDate(2024, 9, 17);
    }

    @Test
    public void testAddEventSuccessfully() {
        assertTrue(myCalendar.addEvent(date1, "Event1"));
        assertTrue(myCalendar.addEvent(date2, "Event2"));
        assertTrue(myCalendar.addEvent(new MyDate(2024, 9, 18), "Event3"));
    }

    @Test
    public void testAddEventWhenCapacityReached() {
        myCalendar.addEvent(date1, "Event1");
        myCalendar.addEvent(date2, "Event2");
        myCalendar.addEvent(new MyDate(2024, 9, 18), "Event3");
        assertFalse(myCalendar.addEvent(new MyDate(2024, 9, 19), "Event4")); // Should return false
    }

    @Test
    public void testFinishNextEvent() {
        myCalendar.addEvent(date1, "Event1");
        myCalendar.addEvent(date2, "Event2");
        assertEquals("Event1", myCalendar.finishNextEvent()); // Should return Event1
        assertEquals("Event2", myCalendar.finishNextEvent()); // Should return Event2
    }

    @Test
    public void testFinishNextEventWhenNoEvents() {
        assertEquals("NONE", myCalendar.finishNextEvent()); // Should return NONE
    }

    @Test
    public void testDateToString() {
        MyDate myDate = new MyDate(2024, 9, 16);
        assertEquals("2024-09-16", myDate.toString());
    }

    @Test
    public void testAddDays() {
        MyDate myDate = new MyDate(2024, 9, 16);
        myDate.addDays(5); // Adding 5 days
        assertEquals("2024-09-21", myDate.toString()); // Should return 2024-09-21
    }

    //@Test
    public void testBoundaryDifference() {
        MyDate myDate1 = new MyDate(2024, 1, 1);
        MyDate myDate2 = new MyDate(2024, 1, 31);
        assertEquals(30, MyDate.difference(myDate1, myDate2)); // Should return 30 days difference
    }

    @Test
    public void testDifferenceSameDate() {
        MyDate myDate1 = new MyDate(2024, 9, 16);
        MyDate myDate2 = new MyDate(2024, 9, 16);
        assertEquals(0, MyDate.difference(myDate1, myDate2)); // Should return 0 days difference
    }

    //@Test
    public void testDifferenceLeapYear() {
        MyDate myDate1 = new MyDate(2024, 2, 29); // Leap year date
        MyDate myDate2 = new MyDate(2025, 2, 28); // Non-leap year date
        assertEquals(364, MyDate.difference(myDate1, myDate2)); // Should return 364 days difference
    }
}
