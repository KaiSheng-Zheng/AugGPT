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
        for (int i = 0; i < days; i++) {
            if ((this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0) {
                switch (this.month) {
                    case 1, 3, 5, 7, 8, 10 -> {
                        if (this.day + 1 > 31) {
                            this.month++;
                            this.day = 1;
                        } else
                            this.day++;
                    }
                    case 4, 6, 9, 11 -> {
                        if (this.day + 1 > 30) {
                            this.month++;
                            this.day = 1;
                        } else
                            this.day++;
                    }
                    case 2 -> {
                        if (this.day + 1 > 29) {
                            this.month++;
                            this.day = 1;
                        } else
                            this.day++;
                    }
                    case 12 -> {
                        if (this.day + 1 > 31) {
                            this.year++;
                            this.month = 1;
                            this.day = 1;
                        } else
                            this.day++;
                    }
                    default -> {
                    }
                }
            } else {
                switch (this.month) {
                    case 1, 3, 5, 7, 8, 10 -> {
                        if (this.day + 1 > 31) {
                            this.month++;
                            this.day = 1;
                        } else
                            this.day++;
                    }
                    case 4, 6, 9, 11 -> {
                        if (this.day + 1 > 30) {
                            this.month++;
                            this.day = 1;
                        } else
                            this.day++;
                    }
                    case 2 -> {
                        if (this.day + 1 > 28) {
                            this.month++;
                            this.day = 1;
                        } else
                            this.day++;
                    }
                    case 12 -> {
                        if (this.day + 1 > 31) {
                            this.year++;
                            this.month = 1;
                            this.day = 1;
                        } else
                            this.day++;
                    }
                    default -> {
                    }
                }
            }
        }
    }

    public static int difference(MyDate date1, MyDate date2) {
        int sum1 = 0, sum2 = 0;
        int[] monthTableRun = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] monthTablePin = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] yearTable = new int[10000];
        for (int i = 0; i < 10000; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
                yearTable[i] = 366;
            else
                yearTable[i] = 365;
        }
        if (yearTable[date1.year] == 366 && yearTable[date2.year] == 366) {
            for (int i = 0; i < date1.month - 1; i++) {
                sum1 += monthTableRun[i];
            }
            sum1 += date1.day;
            for (int i = 0; i < date2.month - 1; i++) {
                sum2 += monthTableRun[i];
            }
            sum2 += date2.day;
        }
        if (yearTable[date1.year] == 365 && yearTable[date2.year] == 366) {
            for (int i = 0; i < date1.month - 1; i++) {
                sum1 += monthTablePin[i];
            }
            sum1 += date1.day;
            for (int i = 0; i < date2.month - 1; i++) {
                sum2 += monthTableRun[i];
            }
            sum2 += date2.day;
        }
        if (yearTable[date1.year] == 366 && yearTable[date2.year] == 365) {
            for (int i = 0; i < date1.month - 1; i++) {
                sum1 += monthTableRun[i];
            }
            sum1 += date1.day;
            for (int i = 0; i < date2.month - 1; i++) {
                sum2 += monthTablePin[i];
            }
            sum2 += date2.day;
        }
        if (yearTable[date1.year] == 365 && yearTable[date2.year] == 365) {
            for (int i = 0; i < date1.month - 1; i++) {
                sum1 += monthTablePin[i];
            }
            sum1 += date1.day;
            for (int i = 0; i < date2.month - 1; i++) {
                sum2 += monthTablePin[i];
            }
            sum2 += date2.day;
        }
        for (int i = 0; i < date1.year - 1; i++) {
            sum1 += yearTable[i];
        }
        for (int i = 0; i < date2.year - 1; i++) {
            sum2 += yearTable[i];
        }
        return (sum1 - sum2);
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

    public String toString() {
        if (this.day >= 10 && this.month >= 10)
            return "" + this.year + "-" + this.month + "-" + this.day + "";
        if (this.day < 10 && this.month >= 10)
            return "" + this.year + "-" + this.month + "-0" + this.day + "";
        if (this.day < 10 && this.month < 10)
            return "" + this.year + "-0" + this.month + "-0" + this.day + "";
        if (this.day >= 10 && this.month < 10)
            return "" + this.year + "-0" + this.month + "-" + this.day + "";
        return null;
    }
}
