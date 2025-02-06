public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days){
        int cha = 0;
        if(month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12){
            cha = 31 - day;
        }else if(month == 4 || month == 6 || month == 9 || month == 11){
            cha = 30 - day;
        }else if( year % 400 == 0 && month == 2){
            cha = 29 - day;
        }else if( year % 4 == 0 && year % 100 != 0 && month == 2){
            cha = 29 - day;
        }else{
            cha = 28 - day;
        }
        if( days <= cha){
            day += days;
        }else if(days > cha){
            day = 1;
            days -= cha + 1;
            month += 1;
            if(month == 13){
                month = 1;
                year += 1;
            }
            while( days > 30){
                if (month == 1 || month == 3 || month == 5 || month == 7
                        || month == 8 || month == 10 || month == 12){
                    month += 1;
                    days -= 31;
                    if ( month == 13 ){
                        month = 1;
                        year += 1;
                    }
                }else if (month == 4 || month == 6 || month == 9 || month == 11){
                    month += 1;
                    days -= 30;
                }else if ( year % 400 == 0 && month == 2){
                    month += 1;
                    days -= 29;
                }else if ( year % 4 == 0 && year % 100 != 0 && month == 2){
                    month += 1;
                    days -= 29;
                }else {
                    month += 1;
                    days -= 28;
                }
            }
        }
        if(days >= 0){
            if(month == 1 || month == 3 || month == 5 || month == 7
                    || month == 8 || month == 10 || month == 12){
                day += days;
            }else if (month == 4 || month == 6 || month == 9 || month == 11){
                if(days == 30){
                    month += 1;
                } else {
                    day += days;
                }
            }else if ( year % 400 == 0 && month == 2){
                if(days >= 29){
                    month += 1;
                    day = days - 28;
                }else{
                    day += days;
                }
            }else if( year % 4 == 0 && year % 100 != 0 && month == 2){
                if(days >= 29){
                    month += 1;
                    day = days - 28;
                }else{
                    day += days;
                }
            }else{
                if(days >= 28){
                    month += 1;
                    day = days - 27;
                }else{
                    day += days;
                }
            }
        }
    }

    public String toString(){
        String DATE = null;
        DATE = String.format("%04d-%02d-%02d",year,month,day);
        return DATE;
    }

    public static int difference(MyDate date1, MyDate date2){
        int diffinyear = date1.year - date2.year;
        int a = diffinyear / 4;
        int b = diffinyear / 100;
        int c = diffinyear / 400;
        int nian = diffinyear * 365 + a -b +c;
        int diffinmonth = 0;
        int[] x = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int y = 0;
        if(date1.month >= date2.month){
            for (int i = date2.month - 1;i < date1.month - 1;i += 1){
                y += x[i];
            }
        }else{
            for (int i = date1.month - 1;i < date2.month - 1;i += 1){
                y -= x[i];
            }
        }
        diffinmonth = y;
        int diffinday = date1.day - date2.day;
        int differday = nian + diffinmonth + diffinday;
        if(date1.year > date2.year){
            if(((date1.year % 4 == 0 && date1.year % 100 != 0) || (date1.year % 400 == 0)) && date1.month > 2){
                differday += 1;
            }
            if(((date2.year % 4 == 0 && date2.year % 100 != 0) || (date2.year % 400 == 0)) && date2.month <= 2 ){
                differday += 1;
            }
        }else if (date1.year < date2.year){
            if (((date1.year % 4 == 0 && date1.year % 100 != 0) || (date1.year % 400 == 0)) && date1.month < 2){
                differday -= 1;
            }
            if (((date2.year % 4 == 0 && date2.year % 100 != 0) || (date2.year % 400 == 0)) && date2.month >= 2){
                differday -= 1;
            }
        }
        return differday;
    }
}