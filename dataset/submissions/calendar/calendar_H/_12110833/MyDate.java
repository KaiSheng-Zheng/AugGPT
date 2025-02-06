public class MyDate {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day){ //constructor method;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days){ //addDays method: +days;
        int[] montharray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = 0; i < days; i++) {
            if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                montharray[1] = 29;
            } else {
                montharray[1] = 28;
            }

            if (day < montharray[month-1]){
                day++;
            } else {
                day = 1;
                if(month < 12){
                    month++;
                } else {
                    month = 1;
                    year++;
                }
            }
        }
    }


    public String toString(){
        return String.format("%d-%02d-%02d", year, month, day);
    }

    public static int difference(MyDate date1, MyDate date2){ //difference method;
        int by=0,bm=0,bd=0,sy=0,sm=0,sd=0;

        if(date1.getYear() > date2.getYear()){
            by = date1.getYear(); bm = date1.getMonth(); bd = date1.getDay();
            sy = date2.getYear(); sm = date2.getMonth(); sd = date2.getDay();
        }
        if(date1.getYear() < date2.getYear()){
            by = date2.getYear(); bm = date2.getMonth(); bd = date2.getDay();
            sy = date1.getYear(); sm = date1.getMonth(); sd = date1.getDay();
        }
        if(date1.getYear() == date2.getYear()){
            if(date1.getMonth() > date2.getMonth()){
                by = date1.getYear(); bm = date1.getMonth(); bd = date1.getDay();
                sy = date2.getYear(); sm = date2.getMonth(); sd = date2.getDay();
            }
            if(date1.getMonth() < date2.getMonth()){
                by = date2.getYear(); bm = date2.getMonth(); bd = date2.getDay();
                sy = date1.getYear(); sm = date1.getMonth(); sd = date1.getDay();
            }
            if(date1.getMonth() == date2.getMonth()){
                if(date1.getDay() > date2.getDay()){
                    by = date1.getYear(); bm = date1.getMonth(); bd = date1.getDay();
                    sy = date2.getYear(); sm = date2.getMonth(); sd = date2.getDay();
                }
                if(date1.getDay() < date2.getDay()){
                    by = date2.getYear(); bm = date2.getMonth(); bd = date2.getDay();
                    sy = date1.getYear(); sm = date1.getMonth(); sd = date1.getDay();
                }
                if(date1.getDay() == date2.getDay()){
                    by = date1.getYear(); bm = date1.getMonth(); bd = date1.getDay();
                    sy = date2.getYear(); sm = date2.getMonth(); sd = date2.getDay();
                }
            }
        }
        int count;
        for(count = 0; ; count++){
            if(by == sy && bm == sm && bd == sd){
                break;
            }
            int[] array = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if ((sy % 400 == 0) || (sy % 4 == 0 && sy % 100 != 0)) {
                array[1] = 29;
            } else {
                array[1] = 28;
            }

            if (sd < array[sm-1]){
                sd++;
            } else {
                sd = 1;
                if(sm < 12){
                    sm++;
                } else {
                    sm = 1;
                    sy++;
                }
            }

        }

        if(date1.getYear() > date2.getYear()){
            return count;
        }
        if(date1.getYear() < date2.getYear()){
            return -count;
        }
        if(date1.getYear() == date2.getYear()){
            if(date1.getMonth() > date2.getMonth()){
                return count;
            }
            if(date1.getMonth() < date2.getMonth()){
                return -count;
            }
            if(date1.getMonth() == date2.getMonth()){
                if(date1.getDay() > date2.getDay()){
                    return count;
                }
                if(date1.getDay() < date2.getDay()){
                    return -count;
                }
                if(date1.getDay() == date2.getDay()){
                    return count;
                }
            }
        }
        return by;
    }
}
