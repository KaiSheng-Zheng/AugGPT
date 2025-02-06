
public class MyDate {
    private int year;
    private int month;
    private int day;
    private int MaxDays(){
        int dayMax=0;
        switch (month){
            case 1,3,5,7,8,10,12: dayMax = 31; break;
            case 4,6,9,11: dayMax = 30; break;
            case 2: dayMax = (year%400==0||(year%4==0&&year%100!=0))? 29:28; break;
        }
        return dayMax;
    }
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days){
        day+=days;
        while(day>MaxDays()){
            day-=MaxDays();
            month+=1;
            if(month>12){
                year+=1;
                month=1;
            }
        }
    }
    public static int difference(MyDate date1, MyDate date2){
        int diff=0;
        int day1=0,day2=0;
        switch(cmp(date1,date2)){
            case -1:{
                for(int year=date1.year;year<date2.year;year++){
                    day2+=(year%400==0||(year%4==0&&year%100!=0))? 366:365;
                }
                for(int i=1;i< date1.month; i++){
                    int daymax=0;
                    switch (i){
                        case 1,3,5,7,8,10,12: daymax = 31; break;
                        case 4,6,9,11: daymax = 30; break;
                        case 2: daymax = (date1.year%400==0||(date1.year%4==0&& date1.year%100!=0))? 29:28; break;
                    }
                    day1+=daymax;
                }
                day1+=date1.day;
                for(int i=1;i< date2.month; i++){
                    int daymax=0;
                    switch (i){
                        case 1,3,5,7,8,10,12: daymax = 31; break;
                        case 4,6,9,11: daymax = 30; break;
                        case 2: daymax = (date2.year%400==0||(date2.year%4==0 && date2.year%100!=0))? 29:28; break;
                    }
                    day2+=daymax;
                }
                day2+=date2.day;
                diff=day1-day2;
                break;
            }
            case 1:{
                for(int year=date2.year;year<date1.year;year++){
                    day1+=(year%400==0||(year%4==0&&year%100!=0))? 366:365;
                }
                for(int i=1;i< date1.month; i++){
                    int daymax=0;
                    switch (i){
                        case 1,3,5,7,8,10,12: daymax = 31; break;
                        case 4,6,9,11: daymax = 30; break;
                        case 2: daymax = (date1.year%400==0||(date1.year%4==0&& date1.year%100!=0))? 29:28; break;
                    }
                    day1+=daymax;
                }
                day1+=date1.day;
                for(int i=1;i< date2.month; i++){
                    int daymax=0;
                    switch (i){
                        case 1,3,5,7,8,10,12: daymax = 31; break;
                        case 4,6,9,11: daymax = 30; break;
                        case 2: daymax = (date2.year%400==0||(date2.year%4==0&& date2.year%100!=0))? 29:28; break;
                    }
                    day2+=daymax;
                }
                day2+=date2.day;
                diff=day1-day2;
                break;
            }
        }
        return diff;
    }
    @Override
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public static int cmp(MyDate date1, MyDate date2){
        if (date1.year < date2.year) return -1;
        else if (date1.year == date2.year) {
            if (date1.month < date2.month) return -1;
            else if (date1.month == date2.month) {
                if (date1.day < date2.day) return -1;
            }
        }
        if(date1.year == date2.year && date1.month == date2.month && date1.day ==date2.day) return 0;
        else return 1;
    }
}