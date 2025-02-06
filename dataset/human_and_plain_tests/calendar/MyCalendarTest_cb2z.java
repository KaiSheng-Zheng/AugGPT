import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class MyCalendarTest_cb2z {
    private MyCalendar calendar;
    private MyDate date;

    @BeforeEach
    void setUp() {
        calendar = new MyCalendar(3); // Set a capacity of 3 events
        date = new MyDate(2024, 9, 16); // Initialize a date
    }

    @Test
    void testAddEventWithinCapacity() {
        assertTrue(calendar.addEvent(date, "Meeting"));
        assertTrue(calendar.addEvent(date, "Lunch"));
        assertTrue(calendar.addEvent(date, "Workshop"));
        assertEquals(3, calendar.event.size());
    }

    @Test
    void testAddEventExceedingCapacity() {
        calendar.addEvent(date, "Meeting");
        calendar.addEvent(date, "Lunch");
        calendar.addEvent(date, "Workshop");
        assertFalse(calendar.addEvent(date, "Conference")); // Should return false as capacity is reached
    }

    @Test
    void testFinishNextEvent() {
        calendar.addEvent(date, "Meeting");
        calendar.addEvent(date, "Lunch");
        assertEquals("Lunch", calendar.finishNextEvent()); // Should return the next event
        assertEquals(1, calendar.event.size()); // One event should remain
    }

    @Test
    void testFinishNextEventWhenEmpty() {
        assertEquals("NONE", calendar.finishNextEvent()); // Should return "NONE" when no events are present
    }
}

