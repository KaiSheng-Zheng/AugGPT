
import java.text.DecimalFormat;
import java.time.LocalDate;


public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate() {
            }

    public MyDate(int year, int month, int day) {
        this.year=year;
        this.day=day;
        this.month=month;

    }
    public void addDays(int days){
        String Date = String.valueOf(LocalDate.of(year,month,day).plusDays(days));
        String [] a1=Date.split("-");
        this.year= Integer.parseInt(a1[0]);
        this.month= Integer.parseInt(a1[1]);
        this.day= Integer.parseInt(a1[2]);

    }
    public String toString(){
        DecimalFormat df1 = new DecimalFormat("0000");
        DecimalFormat df2 = new DecimalFormat("00");
        DecimalFormat df3 = new DecimalFormat("00");
        String y=df1.format(year);
        String m=df2.format(month);
        String d=df3.format(day);
        String s= y+"-"+m+"-"+d;
        return s;
    }
    public int sum(int year,int month,int days){
        int day=0;
        int[] x={0,31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=1;i<year;i++){
            if(i%4==0&& i%100!=0 || i%400==0){
                day+=366;
            }else{
                day+=365;
            }
        }
        if(year%4==0&& year%100!=0 || year%400==0){
            x[2]=29;
        }
        for(int i=1;i<month;i++){

            day+=x[i];
        }
        day+=days;
        return day;
    }
    public static int difference(MyDate date1,MyDate date2){
        String str1=date1.toString();
        String str2=date2.toString();
        String [] a1=str2.split("-");
        String [] a2=str1.split("-");
        int daysum1= date1.sum(Integer.parseInt(a1[0]),Integer.parseInt(a1[1]),Integer.parseInt(a1[2]));
        int daysum2= date1.sum(Integer.parseInt(a2[0]),Integer.parseInt(a2[1]),Integer.parseInt(a2[2]));

        return daysum2-daysum1;

    }

}
