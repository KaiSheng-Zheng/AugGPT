public class MyDate {
    private int year;
    private int month;
    private int day;


    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days) {
        int daysInMonth = daysInMonth(this.year, this.month);

        while (days > 0) {
            if (this.day + days > daysInMonth) {
                days -= (daysInMonth - this.day + 1);
                this.day = 1;

                if (this.month == 12) {
                    this.month = 1;
                    this.year++;
                } else {
                    this.month++;
                }

                daysInMonth = daysInMonth(this.year, this.month);
            } else {
                this.day += days;
                days = 0;
            }
        }
    }


    public String toString() {
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }

    private int daysInMonth(int year, int month) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }


    public static int difference(MyDate date1, MyDate date2)
    {
        return (date1.year - date2.year) * 365 + (date1.month - date2.month) * 30 + (date1.day - date2.day);
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
