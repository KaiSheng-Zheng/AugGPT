public class MyDate {
    private int year;
    private int month;
    private int day;


    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static int difference(MyDate date1, MyDate date2) {
        return findtotaldays(date1) - findtotaldays(date2);
    }

    public static int findtotaldays(MyDate date) {
        int a = 0;
        int b = 0;
        for (int i = 0; i <date.year; i++) {
            if (i % 4 == 0 && i % 100 != 0) {
                if (i == date.year){
                    a=a;
                }else a++;
            }
            if (i % 400 == 0) {
                if (i == date.year){
                    a=a;
                }else a++;
            }
        }
        for (int i = 1; i < date.month; i++) {
            if ((i == 4) || (i == 6) || (i == 9) || (i == 11)) {
                b += 30;
            } else if (i == 2) {
                if (date.year % 4 == 0 && date.year % 100 != 0 ) {
                    b += 29;
                }
                else if (date.year % 400 == 0) {
                    b += 29;
                }else {
                    b += 28;
                }
            } else {
                b += 31;
            }
        }
        return a * 366 + (date.year - a) * 365 + b + date.day;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public void addDays(int days) {
        if (month == 12 && day + days > 31) {
            int c = days - (31 - day);
            month = 1;
            year++;
            findMonth(days, c);
        } else if (month == 12 && day + days <= 31) {
            this.day = day + days;
        }
        if (month == 2) {
            if (year % 4 == 0 && year % 100 != 0 ) {
                shit(days);
            }else if (year % 400 == 0) {
                shit(days);
            }else if (day + days <= 28) {
                this.day = day + days;
            }
            if (day + days > 28) {
                int c = days - (28 - day);
                day = 0;
                findMonth(days, c);
            }
        }
        if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
            if (day + days <= 30) {
                this.day = day + days;
            }
            if (day + days > 30) {
                int c = days - (30 - day);
                month++;
                day = 0;
                findMonth(days, c);
            }
        }
        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)) {
            if (day + days <= 31) {
                this.day = day + days;
            }
            if (day + days > 31) {
                int c = days - (31 - day);
                month++;
                day = 0;
                findMonth(days, c);
            }

        }

    }

    private void shit(int days) {
        if (day + days <= 29) {
            this.day = day + days;
        }
        if (day + days > 29) {
            int c = days - (29 - day);
            day = 0;
            findMonth(days, c);
        }
    }

    private void findMonth(int days, int c) {
        while (c > 0) {
            if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
                if (day + c <= 30) {
                    this.day = day + c;
                    c = 0;
                } else {
                    month++;
                    c -= (30 - day + 1);
                    day = 1;
                }
            } else if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)) {
                if (day + c <= 31) {
                    this.day = day + c;
                    c = 0;
                } else {
                    month++;
                    c -= (31 - day + 1);
                    day = 1;
                }
            } else if (month == 12) {
                if (day + c <= 31) {
                    this.day = day + c;
                    c = 0;
                } else {
                    month = 1;
                    year++;
                    c -= (31 - day + 1);
                    day = 1;
                }
            } else if (month == 2) {
                if (year % 4 == 0 && year % 100 != 0 ) {
                    if (day + c <= 29) {
                        this.day = day + c;
                        c = 0;
                    } else {
                        month++;
                        c -= (29 - day + 1);
                        day = 1;
                    }
                } else if ( year % 400 == 0) {
                    if (day + c <= 29) {
                        this.day = day + c;
                        c = 0;
                    } else {
                        month++;
                        c -= (29 - day + 1);
                        day = 1;
                    }

                } else {
                    if (day + c <= 28) {
                        this.day = day + c;
                        c = 0;
                    } else {
                        month++;
                        c -= (28 - day + 1);
                        day = 1;
                    }
                }
            }
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }
}

