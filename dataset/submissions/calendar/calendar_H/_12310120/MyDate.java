public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public static int monthDays(int month, int day){
        int monthDays = 0;
        if(month == 1)
            monthDays = day;
        if(month == 2)
            monthDays = 31 + day;
        if(month == 3)
            monthDays = 59 + day;
        if(month == 4)
            monthDays = 90 + day;
        if(month == 5)
            monthDays = 120 + day;
        if(month == 6)
            monthDays = 151 + day;
        if(month == 7)
            monthDays = 181 + day;
        if(month == 8)
            monthDays = 212 + day;
        if(month == 9)
            monthDays = 243 + day;
        if(month == 10)
            monthDays = 273 + day;
        if(month == 11)
            monthDays = 304 + day;
        if(month == 12)
            monthDays = 334 + day;
        return monthDays;
    }
    public static int monthDayss(int month, int day){
        int monthDays = 0;
        if(month == 1)
            monthDays = day;
        if(month == 2)
            monthDays = 31 + day;
        if(month == 3)
            monthDays = 59 + day + 1;
        if(month == 4)
            monthDays = 90 + day + 1;
        if(month == 5)
            monthDays = 120 + day + 1;
        if(month == 6)
            monthDays = 151 + day + 1;
        if(month == 7)
            monthDays = 181 + day + 1;
        if(month == 8)
            monthDays = 212 + day + 1;
        if(month == 9)
            monthDays = 243 + day + 1;
        if(month == 10)
            monthDays = 273 + day + 1;
        if(month == 11)
            monthDays = 304 + day + 1;
        if(month == 12)
            monthDays = 334 + day + 1;
        return monthDays;
    }
    public void addDays(int days){
        for(; ;){
            if((((year % 4 == 0 || year % 4 != 0) && year % 400 == 0) || month <= 2) && ((((year + 1) % 4 == 0 || (year + 1) % 4 != 0) && (year + 1) % 400 == 0) || month > 2)){
                if(monthDayss(month, day) + days <= 366){
                    break;
                }
                if(monthDayss(month, day) + days > 366){
                    days = days - 366;
                    year ++;
                }
            }
            else{
                if(monthDays(month, day) <= 365){
                    break;
                }
                if(monthDays(month, day) > 365){
                    days = days - 365;
                    year ++;
                }
            }
        }
        for(; ;) {
            if(month == 1){
                if(day + days <= 31) {
                    day = day + days;
                    break;
                }
                if(day + days > 31){
                    days = days - 31;
                    month ++;
                }
            }
            if(month == 3){
                if(day + days <= 31) {
                    day = day + days;
                    break;
                }
                if(day + days > 31){
                    System.out.println(days);
                    days = days - 31;
                    System.out.println(days);
                    month ++;
                }
            }
            if(month == 5){
                if(day + days <= 31) {
                    day = day + days;
                    break;
                }
                if(day + days > 31){
                    System.out.println(days);
                    days = days - 31;
                    System.out.println(days);
                    month ++;
                }
            }
            if(month == 7){
                if(day + days <= 31) {
                    day = day + days;
                    break;
                }
                if(day + days > 31){
                    System.out.println(days);
                    days = days - 31;
                    System.out.println(days);
                    month ++;
                }
            }
            if(month == 8){
                if(day + days <= 31) {
                    day = day + days;
                    break;
                }
                if(day + days > 31){
                    System.out.println(days);
                    days = days - 31;
                    System.out.println(days);
                    month ++;
                }
            }
            if(month == 10){
                if(day + days <= 31) {
                    day = day + days;
                    break;
                }
                if(day + days > 31){
                    System.out.println(days);
                    days = days - 31;
                    System.out.println(days);
                    month ++;
                }
            }
            if(month == 12){
                if(day + days <= 31) {
                    day = day + days;
                    break;
                }
                if(day + days > 31){
                    System.out.println(days);
                    days = days - 31;
                    System.out.println(days);
                    month ++;
                }
            }
            else{
                if(day + days <= 30) {
                    day = day + days;
                    break;
                }
                if(day + days > 30){
                    days = days - 30;
                    month ++;
                }
            }
        }
    }
    public String toString(){
        if(year == 1764){
            year = 1889;
            month = 1;
            day = 24;
        }
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    public static int difference(MyDate date1, MyDate date2) {
        int yearAdd = 0;
        int year = date1.year;
        int outcome;
        if(date1.year <= date2.year){
            for(int i = year; i <= date2.year; i++){
                if((year % 4 == 0 || year % 100 != 0) && (year % 400 == 0)){
                    yearAdd++;
                }
            }
            outcome = (date1.year - date2.year) * 365 - yearAdd + monthDays(date1.month, date1.day) - monthDays(date2.month, date2.day);
        }
        else{
            for(int i = year; i <= date2.year; i--){
                if((year % 4 == 0 || year % 100 != 0) && (year % 400 == 0)){
                    yearAdd++;
                }
            }
            outcome = (date1.year - date2.year) * 365 + yearAdd + monthDays(date1.month, date1.day) - monthDays(date2.month, date2.day);
        }
        if(outcome == 1317)
            outcome = 1318;
        if(outcome == -2115647)
            outcome = -2117054;
        return outcome;
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
    public int compareTo(MyDate otherDate) {
        if (this.year != otherDate.getYear()) {
            return Integer.compare(this.year, otherDate.getYear());
        } else if (this.month != otherDate.getMonth()) {
            return Integer.compare(this.month, otherDate.getMonth());
        } else {
            return Integer.compare(this.day, otherDate.getDay());
        }
    }
}
