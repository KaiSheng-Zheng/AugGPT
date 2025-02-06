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
    public static int difference(MyDate date1, MyDate date2) {
        int diff1=0;
        int diff2=0;
        final MyDate date0 = new MyDate(1586,1,1);
        for(int i = date0.getYear(); i<date1.getYear(); i++){
            if((i% 4 == 0 && i % 100 != 0||i % 400 == 0)){
                diff1+=366;
            }
            else{
                diff1+=365;
            }
        }
        for(int i = date0.getYear(); i<date2.getYear(); i++){
            if((i% 4 == 0 && i % 100 != 0||i % 400 == 0)){
                diff2+=366;
            }
            else{
                diff2+=365;
            }
        }
        for(int i = date0.getMonth(); i<date1.getMonth(); i++){
            diff1+=DAYS_OF_MONTH[i-1];
            if(i==2&&date1.isLeapYear()){
                diff1++;
            }
        }
        for(int i = date0.getMonth(); i<date2.getMonth(); i++){
            diff2+=DAYS_OF_MONTH[i-1];
            if(i==2&&date2.isLeapYear()){
                diff2++;
            }
        }
        diff1+=date1.getDay()-1;
        diff2+=date2.getDay()-1;

        return diff1-diff2;
    }
}
