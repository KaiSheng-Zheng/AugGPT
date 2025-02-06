public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public void addDays(int dayIn) {
        /*
        // Create a MyDate object for the boundary date
        MyDate date = new MyDate(2024, 12, 31);

        // Add 1 day (should roll over to next year)
        date.addDays(1);

        incorrect output: 2024-13-01
         */
        int year = this.year;
        int month = this.month;
        int day = this.day;
        while (dayIn > 0) {
            dayIn--;
            day++;
            if (month > 12) {
                month = 1;
                year++;
            }
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day > 31) {
                    day = 1;
                    month++;
                }
            } else if (month == 2) {
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    if (day > 29) {
                        day = 1;
                        month++;
                    }
                } else {
                    if (day > 28) {
                        day = 1;
                        month++;
                    }
                }

            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day > 30) {
                    day = 1;
                    month++;
                }
            }
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toString() {
        return String.format("%02d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {

        int y1 = date1.getYear();
        int y2 = date2.getYear();
        int m1 = date1.getMonth();
        int m2 = date2.getMonth();
        int d1 = date1.getDay();
        int d2 = date2.getDay();

        int differ = 0;

        while ((y1 != y2) || (m1 != m2) || (d1 != d2)) {

            if (y1 > y2 || ((y1 == y2) && (m1 > m2)) || ((y1 == y2) && (m1 == m2) && (d1 >= d2))) {
                differ++;
                d2++;
                switch (m2) {
                    case 1, 3, 5, 7, 8, 10, 12 -> {
                        if (d2 > 31) {
                            d2 = 1;
                            m2++;
                        }
                    }
                    case 2 -> {
                        if ((y2 % 4 == 0 && y2 % 100 != 0) || (y2 % 400 == 0)) {
                            if (d2 > 29) {
                                d2 = 1;
                                m2++;
                            }
                        } else {
                            if (d2 > 28) {
                                d2 = 1;
                                m2++;
                            }
                        }
                    }
                    case 4, 6, 9, 11 -> {
                        if (d2 > 30) {
                            d2 = 1;
                            m2++;
                        }
                    }
                }
                if (m2 > 12) {
                    m2 = 1;
                    y2++;
                }
            } else {
                differ--;
                d1++;
                switch (m1) {
                    case 1, 3, 5, 7, 8, 10, 12 -> {
                        if (d1 > 31) {
                            d1 = 1;
                            m1++;
                        }
                    }
                    case 2 -> {
                        if ((y1 % 4 == 0 && y1 % 100 != 0) || (y1 % 400 == 0)) {
                            if (d1 > 29) {
                                d1 = 1;
                                m1++;
                            }
                        } else {
                            if (d1 > 28) {
                                d1 = 1;
                                m1++;
                            }
                        }
                    }
                    case 4, 6, 9, 11 -> {
                        if (d1 > 30) {
                            d1 = 1;
                            m1++;
                        }
                    }
                }
                if (m1 > 12) {
                    m1 = 1;
                    y1++;
                }
            }

        }
        return differ;
    }

}