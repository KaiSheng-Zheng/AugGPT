import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class MyDate  {
     int year;
     int month;
     int day;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days) {
        int newDay = this.day + days;
        int newMonth = this.month;
        int newYear = this.year;
        while (newDay > getDaysInMonth(newYear, newMonth)) {
            newDay -= getDaysInMonth(newYear, newMonth);
            newMonth++;
            if (newMonth > 12) {
                newMonth = 1;
                newYear++;
            }
        }
        this.day = newDay;
        this.month = newMonth;
        this.year = newYear;
    }
    public String toString() {
        return year + "-" +addzero(month) + "-" + addzero(day);
    }
    public static int difference(MyDate date1, MyDate date2) {
        LocalDate m=LocalDate.of(date1.year,date1.month,date1.day);
        LocalDate n=LocalDate.of(date2.year,date2.month,date2.day);
        int difference= (int) ChronoUnit.DAYS.between(m,n);
        return -difference;
    }
    private static int getDaysInMonth(int year, int month) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            case 4, 6, 9, 11 -> {
                return 30;
            }
            case 2 -> {
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            }
            default -> throw new IllegalArgumentException(String.valueOf(month));
        }
    }
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    private static String addzero(int value){
        return String.format("%02d",value);
    }
        }
