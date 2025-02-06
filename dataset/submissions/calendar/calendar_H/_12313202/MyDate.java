public class MyDate {
    final static private int m[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private static boolean judge(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private void step(){
        day++;
        if(day > m[month] || (!judge(year) && month == 2 && day == 29)){
            day = 1;
            month++;
        }
        if(month == 13){
            month = 1;
            year++;
        }
    }

    public void addDays(int days){
        while(days > 0 && month <= 2){
            days--;
            step();
        }
        while(days >= 366){
            if(judge(year + 1) && month > 2) days -= 366;
            else days -= 365;
            year++;
        }
        while(days > 0){
            days--;
            step();
        }
    }

    public String toString(){
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2){
        if(date1.year < date2.year) return -difference(date2, date1);
        int v1 = date1.day, v2 = date2.day;
        for(int i = 1; i < date1.month; i++){
            v1 += m[i];
            if(i == 2 && !judge(date1.year)) v1--;
        }
        for(int i = 1; i < date2.month; i++){
            v2 += m[i];
            if(i == 2 && !judge(date2.year)) v2--;
        }
        for(int i = date2.year; i < date1.year; i++){
            v1 += judge(i) ? 366 : 365;
        }
        return v1 - v2;
    }

    public static int judge(MyDate d1, MyDate d2){
        if(d1.year != d2.year) return d1.year < d2.year ? -1 : 1;
        else{
            if(d1.month != d2.month) return d1.month < d2.month ? -1 : 1;
            else{
                if(d1.day != d2.day) return d1.day < d2.day ? -1 : 1;
                else return 0;
            }
        }
    }
}
