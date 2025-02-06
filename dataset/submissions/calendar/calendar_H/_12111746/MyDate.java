import java.time.LocalDate;

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
        year = date.getYear();
        month = date.getMonthValue();
        day = date.getDayOfMonth();
    }
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    public static int difference(MyDate date1, MyDate date2) {
        LocalDate d1 = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate d2 = LocalDate.of(date2.year, date2.month, date2.day);
        long diff = d1.toEpochDay() - d2.toEpochDay();
        return (int)diff;
    }
}
