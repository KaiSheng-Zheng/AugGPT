public class MyDate {
    private int year,month,day;
    static int[][] lim=new int [][]{ {0,31,28,31,30,31,30,31,31,30,31,30,31},{0,31,29,31,30,31,30,31,31,30,31,30,31} };
    public MyDate(int y,int m,int d){
        year=y;month=m;day=d;
    }
    public void addDays(int cnt){
        while(cnt>0){
            int tmp=0;
            if((year%4==0&&year%100!=0)||year%400==0)   tmp=1;
            if(cnt>=lim[tmp][month]-day+1){
                cnt-=(lim[tmp][month]-day+1);
                month++;day=1;
                if(month==13){
                    month=1;year++;
                }
            }
            else{
                day+=cnt;
                cnt=0;
            }
        }
        return;
    }
    public String toString(){
        String y=String.valueOf(year);
        while(y.length()<4) y="0"+y;
        String d=String.valueOf(day);
        while(d.length()<2) d="0"+d;
        String m=String.valueOf(month);
        while(m.length()<2) m="0"+m;
        String tmp=y+"-"+m+"-"+d;
        return tmp;
    }

    public static boolean Compare(MyDate date1,MyDate date2){
        if(date1.year!=date2.year)    return (date1.year<date2.year);
        else if(date1.month!=date2.month)   return (date1.month<date2.month);
        else return date1.day<date2.day;
    }
    public static boolean Equal(MyDate date1,MyDate date2){
        return (date1.year==date2.year)&&(date1.month==date2.month)&&(date1.day==date2.day);
    }
    public static int difference(MyDate dat1,MyDate dat2){
        int f=-1;
        MyDate date1=new MyDate (dat1.year,dat1.month, dat1.day),date2= new MyDate(dat2.year, dat2.month, dat2.day);
        if(!Compare(date1,date2)){
             MyDate tmp;
             tmp=date2;
             date2=date1;
             date1=tmp;
            f=1;
        }
//        System.out.print(date1+" "+date2);

        for(int i=0;i<=100000000;++i){
//            System.out.println(date1+" "+date2);
            if(!Compare(date1,date2)&&!Compare(date2,date1)){
//                System.out.printf("%d???\n",i*f);
                return i*f;
            }
            else{
                date1.addDays(1);
            }
        }
//        System.out.println("????");
        return 0;
    }

}
