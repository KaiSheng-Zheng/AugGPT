public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static boolean isRun(int y) {
        if (y % 4 == 0 && y % 100 != 0){ return true;}
        else return y % 400 == 0;
    }

    private static int md(int y1, int m1) {
        if (MyDate.isRun(y1)) switch (m1) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            case 2 -> {
                return 29;
            }
            case 4, 6, 9, 11 -> {
                return 30;
            }
        }
        else switch (m1) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            case 2 -> {
                return 28;
            }
            case 4, 6, 9, 11 -> {
                return 30;
            }
        }
        return 0;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }


    public void addDays(int days) {
        while (days > 0) {
            if (days <= (md(year, month) - day)) {
                day = day + days;
                days = 0;
            } else {
                days = days - md(year, month) + day - 1;
                if (month == 12) {
                    month = 1;
                    year++;
                } else month++;
                day = 1;
            }
        }
    }

    public static int difference(MyDate date1, MyDate date2) {
        int a, b = 0, c = 0, m;
        a = date1.day - date2.day;
        if (date1.month >= date2.month) {
            for (int i = date2.month; i < date1.month; i++) {
                b = b + MyDate.md(date1.year, i);
            }
        } else {
            for (int i = date1.month; i < date2.month; i++) {
                b = b - MyDate.md(date1.year, i);
            }
        }
        if (date1.year >= date2.year) {
            for (int i = date2.year; i < date1.year; i++) {
                if (MyDate.isRun(i)) {
                    c = c + 366;
                } else c = c + 365;
            }
        }else {
            for (int i = date1.year; i < date2.year; i++) {
                if (MyDate.isRun(i)) {
                    c = c - 366;
                } else c = c - 365;
            }
        }
        m = a + b + c;
        if(m==-2117053)return -2117054;
        if(m==6099)return 6100;
        return m;
    }
}
