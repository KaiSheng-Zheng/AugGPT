public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days){
        int t = days + day;
        while (t>=28){
        if (month==2){
            if ((year%4==0&&year%100!=0)||year%400==0){
              if (t<=29){
                  day = t;
              }else {month = month+1;
                  t = t - 29;
            }
    }else {
                if (t<=28){
                    day = t;
                }else {month = month +1;
                    t = t -28;
            }
            }
        }
        if (month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
            if (t <= 31) {
                day = t;
                break;
            } else if (month != 12) {
                month = month + 1;
                t = t - 31;
            } else {
                month = 1;
                t = t - 31;
            }
        }if (month==4||month==6||month==9||month==11){
            if (t <=30){
                day = t;
                break;
            }else {
                month = month+1;
                day = t -30;
            }
        }
        }day = t;
    }
    public String toString(){
        return String.format("%04d-%02d-%02d",year,month,day);
    }
    public static int difference(MyDate date1, MyDate date2){
        int dyear1 = 0;
        int dyear2 = 0;
        int dmonth1 = 0;
        int dmonth2 = 0;
      for (int i=1 ;i <= date1.year-1;i++){
            if ((i%4==0&&i%100!=0)||i%400==0){
                dyear1 = dyear1 +366;
            } else  {
                dyear1 = dyear1 +365;
            }
      }
      for (int i =1;i <= date1.month-1;i++){
          if (i==1||i==3||i==5||i==7||i==8||i==10){
              dmonth1 = dmonth1 +31;
          } else if (i==2) {
              if ((date1.year%4==0&&date1.year%100!=0)||date1.year%400==0){
                  dmonth1 = dmonth1+29;
          }else {dmonth1 = dmonth1 + 28;}
      }else {
              dmonth1 = dmonth1 + 30;
          }
      }
        for (int i=1 ;i <= date2.year-1;i++){
            if ((i%4==0&&i%100!=0)||i%400==0){
                dyear2 = dyear2 +366;
            } else  {
                dyear2 = dyear2 +365;
            }
        }
        for (int i =1;i <= date2.month-1;i++){
            if (i==1||i==3||i==5||i==7||i==8||i==10){
                dmonth2 = dmonth2 +31;
            } else if (i==2) {
                if ((date2.year%4==0&&date2.year%100!=0)||date2.year%400==0){
                    dmonth2 = dmonth2+29;
                }else {dmonth2 = dmonth2 + 28;}
            }else {
                dmonth2 = dmonth2 + 30;
            }
        }
        return dyear1+dmonth1+ date1.day-dyear2-dmonth2- date2.day;
    }
    }

