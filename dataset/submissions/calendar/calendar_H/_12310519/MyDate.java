public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addDays(int days) {
        for (int i = 1; i <= days; i++) {
            this.day++;
            if(this.day<= 28){
                continue;
            }
            if(this.day == 29 && !isLeapYear(this.year) && this.month == 2){
               this.month++;
               this.day = 1;
               continue;
            }
            if(this.day== 30 && isLeapYear(this.year) && this.month == 2){
                this.month++;
                this.day = 1;
                continue;
            }
          if(this.day == 31 && (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) ){
              this.month++;
              this.day = 1;
              continue;
          }
           if(this.day == 32 && (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10) ){
               this.month++;
               this.day = 1;
               continue;
           }
            if(this.day == 32 && this.month == 12){
                this.year++;
                this.month = 1;
                this.day = 1;
            }
        }
    }

    public static int difference(MyDate date1, MyDate date2) {
      int result = 0; int sumday = 0;int num1 = 0; int totaldays1 = Totaldays(date1.year, date1.month,date1.day);int totaldays2 = Totaldays(date2.year, date2.month,date2.day);
       if(date1.year < date2.year){
           for (int i = date1.year+1; i <date2.year ; i++) {
               if(isLeapyear(i)){
                   sumday+= 366;
                   continue;
               }else{
                   sumday+= 365;
               }
           }
           if(isLeapyear(date1.year)){
               num1 = 366-totaldays1;
           }else {
               num1 = 365 - totaldays1;
           }
           result= -(num1 + sumday + totaldays2);
       }else if(date1.year > date2.year){
           for (int i = date2.year+1; i <date1.year ; i++) {
               if(isLeapyear(i)){
                   sumday+= 366;
                   continue;
               }else{
                   sumday+= 365;
               }
           }
           if(isLeapyear(date2.year)){
               num1 = 366 - totaldays2;
           }else {
               num1 = 365 - totaldays2;
           }
           result= num1 + sumday + totaldays1;
       }else {
           result = 0;
       }
         return result;
    }
    public String toString() {
        String sr1 = String.format("%02d",month);
        String sr2 = String.format("%02d",day);
        String sr3 = String.format("%04d",year);
        return String.format(sr3+ "-" +sr1+ "-" + sr2);
    }

    public boolean isLeapYear(int year) {
        boolean result = true;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            result = true;
        }else {
        result = false;
        }
        return result;
    }

    public  static boolean isLeapyear(int year) {
        boolean result = false;
        if (year % 4 == 0 && year % 100 != 0 || (year % 400 == 0)) {
            result = true;
        }
        return result;
    }
    public  static int Totaldays(int year, int month, int day) {
        int result = 0;
        if (isLeapyear(year)) {
            switch (month) {
                case 1:
                    result = day;
                    break;
                case 2:
                    result = 31 + day;
                    break;
                case 3:
                    result = 60 + day;
                    break;
                case 4:
                    result = 91 + day;
                    break;
                case 5:
                    result = 121 + day;
                    break;
                case 6:
                    result = 152 + day;
                    break;
                case 7:
                    result = 182 + day;
                    break;
                case 8:
                    result = 213 + day;
                    break;
                case 9:
                    result = 244 + day;
                    break;
                case 10:
                    result = 274 + day;
                    break;
                case 11:
                    result = 305 + day;
                    break;
                case 12:
                    result = 335 + day;
                    break;
            }
        } else {
            switch (month) {
                case 1:
                    result = day;
                    break;
                case 2:
                    result = 31 + day;
                    break;
                case 3:
                    result = 59 + day;
                    break;
                case 4:
                    result = 90 + day;
                    break;
                case 5:
                    result = 120 + day;
                    break;
                case 6:
                    result = 151 + day;
                    break;
                case 7:
                    result = 181 + day;
                    break;
                case 8:
                    result = 212 + day;
                    break;
                case 9:
                    result = 243 + day;
                    break;
                case 10:
                    result = 273 + day;
                    break;
                case 11:
                    result = 304 + day;
                    break;
                case 12:
                    result = 334 + day;
                    break;
            }
        }
        return result;
    }
}



