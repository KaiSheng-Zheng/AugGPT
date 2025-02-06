import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyDate{
    private int year, month, day;
    private final LocalDate BEGIN = LocalDate.of(1970,1,1);
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public void addDays(int days) {
        boolean done=false;
        day += days;
        if (day<=28) return;
        while(!done){
            switch (month) {
                case 1, 3, 5, 7, 9, 11:
                    if (day > 31) {
                        month++;
                        day -= 31;
                    } else done = true;
                    break;
                case 2:
                    if (day > (isLeapYear(year)?29:28)) {
                        month++;
                        day -= isLeapYear(year)?29:28;
                    } else done = true;
                    break;
                case 4, 6, 8, 10:
                    if (day > 30) {
                        month++;
                        day -= 30;
                    } else done = true;
                    break;
                case 12:
                    if (day > 31) {
                        year++;
                        month = 1;
                        day -= 31;
                    } else done = true;
                    break;
            }
        }
    }
    public boolean isLeapYear(int year){
        return year%4==0 && year%100!=0 || year%400==0;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int days1 = toDays(date1), days2 = toDays(date2);
        return days1 - days2;
    }

    public static int toDays(MyDate date) {
        return date.toDays();
    }
    public int toDays(){
        LocalDate dayNow = LocalDate.parse(this.toString());
        return (int) BEGIN.until(dayNow, ChronoUnit.DAYS);
    }
}
