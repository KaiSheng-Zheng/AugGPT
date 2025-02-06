import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;
    public MyDate (int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    //I'm sorry that I searched for Internet to solve this problem to avoid "while error"...
    public void addDays (int days) {
        LocalDate date = LocalDate.parse(this.toString());
        date = date.plusDays(days);
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.day = date.getDayOfMonth();
    }
    public String toString() {
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }
    public int compareTo(MyDate date) {
        if (this.year != date.year) return this.year - date.year;
        if (this.month != date.month) return this.month - date.month;
        if (this.day != date.day) return this.day - date.day;
        return 0;
    }
    public static int difference(MyDate date01, MyDate date02) {
        LocalDate date1 = LocalDate.parse(date01.toString());
        LocalDate date2 = LocalDate.parse(date02.toString());
        return (int)ChronoUnit.DAYS.between(date2, date1);
    }
}
