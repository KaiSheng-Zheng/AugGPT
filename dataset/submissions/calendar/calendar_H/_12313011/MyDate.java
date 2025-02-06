public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
    public void addDays(int days){
        MyDate date = new MyDate(this.year,this.month,this.day);
        int newDays = getDays(date) + days;
        int newYear = 1;
        int newMonth = 1;
        int newDay;
        while(newDays > (isLeapYear(newYear) ? 366 : 365)){
            newDays -= isLeapYear(newYear) ? 366 : 365;
            newYear++;
        }
        while(newDays > getDaysFromMonth(newMonth,newYear)){
            newDays -= getDaysFromMonth(newMonth,newYear);
            newMonth++;
        }
        newDay = newDays;
        this.year = newYear;
        this.month = newMonth;
        this.day = newDay;
    }
    public String toString(){
        return String.format("%d-%02d-%02d",year,month,day);
    }
    public static int difference(MyDate date1, MyDate date2){
        return getDays(date1) - getDays(date2);
    }
    public static int getDays(MyDate date){
        int days = 0;
        for (int i = 1; i < date.getYear() ; i++) {
            days += isLeapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < date.getMonth(); i++) {
            days += getDaysFromMonth(i,date.getYear());
        }
        days += date.getDay();
        return days;
    }
    public static int getDaysFromMonth(int month,int year) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 31;
        }
    }

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
}
