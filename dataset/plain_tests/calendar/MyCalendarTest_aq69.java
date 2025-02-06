import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class MyCalendarTest_aq69 {
    private MyCalendar calendar;
    private MyDate date1;
    private MyDate date2;

    @BeforeEach
    public void setUp() {
        calendar = new MyCalendar(3); // Capacity of 3 events
        date1 = new MyDate(2024, 1, 15);
        date2 = new MyDate(2024, 2, 10);
    }

    @Test
    public void testAddEventSuccessfully() {
        assertTrue(calendar.addEvent(date1, "Event1"));
        assertTrue(calendar.addEvent(date2, "Event2"));
    }

    @Test
    public void testAddEventExceedingCapacity() {
        calendar.addEvent(date1, "Event1");
        calendar.addEvent(date2, "Event2");
        calendar.addEvent(new MyDate(2024, 3, 5), "Event3");
        assertFalse(calendar.addEvent(new MyDate(2024, 4, 20), "Event4")); // Exceeds capacity
    }

    @Test
    public void testFinishNextEvent() {
        calendar.addEvent(date1, "Event1");
        calendar.addEvent(date2, "Event2");
        assertEquals("Event1", calendar.finishNextEvent());
        assertEquals("Event2", calendar.finishNextEvent());
    }

    @Test
    public void testFinishNextEventWhenEmpty() {
        assertEquals("NONE", calendar.finishNextEvent()); // No events to finish
    }

    //@Test
    public void testEventSorting() {
        calendar.addEvent(new MyDate(2024, 3, 5), "Event3");
        calendar.addEvent(new MyDate(2024, 1, 15), "Event1");
        calendar.addEvent(new MyDate(2024, 2, 10), "Event2");

        assertEquals("2024-01-15Event1", calendar.finishNextEvent());
        assertEquals("2024-02-10Event2", calendar.finishNextEvent());
        assertEquals("2024-03-05Event3", calendar.finishNextEvent());
    }
}

