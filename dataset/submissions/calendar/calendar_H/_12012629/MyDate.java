

import java.util.ArrayList;

public class MyDate {
    private int year;
    private int month;
    private int day;
    protected ArrayList<String> event=new ArrayList<>();
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days) {
        while(days-->0)
        {
            day += 1;

            if (day > month_days(month)) {
                day = 1;
                month += 1;
            }
            if (month > 12) {
                month = 1;
                year += 1;
            }
        }
    }
    public String toString(){
        return year+"-"+String.format("%02d", month)+"-"+String.format("%02d", day);
    }
    public int all_days(){
        int days=day;
        for(int i=1;i<month;i++){
            days+=month_days(i);
        }
        for(int j=1;j<year;j++){
            days+=year_days(j);
        }
        return days;
    }

    public int year_days(int year) {
        if((year/4==0&&year/100!=0)||year/400==0){
            return 366;
        }else {
            return 365;
        }
    }

    public int month_days(int month) {
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            return 31;
        } else if (month==4||month==6||month==9||month==11) {
            return 30;
        }else {
            if((year/4==0&&year/100!=0)||year/400==0){
                return  29;
            }else {
                return 28;
            }
        }
    }

    public void add_event(String eventName){
        event.add(eventName);
    }


    public static int difference(MyDate date1, MyDate date2){
        int days_1= date1.all_days();
        int days_2= date2.all_days();
        return days_1-days_2;
    }
}