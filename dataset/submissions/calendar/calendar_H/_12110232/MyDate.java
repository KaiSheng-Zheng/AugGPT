import java.util.Comparator;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;
    private String eventName;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addEventname(String eventName) {
       this.eventName = eventName;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    public int[][] getCalendar() {
        return calendar();
    }

    public int[][] calendar() {
        int[][] calendar = new int[12][];
        int dayInYear = 1;
        for (int i = 0; i < 12; i++) {
            int daysInMonth = getDaysInMonth(i + 1, year);
            calendar[i] = new int[daysInMonth];
            for (int j = 0; j < daysInMonth; j++) {
                calendar[i][j] = dayInYear;
                dayInYear++;
            }
        }
        return calendar;
    }

    public int getDaysInMonth(int month, int year) {
        int[] daysInMonth = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return daysInMonth[month - 1];
    }

    public int getDaysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    public void addDays(int days) {
        int[][] calendar = getCalendar();
        int newDayNum = calendar[month - 1][day - 1] + days;

        while (newDayNum > getDaysInYear(year)) {
            newDayNum -= getDaysInYear(year);
            year++;
        }

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                if (calendar[i][j] == newDayNum) {
                    month = i + 1;
                    day = j + 1;
                    return;
                }
            }
        }
    }

    public static int difference(MyDate date1, MyDate date2) {
        int daysDifference = 0;

        if (date1.year > date2.year || (date1.year == date2.year && date1.month > date2.month) ||
                (date1.year == date2.year && date1.month == date2.month && date1.day > date2.day)) {
            MyDate afterDate = new MyDate(date1.year, date1.month, date1.day);
            MyDate beforeDate = new MyDate(date2.year, date2.month, date2.day);
            while (beforeDate.year != afterDate.year || beforeDate.month != afterDate.month || beforeDate.day != afterDate.day) {
                beforeDate.addDays(1);
                daysDifference++;
            }
            return daysDifference;

        } else {
            MyDate beforeDate = new MyDate(date1.year, date1.month, date1.day);
            MyDate afterDate = new MyDate(date2.year, date2.month, date2.day);
            while (beforeDate.year != afterDate.year || beforeDate.month != afterDate.month || beforeDate.day != afterDate.day) {
                beforeDate.addDays(1);
                daysDifference++;
            }
            return daysDifference * -1;
        }
    }

    public String getEventName(){
        return this.eventName;
    }
    public int getEventYear(){
        return this.year;
    }
    public int getNameMonth(){
        return this.month;
    }
    public int getEventDay(){
        return this.day;
    }


    @Override
    public int compareTo(MyDate o) {
        int difference1 = year - o.year;
        if (difference1 != 0) {
            return difference1;
        }
        int difference2 = month - o.month;
        if (difference2 != 0) {
            return difference2;
        }
        int difference3 = day - o.day;
        if (difference3 != 0) {
            return difference3;
        }
        return eventName.compareTo(o.eventName);
    }
}
