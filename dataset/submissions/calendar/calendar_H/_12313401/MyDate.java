public class MyDate {
    private int year;
    private int month;
    private int day;


    public MyDate(int year, int month, int day) {
        this.day = day;
        this.year = year;
        this.month = month;

    }

    public void addDays(int day) {
        for (int i = day; i != 0; ) {
            switch (this.month) {
                case 1, 3, 5, 7, 8, 10, 12:
                    i--;
                    this.day++;
                    if (this.day > 31) {
                        this.day -= 31;
                        this.month += 1;
                        if (this.month > 12) {
                            this.month -= 12;
                            this.year += 1;
                        }
                    }
                    break;
                case 2:
                    i--;
                    this.day++;
                    if (this.day > 28 + Y(this.year)) {
                        this.day -= 28 + Y(this.year);
                        this.month += 1;
                    }
                    break;
                case 4, 6, 9, 11:
                    i--;
                    this.day++;
                    if (this.day > 30) {
                        this.day -= 30;
                        this.month += 1;
                    }
                    break;
            }
        }

    }

    public static int Y(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return 1;
                } else return 0;
            } else return 1;
        } else return 0;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public MyDate copy() {
        return new MyDate(this.year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        MyDate Date1 = date1.copy();
        MyDate Date2 = date2.copy();
        int s = 0;
        MyDate Date3 = new MyDate(Date1.year, 1, 1);
        int s1 = 0;
        MyDate Date4 = new MyDate(Date2.year, 1, 1);
        int s2 = 0;
        for (int i = 0; Date1.toString().compareTo(Date3.toString()) != 0; i++) {
            Date3.addDays(1);
            s1 = i + 1;
        }
        for (int i = 0; Date4.toString().compareTo(Date2.toString()) != 0; i++) {
            Date4.addDays(1);
            s2 = i + 1;
        }
        if (Date2.year > Date1.year) {
            for (int i = Date1.year; i < Date2.year; i++) {
                Date1.year++;
                s -= Y(i) + 365;
            }
        } else {
            for (int i = Date2.year; i < Date1.year; i++) {
                Date2.year++;
                s += Y(i) + 365;
            }
        }
        return s + (s1 - s2);
    }
}
