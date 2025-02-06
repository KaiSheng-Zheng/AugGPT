public class MyDate {
    private int year = 1;
    private int month = 1;
    private int day = 1;

    private static final int PERIOD = 146097;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate(MyDate date) {
        copyFrom(date);
    }

    public MyDate() {
    }

    private int stepYear(int extra) {
        int newYear = year + extra / 366;
        MyDate date = new MyDate(newYear, 1, 1);
        int newExtra = extra - difference(date, this);
        year = newYear;
        if (newExtra >= 366) newExtra = stepYear(newExtra);
        return newExtra;
    }

    private boolean dayExceedBound() {
        if (month == 2) {
            if (isLunarYear(year)) return day > 29;
            return day > 28;
        }
        if (isGreatMonth(month)) return day > 31;
        return day > 30;
    }

    private void nextDay() {
        day++;
        if (dayExceedBound()) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    public void copyFrom(MyDate date) {
        year = date.year;
        month = date.month;
        day = date.day;
    }

    public void addDays(int days) {
        days += countInYear(this) - 1;
        month = 1;
        day = 1;
        year += (days / PERIOD) * 400;
        days %= PERIOD;
        days = stepYear(days);
        int newMonth = month + days / 31, extraYear = (newMonth - 1) / 12, newYear = year + extraYear;
        newMonth -= extraYear * 12;
        MyDate date = new MyDate(newYear, newMonth, 1);
        days -= difference(date, this);
        copyFrom(date);
        if (days < 28) day += days;
        else {
            day = 28;
            days -= 27;
            for (; days > 0; days--) nextDay();
        }
    }

    @Override
    public String toString() {
        char[] c = String.format("%4d-%2d-%2d", year % 10000, month, day).toCharArray();
        for (int i = 0; i < 10; i++)
            if (c[i] == ' ') c[i] = '0';
        return String.copyValueOf(c);
    }

    private static boolean isLunarYear(int year) {
        if ((year & 3) != 0) return false;
        year >>= 2;
        if (year % 25 != 0) return true;
        year /= 25;
        return (year & 3) == 0;
    }

    private static boolean isGreatMonth(int month) {
        if (month > 7) return (month & 1) == 0;
        return (month & 1) != 0;
    }

    private static int countInYear(MyDate date) {
        int count = 30 * (date.month - 1) + date.day;
        for (int i = 1; i < date.month; i++)
            if (isGreatMonth(i)) count++;
        if (date.month > 2) {
            if (isLunarYear(date.year)) count--;
            else count -= 2;
        }
        return count;
    }

    private static int differenceForYear(int year1, int year2) {
        int countYear = year1 - year2, countExtra = 0;
        if (year1 != year2) {
            year1--;
            year2--;
            year1 >>= 2;
            year2 >>= 2;
            if (year1 != year2) {
                countExtra = year1 - year2;
                year1 /= 25;
                year2 /= 25;
                if (year1 != year2) {
                    countExtra -= year1 - year2;
                    year1 >>= 2;
                    year2 >>= 2;
                    if (year1 != year2) countExtra += year1 - year2;
                }
            }
        }
        return countYear * 365 + countExtra;
    }

    public static boolean isBigger(MyDate date1, MyDate date2) {
        if (date1.year > date2.year) return true;
        if (date1.year < date2.year) return false;
        if (date1.month > date2.month) return true;
        if (date1.month < date2.month) return false;
        return date1.day > date2.day;
    }

    public static int difference(MyDate date1, MyDate date2) {
        return differenceForYear(date1.year, date2.year) + countInYear(date1) - countInYear(date2);
    }
}