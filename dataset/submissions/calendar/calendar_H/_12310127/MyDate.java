public class MyDate {
    private int year;
    private int month;
    private int day;
    static int[] Month1 = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] Month2 = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days){
        int lessday = lessday(this);
        while(days >= lessday){
            this.year++;
            this.month = 1;
            this.day = 1;
            days -= lessday;
            if(leapyear(this.year)){
                lessday = 366;
            }
            else{
                lessday = 365;
            }
        }
        if (leapyear(this.year)) {
            for (int i = this.month; days >= Month2[i] - this.day + 1; i++) {
                this.month++;
                days -= Month2[i] - this.day + 1;
                this.day = 1;
            }
        } else {
            for (int i = this.month; days >= Month1[i] - this.day + 1; i++) {
                this.month++;
                days -= Month1[i] - this.day + 1;
                this.day = 1;
            }
        }
        this.day += days;
    }
    public static int difference(MyDate date1, MyDate date2){
        int lessday1 = lessday(date1);
        int lessday2 = lessday(date2);
        int dif = lessday2 - lessday1;
        int year1 = date1.year + 1;
        int year2 = date2.year + 1;
        if(year1 >= year2){
            for(int i = year2; i < year1; i++){
                if(leapyear(i)){
                    dif += 366;
                }
                else{
                    dif += 365;
                }
            }
        }
        else {
            for(int i = year1; i < year2; i++){
                if(leapyear(i)){
                    dif -= 366;
                }
                else{
                    dif -= 365;
                }
            }
        }
        return dif;
    }
    public static boolean leapyear(int year){
        if((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)){
            return true;
        }
        return false;
    }
    public static int lessday(MyDate date){
        int lessday = 0;
        if(leapyear(date.year)){
            lessday += Month2[date.month] - date.day + 1;
            for(int i = date.month + 1; i <= 12; i++){
                lessday += Month2[i];
            }
        }
        else {
            lessday += Month1[date.month] - date.day + 1;
            for(int i = date.month + 1; i <= 12; i++){
                lessday += Month1[i];
            }
        }
        return lessday;
    }
    public String toString(){
        if(this.month < 10 && this.day < 10)
            return this.year + "-0" + this.month + "-0" + this.day;
        if(this.month > 10 && this.day < 10)
            return this.year + "-" + this.month + "-0" + this.day;
        if(this.month > 10 && this.day > 10)
            return this.year + "-" + this.month + "-" + this.day;
        else
            return this.year + "-0" + this.month + "-" + this.day;
    }
}