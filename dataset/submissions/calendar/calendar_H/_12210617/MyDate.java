public class MyDate
    implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days) {
        int currentDays = getDaysInMonth(year, month) - day + 1;
        int addedDays = days + currentDays;
        while(addedDays > getDaysInMonth(year, month)) {
            int temp = addedDays - getDaysInMonth(year, month);
            days += temp;
            month++;
            if(month > 12) {
                month = 1;
                year++;
            }
            addedDays -= getDaysInMonth(year, month);
        }
        day += days;
    }
    @Override
    public int compareTo(MyDate other) {
        int result = this.year - other.year;
        if (result == 0) {
            result = this.month - other.month;
            if (result == 0) {
                result = this.day - other.day;
            }
        }
        return result;
    }
    public String toString() {
        return year + "-" + month + "-" + day;
    }
    public static int difference(MyDate date1, MyDate date2) {
        int diff = (date2.year - date1.year) * 12 + (date2.month - date1.month);
        if(date2.day < date1.day) {
            diff--;
        }
        return diff;
    }
    private static int getDaysInMonth(int year, int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
            default -> throw new IllegalArgumentException("Invalid month");
        };
    }
        private String eventName;
    public String getEventName() {
            return eventName;
        }

}
