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
        int allDay = this.day + days;
        int number = numbers(this.year, this.month, allDay);
        if (LeapYear(this.year)) {
            if (number > 366) {
                this.year++;
                int item1 = number - 366;
                while(true){
                    if (!LeapYear(this.year)){
                        if (item1 > 365){
                            item1 -= 365;
                            this.year ++;
                        }else {
                            break;
                        }
                    }else {
                        if (item1 > 366){
                            item1 -= 366;
                            this.year ++;
                        }else {
                            break;
                        }
                    }
                }
                for (int i = 1; i <= 12; i++) {
                    if (i == 2) {
                        if (item1 <= 29) {
                            this.month = 2;
                            this.day = item1 ;
                            break;
                        }else {
                            item1 -= 29;
                        }
                    }else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                        if (item1 <= 31) {
                            this.month = i;
                            this.day = item1;
                            break;
                        } else {
                            item1 -= 31;
                        }
                    } else {
                        if (item1 <= 30) {
                            this.month = i;
                            this.day = item1;
                            break;
                        } else {
                            item1 -= 30;
                        }
                    }
                }

            } else {
                int item1 = number;
                for (int i = 1; i <= 12; i++) {
                    if (i == 2) {
                        if (item1 <= 29) {
                            this.month = 2;
                            this.day = item1;
                            break;
                        }else {
                            item1 -= 29;
                        }
                    }else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                        if (item1 <= 31) {
                            this.month = i;
                            this.day = item1;
                            break;
                        } else {
                            item1 -= 31;
                        }
                    } else {
                        if (item1 <= 30) {
                            this.month = i;
                            this.day = item1;
                            break;
                        } else {
                            item1 -= 30;
                        }
                    }
                }
            }
        } else {
            if (number > 365) {
                this.year++;
                int item1 = number - 365;
                while(true){
                    if (!LeapYear(this.year)){
                        if (item1 > 365){
                            item1 -= 365;
                            this.year ++;
                        }else {
                            break;
                        }
                    }else {
                        if (item1 >  366){
                            item1 -= 366;
                            this.year ++;
                        }else {
                            break;
                        }
                    }
                }

                for (int i = 1; i <= 12; i++) {
                    if (i == 2) {
                        if (item1 <= 28) {
                            this.month = 2;
                            this.day = item1;
                            break;
                        }else {
                            item1 -= 28;
                        }
                    }else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                        if (item1 <= 31) {
                            this.month = i;
                            this.day = item1;
                            break;
                        } else {
                            item1 -= 31;
                        }
                    } else {
                        if (item1 <= 30) {
                            this.month = i;
                            this.day = item1;
                            break;
                        } else {
                            item1 -= 30;
                        }
                    }
                }

            } else {
                int item1 = number;
                for (int i = 1; i <= 12; i++) {
                    if (i == 2) {
                        if (item1 <= 28) {
                            this.month = 2;
                            this.day = item1;
                            break;
                        }else {
                            item1 -= 28;
                        }
                    }else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                        if (item1 <= 31) {
                            this.month = i;
                            this.day = item1;
                            break;
                        } else {
                            item1 -= 31;
                        }
                    } else {
                        if (item1 <= 30) {
                            this.month = i;
                            this.day = item1;
                            break;
                        } else {
                            item1 -= 30;
                        }
                    }
                }
            }
        }
    }



    public String toString() {
        if (day >= 10){
            if (month >= 10){
                return String.format("%d-%d-%d",year,month,day);
            }else {
                return String.format("%d-"+0+"%d-%d",year,month,day);
            }
        }else {
            if (month >= 10){
                return String.format("%d-%d-"+0+"%d",year,month,day);
            }else {
                return String.format("%d-"+0+"%d-"+0+"%d",year,month,day);
            }
        }
    }

    public static int difference(MyDate date1,MyDate date2){
        return (date1.numbers(date1.year,date1.month,date1.day) -
                date2.numbers(date2.year,date2.month,date2.day) + date1.diffYear(date1.year,date2.year));
    }

    public boolean LeapYear(int year){
        if (year%100 == 0){
            if (year%400 == 0){
                return true;
            }else {
                return false;
            }
        }else if (year%4 == 0){
            return true;
        }else {
            return false;
        }
    }
    public int numbers(int year,int month,int allDay){
        int item = 0;
        if (LeapYear(year)){
            for (int i = 1; i < month; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 ){
                    item += 31;
                }else if (i == 2){
                    item += 29;
                }else {
                    item += 30;
                }
            }
        }else {
            for (int i = 1; i < month; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 ){
                    item += 31;
                }else if (i == 2){
                    item += 28;
                }else {
                    item += 30;
                }
            }
        }
        return (item+allDay);
    }

    public int diffYear(int year1,int year2){
        int diff = 0;
        if (year1 < year2){
            for (int i = 0; i < year2 - year1; i++) {
                if (LeapYear(year1+i)){
                    diff += 366;
                }else {
                    diff += 365;
                }
            }
            return (-diff);
        }else if (year1 == year2){
            return 0;
        }else {
            for (int i = 0; i < year1 - year2; i++) {
                if (LeapYear(year2+i)){
                    diff += 366;
                }else {
                    diff += 365;
                }
            }
            return diff;
        }
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
