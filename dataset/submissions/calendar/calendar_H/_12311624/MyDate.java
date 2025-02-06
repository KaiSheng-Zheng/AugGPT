public class MyDate {
    private int year;
    private int month;
    private int day;
    private int[] a;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            a = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        } else {
            a = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }
        day = day + days;
        while (day > a[month - 1]) {
            day -= a[month - 1];
            month += 1;
            if (month > 12) {
                month =  1;
                year += 1;
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    a = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                } else {
                    a = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                }
            }
        }
    }

    public String toString() {
        if (day / 10 == 0 && month / 10 == 0) {
            return String.format("%d-0%d-0%d", year, month, day);
        } else if (day / 10 > 0 && month / 10 == 0) {
            return String.format("%d-0%d-%d", year, month, day);
        } else if (day / 10 > 0 && month / 10 > 0) {
            return String.format("%d-%d-%d", year, month, day);
        } else {
            return String.format("%d-%d-0%d", year, month, day);
        }
    }

    public static int difference(MyDate date1, MyDate date2) {
        int b = date1.year * 365 + date1.month * 30 + date1.day;
        int c = date2.year * 365 + date2.month * 30 + date2.day;
        int[] a ;
        if (b < c) {
            int days = -date1.day;
            int year = date1.year;
            int month = date1.month;
            while (year < date2.year || month < date2.month) {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    a = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                } else {
                    a = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                }
                days += a[month - 1];
                month += 1;
                if (month > 12) {
                    month = 1;
                    year += 1;

                }
            }
            days += date2.day;
            return -days;
        } else {
            int days = -date2.day;
            int year = date2.year;
            int month = date2.month;
            while (year < date1.year || month < date1.month) {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    a = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                } else {
                    a = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                }
                days += a[month - 1];
                month += 1;
                if (month > 12) {
                    month = 1;
                    year += 1;
                }
            }
            days += date1.day;
            return days;
        }
    }
}
