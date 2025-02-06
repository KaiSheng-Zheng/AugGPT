public class MyDate {
    private int year;
    private int month;
    private int day;
    private long timestamp;


    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int compareTo(MyDate other) {
        if (this.year != other.year) {
            return this.year - other.year;
        } else if (this.month != other.month) {
            return this.month - other.month;
        } else {
            return this.day - other.day;
        }
    }
    public void addDays(int days) {
        day += days;
        while (day > getDaysInMonth(year, month)) {
            day -= getDaysInMonth(year, month);
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }
@Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int days1 = dateToDays(date1);
        int days2 = dateToDays(date2);

        return days1 - days2;
    }

    private static int dateToDays(MyDate date) {

        int year = date.year;
        int month = date.month;
        int day = date.day;
        int days = year * 365;
        days += countLeapYears(year, month);
        for (int m = 1; m < month; m++) {
            days += getDaysInMonth(year, m);
        }
        days += day;
        return days;
    }
    private static int countLeapYears(int year, int month) {
        if (month <= 2) {
            year--;
        }
        int leapYears = 0;
        for(int i=year;i>=0;i--){
            if(isLeapYear(year)){
                leapYears++;
            }
        }

        return leapYears;
    }

    private static int getDaysInMonth(int year, int month) {

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        return daysInMonth[month-1];
    }

    private static boolean isLeapYear(int year) {

        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }

        if (year % 400 == 0) {
            return true;
        }

        return false;
    }
}
