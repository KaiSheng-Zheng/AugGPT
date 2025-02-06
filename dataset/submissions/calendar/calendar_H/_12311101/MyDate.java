public class MyDate {
    private int year;
    private int month;
    private int day;

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

    public MyDate(int year, int month, int day) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public void addDays(int days) {
        for (int i = 0; i < days; i++) {
            if (year % 4 == 0 && year % 400 == 0) {
                if (month == 12) {
                    if (day == 31) {
                        year += 1;
                        month = 1;
                        day = 1;
                    }
                    else {
                        day += 1;
                    }
                }
                else if (month == 1|| month == 3|| month ==5|| month ==7|| month==8|| month ==10){
                    if (day == 31){
                        month += 1;
                        day = 1;
                    }
                    else{
                        day += 1;
                    }
                }
                else if (month == 2){
                    if (day == 29){
                        month += 1;
                        day = 1;
                    }
                    else{
                        day += 1;
                    }}
                else{
                    if (day==30){
                    month += 1;
                    day =1;
                }
                else{
                    day += 1;}
                }
            }
            else if (year % 4 == 0 && year % 100 != 0) {
                if (month == 12) {
                    if (day == 31) {
                        year += 1;
                        month = 1;
                        day = 1;
                    }
                    else {
                        day += 1;
                    }
                }
                else if (month == 1|| month == 3|| month ==5|| month ==7|| month==8|| month ==10){
                    if (day==31){
                        month += 1;
                        day = 1;
                    }
                    else{
                        day += 1;
                    }
                }
                else if (month == 2){
                    if (day==29){
                        month += 1;
                        day =1;
                    }
                    else{
                        day += 1;
                    }}
                else{
                    if (day==30){
                        month += 1;
                        day =1;
                    }
                    else{
                        day += 1;}
                }
            }
            else if (year % 4 != 0 ) {
                if (month == 12) {
                    if (day == 31) {
                        year += 1;
                        month = 1;
                        day = 1;
                    }
                    else {
                        day += 1;
                    }
                }
                else if (month == 1|| month == 3|| month ==5|| month ==7|| month==8|| month ==10){
                    if (day==31){
                        month += 1;
                        day = 1;
                    }
                    else{
                        day += 1;
                    }
                }
                else if (month == 2){
                    if (day==28){
                        month += 1;
                        day =1;
                    }
                    else{
                        day += 1;
                    }}
                else{
                    if (day==30){
                        month += 1;
                        day =1;
                    }
                    else{
                        day += 1;}
                }
            }
            else if (year % 400 != 0 && year % 100 ==0 ) {
                if (month == 12) {
                    if (day == 31) {
                        year += 1;
                        month = 1;
                        day = 1;
                    }
                    else {
                        day += 1;
                    }
                }
                else if (month == 1|| month == 3|| month ==5|| month ==7|| month==8|| month ==10){
                    if (day==31){
                        month += 1;
                        day = 1;
                    }
                    else{
                        day += 1;
                    }
                }
                else if (month == 2){
                    if (day==28){
                        month += 1;
                        day =1;
                    }
                    else{
                        day += 1;
                    }}
                else{
                    if (day==30){
                        month += 1;
                        day =1;
                    }
                    else{
                        day += 1;}
                }
            }
        
    }
    }

    public String toString () {
        String date = "0";
        if (month>=10 && day >= 10){
            date = year + "-" + month + "-" + day;
            }
        else if (month< 10 && day >= 10){
             date = year + "-" +"0" + month + "-" + day;
        }
        else if (month>= 10 && day < 10){
             date = year + "-"  + month + "-" +"0"+ day;
        }
        else if (month < 10 && day <10){
             date = year + "-" +"0" +month + "-" +"0"+ day;
        }
        return date;
    }

    public static int difference(MyDate date1, MyDate date2){
        int  num;
        int totaldate1 =0;
        int totaldate2 =0;
        for (int i = 0;  i< date1.getYear(); i++) {
            if (date1.isrunnian(i)){
                totaldate1 += 366;
            }
            else {
                totaldate1 += 365;
            }
        }
        if(date1.isrunnian(date1.getYear())){
            for (int j = 0; j < date1.getMonth(); j++) {
                if(j== 2){
                    totaldate1 += 29;
                }
                else if(j==1 ||j==3||j==5||j==7||j==8||j==10||j==12){
                    totaldate1 += 31;
                }
                else if(j==4||j==6||j==9||j==11){
                    totaldate1 += 30;
                }

            }
        }
        else {
            for (int j = 0; j < date1.getMonth(); j++) {
                if(j == 2){
                    totaldate1 += 28;
                }
                else if(j==1||j==3||j==5||j==7||j==8||j==10||j==12){
                    totaldate1 += 31;
                }
                else if(j==4||j==6||j==9||j==11){
                    totaldate1 += 30;
                }

            }
        }
        totaldate1 += date1.getDay();
        for (int i = 0;  i< date2.getYear(); i++) {
            if (date2.isrunnian(i)){
                totaldate2 += 366;
            }
            else {
                totaldate2 += 365;
            }

        }
        if(date2.isrunnian(date2.getYear())){
            for (int j = 0; j < date2.getMonth(); j++) {
                if(j == 2){
                    totaldate2 += 29;
                }
                else if(j==1 ||j==3||j==5||j==7||j==8||j==10||j==12){
                    totaldate2 += 31;
                }
                else if(j==4||j==6||j==9||j==11){
                    totaldate2 += 30;
                }
            }
        }
        else {
            for (int j = 0; j < date2.getMonth(); j++) {
                if(j == 2){
                    totaldate2 += 28;
                }
                else if(j==1 ||j==3||j==5||j==7||j==8||j==10||j==12){
                    totaldate2 += 31;
                }
                else if(j==4||j==6||j==9||j==11){
                    totaldate2 += 30;
                }
            }
        }
        totaldate2 += date2.getDay();
        num = totaldate1 - totaldate2;
        return num;
    }

    public boolean isrunnian(int theyear){
        boolean flag = false ;
        if(theyear % 4 == 0 && theyear % 400 == 0){
            flag = true ;
        } else if (theyear % 4 == 0 && theyear % 100!=0){
            flag = true;
        }
        return flag;

    }
}