
import  java.util.ArrayList;
public class MyDate {
    private int year;
    private int month;
    private int day;
    private static int maxday;
    private static int maxmonth=13;
    private ArrayList<String> events = new ArrayList<>();

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days) {
        for(int i=0;i<days;i++){
            switch (month){
                case 1: case 3: case 5: case 7: case 8: case 10:
                case 12:maxday=32;break;
                case 2:maxday=29;break;
                default:maxday=31;
            }
            if((year%4==0&&year%100!=0)||year%400==0){
                if (month==2){
                    maxday=30;
                }
            }
            day++;
            if(day==maxday){
                day=1;
                month++;
            }
            if(month==maxmonth){
                month=1;
                year++;
            }
        }
    }
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    public static int difference(MyDate date1,MyDate date2){
        if (date1.year> date2.year||(date1.year==date2.year&&
                date1.month> date2.month)||(date1.year==date2.year
                &&date1.month==date2.month&&date1.day>date2.day)) {
            int count=0;
            int recordYear= date2.year;
            int recordMonth= date2.month;
            int recordDay= date2.day;
            while(!(date1.getYear()==date2.getYear()&&
                    date1.getMonth()==date2.getMonth()&&
                    date1.getDay()==date2.getDay())){
                count++;
                switch (date2.month){
                    case 1: case 3: case 5: case 7: case 8: case 10:
                    case 12:maxday=32;break;
                    case 2:maxday=29;break;
                    default:maxday=31;
                }
                if((date2.year%4==0&&date2.year%100!=0)||date2.year%400==0){
                    if (date2.month==2){
                        maxday=30;
                    }
                }
                date2.day++;
                if(date2.day==maxday){
                    date2.day=1;
                    date2.month++;
                }
                if(date2.month==maxmonth){
                    date2.month=1;
                    date2.year++;
                }
            }
            date2.year=recordYear;
            date2.month=recordMonth;
            date2.day=recordDay;
            return count;
        }
        else if (date1.year==date2.year&&date1.month==date2.month&&
            date1.day==date2.day){
            return 0;
        }
        else{
            int count=0;
            int recordYear= date1.year;
            int recordMonth= date1.month;
            int recordDay= date1.day;
            while(!(date1.getYear()==date2.getYear()&&
                    date1.getMonth()==date2.getMonth()&&
                    date1.getDay()==date2.getDay())){
                count++;
                switch (date1.month){
                    case 1: case 3: case 5: case 7: case 8: case 10:
                    case 12:maxday=32;break;
                    case 2:maxday=29;break;
                    default:maxday=31;
                }
                if((date1.year%4==0&&date1.year%100!=0)||date1.year%400==0){
                    if (date1.month==2){
                        maxday=30;
                    }
                }
                date1.day++;
                if(date1.day==maxday){
                    date1.day=1;
                    date1.month++;
                }
                if(date1.month==maxmonth){
                    date1.month=1;
                    date1.year++;
                }
            }
            date1.year=recordYear;
            date1.month=recordMonth;
            date1.day=recordDay;
            return -count;
        }
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
}