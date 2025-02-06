public class MyDate {
    private int year;
    private int month;
    private int day;
    private int[] daysInMonth={31,28,31,30,31,30,31,31,30,31,30,31};


    public MyDate(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public void addDays(int days){
        day+=days;
        while(!ifDateValid(month,day)){
            if(ifGapyear(year)){
                daysInMonth[1]=29;
            }
            else{
                daysInMonth[1]=28;
            }
            if (day>daysInMonth[month-1]){
                day-=daysInMonth[month-1];
                month++;
            }
            if (month>12){
                month=1;
                year++;
            }
        }
    }

    public static int difference(MyDate date1, MyDate date2){
        int count = 0;
        MyDate dateInitial = new MyDate(date1.year, date1.month,date1.day);
        MyDate dateFinal = new MyDate(date2.year, date2.month,date2.day);
        while (true){
            if(equals(dateInitial,date2)){
                return -count;
            }
            if (equals(dateFinal,date1)){
                return count;
            }
            dateInitial.addDays(1);
            dateFinal.addDays(1);
            count++;
        }

    }

    public boolean ifDateValid(int month , int day){
        if (month>12 || month<1){
            return false;
        }
        if (day>daysInMonth[month-1] || day<1){
            return false;
        }
        return true;
    }

    public boolean ifGapyear(int year){
        if (year%4==0 && year%100!=0){
            return true;
        }
        if (year%400==0){
            return true;
        }
        return false;
    }

    public static boolean equals(MyDate date1,MyDate date2){
        if (date1.year==date2.year && date1.month==date2.month && date1.day==date2.day){
            return true;
        }else
            return false;
    }

    public String toString(){
        String Month,Day;
        if(month<10){
            Month  = "0"+this.month;
        }else{
            Month = String.valueOf(this.month);
        }
        if(day<10){
            Day = "0"+this.day;
        }else{
            Day = String.valueOf(this.day);
        }
        return String.format("%d-%s-%s",year,Month,Day);
    }
}
