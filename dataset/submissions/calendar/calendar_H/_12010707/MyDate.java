import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public void addDays(int days) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(this.toString());
            long time = date.getTime();
            long day = (long)days * 24 * 60 * 60 * 1000;
            time += day;
            Date newDate = new Date(time);
            String dat=newDate.toString();
            this.year=Integer.parseInt(dat.substring(24,28));
            String mon=dat.substring(4,7);
            switch (mon){
                case("Jan"):this.month=1;
                break;
                case("Feb"):this.month=2;
                break;
                case("Mar"):this.month=3;
                break;
                case("Apr"):this.month=4;
                break;
                case("May"):this.month=5;
                break;
                case("Jun"):this.month=6;
                break;
                case("Jul"):this.month=7;
                break;
                case("Aug"):this.month=8;
                break;
                case("Sep"):this.month=9;
                break;
                case("Oct"):this.month=10;
                break;
                case("Nov"):this.month=11;
                break;
                case("Dec"):this.month=12;
                break;
            }
            int da = Integer.parseInt(dat.substring(8,10));
            this.day=da;



        }catch (ParseException e){

        }
    }
    public static int difference(MyDate date1, MyDate date2)  {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateh = dateFormat.parse(date1.toString());
            Date datet = dateFormat.parse(date2.toString());
            Long startime = dateh.getTime();
            Long endtime = datet.getTime();
            Long num = startime - endtime;
            return (int) (num / 24 / 60 / 60 / 1000);
        }catch (ParseException e){
            return 0;
        }
    }

}
