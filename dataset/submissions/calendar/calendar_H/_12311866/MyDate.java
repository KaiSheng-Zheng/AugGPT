
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {

    private int year;
    private int month;
    private int day;
    private Date date;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        String str = "" + year + "-" + month + "-" + day;
        try {
            this.date = sdf.parse(str);
        } catch (Exception e) {
        }
    }


    public void addDays(int days) {
//        SimpleDateFormat sdf=new SimpleDateFormat("dd");
//        String str = ""+days;
//        Date adddays = new Date();
//        try {
//        adddays=sdf.parse(str);
//        } catch (Exception e) {
//        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        date = cal.getTime();
//        day += days;
//        switch (month) {
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12:
//                int m1 = day / 31;
//                int d1 = day % 31;
//                month += m1;
//                day = d1;
//                break;
//            case 4:
//            case 6:
//            case 9:
//            case 11:
//                int m2 = day / 30;
//                int d2 = day % 30;
//                month += m2;
//                day = d2;
//                break;
//            default:
//                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
//                    int m3 = day / 29;
//                    int d3 = day % 29;
//                    month += m3;
//                    day = d3;
//                    break;
//                } else {
//                    int m3 = day / 28;
//                    int d3 = day % 28;
//                    month += m3;
//                    day = d3;
//                    break;
//                }
//        }

    }

    public String toString() {

        // String str = new String();
        //String str = new String("%04d-%02d-%02d",year,month,day);
        // str.formatted("%04d-%02d-%02d", year, month, day);
        // return str;
        return this.sdf.format(this.date);
        //System.out.printf("%04d-%02d-%02d",year,month,day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        Date start = date1.getDate();
        Date end = date2.getDate();
        long day=0;
        try {
            long millisecond = start.getTime() - end.getTime();
            day = millisecond / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int d = (int) day;
        return d;
    }
        public Date getDate () {
            return this.date;
        }
    }
