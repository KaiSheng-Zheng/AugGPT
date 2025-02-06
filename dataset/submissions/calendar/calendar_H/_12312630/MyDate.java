import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        LocalDate date = LocalDate.of(year, month, day);
        date = date.plusDays(days);
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.day = date.getDayOfMonth();
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        LocalDate d1 = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate d2 = LocalDate.of(date2.year, date2.month, date2.day);
        return (int) ChronoUnit.DAYS.between(d1, d2);
    }
    public int compareTo(MyDate other) {
        if (this.year != other.year) {
            return this.year - other.year;
        } else if (this.month != other.month) {
            return this.month - other.month;
        } else {
            return this.day - other.day;
        }
    }

}
