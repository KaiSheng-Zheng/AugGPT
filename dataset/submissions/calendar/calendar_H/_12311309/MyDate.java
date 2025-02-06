public class MyDate {
    private int year;
    private int month;
    private int day;
    private int total;

    public int calculate(int year, int month, int day) {
        int n = 0;
        for (int i = 1; i < year; i++) {
            if (i % 400 == 0)
                n += 366;
            else if (i % 100 == 0)
                n += 365;
            else if (i % 4 == 0)
                n += 366;
            else n += 365;
        }
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10)
                n += 31;
            else if (i == 2 && year % 400 == 0)
                n += 29;
            else if (i == 2 && year % 100 == 0)
                n += 28;
            else if (i == 2 && year % 4 == 0)
                n += 29;
            else if (i == 2)
                n += 28;
            else n += 30;
        }
        n += day;
        return n;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.total = calculate(year, month, day);
    }

    public void addDays(int days) {
        total += days;
        int total1 = total;
        int counter1 = 1;
        int counter2 = 1;
        while (total1 > 366) {
            if (counter1 % 400 == 0) {
                total1 -= 366;
            } else if (counter1 % 100 == 0) {
                total1 -= 365;
            } else if (counter1 % 4 == 0) {
                total1 -= 366;
            } else {
                total1 -= 365;
            }
            counter1 += 1;
        }
        while (total1 == 366) {
            if (counter1 % 400 == 0) {
                year = counter1;
                month = 12;
                day = 31;
                total1 = -1;
            } else if (counter1 % 100 == 0) {
                counter1 += 1;
                total1 -= 365;
            } else if (counter1 % 4 == 0) {
                year = counter1;
                month = 12;
                day = 31;
                total1 = -1;
            } else {
                counter1 += 1;
                total1 -= 365;
            }
        }
        while (total1 <= 365 && total1 > 31) {
            if (counter2 == 1 || counter2 == 3 || counter2 == 5 || counter2 == 7 || counter2 == 8 || counter2 == 10) {
                total1 -= 31;
            } else if (counter2 == 2 && counter1 % 400 == 0) {
                total1 -= 29;
            } else if (counter2 == 2 && counter1 % 100 == 0) {
                total1 -= 28;
            } else if (counter2 == 2 && counter1 % 4 == 0) {
                total1 -= 29;
            } else if (counter2 == 2) {
                total1 -= 28;
            } else {
                total1 -= 30;
            }
            counter2 += 1;
        }
        while (total1 == 31) {
            if (counter2 == 1 || counter2 == 3 || counter2 == 5 || counter2 == 7 || counter2 == 8 || counter2 == 10 || counter2 == 12) {
                year = counter1;
                month = counter2;
                day = 31;
                total1 = -1;
            } else if (counter2 == 2 && counter1 % 400 == 0) {
                total1 -= 29;
                counter2 += 1;
            } else if (counter2 == 2 && counter1 % 100 == 0) {
                total1 -= 28;
                counter2 += 1;
            } else if (counter2 == 2 && counter1 % 4 == 0) {
                total1 -= 29;
                counter2 += 1;
            } else if (counter2 == 2) {
                total1 -= 28;
                counter2 += 1;
            } else {
                total1 -= 30;
                counter2 += 1;
            }
        }
        while (total1 == 30) {
            if (counter2 == 1 || counter2 == 3 || counter2 == 5 || counter2 == 7 || counter2 == 8 || counter2 == 10 || counter2 == 12) {
                year = counter1;
                month = counter2;
                day = 30;
                total1 = -1;
            } else if (counter2 == 2 && counter1 % 400 == 0) {
                total1 -= 29;
                counter2 += 1;
            } else if (counter2 == 2 && counter1 % 100 == 0) {
                total1 -= 28;
                counter2 += 1;
            } else if (counter2 == 2 && counter1 % 4 == 0) {
                total1 -= 29;
                counter2 += 1;
            } else if (counter2 == 2) {
                total1 -= 28;
                counter2 += 1;
            } else {
                year = counter1;
                month = counter2;
                day = 30;
                total1 = -1;
            }
        }
        while (total1 == 29) {
            if (counter2 == 2 && counter1 % 400 == 0) {
                year = counter1;
                month = counter2;
                day = 29;
                total1 = -1;
            } else if (counter2 == 2 && counter1 % 100 == 0) {
                total1 -= 28;
                counter2 += 1;
            } else if (counter2 == 2 && counter1 % 4 == 0) {
                year = counter1;
                month = counter2;
                day = 29;
                total1 = -1;
            } else if (counter2 == 2) {
                total1 -= 28;
                counter2 += 1;
            } else {
                this.year = counter1;
                month = counter2;
                day = 29;
                total1 = -1;
            }
        }
        while (total1 <= 28 && total1 > 0) {
            year = counter1;
            month = counter2;
            day = total1;
            total1 = -1;
        }
    }

    public static int difference(MyDate date1, MyDate date2) {
        int n1 = date1.calculate(date1.getYear(), date1.getMonth(), date1.getDay());
        int n2 = date2.calculate(date2.getYear(), date2.getMonth(), date2.getDay());
        return n1 - n2;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);

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

    public int getTotal() {
        return total;
    }
}
