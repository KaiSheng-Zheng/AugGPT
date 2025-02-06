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
        LocalDate localDate = LocalDate.of(year, month, day).plusDays(days);
        this.year = localDate.getYear();
        this.month = localDate.getMonthValue();
        this.day = localDate.getDayOfMonth();
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        LocalDate localDate1 = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate localDate2 = LocalDate.of(date2.year, date2.month, date2.day);
        return (int) (localDate1.toEpochDay() - localDate2.toEpochDay());
    }
}
