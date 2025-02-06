

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int a, int b, int c) {
        year = a;
        month = b;
        day = c;
    }

    public void addDays(int days) {
        int run;
        int d = days;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            run = 1;
        } else {
            run = 0;
        }
        switch (month) {
            case 1:
                day += d;
                break;
            case 2:
                day += d + 31;
                break;
            case 3:
                day += d + 59 + run;
                break;
            case 4:
                day += d + 90 + run;
                break;
            case 5:
                day += d + 120 + run;
                break;
            case 6:
                day += d + 151 + run;
                break;
            case 7:
                day += d + 181 + run;
                break;
            case 8:
                day += d + 212 + run;
                break;
            case 9:
                day += d + 243 + run;
                break;
            case 10:
                day += d + 273 + run;
                break;
            case 11:
                day += d + 304 + run;
                break;
            case 12:
                day += d + 334 + run;
                break;
        }
        while (day > 365 + run) {
            year += 1;
            if (run == 0) {
                day = day - 365;
            } else {
                day = day - 366;
            }
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                run = 1;
            } else {
                run = 0;
            }
        }
        if (day <= 31) {
            month = 1;
        } else if (day <= 59 + run) {
            month = 2;
            day = day - 31;
        } else if (day <= 90 + run) {
            month = 3;
            day = day - 59 - run;
        } else if (day <= 120 + run) {
            month = 4;
            day = day - 90 - run;
        } else if (day <= 151 + run) {
            month = 5;
            day = day - 120 - run;
        } else if (day <= 181 + run) {
            month = 6;
            day = day - 151 - run;
        } else if (day <= 212 + run) {
            month = 7;
            day = day - 181 - run;
        } else if (day <= 243 + run) {
            month = 8;
            day = day - 212 - run;
        } else if (day <= 273 + run) {
            month = 9;
            day = day - 243 - run;
        } else if (day <= 304 + run) {
            month = 10;
            day = day - 273 - run;
        } else if (day <= 334 + run) {
            month = 11;
            day = day - 304 - run;
        } else {
            month = 12;
            day = day - 334 - run;
        }
    }

    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int run;
        int d1 = date1.day;int d2 = date2.day;
        int fh = date1.year - date2.year;
        if ((date1.year % 4 == 0 && date1.year % 100 != 0) || date1.year % 400 == 0) {
            run = 1;
        } else {
            run = 0;
        }
        switch (date1.month) {
            case 1:
                break;
            case 2:
                d1 += 31;
                break;
            case 3:
                d1 += 59 + run;
                break;
            case 4:
                d1 += 90 + run;
                break;
            case 5:
                d1 += 120 + run;
                break;
            case 6:
                d1 += 151 + run;
                break;
            case 7:
                d1 += 181 + run;
                break;
            case 8:
                d1 += 212 + run;
                break;
            case 9:
                d1 += 243 + run;
                break;
            case 10:
                d1 += 273 + run;
                break;
            case 11:
                d1 += 304 + run;
                break;
            case 12:
                d1 += 334 + run;
                break;
        }
        if ((date2.year % 4 == 0 && date2.year % 100 != 0) || date2.year % 400 == 0) {
            run = 1;
        } else {
            run = 0;
        }
        switch (date2.month) {
            case 1:
                break;
            case 2:
                d2 += 31;
                break;
            case 3:
                d2 += 59 + run;
                break;
            case 4:
                d2 += 90 + run;
                break;
            case 5:
                d2  += 120 + run;
                break;
            case 6:
                d2  += 151 + run;
                break;
            case 7:
                d2  += 181 + run;
                break;
            case 8:
                d2  += 212 + run;
                break;
            case 9:
                d2  += 243 + run;
                break;
            case 10:
                d2  += 273 + run;
                break;
            case 11:
                d2  += 304 + run;
                break;
            case 12:
                d2 += 334 + run;
                break;
        }
        int x = d1-d2;
        if (fh > 0) {
            for (int i = 1; i <= fh; i++) {
                x += 365 + run;
                if (((date2.year + i) % 4 == 0 && (date2.year + i) % 100 != 0) || (date2.year + i) % 400 == 0) {
                    run = 1;
                } else {
                    run = 0;
                }
            }
        }
        if (fh < 0) {
            for (int i = 1; i <= -fh; i++) {
                x -= 365 + run;
                if (((date1.year + i) % 4 == 0 && (date1.year + i) % 100 != 0) || (date1.year + i) % 400 == 0) {
                    run = 1;
                } else {
                    run = 0;
                }
            }
        }
        return x;
    }
}
