public class MyDate {
    int year,month,day;
    public MyDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    private void Add(){
        int[][] a={
                {0,31,28,31,30,31,30,31,31,30,31,30,31},
                {0,31,29,31,30,31,30,31,31,30,31,30,31}
        };
        int ju=(year%400==0?1:(year%100==0?0:(year%4==0?1:0)));
        day++;
        if(day>a[ju][month]){
            month++;
            day=1;
        }
        if(month>12){
            month=1;
            year++;
        }
    }
    public void addDays(int days){
        assert(days>0);
        while(days!=0) {
            Add();
            days--;
        }
    }
    public String toString(){
        String res=year+"-";
        if(month<10) res=res+"0";
        res=res+month+"-";
        if(day<10) res=res+"0";
        res=res+day;
        return res;
    }
    public static boolean equal(MyDate date1, MyDate date2){
        return (!cmp(date1,date2))&&(!cmp(date2,date1));
    }
    public static boolean cmp(MyDate date1, MyDate date2){
        if(date1.year<date2.year) return true;
        else if(date1.year>date2.year) return false;
        if(date1.month<date2.month) return true;
        else if(date1.month>date2.month) return false;
        return date1.day < date2.day;
    }
    public static int difference(MyDate d1, MyDate d2){
        MyDate date1=new MyDate(d1.year,d1.month,d1.day);
        MyDate date2= new MyDate(d2.year,d2.month,d2.day);
        int f=-1;
        if(!cmp(date1,date2)){
            MyDate tmp=new MyDate(date1.year,date1.month,date1.day);
            date1=date2;date2=tmp;
            f=1;
        }
        int tot=0;
        while(!equal(date1,date2)){
            date1.Add();
            tot++;
        }
        return tot*f;
    }
}
/*

3459 11 20
2923 1 1
 */
