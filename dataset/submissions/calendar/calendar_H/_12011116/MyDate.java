import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate implements Comparable<MyDate> {

    private int year;
    private int month;
    private int day;
    private String name;

    private LocalDate date;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;

        date = LocalDate.of(year, month, day);
    }

    public MyDate(MyDate date, String name) {
        this(date.year, date.month, date.day);
        this.name = name;
    }

    public void addDays(int days) {
        date = date.plusDays(days);

        year = date.getYear();
        month = date.getMonth().getValue();
        day = date.getDayOfMonth();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    @Override
    public int compareTo(MyDate o) {
        int t = this.date.compareTo(o.date);
        if ( t == 0 )
            return name.compareTo(o.name);
        return t;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static int difference(MyDate date1, MyDate date2) {
        return (int) ChronoUnit.DAYS.between(date2.date, date1.date);
    }

//    public static void main(String[] args) {
//        MyDate date1 = new MyDate(2023,1,30);
//        MyDate date2 = new MyDate(2023,3,1);
//        MyDate date3 = new MyDate(2023, 2, 5);
//
//        date1.addDays(2);
//        System.out.println(date1.toString().equals("2023-02-01"));
//
//        int diff = MyDate.difference(date1, date2);
//        System.out.println(diff == -28);
//
//        int diff2 = MyDate.difference(date3, date1);
//        System.out.println(diff2 == 4);
//
//        MyCalendar calendar = new MyCalendar(4);
//        calendar.addEvent(date1, "meeting");
//        calendar.addEvent(date2, "seminar");
//        calendar.addEvent(date3, "appointment");
//        calendar.addEvent(date1, "laundry");
//        boolean success = calendar.addEvent(date1, "exam");
//        System.out.println(success == false); // event capacity exceeded
//        System.out.println(calendar.finishNextEvent().equals("laundry"));
//        System.out.println(calendar.finishNextEvent().equals("meeting"));
//        System.out.println(calendar.finishNextEvent().equals("appointment"));
//        System.out.println(calendar.finishNextEvent().equals("seminar"));
//        System.out.println(calendar.finishNextEvent().equals("NONE"));
//    }
}
