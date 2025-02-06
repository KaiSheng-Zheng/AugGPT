import java.util.Date;

public class MyDate {
    public int year;
    public int month;
    public int day;
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void addDays(int days) {
        day = day + days;
        boolean flag = true;
        while (flag) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                if (day > 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)) {
                    day = day - 31;
                    month = month + 1;
                    continue;}
                    if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && day > 29 && month == 2) {
                        day = day - 29;
                        month++;
                        continue;
                    }
                    if (day > 31 && month == 12) {
                        day = day - 31;
                        month = 1;
                        year++;
                        continue;
                    }
                    if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
                        day = day - 30;
                        month = month + 1;
                        continue;
                    }
                }
            else {
                if (day > 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)) {
                    day = day - 31;
                    month = month + 1;
                    continue;
                    }
                    if (day > 28 && month == 2) {
                        day = day - 28;
                        month++;
                        continue;
                    }
                    if (day > 31 && month == 12) {
                        day = day - 31;
                        month = 1;
                        year++;
                        continue;
                    }
                    if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
                        day = day - 30;
                        month = month + 1;
                        continue;
                    }
                }
            break;
            }
        }
    public String toString(){
        return String.format("%d-%02d-%02d",year,month,day);
    }
    public static int difference(MyDate date1, MyDate date2) {
        boolean flag=true;
        MyDate d1=new MyDate(date2.year,date2.month,date2.day);
        MyDate d2=new MyDate(date1.year,date1.month,date1.day);
        if (date1.year< date2.year||date1.year==date2.year&&date1.month< date2.month||date1.year==date2.year&&date1.month== date2.month&&date1.day<date2.day){
            flag=false;
        }
        else {
            d1.setYear(date1.year);
            d1.setMonth(date1.month);
            d1.setDay(date1.day);
            d2.setYear(date2.year);
            d2.setMonth(date2.month);
            d2.setDay(date2.day);
        }
            int t=0;
            while(d1.year!=d2.year||d1.month!=d2.month||d1.day!=d2.day){
                if (d1.year==d2.year&&d1.month==d2.month){
                    t=t+d1.day-d2.day;
                    break;
                }
                if (d1.day!=1){
                    int t1=d1.day;
                    d1.day=1;
                    t=t+t1-1;
                    continue;
                }
                if (d2.day!=1){
                    if (d2.year % 4 == 0 && d2.year % 100 != 0 || d2.year % 400 == 0){
                        if (d2.month==1||d2.month==3||d2.month==5||d2.month==7||d2.month==8||d2.month==10){
                            int t1=31-d2.day+1;
                            t=t+t1;
                            d2.day=1;
                            d2.month=d2.month+1;
                            continue;
                        } else if (d2.month==4||d2.month==6||d2.month==9||d2.month==11) {
                            int t1=30-d2.day+1;
                            t=t+t1;
                            d2.day=1;
                            d2.month=d2.month+1;
                            continue;
                        }else if(d2.month==2){
                            int t1=29-d2.day+1;
                            t=t+t1;
                            d2.day=1;
                            d2.month=d2.month+1;
                            continue;
                        }else{
                            int t1=31-d2.day+1;
                            t=t+t1;
                            d2.day=1;
                            d2.month=1;
                            d2.year= d2.year+1;
                            continue;
                        }

                    }else{
                        if (d2.month==1||d2.month==3||d2.month==5||d2.month==7||d2.month==8||d2.month==10){
                            int t1=31-d2.day+1;
                            t=t+t1;
                            d2.day=1;
                            d2.month=d2.month+1;
                            continue;
                        } else if (d2.month==4||d2.month==6||d2.month==9||d2.month==11) {
                            int t1=30-d2.day+1;
                            t=t+t1;
                            d2.day=1;
                            d2.month=d2.month+1;
                            continue;
                        }else if(d2.month==2){
                            int t1=28-d2.day+1;
                            t=t+t1;
                            d2.day=1;
                            d2.month=d2.month+1;
                            continue;
                        }else{
                            int t1=31-d2.day+1;
                            t=t+t1;
                            d2.day=1;
                            d2.month=1;
                            d2.year= d2.year+1;
                            continue;
                        }

                    }
                }
                else {
                    if (d2.year % 4 == 0 && d2.year % 100 != 0 || d2.year % 400 == 0){
                        if (d2.month==1||d2.month==3||d2.month==5||d2.month==7||d2.month==8||d2.month==10){
                            int t1=31;
                            t=t+t1;
                            d2.month=d2.month+1;
                            continue;
                        } else if (d2.month==4||d2.month==6||d2.month==9||d2.month==11) {
                            int t1=30;
                            t=t+t1;
                            d2.month=d2.month+1;
                            continue;
                        }else if(d2.month==2){
                            int t1=29;
                            t=t+t1;
                            d2.month=d2.month+1;
                            continue;
                        }else{
                            int t1=31;
                            t=t+t1;
                            d2.month=1;
                            d2.year= d2.year+1;
                            continue;
                        }

                    }else{
                        if (d2.month==1||d2.month==3||d2.month==5||d2.month==7||d2.month==8||d2.month==10){
                            int t1=31;
                            t=t+t1;
                            d2.month=d2.month+1;
                            continue;
                        } else if (d2.month==4||d2.month==6||d2.month==9||d2.month==11) {
                            int t1=30;
                            t=t+t1;
                            d2.month=d2.month+1;
                            continue;
                        }else if(d2.month==2){
                            int t1=28;
                            t=t+t1;
                            d2.month=d2.month+1;
                            continue;
                        }else{
                            int t1=31;
                            t=t+t1;
                            d2.month=1;
                            d2.year= d2.year+1;
                            continue;
                        }

                    }

                }
            }
            if (! flag){
                t=-t;
            }
            return t;
    }
}
