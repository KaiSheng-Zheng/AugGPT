public class MyDate implements Cloneable{
    public static int[] Dt={0,31,28,31,30,31,30,31,31,30,31,30,31};
    private int year,month,day;
    public MyDate(int Y, int M, int D){year=Y;month=M;day=D;}
    public String toString(){return String.format("%d-%02d-%02d",year,month,day);}
    public static boolean isr(int y) {return y%400==0||(y%4==0&&y%100!=0);}
    public static boolean gthan(MyDate x,MyDate y){
        if(x.year!=y.year)return x.year>y.year;
        if(x.month!=y.month)return x.month>y.month;
        return x.day>y.day;
    }
    public static int getDate(int y,int m){return Dt[m]+(isr(y)&&m==2?1:0);}
    public void addDays(int days){
        day+=days;
        while(day>getDate(year,month)){day-=getDate(year,month);if(++month>12){month=1;++year;}}
    }
    public static int difference(MyDate date1, MyDate date2){
        int res=0,f=1;
        if(gthan(date2,date1)){MyDate t=date1.clone();date1=date2.clone();date2=t.clone();f=-1;}
        while(date2.year+1<date1.year){date2.addDays(365);res+=365;}
        while(!date1.toString().equals(date2.toString())){++res;date2.addDays(1);}
        return res*f;
    }
    @Override
    public MyDate clone() {
        try{return (MyDate)super.clone();}
        catch(CloneNotSupportedException e){throw new AssertionError();}
    }
}
