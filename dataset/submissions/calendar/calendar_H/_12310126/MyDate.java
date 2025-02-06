import java.time.LocalDate;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public int getYear(){return year;}
    public int getMonth(){return month;}
    public int getDay(){return day;}
    public MyDate(int year, int month, int day){
        this.day=day;
        this.year=year;
        this.month=month;
    }

    public String toString(){
        return(Integer.toString(year)+"-"+String.format("%02d",month)+"-"+String.format("%02d",day));
    }
    public static int runnian(int year){
        if(year%400==0){return 366;}
        else if (year%100==0) {return 365;}
        else if (year%4==0) {return 366;}
        else{return 365;}

        }
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
    }




    public static int difference(MyDate date1, MyDate date2){
        int numberOfDays=0;
        if(date1.getYear()>date2.getYear()){
            for(int i=date2.getYear();i<date1.getYear();i++ ){
                numberOfDays+=runnian(i);
            }

        }
        else if (date1.getYear() < date2.getYear()) {
            for (int i = date1.getYear(); i < date2.getYear(); i++) {
                numberOfDays -= runnian(i);
            }
    }
        int number1 =0;
        int number2 =0;
        for (int i = 1; i < date1.getMonth(); i++) {
            switch (i) {
                case 1, 3, 5, 7, 8, 10, 12 -> number1 += 31;
                case 2 -> number1 += isLeapYear(date1.getYear()) ? 29 : 28;
                case 4, 6, 9, 11 -> number1 += 30;
            }
        }
            for (int i = 1; i < date2.getMonth(); i++) {
                switch (i) {
                    case 1, 3, 5, 7, 8, 10, 12 -> number2 += 31;
                    case 2 -> number2 += isLeapYear(date2.getYear()) ? 29 : 28;
                    case 4, 6, 9, 11 -> number2 += 30;
                }
            }
            numberOfDays+=(number1-number2);
            numberOfDays+=(date1.getDay()-date2.getDay());
            return numberOfDays;

        }
        public static int getdayofmonth(int month ,int year){
            return switch (month) {
                case 1, 3, 5, 7, 8, 10, 12 -> 31;
                case 2 -> isLeapYear(year) ? 29 : 28;
                case 4, 6, 9, 11 -> 30;
                default -> {
                    System.out.println("Invalid month");
                    yield -1;
                }
            };
        }
    public void addDays(int days){
        LocalDate originDate = LocalDate.of(year,month,day);
        LocalDate newDate = originDate.plusDays(days);
        this.year =newDate.getYear();
        this.month = newDate.getMonthValue();
        this.day = newDate.getDayOfMonth();



    }
    }

