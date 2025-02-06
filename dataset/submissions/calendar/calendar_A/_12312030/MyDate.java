public class MyDate {
    private int year;
    private int month;
    private int day;
    private String name;
    public MyDate() {
        year=month=day=0;
    }
    public MyDate(int year,int month,int day) {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void setMonth(int m) {month=m;}
    public int getYear() {return year;}
    public int getMonth() {return month;}
    public int getDay() {return day;}
    public void setName(String s) {name=s;}
    public String getName() {return name;}
    public boolean isLeapyear() {
        if(year%400==0) return true;
        if(year%4==0&&year%100!=0) return true;
        return false;
    }
    public boolean isLongmonth() {
        if(month==4) return false;
        if(month==6) return false;
        if(month==9) return false;
        if(month==11) return false;
        return true;
    }
    public void addDays(int days) {
        while(days>0) {
            int num_mon;
            if(month==2) {
                if(isLeapyear()) num_mon=29;
                else num_mon=28;
            }else if(isLongmonth()) {
                num_mon=31;
            }else num_mon=30;
            if(days+day<=num_mon){
                day+=days;return;
            }
            month++;
            days-=num_mon-day+1;
            day=1;
            if(month>12) {
                year++;
                month=1;
            }
            //System.out.println(toString());
           // System.out.println(days);
        }
    }
    public String toString() {
        String s1;
        String s2;
        String s3;
        if(year<10) s1="000"+year;
        else if(year<100) s1="00"+year;
        else if(year<1000) s1="0"+year;
        else s1=Integer.toString(year);
        if(month<10) s2="0"+month;
        else s2=Integer.toString(month);
        if(day<10) s3="0"+day;
        else s3=Integer.toString(day);
        return s1+'-'+s2+'-'+s3;
    }
    static public boolean is_big(MyDate date1,MyDate date2){
        if(date1.year>date2.year) return true;
        if(date1.year<date2.year) return false;
        if(date1.month>date2.month) return true;
        if(date1.month<date2.month) return false;
        if(date1.day>date2.day) return true;
        if(date1.day<date2.day) return false;
        return true;
    }
    public static  boolean isLeapyear(int year) {
        if(year%400==0) return true;
        if(year%4==0&&year%100!=0) return true;
        return false;
    }
    public static boolean isLongmonth(int month) {
        if(month==4||month==6||month==9||month==11) return false;
        return true;
    }
    public static int getNumfro(MyDate date) {
        int res=0;
        for(int i=1;i<date.month;i++) {
            if(i==2) {
                if(isLeapyear(date.year)) res+=29;
                else res+=28;
            }else if(isLongmonth(i)) {
                res+=31;
            }else res+=30;
            //System.out.printf("%dmoth: %d\n",i,res);
        }
        //System.out.println(date.toString());
        //System.out.println(res);
        res+=date.day;
        return res;
    }
    public static int getNum(MyDate date1,MyDate date2) {
        int res;
        if(date1.year==date2.year) {
            return getNumfro(date1)-getNumfro(date2);
        }else {
            if(isLeapyear(date2.year)) {
                res=366;
            }else res=365;
            res+=getNumfro(date1)-getNumfro(date2);
            for(int i=date2.year+1;i<date1.year;i++) {
                if(isLeapyear(i)) res+=366;
                else res+=365;
            }
        }
        return res;
    }
    public static int difference(MyDate date1,MyDate date2) {
        boolean isBig=is_big(date1,date2);
        int ans;
        if(isBig) ans=getNum(date1,date2);
        else ans=getNum(date2,date1);
        if(!isBig) ans=-ans;
        return ans;
    }
}
