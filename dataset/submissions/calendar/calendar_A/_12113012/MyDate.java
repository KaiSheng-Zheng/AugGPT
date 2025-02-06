import java.time.LocalDate;

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
        LocalDate specificDate = LocalDate.of(getYear(), getMonth(), getDay());

        int addDays = days;

        LocalDate newDate = specificDate.plusDays(addDays);
        setYear(newDate.getYear());
        setMonth(newDate.getMonthValue());
        setDay(newDate.getDayOfMonth());
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        return dateToday(date1) - dateToday(date2);
       
    }

    public static int dateToday(MyDate date) {
        int sum = 0;
        for (int i = 1; i < date.getYear(); i++) {
            if (isLeapYear(i)) {
                sum += 366;
            } else {
                sum += 365;
            }
        }
        if (date.getMonth() == 1) {

        } else {
            for (int i = 1; i < date.getMonth(); i++) {
                if (i == 4 || i == 6 || i == 9 || i == 11) {
                    sum += 30;
                } else if (i == 2) {
                    if (isLeapYear(date.getYear())) {
                        sum += 29;
                    } else {
                        sum += 28;
                    }
                } else {
                    sum += 31;
                }
            }
        }

        sum += date.getDay();
        return sum;

    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


}