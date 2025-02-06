import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyCalendarTest {
    //1 base case
    @Test
    public void test1() {
        MyDate date = new MyDate(2023, 5, 10);
        date.addDays(7);
        assertEquals("2023-05-17", date.toString());
    }

    //2 over months
    @Test
    public void test2() {
        MyDate date = new MyDate(2022, 4, 10);
        date.addDays(80);
        assertEquals("2022-06-29", date.toString());
    }

    @Test
    //3 over years including special years
    public void test3() {
        MyDate date = new MyDate(1764, 1, 2);
        date.addDays(45678);
        assertEquals("1889-01-24", date.toString());
    }

    @Test
    //4
    public void test4() {
        MyDate date1 = new MyDate(1998, 2, 3);
        MyDate date2 = new MyDate(4399, 12, 31);
        MyDate date3 = new MyDate(1699, 7, 12);
        assertEquals("1998-02-03", date1.toString());
        assertEquals("4399-12-31", date2.toString());
        assertEquals("1699-07-12", date3.toString());
    }

    @Test
    //5 for differences not less than 0
    public void test5() {
        MyDate date1 = new MyDate(1998, 1, 7);
        MyDate date2 = new MyDate(2000, 2, 20);
        MyDate date3 = new MyDate(2003, 9, 30);
        MyDate date4 = new MyDate(2020, 6, 12);
        MyDate date5 = new MyDate(2020, 6, 12);
        int diff21 = MyDate.difference(date2, date1);
        assertEquals(774, diff21);
        int diff32 = MyDate.difference(date3, date2);
        assertEquals(1318, diff32);
        int diff43 = MyDate.difference(date4, date3);
        assertEquals(6100, diff43);
        int diff54 = MyDate.difference(date5, date4);
        assertEquals(0, diff54);
    }

    @Test
    //6 for differences less than 0
    public void test6() {
        MyDate date1 = new MyDate(9256, 3, 7);
        MyDate date2 = new MyDate(3459, 11, 20);
        MyDate date3 = new MyDate(2923, 1, 1);
        MyDate date4 = new MyDate(1600, 4, 30);
        int diff21 = MyDate.difference(date2, date1);
        assertEquals(-2117054, diff21);
        int diff32 = MyDate.difference(date3, date2);
        assertEquals(-196093, diff32);
        int diff43 = MyDate.difference(date4, date3);
        assertEquals(-483096, diff43);
    }

    //7
    @Test
    public void test7() {
        MyCalendar calendar = new MyCalendar(2);
        MyDate date1 = new MyDate(1977, 3, 10);
        MyDate date2 = new MyDate(1755, 6, 28);
        MyDate date3 = new MyDate(2023, 9, 1);
        assertEquals(true, calendar.addEvent(date1, "13456"));
        assertEquals(true, calendar.addEvent(date2, "study$"));
        assertEquals(false, calendar.addEvent(date3, "Buy a gift for dad"));
        assertEquals(false, calendar.addEvent(date2, "letThePartyBegin!"));
        assertEquals(false, calendar.addEvent(date1, "#$%"));
    }

    //8 base case
    @Test
    public void test8() {
        MyDate date1 = new MyDate(1997, 6, 4);
        MyCalendar calendar = new MyCalendar(4);
        calendar.addEvent(date1, "Happy dog 666");
        assertEquals("Happy dog 666", calendar.finishNextEvent());
    }

    //9 test for two set of orders(chronological & alphabetical)
    @Test
    public void test9() {
        MyDate date1 = new MyDate(1980, 4, 10);
        MyDate date2 = new MyDate(2009, 2, 17);
        MyDate date3 = new MyDate(2314, 9, 30);
        MyDate date4 = new MyDate(3456, 12, 31);
        MyDate date5 = new MyDate(3457, 1, 1);
        MyCalendar calendar = new MyCalendar(11);
        calendar.addEvent(date1, "a nice dinner");
        calendar.addEvent(date1, "31415926");
        calendar.addEvent(date1, "$_$who do not love money~");
        calendar.addEvent(date2, "csgo");
        calendar.addEvent(date2, "cs");
        calendar.addEvent(date2, "cdefgab");
        calendar.addEvent(date3, " ");
        calendar.addEvent(date3, "!today I will fly to the moon");
        calendar.addEvent(date3, "");
        calendar.addEvent(date4, "_$");
        calendar.addEvent(date5, "this is so normal");
        calendar.addEvent(date5, "Wow,what a lucky number-666666!");
        assertEquals("$_$who do not love money~", calendar.finishNextEvent());
        assertEquals("31415926", calendar.finishNextEvent());
        assertEquals("a nice dinner", calendar.finishNextEvent());
        assertEquals("cdefgab", calendar.finishNextEvent());
        assertEquals("cs", calendar.finishNextEvent());
        assertEquals("csgo", calendar.finishNextEvent());
        assertEquals("", calendar.finishNextEvent());
        assertEquals(" ", calendar.finishNextEvent());
        assertEquals("!today I will fly to the moon", calendar.finishNextEvent());
        assertEquals("_$", calendar.finishNextEvent());
        assertEquals("this is so normal", calendar.finishNextEvent());
        assertEquals("NONE", calendar.finishNextEvent());
    }

    //10 test for adding & deleting at the same time while not adding events in time order
    @Test
    public void test10() {
        MyDate date1 = new MyDate(4376, 7, 9);
        MyDate date2 = new MyDate(2138, 12, 21);
        MyDate date3 = new MyDate(1602, 6, 30);
        MyDate date4 = new MyDate(2000, 1, 1);
        MyDate date5 = new MyDate(7789, 5, 31);
        MyDate date6 = new MyDate(1765, 10, 14);
        MyCalendar calendar = new MyCalendar(10);
        calendar.addEvent(date1, "java_homework4");
        calendar.addEvent(date1, "matlab_OJ");
        calendar.addEvent(date2, "blow ~Beng!");
        assertEquals("blow ~Beng!", calendar.finishNextEvent());
        assertEquals("java_homework4", calendar.finishNextEvent());
        calendar.addEvent(date6, "#12306");
        calendar.addEvent(date6, "  blank_space_is a BEAUTIFUL song$$");
        calendar.addEvent(date3, "100AC");
        calendar.addEvent(date4, "--:)have a nice day~");
        assertEquals("100AC", calendar.finishNextEvent());
        assertEquals("  blank_space_is a BEAUTIFUL song$$", calendar.finishNextEvent());
        assertEquals("#12306", calendar.finishNextEvent());
        calendar.addEvent(date4, "::135");
        calendar.addEvent(date4, "::135");
        assertEquals("--:)have a nice day~", calendar.finishNextEvent());
        assertEquals("::135", calendar.finishNextEvent());
        assertEquals("::135", calendar.finishNextEvent());
        assertEquals("matlab_OJ", calendar.finishNextEvent());
        calendar.addEvent(date6, "2333");
        calendar.addEvent(date5, "^_^");
        calendar.addEvent(date3, "while(true){debug;}");
        calendar.addEvent(date4, "::135happiness");
        assertEquals("while(true){debug;}", calendar.finishNextEvent());
        assertEquals("2333", calendar.finishNextEvent());
        assertEquals("::135happiness", calendar.finishNextEvent());
        assertEquals("^_^", calendar.finishNextEvent());
        assertEquals("NONE", calendar.finishNextEvent());
        assertEquals("NONE", calendar.finishNextEvent());
    }
}
