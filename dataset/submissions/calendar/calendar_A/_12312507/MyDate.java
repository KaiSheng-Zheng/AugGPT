import java.util.Formatter;

public class MyDate {
    private static final int md[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public MyDate(MyDate mydate){
        this.year=mydate.year;
        this.month= mydate.month;
        this.day= mydate.day;
    }
    private boolean isLeap(){
        if(year%400==0)return true;
        if(year%100==0)return false;
        if(year%4==0)return true;
        return false;
    }
    private int maxDay(){
        if(isLeap()&&month==2)return 29;
        return md[month];
    }
    public void addDays(int days){
        while(days!=0){
            --days;
            ++day;
            if(day>maxDay()){
                ++month;
                day=1;
            }
            if(month>12){
                ++year;
                month=1;
            }
        }
    }
    public String toString(){
        Formatter formatter=new Formatter();
        return formatter.format("%04d-%02d-%02d",year,month,day).toString();
    }
    private static int compare(MyDate date1,MyDate date2){
        if(date1.year!=date2.year)return date1.year<date2.year?-1:1;
        if(date1.month!=date2.month)return date1.month<date2.month?-1:1;
        if(date1.day!=date2.day)return date1.day<date2.day?-1:1;
        return 0;
    }
    public static int difference(MyDate date1, MyDate date2){
        int v=compare(date1,date2);
        if(v==0)return 0;
        if(v<0){
            MyDate date=new MyDate(date1);
            int a=0;
            while(compare(date,date2)!=0){
                date.addDays(1);
                ++a;
            }
            return -a;
        }
        else{
            MyDate date=new MyDate(date2);
            int a=0;
            while(compare(date1,date)!=0){
                date.addDays(1);
                ++a;
            }
            return a;
        }
    }
}