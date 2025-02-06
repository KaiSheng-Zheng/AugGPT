import java.text.DecimalFormat;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }


    public MyDate() {
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

    public void addDays(int days){
        boolean in=true;
        while (days!=0&&in){
            in=false;
            if(month==2){
                boolean RUNNIAN=false;
                if(year%100==0){
                    if(year%400==0){
                        RUNNIAN=true;
                    }
                }
                else if (year%4==0) {
                    RUNNIAN=true;
                }
                if(RUNNIAN){
                    day = days + day;
                    if (day > 29) {
                        in = true;
                        days = day - 30;
                        day = 1;
                        month++;
                    }
                    else days=0;

                }
                else {
                    day = days + day;
                    if (day > 28) {
                        in = true;
                        days = day - 29;
                        day = 1;
                        month++;
                    }
                    else days=0;
                }
            }
            else if (month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
                day = day + days;
                if (day > 31) {
                    if (month == 12) {
                        year++;
                        month = 1;
                        in = true;
                        days = day - 32;
                        day = 1;
                    } else {
                        month++;
                        in = true;
                        days = day - 32;
                        day = 1;
                    }
                }
                else days=0;
            }
            else{
                day=day+days;
                if (day>30){
                    month++;
                    in=true;
                    days=day-31;
                    day=1;

                }
                else days=0;
            }

        }

    }
    public String toString(){
        return  new DecimalFormat("0000").format(year) +"-"+new DecimalFormat("00").format(month)+"-"+new DecimalFormat("00").format(day);
    }
    public static int difference(MyDate date1, MyDate date2){
        int day1= MyDate.Date2Str(date1);
        int day2= MyDate.Date2Str(date2);
        return day1-day2;
    }
    public static int Date2Str(MyDate date){
        int days=0;
        days=(date.year-1)*365;
        days=days+(date.year-1)/4;
        days=days-(date.year-1)/100+(date.year-1)/400;
        if(date.month>=12)
            days=days+30;
        if(date.month>=11)
            days=days+31;
        if(date.month>=10)
            days=days+30;
        if(date.month>=9)
            days=days+31;
        if(date.month>=8)
            days=days+31;
        if(date.month>=7)
            days=days+30;
        if(date.month>=6)
            days=days+31;
        if(date.month>=5)
            days=days+30;
        if(date.month>=4)
            days=days+31;
        if(date.month>=3){
            if((date.year%100!=0&&date.year%4==0)||(date.year%100==0&&date.year%400==0))
                days=days+29;
            else
                days=days+28;
        }

        if(date.month>=2)
            days = days + 31;
        days=date.day+days;
        return days;
    }
}
