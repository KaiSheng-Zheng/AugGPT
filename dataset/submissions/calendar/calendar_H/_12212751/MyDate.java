import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        setYear(year);
        setMonth(month);
        setDay(day);
    }
    public void addDays(int days){
        setDay(getDay()+days);
        while(doaddmonth(getDay())){
            addmonth(getDay());
            while(doaddyear(getMonth())){
                addyear(getMonth());
            }
        }
    }

    public String toString(){
        return String.format("%04d-%02d-%02d",getYear(),getMonth(),getDay());
    }
    public static int difference(MyDate date1, MyDate date2) {
        LocalDate date3 = LocalDate.of(date1.getYear(), date1.getMonth(), date1.getDay());
        LocalDate date4 = LocalDate.of(date2.getYear(), date2.getMonth(), date2.getDay());
        return (int)-ChronoUnit.DAYS.between(date3, date4);
    }
    public static int monthdays(int month){
        int days=0;
        switch (month){
            case 12:days+=31;
            case 11:days+=30;
            case 10:days+=31;
            case 9:days+=30;
            case 7:days+=31;
            case 8:days+=31;
            case 6:days+=30;
            case 5:days+=31;
            case 4:days+=30;
            case 3:days+=31;
            case 2:days+=28;
            case 1:days+=31;
        }
        return days;
    }
    public boolean doaddmonth(int day){
        if(getMonth()==1||getMonth()==3||getMonth()==5||getMonth()==7||getMonth()==8||getMonth()==10||getMonth()==12){
            return day > 31;
        }
        else if(getMonth()==2){
            if(isLeapyear(getYear())){
                return day > 29;
            }
            else {
                return day > 28;
            }
        }
        else{
            return day > 30;
        }
    }
    public void addmonth(int day){
        if(getMonth()==1||getMonth()==3||getMonth()==5||getMonth()==7||getMonth()==8||getMonth()==10||getMonth()==12){
                setDay(getDay()-31);
        }
        else if(getMonth()==2){
            if(isLeapyear(getYear())){
                setDay(getDay()-29);
            }
            else{
                setDay(getDay()-28);
            }
        }
        else{
            setDay(day-30);
        }
        setMonth(getMonth()+1);
    }
    public boolean isLeapyear(int year){
        return year % 4 == 0 && year % 100 != 0;
    }
    public boolean doaddyear(int month){
        return month > 12;
    }
    public void addyear(int month){
        if(month>12){
            setYear(getYear()+1);
            setMonth(1);
        }
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
}