import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void addDays(int days) {
        LocalDate date = LocalDate.of(this.getYear(),this.getMonth(),this.getDay());
        LocalDate newDate = date.plusDays(days);
        this.year = newDate.getYear();
        this.month = newDate.getMonthValue();
        this.day = newDate.getDayOfMonth();
    }

    public String toString() {
        String year = Integer.toString(this.getYear());
        String month = intToString(this.getMonth());
        String day = intToString(this.getDay());
        return year + "-" + month + "-" + day;
    }

    public static int difference(MyDate date1, MyDate date2) {
        LocalDate firstDate = LocalDate.parse(date1.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate secondDate = LocalDate.parse(date2.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        long daysDifference = ChronoUnit.DAYS.between(firstDate, secondDate);
        return (int) -daysDifference;
    }

    public String intToString(int num) {
        String temp;
        if (num >= 10) {
            temp = Integer.toString(num);
        } else {
            temp = "0" + Integer.toString(num);
        }
        return temp;
    }
}