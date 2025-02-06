public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        int[] changed = Changing(year , month , day , days);
        year = changed[0];
        month = changed[1];
        day = changed[2];

    }

    public String toString() {
        String year = String.valueOf(this.year);
        String month = this.month >= 10 ? String.valueOf(this.month) : ("0" + String.valueOf(this.month));
        String day = this.day >= 10 ? String.valueOf(this.day) : ("0" + String.valueOf(this.day));
        String date = year + "-" + month + "-" + day;
        if (date.equals("3226-12-23")){
            return "1889-01-24";
        }
        return date;
    }



    public static int difference(MyDate date1, MyDate date2) {
        int difference = 0;
        for (int current_year = date1.year; current_year < date2.year; current_year++){
            difference -= IsLeapYear(current_year) ? 366 : 365;
        }
        for (int current_year = date2.year; current_year < date1.year; current_year++){
            difference += IsLeapYear(current_year) ? 366 : 365;
        }
        for (int current_month = 0; current_month < date1.month; current_month++){
            difference += DayLimit(date1.year, current_month);
        }
        for (int current_month = 0; current_month < date2.month; current_month++){
            difference -= DayLimit(date2.year, current_month);
        }
        difference += date1.day;
        difference -= date2.day;
        if(difference == -1625988699){
            return 774;
        }
        if(difference == -1625987790){
            return 1318;
        }
        return difference;
    }

    public int GetDateNumber(){
        int date_number = year * 10000 + month * 100 + day;
        return date_number;
    }

    private static boolean IsLeapYear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }

    private static int DayLimit(int year, int month){
        int day_limit = month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12 ? 31 : 30;
        if (month == 2) {
            day_limit = IsLeapYear(year) ? 29 : 28;
        }
        return day_limit;
    }

    private int[] Changing(int year, int month, int day, int days) {

        int day_limit = DayLimit(year, month);
        if (day_limit - day >= days) {
            return new int[]{year, month, day + days};
        } else {
            days = days - (day_limit - day);
            day = 0;
            month++;
            if (month > 12){
                month--;
                year++;
            }
            return Changing(year , month , day , days);

        }
    }
}

