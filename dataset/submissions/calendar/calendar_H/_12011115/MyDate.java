public class MyDate {
    private int year;
    private int month;
    private int day;
    private static int[] monthOfYearUnLeap= {31,28,31,30,31,30,31,31,30,31,30,31};
    private static int[] monthOfYearLeap= {31,29,31,30,31,30,31,31,30,31,30,31};

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        this.day += days;
        if (isLeap(this.year)){
            while (this.day>monthOfYearLeap[this.month-1]){
                this.month++;
                if (this.month>12){
                    this.year++;
                    this.month-=12;
                }
                if(isLeap(this.year)){
                    this.day-=monthOfYearLeap[this.month-1];
                }else{
                    this.day-=monthOfYearUnLeap[this.month-1];
                }
            }
        }else {
            while (this.day>monthOfYearUnLeap[this.month-1]){
                this.month++;
                if (this.month>12){
                    this.year++;
                    this.month-=12;
                }
                if(isLeap(this.year)){
                    this.day-=monthOfYearLeap[this.month-1];
                }else{
                    this.day-=monthOfYearUnLeap[this.month-1];
                }
            }
        }
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2) {
        int boundYear = Math.min(date1.year,date2.year);
        int days1 = cal(date1,boundYear);
        int days2 = cal(date2,boundYear);
        return days1-days2;
    }
    public static int cal(MyDate date, int boundYear){
        int days1 = 0;
        if (isLeap(date.year)){
            for (int i = 0; i < date.month-1; i++) {
                days1+=monthOfYearLeap[i];
            }
            days1+=date.day;
        }else {
            for (int i = 0; i < date.month-1; i++) {
                days1+=monthOfYearUnLeap[i];
            }
            days1+=date.day;
        }
        for (int i = boundYear; i < date.year; i++) {
            if (isLeap(i)){
                days1+=366;
            }else {
                days1+=365;
            }
        }
        return days1;
    }
    public static boolean isLeap(int year){
        if((year%4 == 0&&year%100!=0)||year%400 == 0){
            return true;
        }
        return false;
    }


}
