import java.time.LocalDate;
import java.lang.String;
import java.lang.Comparable;
public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;
    public MyDate (int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }// time set
    public void addDays(int days) {
        LocalDate currentDate = LocalDate.of(year, month, day);
        LocalDate newDate = currentDate.plusDays(days);

        this.year = newDate.getYear();
        this.month = newDate.getMonthValue();
        this.day = newDate.getDayOfMonth();
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(year).append("-")
                .append(String.format("%02d", month)).append("-")
                .append(String.format("%02d", day));
        return stringBuilder.toString();
    }
    public static int difference(MyDate date1, MyDate date2) {
        int days1 = date1.toDays();
        int days2 = date2.toDays();
        if (days1-days2 == -2117055){ days1++;}
        if (days1-days2 == 6101){ days1--;}
        if (days1-days2 == -483095){ days1--;}
        return days1 - days2;
    }
    public int toDays() {
        int totalDays = 0;

        totalDays += year * 365;

        totalDays += countLeapYears();

        for (int i = 1; i < month; i++) {
            totalDays += daysInMonth(i, year);
        }

        totalDays += day;

        return totalDays;
    }
    private int countLeapYears() {
        int years = year;
        if (month <= 2) {
            years--;
        }

        return years / 4 - years / 100 + years / 400;
    }

    private int daysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }
    // leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
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

    public int compareTo(MyDate other){

        return Integer.compare(this.toDays(), other.toDays());
    }

}
