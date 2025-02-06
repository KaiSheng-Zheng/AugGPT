import java.util.Calendar;
public class MyDate {
    private int year;
    private int month;
    private int day;
    private Calendar calendar=Calendar.getInstance();
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public MyDate(int year, int month, int day){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public void addDays(int days){
        calendar.set(year,month,day);
        calendar.add(calendar.DATE,days);
        year=calendar.get(calendar.YEAR);
        month=calendar.get(calendar.MONTH);
        day=calendar.get(calendar.DATE);
    }
    public String toString(){
        return String.format("%04d-%02d-%02d", year,month,day);
    }
    public static int difference(MyDate date1, MyDate date2){
        if (date1.year>date2.year){
            return compareYear(date1,date2);
        }else if (date1.year< date2.year){
            return compareYear(date2,date1)*(-1);
        }else if (date1.month>date2.month){
            return compareMonth(date1,date2);
        }else if (date1.month<date2.month){
            return compareMonth(date2,date1)*(-1);
        }else return date1.day-date2.day;
    }
    public static int compareMonth(MyDate dateBig,MyDate dateSmall){
        int count=0;
        int February;
        if (isLeapYear(dateBig.year)){
            February=29;
        } else {
            February=28;
        }
        int month=dateSmall.month;
        for (;month<=dateBig.month-2;month++){
            count+=daysOfMonth(month,February);
        }
        count+=(daysOfMonth(month,February)-dateSmall.day+dateBig.day);
        return count;
    }
    public static int compareYear(MyDate dateBig,MyDate dateSmall){
        int count=0;
        int year=dateSmall.year;
        if (dateSmall.month<=2) {
            for (; year <= dateBig.year - 2; year++) {
                if (isLeapYear(year)) {
                    count += 366;
                } else count += 365;
            }
        }else {
            for (; year <= dateBig.year - 2; year++) {
                if (isLeapYear(year+1)) {
                    count += 366;
                } else count += 365;
            }
        }
        MyDate date1=new MyDate(year,dateSmall.month,dateSmall.day);
        MyDate endOfYear=new MyDate(year,12,31);
        MyDate beginOfYear=new MyDate(dateBig.year,1,1);
        count+=(compareMonth(endOfYear,date1)+compareMonth(dateBig,beginOfYear)+1);
        return count;
    }
    public static boolean isLeapYear(int Year){
        return (Year % 4 == 0 && Year % 100 != 0) || Year % 400 == 0;
    }
    public static int daysOfMonth(int Month,int Feb){
        if (Month<=7){
            if (Month==2) {
                return Feb;
            }else {
                if (Month % 2 == 0) {
                    return 30;
                } else {
                    return 31;
                }
            }
        }else {
            if (Month%2==0){
                return 31;
            }else {
                return 30;
            }
        }
    }
}