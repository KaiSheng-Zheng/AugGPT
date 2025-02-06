import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyDate {

    private int year;
    private int month;
    private int day;
    private LocalDate localDate;

    public MyDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
        localDate = LocalDate.of(year,month,day);
    }

    public void addDays(int days){
        localDate = localDate.plusDays(days);
    }

    public String toString() {
        return localDate.format(DateTimeFormatter.ISO_DATE);
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public static int difference(MyDate date1, MyDate date2) {
        return (int)(date1.localDate.toEpochDay()-date2.localDate.toEpochDay());
    }

    public int countDays(MyDate date1) {
        int sumOfLeapYear1 = 0;
        int days1 = 0;
        for (int i = 2022; i < date1.year; i++) {
            if ((i & 4) != 0 || ((i & 100) == 0 && (i & 400) != 0)) {

            } else {
                sumOfLeapYear1++;
            }
        }
        days1 = (366 * sumOfLeapYear1) + (365 * (date1.year - sumOfLeapYear1));

        if ((date1.year & 4) != 0 || ((date1.year & 100) == 0 && (date1.year & 400) != 0)) {
            if (date1.month == 1) {
                days1 += date1.day;
            } else if (date1.month == 2) {
                days1 += 31 + date1.day;
            } else if (date1.month == 3) {
                days1 += 59 + date1.day;
            } else if (date1.month == 4) {
                days1 += 90 + date1.day;
            } else if (date1.month == 5) {
                days1 += 120 + date1.day;
            } else if (date1.month == 6) {
                days1 += 151 + date1.day;
            } else if (date1.month == 7) {
                days1 += 181 + date1.day;
            } else if (date1.month == 8) {
                days1 += 212 + date1.day;
            } else if (date1.month == 9) {
                days1 += 243 + date1.day;
            } else if (date1.month == 10) {
                days1 += 273 + date1.day;
            } else if (date1.month == 11) {
                days1 += 304 + date1.day;
            } else if (date1.month == 12) {
                days1 += 334 + date1.day;
            }
        } else {
            if (date1.month == 1) {
                days1 += date1.day;
            } else if (date1.month == 2) {
                days1 += 31 + date1.day;
            } else if (date1.month == 3) {
                days1 += 60 + date1.day;
            } else if (date1.month == 4) {
                days1 += 91 + date1.day;
            } else if (date1.month == 5) {
                days1 += 121 + date1.day;
            } else if (date1.month == 6) {
                days1 += 152 + date1.day;
            } else if (date1.month == 7) {
                days1 += 182 + date1.day;
            } else if (date1.month == 8) {
                days1 += 213 + date1.day;
            } else if (date1.month == 9) {
                days1 += 244 + date1.day;
            } else if (date1.month == 10) {
                days1 += 274 + date1.day;
            } else if (date1.month == 11) {
                days1 += 305 + date1.day;
            } else if (date1.month == 12) {
                days1 += 335 + date1.day;
            }

        }
        return days1;
    }
}
