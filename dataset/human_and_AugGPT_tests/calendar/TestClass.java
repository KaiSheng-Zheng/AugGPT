import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestClass {
    @Test
    public void testAddEventAndFinishNextEvent_u6kl() throws Exception {
        // Create a MyCalendar instance with a capacity of 3
        MyCalendar calendar = new MyCalendar(3);

        // Add an event on a specific date
        MyDate date1 = new MyDate(2024, 2, 9);
        boolean eventAdded = calendar.addEvent(date1, "meeting");
        Assertions.assertTrue(eventAdded, "Event should be added successfully.");

        // Add another event on the same date
        boolean secondEventAdded = calendar.addEvent(date1, "laundry");
        Assertions.assertTrue(secondEventAdded, "Second event should be added successfully.");

        // Add another event on a different date
        MyDate date2 = new MyDate(2024, 2, 10);
        boolean thirdEventAdded = calendar.addEvent(date2, "grocery");
        Assertions.assertTrue(thirdEventAdded, "Third event should be added successfully.");

        // Attempt to add a fourth event, exceeding capacity
        boolean fourthEventAdded = calendar.addEvent(date2, "dinner");
        Assertions.assertFalse(fourthEventAdded, "Event should not be added, capacity exceeded.");

        // Finish the next event
        String finishedEvent = calendar.finishNextEvent();
        Assertions.assertEquals("laundry", finishedEvent, "Next event should be 'laundry'.");

        // Finish another event
        String nextFinishedEvent = calendar.finishNextEvent();
        Assertions.assertEquals("meeting", nextFinishedEvent, "Next event should be 'meeting'.");

        // Finish the last event
        String lastFinishedEvent = calendar.finishNextEvent();
        Assertions.assertEquals("grocery", lastFinishedEvent, "Next event should be 'grocery'.");

        // Attempt to finish another event when none are left
        String noMoreEvents = calendar.finishNextEvent();
        Assertions.assertEquals("NONE", noMoreEvents, "Should return 'NONE' when no events are left.");
    }

    @Test
    public void testDateManipulationAndDifference_pzzs() throws Exception {
        // Create MyDate instances
        MyDate date1 = new MyDate(2024, 2, 1);
        MyDate date2 = new MyDate(2024, 2, 10);

        // Add days to date1
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(date1, 9);

        // Check the string representation after adding days
        String date1String = date1.toString();
        Assertions.assertEquals("2024-02-10", date1String, "Date should be updated to '2024-02-10'.");

        // Calculate the difference between date1 and date2
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        Assertions.assertEquals(0, difference, "The difference should be 0, as both dates are now the same.");
    }

    @Test
    public void testAddMultipleEventsAndCheckCapacity_xgt9() throws Exception {
        // Create a MyCalendar instance with a capacity of 2
        MyCalendar calendar = new MyCalendar(2);

        // Add two events successfully
        MyDate date1 = new MyDate(2024, 2, 9);
        boolean firstEvent = calendar.addEvent(date1, "event1");
        Assertions.assertTrue(firstEvent, "First event should be added successfully.");

        boolean secondEvent = calendar.addEvent(date1, "event2");
        Assertions.assertTrue(secondEvent, "Second event should be added successfully.");

        // Try to add a third event, which should fail
        boolean thirdEvent = calendar.addEvent(date1, "event3");
        Assertions.assertFalse(thirdEvent, "Adding a third event should fail due to capacity.");

        // Finish all events and ensure correct order
        String finishedFirst = calendar.finishNextEvent();
        Assertions.assertEquals("event1", finishedFirst, "First finished event should be 'event1'.");

        String finishedSecond = calendar.finishNextEvent();
        Assertions.assertEquals("event2", finishedSecond, "Second finished event should be 'event2'.");

        // Check that no events are left
        String noEventsLeft = calendar.finishNextEvent();
        Assertions.assertEquals("NONE", noEventsLeft, "Should return 'NONE' when no events are left.");
    }

    //@Test
    public void testDateDifferenceEdgeCases_kb09() throws Exception {
        // Create MyDate instances for edge case testing
        MyDate leapYearDate = new MyDate(2024, 2, 29); // Leap year date
        MyDate nonLeapYearDate = new MyDate(2023, 2, 28); // Non-leap year date

        // Calculate the difference
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        int difference = (int) differenceMethod.invoke(null, nonLeapYearDate, leapYearDate);

        // Assert the difference
        Assertions.assertEquals(-1, difference, "The difference should be negative, as non-leap year date is earlier.");
    }

    //@Test
    public void testAddDaysAndDifference_wew8() throws Exception {
        // Create two MyDate objects
        MyDate date1 = new MyDate(2024, 2, 1); // Initial date
        MyDate date2 = new MyDate(2024, 3, 1); // Target date

        // Use reflection to access the private addDays method and add 28 days to date1
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(date1, 28);

        // Now date1 should be 2024-02-29 (leap year)
        // Check the difference between date1 and date2
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        int diff = (int) differenceMethod.invoke(null, date1, date2);

        // The difference should be 0, as they are the same date now
        Assertions.assertEquals(0, diff);
    }

    //@Test
    public void testToStringAndAddDays_utje() throws Exception {
        // Create a MyDate object
        MyDate date = new MyDate(2024, 2, 28); // Initial date

        // Add 1 day, should roll over to March
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(date, 1);

        // Check the string representation
        Method toStringMethod = MyDate.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        String dateString = (String) toStringMethod.invoke(date);

        // The expected string should be "2024-03-01"
        Assertions.assertEquals("2024-03-01", dateString);
    }

    //@Test
    public void testFinishNextEventOrder_rdoz() throws Exception {
        // Create a MyCalendar with a capacity of 5
        MyCalendar calendar = new MyCalendar(5);
        
        // Add multiple events
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "laundry"));
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "meeting"));
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 2), "grocery shopping"));
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 3), "exercise"));

        // Call finishNextEvent multiple times and check the order
        Assertions.assertEquals("grocery shopping", calendar.finishNextEvent()); // Should return the earliest
        Assertions.assertEquals("laundry", calendar.finishNextEvent()); // Next in order
        Assertions.assertEquals("meeting", calendar.finishNextEvent()); // Next in order
        Assertions.assertEquals("exercise", calendar.finishNextEvent()); // Last event
        Assertions.assertEquals("NONE", calendar.finishNextEvent()); // No more events
    }

    @Test
    public void testCapacityLimit_59j3() throws Exception {
        // Create a MyCalendar with a capacity of 2
        MyCalendar calendar = new MyCalendar(2);
        
        // Add two events successfully
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "event1"));
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 2), "event2"));
        
        // Try to add a third event, which should fail
        Assertions.assertFalse(calendar.addEvent(new MyDate(2024, 2, 3), "event3"));
    }

    @Test
    public void testAddDaysAndToString_c1nw() throws Exception {
        // Create a MyDate object for the date 2024-02-01
        MyDate date = new MyDate(2024, 2, 1);
        
        // Add 28 days to reach 2024-02-29 (Leap year)
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(date, 28);
        
        // Assert that the date now is 2024-02-29
        Method toStringMethod = MyDate.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        String formattedDate = (String) toStringMethod.invoke(date);
        
        Assertions.assertEquals("2024-02-29", formattedDate);
    }

    //@Test
    public void testDifferenceMethod_zm90() throws Exception {
        // Create two MyDate objects
        MyDate date1 = new MyDate(2024, 2, 29);
        MyDate date2 = new MyDate(2024, 3, 1);
        
        // Calculate the difference in days
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        
        // Assert that the difference is 1 day
        Assertions.assertEquals(1, difference);
    }

    //@Test
    public void testFinishNextEventWithMultipleEvents_8nrd() throws Exception {
        // Create a MyCalendar object with capacity of 3
        MyCalendar calendar = new MyCalendar(3);
        
        // Add multiple events on the same date
        Field eventsField = MyCalendar.class.getDeclaredField("events");
        eventsField.setAccessible(true);
        List<String> events = (List<String>) eventsField.get(calendar);
        events.add("laundry");
        events.add("meeting");
        events.add("grocery shopping");
        
        // Call finishNextEvent and assert the returned values
        String firstEvent = calendar.finishNextEvent(); // Should return "grocery shopping"
        String secondEvent = calendar.finishNextEvent(); // Should return "laundry"
        String thirdEvent = calendar.finishNextEvent(); // Should return "meeting"
        String fourthEvent = calendar.finishNextEvent(); // Should return "NONE"
        
        Assertions.assertEquals("grocery shopping", firstEvent);
        Assertions.assertEquals("laundry", secondEvent);
        Assertions.assertEquals("meeting", thirdEvent);
        Assertions.assertEquals("NONE", fourthEvent);
    }

    @Test
    public void testAddEventAndExceedCapacity_71kb() throws Exception {
        // Create a MyCalendar object with capacity of 2
        MyCalendar calendar = new MyCalendar(2);
        
        // Add two events
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 29), "event1"));
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 29), "event2"));
        
        // Try to add a third event and assert it returns false (exceeds capacity)
        Assertions.assertFalse(calendar.addEvent(new MyDate(2024, 2, 29), "event3"));
    }

    @Test
    public void testAddDaysAndDifference_6jy3() throws Exception {
        // Create two MyDate instances to test the addDays and difference methods.
        MyDate date1 = new MyDate(2024, 2, 9);
        MyDate date2 = new MyDate(2024, 2, 20);
        
        // Add days to date1 and check if the difference is as expected.
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(date1, 11); // Add 11 days to date1
        
        // Access the difference method and calculate the difference.
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        int difference = (int) differenceMethod.invoke(null, date1, date2); // Static method call
        
        // The expected difference should be 0 as date1 is now 2024-02-20
        Assertions.assertEquals(0, difference, "The difference should be 0 after adding days.");
    }

    @Test
    public void testFinishNextEventAndCapacity_wx81() throws Exception {
        // Create a MyCalendar instance with a capacity of 3.
        MyCalendar calendar = new MyCalendar(3);
        
        // Add multiple events to the calendar.
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 9), "laundry"), "Should add the first event.");
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 9), "meeting"), "Should add the second event.");
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 10), "grocery"), "Should add the third event.");
        
        // Try adding a fourth event, which should fail due to capacity.
        Assertions.assertFalse(calendar.addEvent(new MyDate(2024, 2, 11), "study"), "Should not add the fourth event due to capacity.");
        
        // Finish the next event and check the order.
        Assertions.assertEquals("laundry", calendar.finishNextEvent(), "Should finish 'laundry' first.");
        Assertions.assertEquals("meeting", calendar.finishNextEvent(), "Should finish 'meeting' next.");
        Assertions.assertEquals("grocery", calendar.finishNextEvent(), "Should finish 'grocery' last.");
        Assertions.assertEquals("NONE", calendar.finishNextEvent(), "Should return 'NONE' after all events are finished.");
    }

    @Test
    public void testBoundaryYearLogic_o2v0() throws Exception {
        // Create MyDate instances to test year boundary logic.
        MyDate date1 = new MyDate(2000, 2, 29); // Leap year
        MyDate date2 = new MyDate(1900, 2, 28); // Not a leap year
        
        // Check if the difference is correctly calculated across century boundaries.
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        
        // The expected difference should be 36525 (including leap years).
        Assertions.assertEquals(36525, difference, "The difference should correctly account for leap years.");
    }

    //@Test
    public void testAddDaysAndLeapYear_74vk() throws Exception {
        // Create a MyDate instance for testing leap year addition.
        MyDate date = new MyDate(2024, 2, 28); // 2024 is a leap year
        
        // Add 1 day to check if it correctly moves to March.
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(date, 1); // Add 1 day
        
        // Check if the date has moved to March 1st.
        Field dayField = MyDate.class.getDeclaredField("day");
        dayField.setAccessible(true);
        int day = (int) dayField.get(date);
        Assertions.assertEquals(1, day, "The day should be March 1st after adding one day to February 29th.");
        
        // Check if the month has updated correctly.
        Field monthField = MyDate.class.getDeclaredField("month");
        monthField.setAccessible(true);
        int month = (int) monthField.get(date);
        Assertions.assertEquals(3, month, "The month should be March after adding one day.");
    }

    @Test
    public void testAddDaysAndToString_zzs4() throws Exception {
        // Create an instance of MyDate with a specific date
        MyDate date = new MyDate(2024, 2, 28);
        
        // Add days to the date, which will trigger the logic for month and year rollover
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(date, 3); // Add 3 days to February 28, 2024
        
        // Verify the date after adding days, it should be 2024-03-02
        Method toStringMethod = MyDate.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        String result = (String) toStringMethod.invoke(date);
        
        assertEquals("2024-03-02", result, "The date should be correctly incremented to 2024-03-02.");
    }

    //@Test
    public void testDifferenceBetweenDates_szbq() throws Exception {
        // Create two MyDate instances for comparison
        MyDate date1 = new MyDate(2024, 1, 1);
        MyDate date2 = new MyDate(2024, 1, 31);
        
        // Calculate the difference between the two dates
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        
        // Verify that the difference is correct
        assertEquals(30, difference, "The difference between January 1 and January 31 should be 30 days.");
    }

    @Test
    public void testFinishNextEventAndAddEvent_io8y() throws Exception {
        // Create a MyCalendar instance with a capacity of 5
        MyCalendar calendar = new MyCalendar(5);
        
        // Add multiple events to the calendar
        Method addEventMethod = MyCalendar.class.getDeclaredMethod("addEvent", MyDate.class, String.class);
        addEventMethod.setAccessible(true);
        
        // Adding events
        MyDate eventDate1 = new MyDate(2024, 2, 10);
        MyDate eventDate2 = new MyDate(2024, 2, 10);
        MyDate eventDate3 = new MyDate(2024, 2, 11);
        
        addEventMethod.invoke(calendar, eventDate1, "laundry");
        addEventMethod.invoke(calendar, eventDate2, "meeting");
        addEventMethod.invoke(calendar, eventDate3, "grocery shopping");
        
        // Call finishNextEvent to get the first event, which should be "laundry"
        Method finishNextEventMethod = MyCalendar.class.getDeclaredMethod("finishNextEvent");
        finishNextEventMethod.setAccessible(true);
        String firstEvent = (String) finishNextEventMethod.invoke(calendar);
        
        assertEquals("laundry", firstEvent, "The first event should be 'laundry' due to chronological order.");
        
        // Call finishNextEvent again to get the second event
        String secondEvent = (String) finishNextEventMethod.invoke(calendar);
        assertEquals("meeting", secondEvent, "The second event should be 'meeting'.");
    }

    @Test
    public void testAddEventExceedCapacity_z083() throws Exception {
        // Create a MyCalendar instance with a capacity of 2
        MyCalendar calendar = new MyCalendar(2);
        
        // Add two events to the calendar
        Method addEventMethod = MyCalendar.class.getDeclaredMethod("addEvent", MyDate.class, String.class);
        addEventMethod.setAccessible(true);
        
        MyDate eventDate1 = new MyDate(2024, 2, 10);
        MyDate eventDate2 = new MyDate(2024, 2, 11);
        
        assertTrue((boolean) addEventMethod.invoke(calendar, eventDate1, "event1"), "Should add event1 successfully.");
        assertTrue((boolean) addEventMethod.invoke(calendar, eventDate2, "event2"), "Should add event2 successfully.");
        
        // Try to add a third event which should exceed capacity
        MyDate eventDate3 = new MyDate(2024, 2, 12);
        boolean result = (boolean) addEventMethod.invoke(calendar, eventDate3, "event3");
        
        assertFalse(result, "Should not be able to add event3 due to capacity limit.");
    }

    //@Test
    public void testAddDaysAndDifference_e3j3() throws Exception {
        // Create a MyDate instance for the date 2024-02-01
        MyDate date1 = new MyDate(2024, 2, 1);
        // Add 30 days to date1, which should result in 2024-03-02
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(date1, 30);
        
        // Create another MyDate instance for 2024-03-01
        MyDate date2 = new MyDate(2024, 3, 1);
        
        // Calculate the difference between the two dates
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        
        // The difference should be -1 since date1 is 2024-03-02 and date2 is 2024-03-01
        Assertions.assertEquals(-1, difference);
    }

    @Test
    public void testAddEventAndFinishNextEvent_3mbe() throws Exception {
        // Create a MyCalendar with a capacity of 3
        MyCalendar calendar = new MyCalendar(3);
        
        // Add events to the calendar
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "laundry"));
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "meeting"));
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 2), "doctor appointment"));
        
        // Try to add another event, which should fail due to capacity
        Assertions.assertFalse(calendar.addEvent(new MyDate(2024, 2, 3), "grocery shopping"));
        
        // Finish the next event, which should return "laundry"
        String nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("laundry", nextEvent);
        
        // Finish the next event, which should return "meeting"
        nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("meeting", nextEvent);
        
        // Finish the next event, which should return "doctor appointment"
        nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("doctor appointment", nextEvent);
        
        // Now all events are finished, so it should return "NONE"
        nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("NONE", nextEvent);
    }

    //@Test
    public void testBoundaryDateDifference_zipa() throws Exception {
        // Create MyDate instances for testing boundary conditions
        MyDate date1 = new MyDate(2024, 2, 29); // Leap year
        MyDate date2 = new MyDate(2024, 3, 1);  // The day after
        
        // Calculate the difference
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        
        // The difference should be 1 since 2024-02-29 is followed by 2024-03-01
        Assertions.assertEquals(1, difference);
    }

    //@Test
    public void testLeapYearHandlingInDifference_d11h() throws Exception {
        // Create MyDate instances to test leap year
        MyDate date1 = new MyDate(2020, 2, 28); // Non-leap year date
        MyDate date2 = new MyDate(2020, 3, 1);  // The day after
        
        // Calculate the difference
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        
        // The difference should be 2 since 2020-02-28 is followed by 2020-02-29 and then 2020-03-01
        Assertions.assertEquals(2, difference);
    }

    @Test
    public void testMyDateAddDaysAndToString_voth() throws Exception {
        // Create an instance of MyDate for testing
        MyDate myDate = new MyDate(2024, 2, 28);
        
        // Use reflection to call the private method 'addDays'
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        
        // Add 1 day to February 28, 2024 (Leap Year)
        addDaysMethod.invoke(myDate, 1);
        
        // Check the result of the toString method to ensure date is now 2024-02-29
        String result = myDate.toString();
        Assertions.assertEquals("2024-02-29", result, "Date should be 2024-02-29 after adding 1 day to 2024-02-28");
        
        // Add 1 more day to check for month change
        addDaysMethod.invoke(myDate, 1);
        result = myDate.toString();
        Assertions.assertEquals("2024-03-01", result, "Date should be 2024-03-01 after adding another day");
    }

    //@Test
    public void testMyDateDifference_uv94() throws Exception {
        // Create two MyDate instances for comparison
        MyDate date1 = new MyDate(2024, 2, 28);
        MyDate date2 = new MyDate(2024, 3, 1);
        
        // Call the static method 'difference' using reflection
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        
        // Calculate the difference between the two dates
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        
        // Assert that the difference is 2 days (from 28th to 1st)
        Assertions.assertEquals(2, difference, "Difference should be 2 days from 2024-02-28 to 2024-03-01");
    }

    @Test
    public void testMyCalendarAddEventAndFinishNextEvent_jf9s() throws Exception {
        // Create a MyCalendar instance with a capacity of 3
        MyCalendar myCalendar = new MyCalendar(3);
        
        // Add events to the calendar
        Assertions.assertTrue(myCalendar.addEvent(new MyDate(2024, 2, 28), "meeting"), "Should be able to add 'meeting'");
        Assertions.assertTrue(myCalendar.addEvent(new MyDate(2024, 2, 28), "laundry"), "Should be able to add 'laundry'");
        Assertions.assertTrue(myCalendar.addEvent(new MyDate(2024, 3, 1), "grocery"), "Should be able to add 'grocery'");
        
        // Try to add one more event exceeding capacity
        Assertions.assertFalse(myCalendar.addEvent(new MyDate(2024, 3, 1), "study"), "Should not be able to add 'study' as it exceeds capacity");
        
        // Finish the next event and check if it returns 'laundry' (alphabetical order)
        String nextEvent = myCalendar.finishNextEvent();
        Assertions.assertEquals("laundry", nextEvent, "Next event should be 'laundry'");
        
        // Finish another event
        nextEvent = myCalendar.finishNextEvent();
        Assertions.assertEquals("meeting", nextEvent, "Next event should be 'meeting'");
        
        // Finish the last event
        nextEvent = myCalendar.finishNextEvent();
        Assertions.assertEquals("grocery", nextEvent, "Next event should be 'grocery'");
        
        // Attempt to finish another event should return "NONE"
        nextEvent = myCalendar.finishNextEvent();
        Assertions.assertEquals("NONE", nextEvent, "No more events should return 'NONE'");
    }

    @Test
    public void testMyDateGetDaysOfMonth_v4xw() throws Exception {
        // Create an instance of MyDate to test month days
        MyDate myDate = new MyDate(2024, 2, 1);

        // Use reflection to access the private method 'getDaysOfMonth'
        Method getDaysOfMonthMethod = MyDate.class.getDeclaredMethod("getDaysOfMonth", int.class, int.class);
        getDaysOfMonthMethod.setAccessible(true);

        // Check the days in February of a leap year
        int daysInFebruary = (int) getDaysOfMonthMethod.invoke(null, 2, 2024);
        Assertions.assertEquals(29, daysInFebruary, "February 2024 should have 29 days");

        // Check the days in April
        int daysInApril = (int) getDaysOfMonthMethod.invoke(null, 4, 2024);
        Assertions.assertEquals(30, daysInApril, "April should have 30 days");

        // Check the days in January
        int daysInJanuary = (int) getDaysOfMonthMethod.invoke(null, 1, 2024);
        Assertions.assertEquals(31, daysInJanuary, "January should have 31 days");
    }

    @Test
    public void testAddDaysAndDifference_iy7f() throws Exception {
        // Create a MyDate object representing January 31, 2024
        MyDate date1 = new MyDate(2024, 1, 31);
        // Add 29 days to reach February 29, 2024 (leap year)
        date1.addDays(29);

        // Create another MyDate object for February 29, 2024
        MyDate date2 = new MyDate(2024, 2, 29);
        // Calculate the difference, should be 0 after adding 29 days
        int difference = (int) invokeDifference_85fb(date1, date2);
        
        // The difference should be 0 since both dates are now the same
        Assertions.assertEquals(0, difference);
    }

    @Test
    public void testAddEventAndFinishNextEvent_03pv() throws Exception {
        // Create a MyCalendar with capacity of 3 events
        MyCalendar calendar = new MyCalendar(3);
        
        // Add three events to the calendar
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "meeting"));
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "laundry"));
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 2), "doctor"));

        // Attempt to add a fourth event, should fail due to capacity
        Assertions.assertFalse(calendar.addEvent(new MyDate(2024, 2, 3), "gym"));

        // Finish the next event and assert it returns "laundry"
        Assertions.assertEquals("laundry", calendar.finishNextEvent());
        // Finish another event and assert it returns "meeting"
        Assertions.assertEquals("meeting", calendar.finishNextEvent());
        // Finish the last event and assert it returns "doctor"
        Assertions.assertEquals("doctor", calendar.finishNextEvent());
        // All events finished, should return "NONE"
        Assertions.assertEquals("NONE", calendar.finishNextEvent());
    }

    //@Test
    public void testLeapYearDifference_bioo() throws Exception {
        // Create two MyDate objects: one for Feb 28, 2024 and one for Mar 1, 2024
        MyDate date1 = new MyDate(2024, 2, 28);
        MyDate date2 = new MyDate(2024, 3, 1);

        // Calculate the difference, should be 2 days (28th to 29th to 1st)
        int difference = (int) invokeDifference_85fb(date1, date2);

        // The difference should be 2 days
        Assertions.assertEquals(2, difference);
    }

    @Test
    public void testAddDaysAcrossMonths_wmx2() throws Exception {
        // Create a MyDate object representing December 31, 2023
        MyDate date = new MyDate(2023, 12, 31);
        // Add 31 days to reach January 31, 2024
        date.addDays(31);
        
        // Check if the date is now January 31, 2024
        Assertions.assertEquals("2024-01-31", date.toString());
    }

    // Reflection methods to invoke private methods
    private Object invokeDifference_85fb(MyDate date1, MyDate date2) throws Exception {
        Method method = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        method.setAccessible(true);
        return method.invoke(null, date1, date2);
    }

    //@Test
    public void testAddDaysAndToString_m7vc() throws Exception {
        // Create a MyDate object for the initial date
        MyDate date = new MyDate(2024, 2, 28);
        
        // Use reflection to access the private method isLeapYear to test it
        Method isLeapYearMethod = MyDate.class.getDeclaredMethod("isLeapYear", int.class);
        isLeapYearMethod.setAccessible(true);
        
        // Assert the leap year status for 2024
        boolean isLeapYear = (boolean) isLeapYearMethod.invoke(null, 2024);
        Assertions.assertTrue(isLeapYear, "2024 should be a leap year.");
        
        // Add 1 day to the date (should roll over to March)
        date.addDays(1);
        
        // Assert the date after adding 1 day
        String expectedDateString = "2024-03-01";
        Assertions.assertEquals(expectedDateString, date.toString(), "Date should be 2024-03-01 after adding 1 day.");
        
        // Add 1 more day to check end of February for a leap year
        date.addDays(1);
        expectedDateString = "2024-03-02";
        Assertions.assertEquals(expectedDateString, date.toString(), "Date should be 2024-03-02 after adding another day.");
    }

    //@Test
    public void testDifference_8l8l() throws Exception {
        // Create two MyDate objects
        MyDate date1 = new MyDate(2024, 2, 28);
        MyDate date2 = new MyDate(2024, 3, 1);
        
        // Call the static method difference using reflection
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        
        // Calculate the difference between the two dates
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        
        // Assert the difference in days
        Assertions.assertEquals(1, difference, "The difference between 2024-02-28 and 2024-03-01 should be 1 day.");
        
        // Check difference when dates are the same
        MyDate date3 = new MyDate(2024, 3, 1);
        difference = (int) differenceMethod.invoke(null, date2, date3);
        Assertions.assertEquals(0, difference, "The difference between the same dates should be 0.");
    }

    @Test
    public void testAddEventAndFinishNextEvent_mg6j() throws Exception {
        // Create a MyCalendar object with a capacity of 3
        MyCalendar calendar = new MyCalendar(3);
        
        // Add events to the calendar
        boolean event1Added = calendar.addEvent(new MyDate(2024, 3, 1), "Meeting");
        boolean event2Added = calendar.addEvent(new MyDate(2024, 3, 1), "Laundry");
        boolean event3Added = calendar.addEvent(new MyDate(2024, 3, 2), "Grocery");
        boolean event4Added = calendar.addEvent(new MyDate(2024, 3, 3), "Gym"); // Should not be added due to capacity
        
        // Assert the events added successfully
        Assertions.assertTrue(event1Added, "First event should be added successfully.");
        Assertions.assertTrue(event2Added, "Second event should be added successfully.");
        Assertions.assertTrue(event3Added, "Third event should be added successfully.");
        Assertions.assertFalse(event4Added, "Fourth event should not be added due to capacity.");
        
        // Finish the next event
        String nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("Laundry", nextEvent, "Next event should be 'Laundry' due to alphabetical order.");
        
        // Finish another event
        nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("Meeting", nextEvent, "Next event should be 'Meeting' after 'Laundry'.");
        
        // Finish the last event
        nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("Grocery", nextEvent, "Next event should be 'Grocery' after 'Meeting'.");
        
        // No more events should return "NONE"
        nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("NONE", nextEvent, "All events finished, should return 'NONE'.");
    }

    @Test
    public void testAddDaysBoundaryConditions_8yel() throws Exception {
        // Create a MyDate object for the boundary date
        MyDate date = new MyDate(2024, 12, 31);
        
        // Add 1 day (should roll over to next year)
        date.addDays(1);
        
        // Assert the date after adding 1 day
        String expectedDateString = "2025-01-01";
        Assertions.assertEquals(expectedDateString, date.toString(), "Date should be 2025-01-01 after adding 1 day.");
        
        // Add days to leap year boundary
        date = new MyDate(2024, 2, 29); // Leap year date
        date.addDays(1);
        expectedDateString = "2024-03-01";
        Assertions.assertEquals(expectedDateString, date.toString(), "Date should be 2024-03-01 after adding 1 day from leap day.");
        
        // Add more days across months
        date.addDays(30); // Adding 30 days
        expectedDateString = "2024-03-31";
        Assertions.assertEquals(expectedDateString, date.toString(), "Date should be 2024-03-31 after adding 30 days from March 1.");
    }

    @Test
    public void testAddDaysAndDifference_gmq4() throws Exception {
        // Creating two MyDate instances to test the addDays and difference methods.
        MyDate date1 = new MyDate(2024, 2, 1);
        MyDate date2 = new MyDate(2024, 2, 28);
        
        // Adding days to date1 to test if it can reach date2.
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(date1, 27); // Adding 27 days to date1
        
        // Now date1 should be 2024-02-28, let's check the difference.
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        
        // The difference should be 0 after adding days
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        Assertions.assertEquals(0, difference, "The difference should be 0 after adding days.");
    }

    @Test
    public void testAddEventAndFinishNextEvent_kigx() throws Exception {
        // Creating a MyCalendar instance with a capacity of 3 events.
        MyCalendar calendar = new MyCalendar(3);
        
        // Adding events to the calendar.
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 10), "laundry"), "Should add the event.");
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 10), "meeting"), "Should add the event.");
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 11), "dinner"), "Should add the event.");
        
        // Now we finish the next event which should be "laundry".
        String nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("laundry", nextEvent, "The next event should be 'laundry'.");
        
        // Finishing the next event which should be "meeting".
        nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("meeting", nextEvent, "The next event should be 'meeting'.");

        // Finishing the next event which should be "dinner".
        nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("dinner", nextEvent, "The next event should be 'dinner'.");

        // No more events should return "NONE".
        nextEvent = calendar.finishNextEvent();
        Assertions.assertEquals("NONE", nextEvent, "No more events should return 'NONE'.");
    }

    //@Test
    public void testBoundaryDifferenceCalculation_f0u9() throws Exception {
        // Testing the boundary condition for the difference method
        MyDate date1 = new MyDate(2024, 1, 1);
        MyDate date2 = new MyDate(2024, 12, 31);
        
        // Calculate the difference
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        Assertions.assertEquals(364, difference, "The difference should be 364 days.");
    }

    @Test
    public void testEventCapacity_zb15() throws Exception {
        // Create a MyCalendar with a capacity of 2
        MyCalendar calendar = new MyCalendar(2);
        
        // Add two events
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 15), "event1"), "Should add event1.");
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 16), "event2"), "Should add event2.");
        
        // Adding a third event should fail
        Assertions.assertFalse(calendar.addEvent(new MyDate(2024, 2, 17), "event3"), "Should not add event3, capacity exceeded.");
    }

    //@Test
    public void testMyDateAddDaysAndToString_082j() throws Exception {
        // Create a MyDate instance for testing
        MyDate date = new MyDate(2024, 2, 28);
        
        // Use reflection to access the private addDays method
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        
        // Add 1 day to trigger a month rollover (February to March)
        addDaysMethod.invoke(date, 1);
        
        // Now we check the string representation of the date
        Method toStringMethod = MyDate.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        String dateString = (String) toStringMethod.invoke(date);
        
        // Assert the date has correctly rolled over to March
        assertEquals("2024-03-01", dateString);
    }

    //@Test
    public void testMyDateDifference_lr26() throws Exception {
        // Create two MyDate instances for testing
        MyDate date1 = new MyDate(2024, 1, 1);
        MyDate date2 = new MyDate(2024, 1, 31);
        
        // Use reflection to access the static difference method
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        
        // Calculate the difference between the two dates
        int difference = (int) differenceMethod.invoke(null, date1, date2);
        
        // Assert the difference is correct
        assertEquals(30, difference);
    }

    @Test
    public void testMyCalendarAddEventAndFinishNextEvent_0dqh() throws Exception {
        // Create a MyCalendar instance with a capacity of 3
        MyCalendar calendar = new MyCalendar(3);
        
        // Add events to the calendar
        assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "meeting"));
        assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "laundry"));
        assertTrue(calendar.addEvent(new MyDate(2024, 2, 2), "grocery shopping"));
        
        // Try to add one more event which should fail due to capacity
        assertFalse(calendar.addEvent(new MyDate(2024, 2, 3), "exercise"));
        
        // Call finishNextEvent and check the returned event
        assertEquals("laundry", calendar.finishNextEvent());
        
        // Call finishNextEvent again and check the next event
        assertEquals("meeting", calendar.finishNextEvent());
        
        // Call finishNextEvent again and check the last event
        assertEquals("grocery shopping", calendar.finishNextEvent());
        
        // Finally, all events should be finished, check the return value
        assertEquals("NONE", calendar.finishNextEvent());
    }

    @Test
    public void testMyDateLeapYearHandling_uf2j() throws Exception {
        // Create a MyDate instance for a leap year
        MyDate leapYearDate = new MyDate(2024, 2, 29);
        
        // Use reflection to add days and check for the next day
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(leapYearDate, 1);
        
        // Check the date should now be March 1, 2024
        Method toStringMethod = MyDate.class.getDeclaredMethod("toString");
        toStringMethod.setAccessible(true);
        String dateString = (String) toStringMethod.invoke(leapYearDate);
        
        // Assert the date has correctly moved to March
        assertEquals("2024-03-01", dateString);
        
        // Now check a non-leap year
        MyDate nonLeapYearDate = new MyDate(2023, 2, 28);
        addDaysMethod.invoke(nonLeapYearDate, 1);
        dateString = (String) toStringMethod.invoke(nonLeapYearDate);
        
        // Assert the date is correctly moved to March
        assertEquals("2023-03-01", dateString);
    }

    @Test
    public void testMyDateAddDaysAndDifference_08ux() throws Exception {
        // Create two MyDate instances to test addDays and difference methods
        MyDate date1 = new MyDate(2024, 2, 1); // Start date
        MyDate date2 = new MyDate(2024, 2, 15); // End date

        // Add days to date1
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(date1, 14); // Adding 14 days to date1

        // Check the new date after addition
        Field dayField = MyDate.class.getDeclaredField("day");
        dayField.setAccessible(true);
        Assertions.assertEquals(15, dayField.get(date1)); // date1 should now be 2024-02-15

        // Calculate the difference
        Method differenceMethod = MyDate.class.getDeclaredMethod("difference", MyDate.class, MyDate.class);
        differenceMethod.setAccessible(true);
        int diff = (int) differenceMethod.invoke(null, date1, date2); // Call static method

        // Assert the difference is 0
        Assertions.assertEquals(0, diff); // They should be the same date
    }

    @Test
    public void testMyCalendarAddEventAndFinishNextEvent_9iu1() throws Exception {
        // Create MyCalendar instance with a capacity of 3
        MyCalendar calendar = new MyCalendar(3);

        // Add events to the calendar
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "Meeting")); // Event 1
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "Laundry")); // Event 2
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 2), "Gym")); // Event 3
        Assertions.assertFalse(calendar.addEvent(new MyDate(2024, 2, 3), "Study")); // Should fail, capacity reached

        // Finish the next event
        String firstEvent = calendar.finishNextEvent(); // Should return "Laundry" (alphabetical order)
        Assertions.assertEquals("Laundry", firstEvent);

        // Finish the next event
        String secondEvent = calendar.finishNextEvent(); // Should return "Meeting"
        Assertions.assertEquals("Meeting", secondEvent);

        // Finish the last event
        String thirdEvent = calendar.finishNextEvent(); // Should return "Gym"
        Assertions.assertEquals("Gym", thirdEvent);

        // All events finished, should return "NONE"
        String noMoreEvents = calendar.finishNextEvent();
        Assertions.assertEquals("NONE", noMoreEvents);
    }

    //@Test
    public void testMyDateAddDaysBoundaryConditions_r993() throws Exception {
        // Create a MyDate instance at the end of a month
        MyDate date = new MyDate(2024, 2, 28); // Leap year

        // Add 1 day to cross into March
        Method addDaysMethod = MyDate.class.getDeclaredMethod("addDays", int.class);
        addDaysMethod.setAccessible(true);
        addDaysMethod.invoke(date, 1); // Move to March 1st

        // Assert the date has moved correctly
        Field monthField = MyDate.class.getDeclaredField("month");
        monthField.setAccessible(true);
        Field dayField = MyDate.class.getDeclaredField("day");
        dayField.setAccessible(true);
        Assertions.assertEquals(3, monthField.get(date)); // Month should be 3
        Assertions.assertEquals(1, dayField.get(date)); // Day should be 1
    }

    @Test
    public void testMyCalendarAddEventCapacity_w01x() throws Exception {
        // Create a MyCalendar instance with a capacity of 1
        MyCalendar calendar = new MyCalendar(1);

        // Add the first event
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 1), "Event A"));

        // Try to add a second event, which should fail
        Assertions.assertFalse(calendar.addEvent(new MyDate(2024, 2, 2), "Event B"));

        // Finish the first event
        String finishedEvent = calendar.finishNextEvent();
        Assertions.assertEquals("Event A", finishedEvent);

        // After finishing the event, we should be able to add another one
        Assertions.assertTrue(calendar.addEvent(new MyDate(2024, 2, 2), "Event B")); // Now should succeed
    }


}
