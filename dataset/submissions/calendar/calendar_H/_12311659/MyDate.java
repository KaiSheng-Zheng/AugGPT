public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static boolean whetherleapyear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int monthmaxday(int month, int year) {
        int monthmaxday = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            monthmaxday = 31;
        } else if (month == 2 && whetherleapyear(year)) {
            monthmaxday = 29;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            monthmaxday = 30;
        } else {
            monthmaxday = 28;
        }
        return monthmaxday;
    }

    public void addDays(int days) {
        day += days;
        while (day > monthmaxday(month, year)) {
            day -= monthmaxday(month, year);
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    public String toString() {
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public static int min(int a,int b ){
        int min=0;
        if(a>b){
            min=b;
        }else{
            min=a;
        }
        return min;
    }
    public static int max(int a,int b ){
        int max=0;
        if(a>b){
            max=a;
        }else{
            max=b;
        }
        return max;
    }
    public static int dayInYear(MyDate date){
        int day=0;
        for(int i=1;i< date.month;i++){
            day+= date.monthmaxday(i, date.year);
        }
        day+=date.day;
        return day;
    }
    public static int difference(MyDate date1, MyDate date2) {
        int leapnumber=0;
        int gap=0;
        int max=max(date1.year, date2.year);
        int min=min(date1.year, date2.year);
        for(int i=min(date1.year, date2.year);i<max(date1.year, date2.year);i++){
            if(whetherleapyear(i)){
                leapnumber++;
            }
        }
        if(date1.year==date2.year){
            gap=dayInYear(date1)-dayInYear(date2);
        }else if(date1.year>date2.year){
            gap=(max-min)*365+leapnumber-dayInYear(date2)+dayInYear(date1);
        }else{
            gap=-((max-min)*365+leapnumber-dayInYear(date1)+dayInYear(date2));
        }
            return gap;
    }
}
