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
        LocalDate currentDate = LocalDate.of(year, month, day);
        LocalDate newDate = currentDate.plusDays(days);
        year = newDate.getYear();
        month = newDate.getMonthValue();
        day = newDate.getDayOfMonth();
    }

    @Override
    public String toString() {
        return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        LocalDate localDate1 = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate localDate2 = LocalDate.of(date2.year, date2.month, date2.day);
        long daysBetween = ChronoUnit.DAYS.between(localDate1, localDate2);
        return (int) (daysBetween * -1); // Multiply by -1 to get the difference in the desired direction
    }
}