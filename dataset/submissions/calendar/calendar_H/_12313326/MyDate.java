public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days) {
        day = day + days;
        correct:while (true) {
            switch (month) {
                case 12:
                    if (day > 31) {
                        year = year + 1;
                        month = 1;
                        day = day - 31;
                    }
                    else {
                        break correct;
                    }
                    break;
                case 1, 3, 5, 7, 8, 10:
                    if (day > 31) {
                        month = month + 1;
                        day = day - 31;
                    }
                    else {
                        break correct;
                    }
                    break;
                case 4, 6, 9, 11:
                    if (day > 30) {
                        month = month + 1;
                        day = day - 30;
                    }
                    else {
                        break correct;
                    }
                    break;
                case 2:
                    if (year % 400 == 0) {
                        if (day > 29) {
                            month = month + 1;
                            day = day - 29;
                        }
                        else {
                            break correct;
                        }
                    }
                    else if (year % 4 == 0 && year % 100 != 0) {
                        if (day > 29) {
                            month = month + 1;
                            day = day - 29;
                        }
                        else {
                            break correct;
                        }
                    }
                    else{
                        if(day > 28){
                            month = month + 1;
                            day = day - 28;
                        }
                        else{
                            break correct;
                        }
                    }
                    break;
            }
        }
    }
    public String toString(){
        String realmonth = null;
        String realday = null;
        if(month < 10){
            realmonth = "0" + String.valueOf(month);
        }
        else{
            realmonth = String.valueOf(month);
        }
        if(day < 10){
            realday = "0" + String.valueOf(day);
        }
        else{
            realday = String.valueOf(day);
        }
        String realdate = String.valueOf(year) + "-" + realmonth + "-" + realday;
        return realdate;
    }
    public static int difference(MyDate date1,MyDate date2){
        int yeardays1 = ((date1.year - 1)/4 - (date1.year - 1)/100 + (date1.year - 1)/400) * 366 + ((date1.year - 1) - (date1.year - 1)/4 + (date1.year - 1)/100 - (date1.year - 1)/400) * 365;
        int yeardays2 = ((date2.year - 1)/4 - (date2.year - 1)/100 + (date2.year - 1)/400) * 366 + ((date2.year - 1) - (date2.year - 1)/4 + (date2.year - 1)/100 - (date2.year - 1)/400) * 365;
        int monthdays1 = 0;
        int monthdays2 = 0;
        for(int i = date1.month;i >= 1;i--){
            switch(i){
                case 2,4,6,8,9,11:
                    monthdays1 = monthdays1 + 31;
                    break;
                case 5,7,10,12:
                    monthdays1 = monthdays1 + 30;
                    break;
                case 3:
                    if(date1.year % 400 == 0){
                        monthdays1 = monthdays1 + 29;
                    }
                    else if(date1.year % 4 == 0 && date1.year % 100 != 0){
                        monthdays1 = monthdays1 + 29;
                    }
                    else{
                        monthdays1 = monthdays1 + 28;
                    }
                    break;
            }
        }
        for(int i = date2.month;i >= 1;i--){
            switch(i){
                case 2,4,6,8,9,11:
                    monthdays2 = monthdays2 + 31;
                    break;
                case 5,7,10,12:
                    monthdays2 = monthdays2 + 30;
                    break;
                case 3:
                    if(date2.year % 400 == 0){
                        monthdays2 = monthdays2 + 29;
                    }
                    else if(date2.year % 4 == 0 && date2.year % 100 != 0){
                        monthdays2 = monthdays2 + 29;
                    }
                    else{
                        monthdays2 = monthdays2 + 28;
                    }
                    break;
            }
        }
        int difference = yeardays1 + monthdays1 + date1.day - yeardays2 - monthdays2 - date2.day;
        return difference;
    }
}