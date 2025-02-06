public class MyDate {
    private int year;
    private int month;
    private int day;

    static int[] mon={0,31,28,31,30,31,30,31,31,30,31,30,31};

    public static boolean equal(MyDate date1, MyDate date2){
        return date1.year==date2.year&&date1.month==date2.month&&date1.day==date2.day;
    }
    public static boolean cmp(MyDate date1, MyDate date2){
        if(date1.year>date2.year)return true;
        if(date1.year==date2.year&&date1.month>date2.month)return true;
        if(date1.year==date2.year&&date1.month==date2.month&&date1.day>date2.day)return true;
        return false;
    }
    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void addDays(int days){
        for(int i=1;i<=days;i++){
            ++day;
            mon[2]=((year%100!=0&&year%4==0)||(year%100==0&&year%400==0))?29:28;
            if(day>mon[month]){
                ++month;
                day=1;
            }
            if(month>12){
                month=1;
                year++;
            }
        }
    }
    public String toString(){
        String y=""+year,m=""+month,d=""+day;
        while(y.length()<4)y="0"+y;
        while(m.length()<2)m="0"+m;
        while(d.length()<2)d="0"+d;
        return y+"-"+m+"-"+d;
    }
    public static int difference(MyDate date1, MyDate date2){
        int flg=-1,res=0;
        MyDate d1=new MyDate(date1.year,date1.month,date1.day);
        MyDate d2=new MyDate(date2.year,date2.month,date2.day);
        if(equal(d1,d2))return 0;
        if(cmp(d1,d2)){
            flg=1;
            d1.year^=d2.year;d2.year^=d1.year;d1.year^=d2.year;
            d1.month^=d2.month;d2.month^=d1.month;d1.month^=d2.month;
            d1.day^=d2.day;d2.day^=d1.day;d1.day^=d2.day;
        }
        while(!cmp(d1,d2)){d1.addDays(1);++res;}
        res--;
        return flg*res;
    }
}
