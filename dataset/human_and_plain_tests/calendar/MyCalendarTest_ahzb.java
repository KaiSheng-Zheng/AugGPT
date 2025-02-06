import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class MyCalendarTest_ahzb {
    private MyCalendar calendar;
    private MyDate date1;
    private MyDate date2;

    @BeforeEach
    public void setUp() {
        calendar = new MyCalendar(3); // Set capacity to 3
        date1 = new MyDate(2024, 9, 16); // Create a date for today
        date2 = new MyDate(2024, 9, 17); // Create a date for tomorrow
    }

    @Test
    public void testAddEventSuccessfully() {
        assertTrue(calendar.addEvent(date1, "Meeting"));
        assertTrue(calendar.addEvent(date2, "Conference"));
        assertEquals(2, calendar.event.size());
    }

    @Test
    public void testAddEventExceedsCapacity() {
        calendar.addEvent(date1, "Event 1");
        calendar.addEvent(date2, "Event 2");
        assertTrue(calendar.addEvent(new MyDate(2024, 9, 18), "Event 3")); // Should succeed
        assertFalse(calendar.addEvent(new MyDate(2024, 9, 19), "Event 4")); // Should fail
    }

    @Test
    public void testFinishNextEvent() {
        calendar.addEvent(date1, "Event 1");
        calendar.addEvent(date2, "Event 2");
        assertEquals("Event 1", calendar.finishNextEvent());
        assertEquals(1, calendar.event.size()); // Check that one event has been removed
        assertEquals("Event 2", calendar.finishNextEvent());
        assertEquals(0, calendar.event.size()); // Check that all events have been removed
        assertEquals("NONE", calendar.finishNextEvent()); // Check when there are no events
    }

    @Test
    public void testAddEventWithSorting() {
        calendar.addEvent(date2, "Event B");
        calendar.addEvent(date1, "Event A");
        calendar.addEvent(new MyDate(2024, 9, 18), "Event C");
        assertEquals("2024-09-16Event A", calendar.event.get(0));
        assertEquals("2024-09-17Event B", calendar.event.get(1));
        assertEquals("2024-09-18Event C", calendar.event.get(2));
    }

    @Test
    public void testMyDateToString() {
        MyDate myDate = new MyDate(2024, 9, 16);
        assertEquals("2024-09-16", myDate.toString());
    }

    @Test
    public void testMyDateAddDays() {
        MyDate myDate = new MyDate(2024, 9, 16);
        myDate.addDays(15);
        assertEquals("2024-10-01", myDate.toString()); // Check if the date is correctly incremented
    }

    //@Test
    public void testBoundaryDifference() {
        MyDate date1 = new MyDate(2024, 9, 16);
        MyDate date2 = new MyDate(2024, 10, 1);
        assertEquals(15, MyDate.difference(date1, date2));
    }

    //@Test
    public void testDifferenceWithNegativeResult() {
        MyDate date1 = new MyDate(2024, 10, 1);
        MyDate date2 = new MyDate(2024, 9, 16);
        assertEquals(-15, MyDate.difference(date1, date2));
    }
}
