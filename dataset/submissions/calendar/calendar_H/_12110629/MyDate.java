
class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        int currentDay = this.day;
        int currentMonth = this.month;
        int currentYear = this.year;

        for (int i = 0; i < days; i++) {
            currentDay++;
            if (currentDay > 31) {
                currentDay = 1;
                currentMonth++;
                if (currentMonth > 12) {
                    currentMonth = 1;
                    currentYear++;
                }
            }
        }

        this.day = currentDay;
        this.month = currentMonth;
        this.year = currentYear;
    }

    @Override
    public String toString() {
        return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int[] days_in_month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int diffYears = date1.year - date2.year;
        int diffMonths = date1.month - date2.month;
        int diffDays = date1.day - date2.day;
        int day = 0;
        if (diffMonths != 0 && diffMonths >= 0) {
            day = days_in_month[date1.month - 1];
        } else if (diffMonths != 0) {
            day = -days_in_month[date1.month - 1];
        }
        if (diffDays != 0 && diffDays >= 0) {
            day += diffDays;
        } else if (diffDays != 0) {
            day += -diffDays;
        }
        return day;

    }

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
}