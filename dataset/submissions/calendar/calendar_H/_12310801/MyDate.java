public class MyDate {
    private int year;
    private int month;
    private int day;
    private static int[] Mon = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    private boolean Check() {
        if(year % 4 != 0) return false;
        return year % 100 != 0 || year % 400 == 0;
    }
    private int Ask() {
        if(month != 2) return Mon[month];
        if(Check()) return 29;
        return 28;
    }
    public void addDays(int days) {
        assert(days > 0);
        while(days != 0) {
            int tmp = Ask() - day;
            if(days <= tmp) {
                day += days;
                days = 0;
            }
            else {
                days -= tmp;
                day = 0;
                month ++;
                if(month == 13) {
                    year ++;
                    month = 1;
                }
            }
        }
    }
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    private static boolean pre(MyDate date1, MyDate date2) {
        if(date1.year != date2.year) return date1.year < date2.year;
        if(date1.month != date2.month) return date1.month < date2.month;
        return date1.day < date2.day;
    }
    public static int difference(MyDate d1, MyDate d2) {
        MyDate A = new MyDate(d1.year, d1.month, d1.day);
        MyDate B = new MyDate(d2.year, d2.month, d2.day);
        int ans = 0;
        if(pre(A, B)) {
            while(A.year != B.year || A.month != B.month) {
                ans -= A.Ask() - A.day;
                A.month ++;
                A.day = 0;
                if(A.month == 13) {
                    A.month = 1;
                    A.year ++;
                }
            }
            ans -= B.day - A.day;
        }
        else {
            while(A.year != B.year || A.month != B.month) {
                ans += B.Ask() - B.day;
                B.month ++;
                B.day = 0;
                if(B.month == 13) {
                    B.month = 1;
                    B.year ++;
                }
            }
            ans += A.day - B.day;
        }
        return ans;
    }
}
