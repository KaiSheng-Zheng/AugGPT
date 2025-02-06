public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            monthDays[1] = 29;
        }
        while (days > 0) {
            if (monthDays[month - 1] - day >= days) {
                day += days;
                days = 0;
            } else {
                days -= (monthDays[month - 1] - day + 1);
                day = 1;
                month++;
                if (month > 12) {
                    year++;
                    month = 1;
                    if (isLeapYear(year)) {
                        monthDays[1] = 29;
                    } else {
                        monthDays[1] = 28;
                    }
                }
            }
        }
    }

    public String toString() {
        String date = "";
        date += year;
        date += "-";
        if (month < 10) {
            date += "0";
        }
        date += month;
        date += "-";
        if (day < 10) {
            date += "0";
        }
        date += day;
        return date;
    }

    public static int difference(MyDate date1, MyDate date2) {
        if (date1.year == date2.year && date1.month == date2.month && date1.day == date2.day) {
            return 0;
        }
        int days = 0;
        boolean test = true;
        if (date1.year > date2.year || (date1.year == date2.year && date1.month > date2.month) || (date1.year == date2.year && date1.month == date2.month && date1.day > date2.day)) {
            test = false;
        }
        if (test) {
            int year1 = date1.year, month1 = date1.month, day1 = date1.day;
            while (!(date1.year == date2.year && date1.month == date2.month && date1.day == date2.day)) {
                date1.addDays(1);
                days++;
            }
            date1.day=day1;
            date1.month=month1;
            date1.year=year1;
            days=-days;
        }else {
            int year1 = date2.year, month1 = date2.month, day1 = date2.day;
            while (!(date1.year == date2.year && date1.month == date2.month && date1.day == date2.day)) {
                date2.addDays(1);
                days++;
            }
            date2.day=day1;
            date2.month=month1;
            date2.year=year1;
        }
        return days;
    }
    public static boolean Compare(MyDate date1,MyDate date2){
        if (date1.year > date2.year || (date1.year == date2.year && date1.month > date2.month) || (date1.year == date2.year && date1.month == date2.month && date1.day > date2.day)) {
            return true;
        }
        else return false;
    }
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
