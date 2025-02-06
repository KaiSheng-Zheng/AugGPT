public class MyDate {
    private int year, month, day;
    private static String[] strMonths, strDays;
    private static int[] dayInMonths;

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    public static boolean isLeapYear(int year) {
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else return false;
    }

    public static boolean isValidDate(int year, int month, int day) {
        if((year > 0 && year < 10000) && (month > 0 && month < 13)) {
            switch(month) {
                case 1: if(day > 0 && day < 32) return true;
                    break;
                case 2: if((isLeapYear(year) && day > 0 && day < 30) || (!isLeapYear(year) && day > 0 && day < 29)) return true;
                    break;
                case 3: if(day > 0 && day < 32) return true;
                    break;
                case 4: if(day > 0 && day < 31) return true;
                    break;
                case 5: if(day > 0 && day < 32) return true;
                    break;
                case 6: if(day > 0 && day < 31) return true;
                    break;
                case 7: if(day > 0 && day < 32) return true;
                    break;
                case 8: if(day > 0 && day < 32) return true;
                    break;
                case 9: if(day > 0 && day < 31) return true;
                    break;
                case 10: if(day > 0 && day < 32) return true;
                    break;
                case 11: if(day > 0 && day < 31) return true;
                    break;
                case 12: if(day > 0 && day < 32) return true;
                    break;
            }
        } else return false;
        return false;
    }

    /*public static int getDayOfWeek(int year, int month, int day) {
        //Gauss's algorithm for determining the day of the week
        if((day += month) < 3) {
            year--;
        } else {
            year = year - 2;
        }
        return (23 * month / 9 + day + 4 + year/4 - year/100 + year/400) % 7;
    }*/

    public void setDate(int year, int month, int day) {
        try {
            if(isValidDate(year, month, day)) {
                this.year = year;
                this.month = month;
                this.day = day;
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid year, month, or day!");
        }
    }

    public void setYear(int year) {
        try {
            if(year > 0 && year < 10000) {
                this.year = year;
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid year!");
        }
    }

    public void setMonth(int month) {
        try {
            if(month > 0 && month < 13) {
                this.month = month;
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid month!");
        }
    }

    public void setDay(int day) {
        int dayMax = 31;
        switch(this.getMonth()) {
            case 1: dayMax = 31;
                break;
            case 2: if(isLeapYear(this.year)) dayMax = 29; else dayMax = 28;
                break;
            case 3: dayMax = 31;
                break;
            case 4: dayMax = 30;
                break;
            case 5: dayMax = 31;
                break;
            case 6: dayMax = 30;
                break;
            case 7: dayMax = 31;
                break;
            case 8: dayMax = 31;
                break;
            case 9: dayMax = 30;
                break;
            case 10: dayMax = 31;
                break;
            case 11: dayMax = 30;
                break;
            case 12: dayMax = 31;
                break;
        }
        try {
            if(day > 0 && day <= dayMax) {
                this.day = day;
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid month!");
        }
    }
    //getters below
    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }



    public String toString() {
        if(isValidDate(this.getYear(),this.getMonth(),this.getDay())) {
            String pre = "";

            /*switch(getDayOfWeek(this.year,this.month,this.day)) {
                case 0: pre = "Sun";
                    break;
                case 1: pre = "Mon";
                    break;
                case 2: pre = "Tues";
                    break;
                case 3: pre = "Wednes";
                    break;
                case 4: pre = "Thurs";
                    break;
                case 5: pre = "Fri";
                    break;
                case 6: pre = "Satur";
                    break;
            }*/
            //String month = "";

            switch(this.getMonth()) {
                case 1: month = 1;
                    break;
                case 2: month = 2;
                    break;
                case 3: month = 3;
                    break;
                case 4: month = 4;
                    break;
                case 5: month = 5;
                    break;
                case 6: month = 6;
                    break;
                case 7: month = 7;
                    break;
                case 8: month = 8;
                    break;
                case 9: month = 9;
                    break;
                case 10: month = 10;
                    break;
                case 11: month = 11;
                    break;
                case 12: month = 12;
                    break;
            }
            return String.format("%04d-%02d-%02d", year, month, day);
        } else {
            return "Invalid Date!";
        }

    }

    public int dayMax() {
        int dayMax = 31;
        switch(this.getMonth()) {
            case 1: dayMax = 31;
                break;
            case 2: if(isLeapYear(this.year)) dayMax = 29; else dayMax = 28;
                break;
            case 3: dayMax = 31;
                break;
            case 4: dayMax = 30;
                break;
            case 5: dayMax = 31;
                break;
            case 6: dayMax = 30;
                break;
            case 7: dayMax = 31;
                break;
            case 8: dayMax = 31;
                break;
            case 9: dayMax = 30;
                break;
            case 10: dayMax = 31;
                break;
            case 11: dayMax = 30;
                break;
            case 12: dayMax = 31;
                break;
        }
        return dayMax;
    }

    public MyDate nextDay() {
        if(this.getDay() != this.dayMax()) {
            ++ this.day;
        } else {
            this.day = 1;
            if(this.month == 12) {
                this.month = 1;
                ++ this.year;
            } else {
                ++ this.month;
            }
        }
        return this;
    }

    public String toUniversalString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

        public void  addDays(int days) {
        for(int i = 0; i < days; ++ i) {
            this.nextDay();
        }
    }


    public static int difference(MyDate date1, MyDate date2) {
        int difference = 0;
        if (date1.getYear() == date2.getYear()) {
            if (date1.getMonth() == date2.getMonth()) {
                difference = date2.getDay() - date1.getDay();
            } else {
                difference = date1.dayMax() - date1.getDay();
                for (int i = date1.getMonth() + 1; i < date2.getMonth(); ++i) {
                    switch (i) {
                        case 1:
                            difference += 31;
                            break;
                        case 2:
                            if (isLeapYear(date1.getYear())) difference += 29;
                            else difference += 28;
                            break;
                        case 3:
                            difference += 31;
                            break;
                        case 4:
                            difference += 30;
                            break;
                        case 5:
                            difference += 31;
                            break;
                        case 6:
                            difference += 30;
                            break;
                        case 7:
                            difference += 31;
                            break;
                        case 8:
                            difference += 31;
                            break;
                        case 9:
                            difference += 30;
                            break;
                        case 10:
                            difference += 31;
                            break;
                        case 11:
                            difference += 30;
                            break;
                        case 12:
                            difference += 31;
                            break;
                    }
                }
                difference += date2.getDay();
            }
        } else {
            difference = date1.dayMax() - date1.getDay();
            for (int i = date1.getMonth() + 1; i < 13; ++i) {
                switch (i) {
                    case 1:
                        difference += 31;
                        break;
                    case 2:
                        if (isLeapYear(date1.getYear())) difference += 29;
                        else difference += 28;
                        break;
                    case 3:
                        difference += 31;
                        break;
                    case 4:
                        difference += 30;
                        break;
                    case 5:
                        difference += 31;
                        break;
                    case 6:
                        difference+= 30;
                        break;
                    case 7:
                        difference+= 31;
                        break;
                    case 8:
                        difference+= 31;
                        break;
                    case 9:
                        difference += 30;
                        break;
                    case 10:
                        difference += 31;
                        break;
                    case 11:
                        difference+= 30;
                        break;
                    case 12:
                        difference+= 31;
                        break;
                }
            }
            for (int i = date1.getYear() + 1; i < date2.getYear(); ++i) {
                if (isLeapYear(i)) difference+= 366;
                else difference += 365;
            }
        }

        return difference;
    }


    public int compareTo(MyDate date) {
    if(this.getYear() < date.getYear()) {
            return -1;
        } else if(this.getYear() > date.getYear()) {
            return 1;
        } else {
            if(this.getMonth() < date.getMonth()) {
                return -1;
            } else if(this.getMonth() > date.getMonth()) {
                return 1;
            } else {
                if(this.getDay() < date.getDay()) {
                    return -1;
                } else if(this.getDay() > date.getDay()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}


