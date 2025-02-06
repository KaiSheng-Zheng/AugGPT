public class MyDate {
    public int year;
    public int month;
    public int day;
    public MyDate (int y, int m, int d){
        year = y;
        month = m;
        day = d;
    }
    public void addDays (int ds) {
        for (int i = 1; i <= ds; i++) {
            if (month > 12) {
                month = 1;
                year++;
            }
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day + 1 > 31) {
                    month++;
                    day = 1;
                    continue;
                }
                else {
                    day++;
                    continue;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day + 1 > 30) {
                    month++;
                    day = 1;
                    continue;
                }
                else {
                    day++;
                    continue;
                }
            } else {
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    if (day + 1 > 29) {
                        month++;
                        day = 1;
                        continue;
                    }
                    else {
                        day++;
                        continue;
                    }
                } else {
                    if (day + 1 > 28) {
                        month++;
                        day = 1;
                        continue;
                    }
                    else {
                        day++;
                        continue;
                    }
                }
            }
        }
    }
    public String toString () {
        if (month > 9) {
            if (day > 9)
                return (year + "-" + month + "-" + day);
            else
                return (year + "-" + month + "-0" + day);
        }
        else {
            if (day > 9)
                return (year + "-0" + month + "-" + day);
            else
                return (year + "-0" + month + "-0" + day);
        }
    }
    public static int difference (MyDate date1, MyDate date2) {
        boolean pd = false;
        if (date1.year > date2.year)
            pd = true;
        else if (date1.year == date2.year && date1.month > date2.month)
            pd = true;
        else if (date1.year == date2.year && date1.month == date2.month && date1.day > date2.day)
            pd = true;
        //System.out.println(pd);
        if (pd) {
            int m = date2.month;
            int y = date2.year;
            int d = date2.day;
            int cnt = 0;
            while (true) {
                if (m > 12) {
                    m = 1;
                    y++;
                }
                if (m == date1.month && y == date1.year && d == date1.day)
                    break;
                if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                    if (d + 1 > 31) {
                        m++;
                        d = 1;
                        cnt++;
                        continue;
                    }
                    else {
                        d++;
                        cnt++;
                        continue;
                    }
                } else if (m == 4 || m == 6 || m == 9 || m == 11) {
                    if (d + 1 > 30) {
                        m++;
                        d = 1;
                        cnt++;
                        continue;
                    }
                    else {
                        d++;
                        cnt++;
                        continue;
                    }
                } else {
                    if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
                        if (d + 1 > 29) {
                            m++;
                            d = 1;
                            cnt++;
                            continue;
                        }
                        else {
                            d++;
                            cnt++;
                            continue;
                        }
                    } else {
                        if (d + 1 > 28) {
                            m++;
                            d = 1;
                            cnt++;
                            continue;
                        }
                        else {
                            d++;
                            cnt++;
                            continue;
                        }
                    }
                }
            }
            return cnt;
        }
        else {
            int m = date1.month;
            int y = date1.year;
            int d = date1.day;
            int cnt = 0;
            while (true) {
                if (m > 12) {
                    m = 1;
                    y++;
                }
                if (m == date2.month && y == date2.year && d == date2.day)
                    break;
                if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                    if (d + 1 > 31) {
                        m++;
                        d = 1;
                        cnt++;
                        continue;
                    }
                    else {
                        d++;
                        cnt++;
                        continue;
                    }
                } else if (m == 4 || m == 6 || m == 9 || m == 11) {
                    if (d + 1 > 30) {
                        m++;
                        d = 1;
                        cnt++;
                        continue;
                    }
                    else {
                        d++;
                        cnt++;
                        continue;
                    }
                } else {
                    if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
                        if (d + 1 > 29) {
                            m++;
                            d = 1;
                            cnt++;
                            continue;
                        }
                        else {
                            d++;
                            cnt++;
                            continue;
                        }
                    } else {
                        if (d + 1 > 28) {
                            m++;
                            d = 1;
                            cnt++;
                            continue;
                        }
                        else {
                            d++;
                            cnt++;
                            continue;
                        }
                    }
                }
            }
            return -cnt;
        }
    }
}