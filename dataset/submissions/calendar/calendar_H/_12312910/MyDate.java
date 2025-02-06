public class MyDate {
    private int year;
    private int month;
    private int day;
    private String eventName;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate(int year, int month, int day, String eventName) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.eventName = eventName;
    }

    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    public String getEventName() {
        return eventName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            this.day++;
            if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
                if (this.day > 31) {
                    this.month++;
                    this.day -= 31;
                }
            } else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
                if (this.day > 30) {
                    this.month++;
                    this.day -= 30;
                }
            } else if (this.month == 2) {
                if (this.year % 400 == 0 || (this.year % 4 == 0 && this.year % 100 != 0)) {
                    if (this.day > 29) {
                        this.month++;
                        this.day -= 29;
                    }
                } else {
                    if (this.day > 28) {
                        this.month++;
                        this.day -= 28;
                    }
                }
            }
            if (this.month > 12) {
                this.year++;
                this.month -= 12;
            }
        }
    }

    @Override
    public String toString() {
        if (this.month >= 10 && this.day >= 10) {
            return (this.year + "-" + this.month + "-" + this.day);
        } else if (this.month >= 10 && this.day < 10) {
            return (this.year + "-" + this.month + "-0" + this.day);
        } else if (this.month < 10 && this.day >= 10) {
            return (this.year + "-0" + this.month + "-" + this.day);
        } else {
            return (this.year + "-0" + this.month + "-0" + this.day);
        }
    }

    public static int difference(MyDate date1, MyDate date2) {
        int day1 = 0;
        int day2 = 0;
        for (int i = 0; i < date1.getYear(); i++) {
            if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                day1 += 366;
            } else {
                day1 += 365;
            }
        }
        for (int i = 0; i < date2.getYear(); i++) {
            if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                day2 += 366;
            } else {
                day2 += 365;
            }
        }
        for (int i = 0; i < date1.getMonth(); i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                day1 += 31;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                day1 += 30;
            } else if (i == 2) {
                if (date1.getYear() % 400 == 0 || (date1.getYear() % 4 == 0 && date1.getYear() % 100 != 0)) {
                    day1 += 29;
                } else {
                    day1 += 28;
                }
            }
        }
        for (int i = 0; i < date2.getMonth(); i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                day2 += 31;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                day2 += 30;
            } else if (i == 2) {
                if (date2.getYear() % 400 == 0 || (date2.getYear() % 4 == 0 && date2.getYear() % 100 != 0)) {
                    day2 += 29;
                } else {
                    day2 += 28;
                }
            }
        }
        day1 += date1.getDay();
        day2 += date2.getDay();
        return day1 - day2;
    }

}