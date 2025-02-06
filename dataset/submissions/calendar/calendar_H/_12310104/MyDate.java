public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static int ReturnYearsLength(int year){
        int days = 0;
        for(int i = 0;i<year;i++){
            days += ReturnYearLength(i);
        }
        return days;
    }

    public static int ReturnMonthsLength(int year,int month){
        int days =0;
        for(int i = 1;i<month;i++){
            days += ReturnMonthLength(year, i);
        }
        return days;
    }

    public static int ReturnYearLength(int year){
        if((year%4==0 && year%100 !=0)|| year%400==0){
            return 366;
        }
        else return 365;
    }

    public static int ReturnMonthLength(int year,int month){
        if((year%4==0 && year%100 !=0)|| year%400==0){
            if(month ==2) return 29;
        }
        
            switch (month) {
                case 1:
                    return 31;
                case 2:
                    return 28;
                case 3:
                    return 31;
                case 4:
                    return 30;
                case 5:
                    return 31;
                case 6:
                    return 30;
                case 7:
                    return 31;
                case 8:
                    return 31;
                case 9:
                    return 30;
                case 10:
                    return 31;
                case 11:
                    return 30;
                case 12:
                    return 31;
                default:
                    return 0;
            }
        
        
    }

    public void addDays(int days){
        while (this.day+days>ReturnMonthLength(this.year, this.month)) {
            days-=ReturnMonthLength(this.year, this.month);
            this.month++;
            if(this.month>12){
                this.year++;
                this.month = 1;
            }
        }
        this.day += days;
    }

    public String toString(){
        String month_to_print = String.valueOf(this.month);
        String day_to_print = String.valueOf(this.day);
        if(month_to_print.length()==1)month_to_print = "0"+month_to_print;
        if(day_to_print.length()==1)day_to_print = "0"+day_to_print;
        return this.year+"-"+month_to_print+"-"+day_to_print;

    }

    public static int difference(MyDate date1, MyDate date2){
        int Dates_1 = ReturnYearsLength(date1.year) + ReturnMonthsLength(date1.year,date1.month)+date1.day;
        int Dates_2 = ReturnYearsLength(date2.year) + ReturnMonthsLength(date2.year,date2.month)+date2.day;
        return Dates_1 - Dates_2;

    }
}

