public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public  MyDate(MyDate date){
        this.year=date.year;
        this.month=date.month;
        this.day=date.day;
    }
    public MyDate(){}

    public void addDays(int days){
        if (days <= this.dayPerMonth()[this.month]-this.day){
            day=day+days;
        }
        if (days > this.dayPerMonth()[this.month]-day){
            days=days-(this.dayPerMonth()[this.month]-day+1);
            day=1;
            if (month<12){
            month++;
        }
        else {
            year++;
            month=1;
        }

        while(days>=0){
            if (month<12){
                if (days-this.dayPerMonth()[this.month]>=0){
                    days=days-this.dayPerMonth()[this.month];
                    month++;}
                else {break;}
                }
            else {
                if (days-this.dayPerMonth()[this.month]>=0){
                days=days-this.dayPerMonth()[this.month];
                year++;
                month=1;
                } else {break;}
            }
            }
        day=day+days;
        }
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);

    }
    public int[] dayPerMonth(){
        int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if ((this.year % 400 == 0 || (this.year % 4 == 0 && this.year % 100 != 0))){
            daysPerMonth[2]=29;}
        return daysPerMonth;
    }
    public static int difference(MyDate date1, MyDate date2){
        int difference=0;
        MyDate max=new MyDate();
        MyDate min=new MyDate();
            if (date1.year>date2.year||(date1.year==date2.year&&date1.month>date2.month)||(date1.year==date2.year&&date1.month==date2.month&&date1.day>=date2.day)){
            max.year=date1.year;
            max.month=date1.month;
            max.day=date1.day;
            min.year=date2.year;
            min.month=date2.month;
            min.day=date2.day;}
            else {
            max.year=date2.year;
            max.month=date2.month;
            max.day=date2.day;
            min.year=date1.year;
            min.month=date1.month;
            min.day=date1.day;}
            if(min.month!=max.month){
            difference+=(min.dayPerMonth()[min.month]- min.day);
            min.day=1;
            if (min.month<12){min.month++;}
            else {min.year++;min.month=1;}
            if (min.year!=max.year){
                for (;min.month<=12;min.month++){
                    difference+=min.dayPerMonth()[min.month];
                }
                min.year++;
                min.month=1;
            }
            while(min.year< max.year){
                if (min.year % 400 == 0 || (min.year % 4 == 0 && min.year % 100 != 0)){
                    difference+=366;
                }
                else {difference+=365;}
                min.year++;
            }
            while (min.month<max.month){
                difference+=min.dayPerMonth()[min.month];
                min.month++;
            }
            difference+=max.day;}
            else {
                difference= max.day- min.day;
            }
        if (!(date1.year>date2.year||(date1.year==date2.year&&date1.month>date2.month)||(date1.year==date2.year&&date1.month==date2.month&&date1.day>=date2.day))){
            difference=0-difference;
        }
        return difference;
    }

}



