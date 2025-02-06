import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class MyDate {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        String date = year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
        LocalDate now = LocalDate.parse(date);
        LocalDate future = now.plusDays(days);
        year = future.getYear();
        month = future.getMonthValue();
        day = future.getDayOfMonth();
    }

    public String toString() {
        return year+"-"+String.format("%02d",month)+"-"+String.format("%02d",day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        LocalDate date11 = LocalDate.of(date1.year, date1.month, date1.day);
        LocalDate date22 = LocalDate.of(date2.year, date2.month, date2.day);
        long diff = ChronoUnit.DAYS.between(date11, date22);
        return -(int) diff;
    }


}
