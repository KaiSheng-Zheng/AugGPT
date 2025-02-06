import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class MyCalendarTest_s2hs {
    private MyCalendar myCalendar;

    @BeforeEach
    public void setUp() {
        myCalendar = new MyCalendar(5); // Set capacity to 5 for testing
    }

    @Test
    public void testAddEventWithinCapacity() {
        MyDate date = new MyDate(2024, 9, 16);
        assertTrue(myCalendar.addEvent(date, "Meeting"));
        assertTrue(myCalendar.addEvent(date, "Lunch"));
        assertTrue(myCalendar.addEvent(date, "Conference"));
        assertEquals(3, myCalendar.getEventsCount()); // Assume this method returns the count of events
    }

    @Test
    public void testAddEventExceedingCapacity() {
        MyDate date = new MyDate(2024, 9, 16);
        for (int i = 0; i < 5; i++) {
            myCalendar.addEvent(date, "Event " + i);
        }
        assertFalse(myCalendar.addEvent(date, "Overflow Event")); // Should return false
    }

    @Test
    public void testFinishNextEvent() {
        MyDate date1 = new MyDate(2024, 9, 16);
        MyDate date2 = new MyDate(2024, 9, 17);
        myCalendar.addEvent(date1, "First Event");
        myCalendar.addEvent(date2, "Second Event");

        String finishedEvent = myCalendar.finishNextEvent();
        assertEquals("First Event", finishedEvent); // Should finish the first event added
        assertEquals(1, myCalendar.getEventsCount()); // Only one event should remain
    }

    @Test
    public void testFinishNextEventWhenNoEvents() {
        assertEquals("NONE", myCalendar.finishNextEvent()); // Should return "NONE" when no events are present
    }
}
