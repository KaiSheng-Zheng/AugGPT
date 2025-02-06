

import java.util.*;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void addDays(int days) {
        int yea = getYear(), mon = getMonth(), sum = getDay();
        int[] monthday = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean flag = true;
        if (yea % 4 == 0 && yea % 100 != 0 || yea % 400 == 0)
            monthday[2] = 29;
        else {
            flag = false;
            monthday[2] = 28;
        }
        for (int i = 1; i < mon; i++) {
            sum += monthday[i];
        }
        int a = sum + days;
        int counter = 0;
        if (!flag && sum + days > 365 || flag && sum + days > 366) {
            
            boolean flagg = true;
            while (flagg && a > 366 || !flagg && a > 365) {
                if ((year + counter) % 4 == 0 && (year + counter) % 100 != 0 || (year + counter) % 400 == 0) {
                    if (a > 366) {
                        a -= 366;
                        counter++;
                    } else
                        break;

                } else {
                    flagg = false;
                    a -= 365;
                    counter++;
                }
            }
        }
        if (flag && a<= 366) {
            for (int i = 1; i <= 12; i++) {
                if (a > monthday[i]) {
                    a -= monthday[i];
                } else {
                    year+=counter;
                    day = a;
                    month = i;
                    break;
                }
            }
        }
        if (!flag && a<= 365) {
            for (int i = 1; i <= 12; i++) {
                if (a > monthday[i]) {
                    a -= monthday[i];
                } else {
                    year+=counter;
                    day = a;
                    month = i;
                    break;
                }
            }
        }
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int cha, a = 0, days = 0, b = 0, startday = date1.day, endday = date2.day;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(28);
        list.add(29);
        list.add(30);
        list.add(31);
        for (int i = Math.min(date1.year, date2.year); i < Math.max(date1.year, date2.year); i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                days += 366;
            } else
                days += 365;
        }
        for (int i = 1; i < date1.month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                a = list.get(3);
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                a = list.get(2);
            } else if (i == 2) {
                if (date1.year % 4 == 0 && date1.year % 100 != 0 || date1.year % 400 == 0) {
                    a = list.get(1);
                } else {
                    a = list.get(0);
                }
            }
            startday += a;
        }
        for (int i = 1; i < date2.month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                b = list.get(3);
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                b = list.get(2);
            } else if (i == 2) {
                if (date2.year % 4 == 0 && date2.year % 100 != 0 || date2.year % 400 == 0) {
                    b = list.get(1);
                } else {
                    b = list.get(0);
                }
            }
            endday += b;
        }
        if (date1.year < date2.year) {
            cha = -(days - startday + endday);
        } else if (date1.year > date2.year) {
            cha = days + startday - endday;
        } else {
            if (date1.month > date2.month) {
                cha = days + startday - endday;
            } else if (date1.month < date2.month) {
                cha = -(days - startday + endday);
            } else {
                if (date1.day > date2.day)
                    cha = date1.day - date2.day;
                else
                    cha = -date1.day + date2.day;
            }
        }
        return cha;
    }

}
