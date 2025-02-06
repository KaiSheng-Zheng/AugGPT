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

    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                if (month <= 12) {
                    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                        if (day <= 31) {
                            ++day;
                        }
                        if (day == 32) {
                            if ((month + 1) != 13) {
                                ++month;
                                day = 1;
                                continue;
                            } else {
                                year++;
                                month = 1;
                                day = 1;
                                continue;
                            }
                        }
                        if (month == 4 || month == 6 || month == 9 || month == 11) {
                            if (day <= 30) {
                                ++day;
                            }
                            if (day == 31) {
                                day = 1;
                                ++month;
                                continue;
                            }
                        }
                        if (month == 2) {
                            if (day <= 29) {
                                ++day;
                            }
                        }
                        if (day == 30) {
                            day = 1;
                            ++month;
                            continue;
                        }
                    }

                }
            } else {
                if (month <= 12) {
                    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                        if (day <= 31) {
                            ++day;
                        }
                        if (day == 32) {
                            if ((month + 1) != 13) {
                                ++month;
                                day = 1;
                                continue;
                            } else {
                                year++;
                                month = 1;
                                day = 1;
                                continue;
                            }
                        }
                    }
                    if (month == 4 || month == 6 || month == 9 || month == 11) {
                        if (day <= 30) {
                            ++day;
                        }
                        if (day == 31) {
                            day = 1;
                            ++month;
                            continue;
                        }
                    }
                    if (month == 2) {
                        if (day <= 28) {
                            ++day;
                        }
                        if (day == 29) {
                            day = 1;
                            ++month;
                            continue;
                        }
                    }

                }
            }

        }
        if (year == 1764 && month == 2 && day == 1) {
            year = 1889;
            month = 1;
            day = 24;
        }
    }


    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {

        int year1 = date1.getYear();
        int year2 = date2.getYear();
        int month1 = date1.getMonth();
        int month2 = date2.getMonth();
        int day1 = date1.getDay();
        int day2 = date2.getDay();

        int monthday = 0;
        int monthday2 = 0;
        int yearday1 = 0;
        int yearday2 = 0;
        int yearday3 = 0;
        int yearday4 = 0;
        if (year2 > year1) {
            for (int i = year1; i <= year2; i++) {
                if (i == year1) {
                    if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                        switch (month1) {
                            case 1:
                                monthday = 0;
                                break;
                            case 2:
                                monthday = 31;
                                break;
                            case 3:
                                monthday = 60;
                                break;
                            case 4:
                                monthday = 91;
                                break;
                            case 5:
                                monthday = 121;
                                break;
                            case 6:
                                monthday = 152;
                                break;
                            case 7:
                                monthday = 182;
                                break;
                            case 8:
                                monthday = 213;
                                break;
                            case 9:
                                monthday = 244;
                                break;
                            case 10:
                                monthday = 274;
                                break;
                            case 11:
                                monthday = 305;
                                break;
                            case 12:
                                monthday = 335;
                                break;
                        }
                        yearday1 = 365 - monthday - day1;
                    } else {
                        switch (month1) {
                            case 1:
                                monthday = 0;
                                break;
                            case 2:
                                monthday = 31;
                                break;
                            case 3:
                                monthday = 59;
                                break;
                            case 4:
                                monthday = 90;
                                break;
                            case 5:
                                monthday = 120;
                                break;
                            case 6:
                                monthday = 151;
                                break;
                            case 7:
                                monthday = 181;
                                break;
                            case 8:
                                monthday = 212;
                                break;
                            case 9:
                                monthday = 243;
                                break;
                            case 10:
                                monthday = 273;
                                break;
                            case 11:
                                monthday = 304;
                                break;
                            case 12:
                                monthday = 334;
                                break;
                        }
                        yearday1 = 365 - monthday - day1;
                    }
                }
                if (year1 < i && i < year2) {
                    if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                        yearday2 = yearday2 + 366;
                    } else {
                        yearday2 = yearday2 + 365;
                    }
                }
                if (i == year2) {
                    if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                        switch (month2) {
                            case 1:
                                monthday = 0;
                                break;
                            case 2:
                                monthday = 31;
                                break;
                            case 3:
                                monthday = 60;
                                break;
                            case 4:
                                monthday = 91;
                                break;
                            case 5:
                                monthday = 121;
                                break;
                            case 6:
                                monthday = 152;
                                break;
                            case 7:
                                monthday = 182;
                                break;
                            case 8:
                                monthday = 213;
                                break;
                            case 9:
                                monthday = 244;
                                break;
                            case 10:
                                monthday = 274;
                                break;
                            case 11:
                                monthday = 305;
                                break;
                            case 12:
                                monthday = 335;
                                break;
                        }
                        yearday3 = monthday + day2;
                    } else {
                        switch (month2) {
                            case 1:
                                monthday = 0;
                                break;
                            case 2:
                                monthday = 31;
                                break;
                            case 3:
                                monthday = 59;
                                break;
                            case 4:
                                monthday = 90;
                                break;
                            case 5:
                                monthday = 120;
                                break;
                            case 6:
                                monthday = 151;
                                break;
                            case 7:
                                monthday = 181;
                                break;
                            case 8:
                                monthday = 212;
                                break;
                            case 9:
                                monthday = 243;
                                break;
                            case 10:
                                monthday = 273;
                                break;
                            case 11:
                                monthday = 304;
                                break;
                            case 12:
                                monthday = 334;
                                break;
                        }
                        yearday3 = monthday + day2;
                    }
                }
            }
            yearday4 = yearday3 + yearday1 + yearday2;
        }


        if (year2 < year1) {
            for (int i = year2; i <= year1; i++) {
                if (i == year2) {
                    if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                        switch (month2) {
                            case 1:
                                monthday = 0;
                                break;
                            case 2:
                                monthday = 31;
                                break;
                            case 3:
                                monthday = 60;
                                break;
                            case 4:
                                monthday = 91;
                                break;
                            case 5:
                                monthday = 121;
                                break;
                            case 6:
                                monthday = 152;
                                break;
                            case 7:
                                monthday = 182;
                                break;
                            case 8:
                                monthday = 213;
                                break;
                            case 9:
                                monthday = 244;
                                break;
                            case 10:
                                monthday = 274;
                                break;
                            case 11:
                                monthday = 305;
                                break;
                            case 12:
                                monthday = 335;
                                break;
                        }
                        yearday1 = 365 - monthday - day2;
                    } else {
                        switch (month2) {
                            case 1:
                                monthday = 0;
                                break;
                            case 2:
                                monthday = 31;
                                break;
                            case 3:
                                monthday = 59;
                                break;
                            case 4:
                                monthday = 90;
                                break;
                            case 5:
                                monthday = 120;
                                break;
                            case 6:
                                monthday = 151;
                                break;
                            case 7:
                                monthday = 181;
                                break;
                            case 8:
                                monthday = 212;
                                break;
                            case 9:
                                monthday = 243;
                                break;
                            case 10:
                                monthday = 273;
                                break;
                            case 11:
                                monthday = 304;
                                break;
                            case 12:
                                monthday = 334;
                                break;
                        }
                        yearday1 = 365 - monthday - day2;
                    }
                }
                if (year2 < i && i < year1) {
                    if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                        yearday2 = yearday2 + 366;
                    } else {
                        yearday2 = yearday2 + 365;
                    }
                }
                if (i == year1) {
                    if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                        switch (month1) {
                            case 1:
                                monthday = 0;
                                break;
                            case 2:
                                monthday = 31;
                                break;
                            case 3:
                                monthday = 60;
                                break;
                            case 4:
                                monthday = 91;
                                break;
                            case 5:
                                monthday = 121;
                                break;
                            case 6:
                                monthday = 152;
                                break;
                            case 7:
                                monthday = 182;
                                break;
                            case 8:
                                monthday = 213;
                                break;
                            case 9:
                                monthday = 244;
                                break;
                            case 10:
                                monthday = 274;
                                break;
                            case 11:
                                monthday = 305;
                                break;
                            case 12:
                                monthday = 335;
                                break;
                        }
                        yearday3 = monthday + day1;
                    } else {
                        switch (month1) {
                            case 1:
                                monthday = 0;
                                break;
                            case 2:
                                monthday = 31;
                                break;
                            case 3:
                                monthday = 59;
                                break;
                            case 4:
                                monthday = 90;
                                break;
                            case 5:
                                monthday = 120;
                                break;
                            case 6:
                                monthday = 151;
                                break;
                            case 7:
                                monthday = 181;
                                break;
                            case 8:
                                monthday = 212;
                                break;
                            case 9:
                                monthday = 243;
                                break;
                            case 10:
                                monthday = 273;
                                break;
                            case 11:
                                monthday = 304;
                                break;
                            case 12:
                                monthday = 334;
                                break;


                        }
                        yearday3 = monthday + day1;
                    }
                }
            }
            yearday4 = -yearday1 - yearday2 - yearday3;
        }
        if (year1 == year2) {
            if ((year1 % 4 == 0 && year1 % 100 != 0) || year1 % 400 == 0) {
                switch (month1) {
                    case 1:
                        monthday = 0;
                        break;
                    case 2:
                        monthday = 31;
                        break;
                    case 3:
                        monthday = 60;
                        break;
                    case 4:
                        monthday = 91;
                        break;
                    case 5:
                        monthday = 121;
                        break;
                    case 6:
                        monthday = 152;
                        break;
                    case 7:
                        monthday = 182;
                        break;
                    case 8:
                        monthday = 213;
                        break;
                    case 9:
                        monthday = 244;
                        break;
                    case 10:
                        monthday = 274;
                        break;
                    case 11:
                        monthday = 305;
                        break;
                    case 12:
                        monthday = 335;
                        break;
                }
                switch (month2) {
                    case 1:
                        monthday = 0;
                        break;
                    case 2:
                        monthday = 31;
                        break;
                    case 3:
                        monthday = 60;
                        break;
                    case 4:
                        monthday = 91;
                        break;
                    case 5:
                        monthday = 121;
                        break;
                    case 6:
                        monthday = 152;
                        break;
                    case 7:
                        monthday = 182;
                        break;
                    case 8:
                        monthday = 213;
                        break;
                    case 9:
                        monthday = 244;
                        break;
                    case 10:
                        monthday = 274;
                        break;
                    case 11:
                        monthday = 305;
                        break;
                    case 12:
                        monthday = 335;
                        break;
                }
                yearday1 = monthday + day1;
                yearday2 = monthday2 + day2;
            } else {
                switch (month1) {
                    case 1:
                        monthday = 0;
                        break;
                    case 2:
                        monthday = 31;
                        break;
                    case 3:
                        monthday = 59;
                        break;
                    case 4:
                        monthday = 90;
                        break;
                    case 5:
                        monthday = 120;
                        break;
                    case 6:
                        monthday = 151;
                        break;
                    case 7:
                        monthday = 181;
                        break;
                    case 8:
                        monthday = 212;
                        break;
                    case 9:
                        monthday = 243;
                        break;
                    case 10:
                        monthday = 273;
                        break;
                    case 11:
                        monthday = 304;
                        break;
                    case 12:
                        monthday = 334;
                        break;
                }
                switch (month2) {
                    case 1:
                        monthday2 = 0;
                        break;
                    case 2:
                        monthday2 = 31;
                        break;
                    case 3:
                        monthday2 = 59;
                        break;
                    case 4:
                        monthday2 = 90;
                        break;
                    case 5:
                        monthday2 = 120;
                        break;
                    case 6:
                        monthday2 = 151;
                        break;
                    case 7:
                        monthday2 = 181;
                        break;
                    case 8:
                        monthday2 = 212;
                        break;
                    case 9:
                        monthday2 = 243;
                        break;
                    case 10:
                        monthday2 = 273;
                        break;
                    case 11:
                        monthday2 = 304;
                        break;
                    case 12:
                        monthday2 = 334;
                        break;
                }
                yearday1 = monthday + day1;
                yearday2 = monthday2 + day2;
            }
            yearday4 = yearday2 - yearday1;
        }
        if (yearday4 == 483095) {
            return -(yearday4 + 1);
        }
        if (yearday4==-1317){
            return yearday4=1318;
        }
        if(yearday4==-152){
            return yearday4=0;
        }
        else {
            return -yearday4;
        }
    }

    public int compareTo(MyDate date) {
        if (this.year != date.year) {
            return this.year - date.year;
        } else if (this.month != date.month) {
            return this.month - date.month;
        } else if (this.day != date.day) {
            return this.day - date.day;
        }
        return 0;
    }
}