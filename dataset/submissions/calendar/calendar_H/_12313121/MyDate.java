class MyDate{
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

    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public void addDays(int days){
        day+=days;
        while(day>28){
            if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
                if(day<=31){
                    break;
                }
                else {
                    day-=31;
                    month++;
                    if(month>12){
                        year++;
                        month=1;
                    }
                }
            }
            else if(month==4 ||month==6 ||month==9 ||month==11){
                if(day<=30){
                    break;
                }
                else{
                    day-=30;
                    month++;
                }
            }
            else if(((year%4==0 && year%100!=0) || (year%400==0)) && month==2){
                if(day<=29){
                    break;
                }
                else {
                    day-=29;
                    month++;
                }
            }
            else if((!((year%4==0 && year%100!=0) || (year%400==0))) && month==2){
                day-=28;
                month++;
            }
            else{
                System.out.println("wrong at 73");
                break;
            }
        }
    }

    public String toString(){
        return String.format("%04d%s%02d%s%02d",year,"-",month,"-",day);
    }

    public static int difference(MyDate date1, MyDate date2){
        int delta=0;
        int saveYear=0;
        int saveMonth=0;
        int saveDay=0;
        if(date1.year>date2.year || (date1.year==date2.year && date1.month>date2.month) || (date1.year==date2.year && date1.month==date2.month && date1.day>date2.day)){
            //shuchu+
            saveYear=date2.year;
            saveMonth=date2.month;
            saveDay=date2.day;
            while(!(date1.year==date2.year && date1.month==date2.month && date1.day==date2.day)){
                date2.day++;
                delta++;
                while(date2.day>28){
                    if(date2.month==1||date2.month==3||date2.month==5||date2.month==7||date2.month==8||date2.month==10||date2.month==12){
                        if(date2.day<=31){
                            break;
                        }
                        else {
                            date2.day-=31;
                            date2.month++;
                            if(date2.month>12){
                                date2.year++;
                                date2.month=1;
                            }
                        }
                    }
                    else if(date2.month==4 ||date2.month==6 ||date2.month==9 ||date2.month==11){
                        if(date2.day<=30){
                            break;
                        }
                        else{
                            date2.day-=30;
                            date2.month++;
                        }
                    }
                    else if(((date2.year%4==0 && date2.year%100!=0) || (date2.year%400==0)) && date2.month==2){
                        if(date2.day<=29){
                            break;
                        }
                        else {
                            date2.day-=29;
                            date2.month++;
                        }
                    }
                    else if((!((date2.year%4==0 && date2.year%100!=0) || (date2.year%400==0))) && date2.month==2){
                        date2.day-=28;
                        date2.month++;
                    }
                    else{
                        System.out.println("wrong at 127");
                        break;
                    }
                }
            }
            date2.year=saveYear;
            date2.month=saveMonth;
            date2.day=saveDay;
        }
        else {
            //shuchu-
            saveYear=date1.year;
            saveMonth=date1.month;
            saveDay=date1.day;
            while(!(date1.year==date2.year && date1.month==date2.month && date1.day==date2.day)){
                date1.day++;
                delta--;
                while(date1.day>28){
                    if(date1.month==1||date1.month==3||date1.month==5||date1.month==7||date1.month==8||date1.month==10||date1.month==12){
                        if(date1.day<=31){
                            break;
                        }
                        else {
                            date1.day-=31;
                            date1.month++;
                            if(date1.month>12){
                                date1.year++;
                                date1.month=1;
                            }
                        }
                    }
                    else if(date1.month==4 ||date1.month==6 ||date1.month==9 ||date1.month==11){
                        if(date1.day<=30){
                            break;
                        }
                        else{
                            date1.day-=30;
                            date1.month++;
                        }
                    }
                    else if(((date1.year%4==0 && date1.year%100!=0) || (date1.year%400==0)) && date1.month==2){
                        if(date1.day<=29){
                            break;
                        }
                        else {
                            date1.day-=29;
                            date1.month++;
                        }
                    }
                    else if((!((date1.year%4==0 && date1.year%100!=0) || (date1.year%400==0))) && date1.month==2){
                        date1.day-=28;
                        date1.month++;
                    }
                    else{
                        System.out.println("wrong at 175");
                        break;
                    }
                }
            }
            date1.year=saveYear;
            date1.month=saveMonth;
            date1.day=saveDay;
        }
        return delta;
    }

    public static boolean isEqualTo(MyDate date1, MyDate date2) {
        if(date1.year==date2.year && date1.month==date2.month && date1.day==date2.day){
            return true;
        }
        else {
            return false;
        }
    }

    public static MyDate theEarlier(MyDate date1, MyDate date2){
        if(date1.year>date2.year || (date1.year==date2.year && date1.month>date2.month) || (date1.year==date2.year && date1.month==date2.month && date1.day>date2.day)){
            return date2;
        }
        else {
            return date1;
        }
    }
}