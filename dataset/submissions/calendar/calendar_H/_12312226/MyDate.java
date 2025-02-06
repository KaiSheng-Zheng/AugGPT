import java.time.LocalDate;

public class MyDate {
    private int year;
    private int month;
    private int day;

    private String monthtoString;
    private String daytoString;


    public MyDate (int year,int month , int day){
       this.year=year;
        this.month=month;

        this.day=day;


    }


    public void addDays(int days){
         day=day+days;
         while (day>=30){
          switch (month){
              case(1):{if(day>31){day=day-31;month=2;}break;
              }case(2):{if(((year%4==0&&year%100!=0)||year%400==0)&&day>29){day=day-29;month=3;break;}
                  else if(!((year%4==0&&year%100!=0)||year%400==0)&&day>28){day=day-28;month=3;}break;
              }case(3):{if(day>31){day=day-31;month=4;}break;
              }case(4):{if(day>30){day=day-30;month=5;}break;
              }case(5):{if(day>31){day=day-31;month=6;}break;
              }case(6):{if(day>30){day=day-30;month=7;}break;
              }case(7):{if(day>31){day=day-31;month=8;}break;
              }case(8):{if(day>31){day=day-31;month=9;}break;
              }case(9):{if(day>30){day=day-30;month=10;}break;
              }case(10):{if(day>31){day=day-31;month=11;}break;
              }case(11):{if(day>30){day=day-30;month=12;}break;
              }case(12):{if(day>31){day=day-31;month=1;year=year+1;}break;
              }


         }
    }}
    public String toString(){
        if (day>=10){daytoString=day+"";}
        else if(day<10)daytoString="0"+day;
        if (month>=10){monthtoString=month+"";}
        else if(month<10)monthtoString="0"+month;
        String date = year+"-"+monthtoString+"-"+daytoString;
        return date;
    }
//    public static int days(int year ,int month , int days){
//        int monthtoDays;
//        switch (month){
//            case(1):(monthtoDays=0
//
//        }        return 365*year+year/4-year/100+year/400+monthtoDays+days;
//    }
    public static int difference(MyDate date1,MyDate date2){



        int result = date1.toString().compareTo(date2.toString());
        LocalDate localDate1=LocalDate.of(date1.getYear(),date1.getMonth(),date1.getDay());
        LocalDate localDate2=LocalDate.of(date2.getYear(),date2.getMonth(),date2.getDay());
        return (int) (localDate1.toEpochDay()- localDate2.toEpochDay());


//        if (result<0)return -1;
//else if(result==0)return 0;
//else if(result>0)return 1
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
