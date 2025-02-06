public class MyDate {
    private int year;
    private int month;
    private int day;
    private static final int[] DAYS_OF_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public boolean isLeapYear() {
        if(this.year% 4 == 0 && this.year % 100 != 0||this.year % 400 == 0) {
            return true;
        }
        return false;
    }
    public int DaysOfMonth() {
        if(isLeapYear() && this.month == 2) {
            return 29;
        }
        return DAYS_OF_MONTH[this.month-1];
    }
    public void addDays(int days) {
        day+=days;
        while(this.day> DaysOfMonth()) {
            this.day -= DaysOfMonth();
            this.month++;
            if(this.month > 12) {
                this.month = 1;
                this.year++;
            }
        }
    }
    public String toString() {
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay(){
        return day;
    }
    public static boolean DateCompare(MyDate date1,MyDate date2)
    {
        if(date1.getYear()>date2.getYear()){
            return true;
        }
        else if(date1.getYear()==date2.getYear()){
            if(date1.getMonth()>date2.getMonth()){
                return true;
            }
            else if(date1.getMonth()==date2.getMonth()){
                if(date1.getDay()>date2.getDay()){
                    return true;
                }
            }
        }
        return false;
    }
    public static int difference(MyDate date3, MyDate date4) {
//        int diff=0;
//        MyDate date1=new MyDate(date3.getYear(),date3.getMonth(),date3.getDay());
//        MyDate date2=new MyDate(date4.getYear(),date4.getMonth(),date4.getDay());
//        if(MyDate.DateCompare(date1,date2)){
//            diff=0;
//            while(!date1.toString().equals(date2.toString())){
//                date2.addDays(1);
//                diff++;
//
//            }
//            return diff;
//        }
//        else{
//            diff=0;
//            while(!date1.toString().equals(date2.toString())){
//                date1.addDays(1);
//                diff++;
//            }
//            return -diff;
//        }
        return 0;
    }
}
