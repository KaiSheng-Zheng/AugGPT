import java.util.ArrayList;

public class MyDate {
    static int[][] mon={{0,31,28,31,30,31,30,31,31,30,31,30,31},
                    {0,31,29,31,30,31,30,31,31,30,31,30,31}};
    private int year;
    private int month;
    private int day;
    ArrayList<String> events=new ArrayList<>();
    public MyDate(int year,int month,int day){
        this.day=day;
        this.month=month;
        this.year=year;
    }
    public String toString(){
        if(month>9&&day>9) return String.format("%d-%d-%d",year,month,day);
        else {
            if(month>9) return String.format("%d-%d-0%d",year,month,day);
            if(day>9) return String.format("%d-0%d-%d",year,month,day);
            else return String.format("%d-0%d-0%d",year,month,day);
        }
    }
    public static int difference(MyDate d1,MyDate d2){
        int x=Sum(d1);
        int y=Sum(d2);
        return x-y;
    }
    public void addDays(int days){
        for (int i = 0; i < days; i++) {
            if(day+1<=mon[LeapYear(year)][month]) day++;
            else {
                day=1;
                if(month+1<=12) {
                    month++;
                }
                else {
                    year++;
                    month=1;
                }
            }
        }
    }
    static int LeapYear(int year){
        int pd=0;
        if(year%4==0) pd++;
        if(year%100==0) pd++;
        if(year%400==0) pd++;
        return pd % 2 ;
    }
    static int Sum(MyDate x){
        int ans=0;
        for(int i=0;i<x.year;i++){
            ans+=365+LeapYear(i);
        }
        for(int i=1;i<x.month;i++) ans+=mon[LeapYear(x.year)][i];
        for(int i=1;i<=x.day;i++) ans++;
        return ans;
    }
}
