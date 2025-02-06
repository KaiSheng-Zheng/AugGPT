public class MyDate {

    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days){
        day = day + days;
        int days_of_month = get_Days_of_Month(year,month);
        while (day > days_of_month) {
            month++;
            if(month > 12){
                month = month - 12;
                year++;
            }
            day = day - days_of_month;
            days_of_month = get_Days_of_Month(year,month);
        }
    }

    public String toString(){
        return String.format("%d-%d%d-%d%d",year,month/10,month%10,day/10,day%10);
    }

    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }

    public static int get_Days_of_Month(int year,int month){
        int daynumber;
        switch (month) {
            case 2:
                if(year%400 == 0 || (year%4 == 0 && year%100 != 0)){
                    daynumber = 29;
                }else{
                    daynumber = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daynumber = 30;
                break;
            default:
                daynumber = 31;
                break;
        }
        return daynumber;
    }

    public static int get_Days_of_Year(int year){
        if(year%400 == 0 || (year%4 == 0 && year%100 != 0)){
            return 366;
        }else{
            return 365;
        }
    }

    public static int get_Days_between_Years(int year1,int year2){
        int result = 0;
        int sign;
        int ko;
        int kn;
        if (year1> year2){
            sign = 1;
            ko = year2;
            kn = year1;
        }else{
            sign = -1;
            ko = year1;
            kn = year2;
        }
        for(int i = ko; i<kn;i++){
            result = result + get_Days_of_Year(i);
        }
        return sign*result;
    }

    public static int get_Days(int year,int month,int day){//get days until that day.
        int result = day;
        for(int i = 1; i<month;i++){
            result = result + get_Days_of_Month(year,i);
        }
        return result;
    }

    public static int difference(MyDate date1, MyDate date2){
        int result = 0;
        if(date1.year == date2.year){
            if(date1.month == date2.month){
                result = date1.day - date2.day;
            }else if(date1.month > date2.month){
                result = get_Days(date1.year,date1.month,date1.day)-get_Days(date2.year,date2.month,date2.day);
            }
        }else{
            result = get_Days_between_Years(date1.year,date2.year)+get_Days(date1.year,date1.month,date1.day)-get_Days(date2.year,date2.month,date2.day);
        }
        return result;
    }
}