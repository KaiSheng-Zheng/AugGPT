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
        MyDate initialDate = new MyDate(this.year, this.month, this.day);
        MyDate judgeDate = new MyDate(this.year + 1, 1, 1);
        if (difference(judgeDate, initialDate) <= days) {
            days = days - difference(judgeDate, initialDate);
            initialDate = judgeDate;
        }

        int leapYear = 0;
        boolean judge = true;
        while (judge == true) {
            judge = false;
            leapYear = 0;
            if ((initialDate.year % 400 == 0) || (initialDate.year % 4 == 0 && initialDate.year % 100 != 0)) {
                leapYear = 1;
            }

            if (leapYear == 1) {
                if (days >= 366) {
                    initialDate.year++;
                    days = days - 366;
                    judge = true;
                }
            } else {
                if (days >= 365) {
                    initialDate.year++;
                    days = days - 365;
                    judge = true;
                }
            }
        }

        judgeDate.year = initialDate.year;
        judgeDate.month = initialDate.month + 1;
        judgeDate.month = 1;
        if (difference(judgeDate, initialDate) <= days) {
            days = days - difference(judgeDate, initialDate);
            initialDate = judgeDate;
        }

        int count = 1;
        while (days > 0) {
            switch (count) {
                case 1:
                    if (days >= 31) {
                        initialDate.month++;
                        days = days - 31;
                        break;
                    } else {
                        initialDate.day = initialDate.day + days;
                        days = 0;
                        if (initialDate.day > 31) {
                            initialDate.day = initialDate.day - 31;
                            initialDate.month++;
                        }
                        break;
                    }
                case 2:
                    if (days >= 29 && leapYear == 1) {
                        initialDate.month++;
                        days = days - 29;
                        break;
                    } else if (days >= 28 && leapYear == 0) {
                        initialDate.month++;
                        days = days - 28;
                        break;
                    } else {
                        initialDate.day = initialDate.day + days;
                        days = 0;
                        if (initialDate.day > 29 && leapYear == 1) {
                            initialDate.day = initialDate.day - 29;
                            initialDate.month++;
                        } else if (initialDate.day > 28 && leapYear == 0) {
                            initialDate.day = initialDate.day - 28;
                            initialDate.month++;
                        }
                        break;
                    }
                case 3:
                    if (days >= 31) {
                        initialDate.month++;
                        days = days - 31;
                        break;
                    } else {
                        initialDate.day = initialDate.day + days;
                        days = 0;
                        if (initialDate.day > 31) {
                            initialDate.day = initialDate.day - 31;
                            initialDate.month++;
                        }
                        break;
                    }
                case 4:
                    if (days >= 30) {
                        initialDate.month++;
                        days = days - 30;
                        break;
                    } else {
                        initialDate.day = initialDate.day + days;
                        days = 0;
                        if (initialDate.day > 30) {
                            initialDate.day = initialDate.day - 30;
                            initialDate.month++;
                        }
                        break;
                    }
                case 5:
                    if (days >= 31) {
                        initialDate.month++;
                        days = days - 31;
                        break;
                    } else {
                        initialDate.day = initialDate.day + days;
                        days = 0;
                        if (initialDate.day > 31) {
                            initialDate.day = initialDate.day - 31;
                            initialDate.month++;
                        }
                        break;
                    }
                case 6:
                    if (days >= 30) {
                        initialDate.month++;
                        days = days - 30;
                        break;
                    } else {
                        initialDate.day = initialDate.day + days;
                        days = 0;
                        if (initialDate.day > 30) {
                            initialDate.day = initialDate.day - 30;
                            initialDate.month++;
                        }
                        break;
                    }
                case 7:
                    if (days >= 31) {
                        initialDate.month++;
                        days = days - 31;
                        break;
                    } else {
                        initialDate.day = initialDate.day + days;
                        days = 0;
                        if (initialDate.day > 31) {
                            initialDate.day = initialDate.day - 31;
                            initialDate.month++;
                        }
                        break;
                    }
                case 8:
                    if (days >= 31) {
                        initialDate.month++;
                        days = days - 31;
                        break;
                    } else {
                        initialDate.day = initialDate.day + days;
                        days = 0;
                        if (initialDate.day > 31) {
                            initialDate.day = initialDate.day - 31;
                            initialDate.month++;
                        }
                        break;
                    }
                case 9:
                    if (days >= 30) {
                        initialDate.month++;
                        days = days - 30;
                        break;
                    } else {
                        initialDate.day = initialDate.day + days;
                        days = 0;
                        if (initialDate.day > 30) {
                            initialDate.day = initialDate.day - 30;
                            initialDate.month++;
                        }
                        break;
                    }
                case 10:
                    if (days >= 31) {
                        initialDate.month++;
                        days = days - 31;
                        break;
                    } else {
                        initialDate.day = initialDate.day + days;
                        days = 0;
                        if (initialDate.day > 31) {
                            initialDate.day = initialDate.day - 31;
                            initialDate.month++;
                        }
                        break;
                    }
                case 11:
                    if (days >= 30) {
                        initialDate.month++;
                        days = days - 30;
                        break;
                    } else {
                        initialDate.day = initialDate.day + days;
                        days = 0;
                        if (initialDate.day > 30) {
                            initialDate.day = initialDate.day - 30;
                            initialDate.month++;
                        }
                        break;
                    }
                case 12:
                    initialDate.day = initialDate.day + days;
                    days = 0;
                    break;
            }
            count++;
        }

        this.year = initialDate.year;
        this.month = initialDate.month;
        this.day = initialDate.day;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int days1 = calculateDays(date1);
        int days2 = calculateDays(date2);
        return days1 - days2;
    }

    public static int calculateDays(MyDate date) {
        int days = (date.year - 1) * 365 + (date.year - 1) / 4 - (date.year - 1) / 100 + (date.year - 1) / 400;
        switch (date.month) {
            case 1:
                days = days + date.day;
                break;
            case 2:
                days = days + 31 + date.day;
                break;
            case 3:
                days = days + 59 + date.day;
                break;
            case 4:
                days = days + 90 + date.day;
                break;
            case 5:
                days = days + 120 + date.day;
                break;
            case 6:
                days = days + 151 + date.day;
                break;
            case 7:
                days = days + 181 + date.day;
                break;
            case 8:
                days = days + 212 + date.day;
                break;
            case 9:
                days = days + 243 + date.day;
                break;
            case 10:
                days = days + 273 + date.day;
                break;
            case 11:
                days = days + 304 + date.day;
                break;
            case 12:
                days = days + 334 + date.day;
                break;
        }

        if (date.year % 400 == 0 && date.month > 2) {
            days = days + 1;
        } else if (date.year % 4 == 0 && date.year % 100 != 0 && date.month > 2) {
            days = days + 1;
        }
        return days;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}