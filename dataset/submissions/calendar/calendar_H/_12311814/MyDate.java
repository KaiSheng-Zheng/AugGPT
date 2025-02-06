import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyDate {

    private LocalDate date;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        date = LocalDate.of(year, month, day);

    }

    public void addDays(int days) {
        date = date.plusDays(days);
    }

    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        return dtf.format(date);
    }

    public String getTimeStamp() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        System.out.println(date.getYear());
        System.out.println(dtf.format(date));
        return dtf.format(date);
    }

    public static int difference(MyDate date1, MyDate date2) {
        LocalDate d1 = LocalDate.of(date1.date.getYear(), date1.date.getMonth(), date1.date.getDayOfMonth());
        LocalDate d2 = LocalDate.of(date2.date.getYear(), date2.date.getMonth(), date2.date.getDayOfMonth());
        return (int) (d1.toEpochDay() - d2.toEpochDay());
    }

}
