
public class MyDate{
    public int year,month,day;
    int[] daycount={0,31,28,31,30,31,30,31,31,30,31,30,31};
    public MyDate(int y,int m,int d){year=y;month=m;day=d;}
    public String toString(){
        String m="",d="";
        if(month<10){
            m="0"+month;
        }else {
            m=""+month;
        }
        if(day<10){
            d="0"+day;
        }else{
            d=""+day;
        }
        return year+"-"+m+"-"+d;
    }
    private boolean is(){return year%400==0||(year%100!=0&&year%4==0);}

    public void addDays(int days){
        day+=days;
        while(day>daycount[month]){
            if(month==2&&is()){
                day-=1;
            }
            day-=daycount[month];
            month+=1;
            if(month==13){
                year+=1;month=1;
            }
        }
    }
    public static int difference(MyDate date1,MyDate date2){
        if(date1.year>date2.year){
            return count(date1,date2);
        } else if (date1.year== date2.year) {
            if(date1.month>date2.month){
                return count(date1,date2);
            } else if (date1.month== date2.month){
                return date1.day-date2.day;
            }
        }
        return count(date2,date1)*-1;
    }
    private static int count(MyDate date1,MyDate date2){
        int count=0;
        MyDate niu=new MyDate(date2.year, date2.month, date2.day);
        while(niu.year!= date1.year||niu.month!=date1.month||niu.day!=date1.day){
            niu.addDays(1);
            count+=1;
        }
        return count;
    }
}