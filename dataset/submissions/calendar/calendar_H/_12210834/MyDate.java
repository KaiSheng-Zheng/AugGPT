public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private int getDaysInMonth(int year, int month) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }
    public void addDays(int days) {
        while (days > 0) {
            int daysInMonth = getDaysInMonth(year, month);
            int remainingDaysInMonth = daysInMonth - day + 1;

            if (days <= remainingDaysInMonth) {
                day += days;
                days = 0;
            } else {
                day = 1;
                if (month == 12) {
                    month = 1;
                    year++;
                } else {
                    month++;
                }
                days -= remainingDaysInMonth;
            }
        }
    }
    public String toString(){

        if(month>=10) {
            if(day>=10) return String.format("%d-%d-%d", year, month, day);
            else return String.format("%d-%d-0%d", year, month, day);
        }
        else {
            if(day>=10) return String.format("%d-0%d-%d", year, month, day);
            else return String.format("%d-0%d-0%d", year, month, day);
        }
    }
    public static int difference(MyDate date1, MyDate date2) {
        int totalDays1 = countTotalDays(date1.getYear(), date1.getMonth(), date1.getDay());
        int totalDays2 = countTotalDays(date2.getYear(), date2.getMonth(), date2.getDay());

        return totalDays1 - totalDays2;
    }

    private static int countTotalDays(int year, int month, int day) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Adjust for leap year
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }
        totalDays += 365 * (year - 1) + countLeapYears(year);

        return totalDays;
    }

    private static int countLeapYears(int year) {
        int count = year / 4 - year / 100 + year / 400;
        if(isLeapYear(year)) count--;
        return count;
    }
    public int compareTo(MyDate other) {
        if (year != other.year) {
            return year - other.year;
        }
        if (month != other.month) {
            return month - other.month;
        }
        return day - other.day;
    }

}

