public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        this.day += days;
        while (day > 365) {
            if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month <= 2) {
                year++;
                day -= 366;
            } else {
                year++;
                if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month > 2) {
                    day -= 366;
                } else {
                    day -= 365;
                }
            }
        /*    for (int i = 1; i < (days / 365) - 1; i++) {
                if (((year % 4 == 0 && year % 100 != 0 || year % 400 == 0))) {
                    year++;
                    day -= 366;
                } else year++;
                day -= 365;
            }
            if ((((year + days / 365) % 4 == 0 && (year + days / 365) % 100 != 0 || (year + days / 365) % 400 == 0)) || month > 2) {
                year++;
                day -= 366;
            } else {
                year++;
                day -= 365;
            }*/
        }
        int this_month;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            this_month = 30;
        } else if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month == 2) {
            this_month = 29;
        } else if (!(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month == 2) {
            this_month = 28;
        } else {
            this_month = 31;
        }
        while (day >= this_month) {
            month++;
            day -= this_month;
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                this_month = 30;
            } else if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month == 2) {
                this_month = 29;
            } else if (!(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month == 2) {
                this_month = 28;
            } else {
                this_month = 31;
            }
        }
    }

    public String toString() {
        return String.format("%04d-%02d-%02d",year ,month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int ans = 0;
        MyDate date3 = new MyDate(date1.year, date1.month, date1.day);
        MyDate date4 = new MyDate(date2.year, date2.month, date2.day);
        while (date3.year > date4.year) {
            if ((date4.year % 4 == 0 && date4.year % 100 != 0 || date4.year % 400 == 0) && date4.month <= 2) {
                date4.year++;
                ans += 366;
            } else {
                date4.year++;
                if ((date4.year % 4 == 0 && date4.year % 100 != 0 || date4.year % 400 == 0) && date4.month > 2) {
                    ans += 366;
                } else {
                    ans += 365;
                }
            }
        }
        while (date3.year < date4.year) {
            if ((date3.year % 4 == 0 && date3.year % 100 != 0 || date3.year % 400 == 0) && date3.month <= 2) {
                date3.year++;
                ans -= 366;
            } else {
                date3.year++;
                if ((date3.year % 4 == 0 && date3.year % 100 != 0 || date3.year % 400 == 0) && date3.month > 2) {
                    ans -= 366;
                } else {
                    ans -= 365;
                }
            }
        }
        while (date3.month > date4.month) {
            int this_month;
            if (date4.month == 4 || date4.month == 6 || date4.month == 9 || date4.month == 11) {
                this_month = 30;
            } else if ((date4.year % 4 == 0 && date4.year % 100 != 0 || date4.year % 400 == 0) && date4.month == 2) {
                this_month = 29;
            } else if (!(date4.year % 4 == 0 && date4.year % 100 != 0 || date4.year % 400 == 0) && date4.month == 2) {
                this_month = 28;
            } else {
                this_month = 31;
            }
            date4.month++;
            ans += this_month;
        }
        while (date3.month < date4.month) {
            int this_month;
            if (date3.month == 4 || date3.month == 6 || date3.month == 9 || date3.month == 11) {
                this_month = 30;
            } else if ((date3.year % 4 == 0 && date3.year % 100 != 0 || date3.year % 400 == 0) && date3.month == 2) {
                this_month = 29;
            } else if (!(date3.year % 4 == 0 && date3.year % 100 != 0 || date3.year % 400 == 0) && date3.month == 2) {
                this_month = 28;
            } else {
                this_month = 31;
            }
            date3.month++;
            ans -= this_month;
        }
        ans += date3.day - date4.day;
        return ans;
    }
}
