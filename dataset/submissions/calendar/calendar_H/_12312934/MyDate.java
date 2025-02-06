public class MyDate {
    private int year;
    private int month;
    private int day;
    static private final int[][] m={{0,31,28,31,30,31,30,31,31,30,31,30,31},{0,31,29,31,30,31,30,31,31,30,31,30,31}};
    static private final int[] y={365,366};
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public MyDate(MyDate x){
        year = x.year;
        day = x.day;
        month = x.month;
    }
    static public int check(int year){
        if(year<=1582){
            if(year%4==0) return 1;
            else return 0;
        }
        if(year%4!=0) return 0;
        if(year%400==0||year%100!=0) return 1;
        return 0;
    }
    public static boolean bigger(MyDate x,MyDate y){
        if(x.year<y.year) return false;
        if(x.year>y.year) return true;
        if(x.month>y.month) return true;
        if(x.month<y.month) return false;
        return x.day>y.day;
    }
    public static boolean Equal(MyDate x,MyDate y){
        return x.year==y.year&&x.month==y.month&&x.day==y.day;
    }
    private static  int sub0(MyDate x){
        int ans=x.day-1;
        for(int i=1;i<x.month;++i)
            ans+=m[check(x.year)][i];
        return ans;
    }
    private static int sub(MyDate Y,MyDate X){
        int ans=0;
        ans-=sub0(X);
        ans+=sub0(Y);
        for(int i=X.year;i<Y.year;++i){
            ans+=y[check(i)];
        }
        return ans;
    }
    private int addyear(int days){
        if(month>2){
            year++;
            days-=y[check(year)];
        }else if(month==2 && day==29){
            days-=365;
            year++;
            day=28;
        }else{
            days-=y[check(year)];
            year++;
        }
        return days;
    }
    public void addDays(int days){
        while (days>0){
            if(days>365){
                days = addyear(days);
            }else if(days+day>m[check(year)][month]){
                days-=m[check(year)][month]-day+1;
                month++;
                if(month==13){
                    month=1;
                    year++;
                }
                day=1;
            }else{
                day+=days;
                days=0;
            }
        }
    }
    public String toString(){
        if(month<10 && day<10) return String.format("%d-0%d-0%d",year, month,day);
        if(month<10 ) return String.format("%d-0%d-%d",year, month,day);
        if(day<10) return String.format("%d-%d-0%d",year, month,day);
        return String.format("%d-%d-%d",year, month,day);
    }
    public static int difference(MyDate date1, MyDate date2){
        if(bigger(date1,date2)) return sub(date1,date2);
        else return -sub(date2,date1);
    }
}
