public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private int isRen(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)?1:0;
    }
    public void addDays(int days){
        int[][] mon={{0,31,28,31,30,31,30,31,31,30,31,30,31},
                     {0,31,29,31,30,31,30,31,31,30,31,30,31}};
        int flag=isRen(year);
        if(mon[flag][month]-day>0){
            if(mon[flag][month]-day<days){
                days-=mon[flag][month]-day;
                day=mon[flag][month];
            }
            else{
                day+=days;
                return;
            }
        }
        while(days>0){
            if(month==12){
                year++;
                month=1;
                flag=isRen(year);
                day=0;
            }
            else
                month++;
            if(days-mon[flag][month]<=0){
                day=days;
                days=0;
            }
            else{
                days-=mon[flag][month];
                day=0;
            }
        }
    }
    public String toString(){
        return String.format("%d-%02d-%02d",year,month,day);
    }
    public static boolean xy(MyDate date1,MyDate date2){
        if(date1.year<date2.year)
            return true;
        if(date1.year==date2.year&&date1.month<date2.month)
            return true;
        if(date1.year==date2.year&& date1.month== date2.month&&date1.day<date2.day)
            return true;
        return false;
    }
    public static boolean equal(MyDate date1,MyDate date2){
        if(!xy(date1,date2)&&!xy(date2,date1))
            return true;
        return false;
    }
    public static boolean dy(MyDate date1,MyDate date2){
        if(!xy(date1,date2)&&!equal(date1,date2))
            return true;
        return false;
    }
    public static int difference(MyDate date1, MyDate date2){
        if(xy(date1,date2))
            return -count(date1,date2);
        return count(date2,date1);
    }

    private static int count(MyDate date1,MyDate date2){
        int l=0;
        int r=366*(date2.year-date1.year+1);
        while(l<r){
            int mid=(l+r)/2;
            MyDate x=new MyDate(date1.year,date1.month,date1.day);
            x.addDays(mid);
            if(xy(x,date2))
                l=mid+1;
            else
                r=mid;
        }
        return l;
    }
}
