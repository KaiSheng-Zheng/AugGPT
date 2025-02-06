public class MyDate implements Comparable {
    private int year;
    private int month;
    private int day;

    public static int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        int remainingDatsInCurrentMonth = getDaysInMonth() - this.day;
        if (days <= remainingDatsInCurrentMonth) {
            this.day += days;
        } else {
            days -= remainingDatsInCurrentMonth;
            this.month++;
            if (this.month > 12) {
                this.month = 1;
                this.year++;
            }
            this.day = 1;
            days--;
            addDays(days);
        }
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getToalDaysInYear() {
        if (isLeapYear()) {
            return 366;
        }
        return 365;
    }

    public int getDaysInYear() {
        int result = 0;
        for (int i = 1; i < this.month; i++) {
            if (isLeapYear() && i == 2) {
                result += daysInMonth[i] + 1;
            } else {
                result += daysInMonth[i];
            }
        }
        result += this.day;
        return result;
    }

    public int getDaysInMonth() {
        if (isLeapYear() && this.month == 2) {
            return daysInMonth[this.month] + 1;
        }
        return daysInMonth[this.month];
    }


    public boolean isEarlierThan(MyDate date) {
        if (this.year < date.getYear()) {
            return true;
        } else if (this.year == date.getYear()) {
            if (this.month < date.getMonth()) {
                return true;
            } else if (this.month == date.getMonth()) {
                if (this.day < date.getDay()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int difference(MyDate date1, MyDate date2) {

        if (date1.isEarlierThan(date2)) {
            return -difference(date2, date1);
        }

        if (date1.getYear() == date2.getYear()) {
            if (date1.getMonth() == date2.getMonth()) {
                return date1.getDay() - date2.getDay();
            } else {
                int result = date2.getDaysInMonth() - date2.getDay();
                for (int i = date2.getMonth() + 1; i < date1.getMonth(); i++) {
                    if (date1.isLeapYear() && i == 2) {
                        result += daysInMonth[i] + 1;
                    } else {
                        result += daysInMonth[i];
                    }
                }
                result += date1.getDay();
                return result;
            }
        } else {
            int result = date2.getToalDaysInYear() - date2.getDaysInYear();
            for (int i = date2.getYear() + 1; i < date1.getYear(); i++) {
                result += new MyDate(i, 12, 31).getToalDaysInYear();
            }
            result += date1.getDaysInYear();
            return result;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof MyDate) {
            MyDate date = (MyDate) obj;
            return this.year == date.getYear() && this.month == date.getMonth() && this.day == date.getDay();
        }
        return false;
    }

    public int hashCode() {
        return this.year * 10000 + this.month * 100 + this.day;
    }

    public int compareTo(Object obj) {
        if (obj instanceof MyDate) {
            MyDate date = (MyDate) obj;
            return difference(this, date);
        }
        return -1;
    }

    public boolean isLeapYear() {
        int year = this.year;
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public String toString() {
        // return a String of the formatted date: yyyy-mm-dd

        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }
}