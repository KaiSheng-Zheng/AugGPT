import java.util.Date;
public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    static int tempThisDay,tempThisMonth,tempThisYear;
    public void addDays(int days){
        tempThisDay = this.day;
        tempThisMonth = this.month;
        tempThisYear = this.year;
        if (daysIn(this.month, this.year) - this.day >= days) {
                this.day = this.day + days;

            } else {
                while (daysIn(this.month, this.year) - this.day < days) {
                    days = days - (daysIn(this.month, this.year) - this.day);
                    this.month++;
                    this.day = 0;
                    if (this.month == 13) {
                        this.month = 1;
                        this.year++;
                    }
                }
                this.day = this.day + days;
            }



        /*
        System.out.println(this.month);
        System.out.println(this.day);

         */

    }
    public static boolean isLeapYear(int year){
        if(year % 400 ==0 || (year % 4==0 && year % 100 !=0)){
            return true;
        }else return false;
    }
    public static int daysIn(int month,int year){
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(isLeapYear(year) && month==2){
            return 29;
        }else{
            return daysInMonth[month-1];
        }
    }
    public static int daysIn(int year){
        int totalDays = 0;
        for(int i=0; i<12 ;i++){
            totalDays = totalDays + daysIn(i+1,year);
        }
        return totalDays;
    }

    public String toString(){
        String thisday = Integer.toString(this.day);
        String thismonth = Integer.toString(this.month);
        if(this.day<10){
            thisday = "0"+thisday;
        }
        if(this.month<10){
            thismonth = "0"+thismonth;
        }

        String thisyear = Integer.toString(this.year);

        return thisyear + "-" + thismonth + "-" + thisday;

    }

    public static int difference(MyDate date1, MyDate date2){

        int tempDate1Month = date1.month;
        int tempDate2Month = date2.month;
        int tempDate1Day = date1.day;
        int tempDate2Day = date2.day;
        int tempDate1Year = date1.year;
        int tempDate2Year = date2.year;
        String date1M = Integer.toString(date1.month);
        String date2M = Integer.toString(date2.month);
        String date1D = Integer.toString(date1.day);
        String date2D = Integer.toString(date2.day);
        if(date1.month<10){
            date1M = "0"+date1.month;
        }
        if(date2.month<10){
            date2M = "0"+date2.month;
        }
        if(date1.day<10){
            date1D = "0"+date1.day;
        }
        if(date2.day<10){
            date2D = "0"+date2.day;
        }
        String date1All = date1.year+date1M+date1D;
        String date2ALl = date2.year+date2M+date2D;
        int date1Int = Integer.parseInt(date1All);
        int date2Int = Integer.parseInt(date2ALl);

//        System.out.println(date2Int);
        int countDay = 0;


        int count=0;
        if(date1Int > date2Int){
            while(date1.year != date2.year || date1.month != date2.month
                    || date1.day != date2.day){
                date2.day++;
                count++;
                if(date2.day>daysIn(date2.month,date2.year)){
                    date2.day = 1;
                    date2.month++;
                    if(date2.month > 12){
                        date2.month =1;
                        date2.year++;
                    }
                }
            }

            date1.day = tempDate1Day;
            date2.day = tempDate2Day;
            date1.month = tempDate1Month;
            date2.month = tempDate2Month;
            date1.year = tempDate1Year;
            date2.year = tempDate2Year;

            return count;
        }
        else if (date2Int > date1Int){
//            System.out.println(date1Int);
//            System.out.println(date2Int);
            while(date1.year != date2.year || date1.month != date2.month
                    || date1.day != date2.day){
                date1.day++;
                count++;
                if(date1.day>daysIn(date1.month,date1.year)){
                    date1.day = 1;
                    date1.month++;
                    if(date1.month>12){
                        date1.month = 1;
                        date1.year++;
                    }
                }
            }
        }
        date1.day = tempDate1Day;
        date2.day = tempDate2Day;
        date1.month = tempDate1Month;
        date2.month = tempDate2Month;
        date1.year = tempDate1Year;
        date2.year = tempDate2Year;

        return -count;


    }
}
