public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            day++;
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
                if (day >31) {
                    month++;
                    day = 1;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day>30) {
                    month++;
                    day = 1;
                }
            } else if (month == 2)
            {
                if ((year % 4 == 0 && year % 100 != 0)||(year % 400 == 0))
                {
                    if (day >29) {
                        month++;
                        day = 1;
                    }
                }
             else {
                    if (day >28) {
                        month++;
                        day = 1;
                    }
                }
            } else if (month == 12 && day >31) {
                year++;
                month = 1;
                day = 1;
            }
        }
    }

    public String toString() {
        return String.format("%4d", year) + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
    }

    public String str() {
        return String.format("%4d", year) + String.format("%02d", month) + String.format("%02d", day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        boolean da2 = true;
        if (date1.year == date2.year) {
            if (date1.month == date2.month) {
                if (date1.day == date2.day) return 0;
                else if (date1.day > date2.day) da2 =false;
            } else if (date1.month > date2.month) da2 = false;
        } else if (date1.year > date2.year) da2 = false;
        if (da2) {
            int year = date1.year;
            int month = date1.month;
            int day = date1.day;
            int t = 0;
            while (true) {
                if (year == date2.year && month == date2.month && day == date2.day) {
                    return -t;
                }
                t++;
                day++;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
                    if (day >31) {
                        month++;
                        day = 1;
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day>30) {
                        month++;
                        day = 1;
                    }
                } else if (month == 2)
                {
                    if ((year % 4 == 0 && year % 100 != 0)||(year % 400 == 0))
                    {
                        if (day >29) {
                            month++;
                            day = 1;
                        }
                    }
                    else {
                        if (day >28) {
                            month++;
                            day = 1;
                        }
                    }
                } else if (month == 12 && day >31) {
                    year++;
                    month = 1;
                    day = 1;
                }
            }
        } else {
            int year = date2.year;
            int month = date2.month;
            int day = date2.day;
            int t = 0;
            while (true) {
                if (year == date1.year && month == date1.month && day == date1.day) {
                    return t;
                }
                t++;
                day++;
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
                    if (day >31) {
                        month++;
                        day = 1;
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day>30) {
                        month++;
                        day = 1;
                    }
                } else if (month == 2)
                {
                    if ((year % 4 == 0 && year % 100 != 0)||(year % 400 == 0))
                    {
                        if (day >29) {
                            month++;
                            day = 1;
                        }
                    }
                    else {
                        if (day >28) {
                            month++;
                            day = 1;
                        }
                    }
                } else if (month == 12 && day >31) {
                    year++;
                    month = 1;
                    day = 1;
                }
            }
        }
    }
}