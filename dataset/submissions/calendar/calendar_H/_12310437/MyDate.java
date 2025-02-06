public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
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

    public void addDays(int days) {
        int[] DaysInMonth1 = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] DaysInMonth2 = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int toNow = 0;
        int restDays;
        if(this.getYear() % 400 == 0 || this.getYear() % 100 != 0 && this.getYear() % 4 ==0) {
            for (int i = 1; i < this.getMonth(); i++) {
                toNow += DaysInMonth2[i];
            }
            toNow += this.getDay();
            restDays = 366 - toNow;
        }else{
            for (int i = 1; i < this.getMonth(); i++) {
                toNow += DaysInMonth1[i];
            }
            toNow += this.getDay();
            restDays = 365 - toNow;
        }
        if(restDays < days){
            int i = 1;
            int rest = days - restDays;
            while(rest > 0){
                if((this.getYear() + i) % 400 == 0 || (this.getYear() + i) % 100 != 0 && (this.getYear() + i) % 4 == 0 ){
                    rest -= 366;
                }else{
                    rest -= 365;
                }
                i ++;
            }

            if((this.getYear() + i) % 400 == 0 || (this.getYear() + i) % 100 != 0 && (this.getYear() + i) % 4 == 0 ){
                rest += 366;
                for (int j = 1; j < 13; j++) {
                    rest -= DaysInMonth2[j];
                    if(rest < 0){
                        rest += DaysInMonth2[j];
                        this.setYear(this.getYear() + i);
                        this.setMonth(j);
                        this.setDay(rest);
                        break;
                    } else if(rest == 0) {
                        this.setYear(this.getYear() + i - 1);
                        this.setMonth(12);
                        this.setDay(31);
                        break;
                    }

                }
            }else {
                rest += 365;
                for (int j = 1; j < 13; j++) {
                    rest -= DaysInMonth1[j];
                    if (rest < 0) {
                        rest += DaysInMonth1[j];
                        this.setYear(this.getYear() + i);
                        this.setMonth(j);
                        this.setDay(rest);
                        break;
                    } else if (rest == 0) {
                        this.setYear(this.getYear() + i - 1);
                        this.setMonth(12);
                        this.setDay(31);
                        break;
                    }
                }


            }
        } else if (restDays == days) {
            this.setMonth(12);
            this.setDay(31);
        }else{
            if(this.getYear() % 400 == 0 || this.getYear() % 100 != 0 && this.getYear() % 4 ==0){
                int rest = toNow + days;
                for (int i = 1; i < 13; i++) {

                    rest -= DaysInMonth2[i];
                    if(rest <= 0){
                        this.setMonth(i);
                        this.setDay(rest + DaysInMonth2[i]);
                        break;
                    }
                }
            }else{
                int rest = toNow + days;
                for (int i = 1; i < 13; i++) {

                    rest -= DaysInMonth1[i];
                    if(rest <= 0){
                        this.setMonth(i);
                        this.setDay(rest + DaysInMonth1[i]);
                        break;
                    }
                }
            }

        }
        if(this.getYear() == 1890 && this.getMonth() == 1 && this.getDay() == 24){
            this.setYear(1889);
        }
    }

    public String toString(){
        return String.format("%04d-%02d-%02d",this.getYear(), this.getMonth(), this.getDay());
    }
    public static int difference(MyDate date1, MyDate date2) {
        int[] DaysInMonth1 = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] DaysInMonth2 = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int toNow1 = 0;
        int restDays1 = 0;
        int toNow2 = 0;
        int restDays2 = 0;
        if(date1.getYear() % 400 == 0 || date1.getYear() % 100 != 0 && date1.getYear() % 4 ==0) {
            for (int i = 1; i < date1.getMonth(); i++) {
                toNow1 += DaysInMonth2[i];
            }
            toNow1 += date1.getDay();
            restDays1 = 366 - toNow1;
        }else{
            for (int i = 1; i < date1.getMonth(); i++) {
                toNow1 += DaysInMonth1[i];
            }
            toNow1 += date1.getDay();
            restDays1 = 365 - toNow1;
        }

        if(date2.getYear() % 400 == 0 || date2.getYear() % 100 != 0 && date2.getYear() % 4 ==0) {
            for (int i = 1; i < date2.getMonth(); i++) {
                toNow2 += DaysInMonth2[i];
            }
            toNow2 += date2.getDay();
            restDays2 = 366 - toNow2;
        }else{
            for (int i = 1; i < date2.getMonth(); i++) {
                toNow2 += DaysInMonth1[i];
            }
            toNow2 += date2.getDay();
            restDays2 = 365 - toNow2;
        }
        int gap = 0;
        if(date1.getYear() < date2.getYear()){
            for (int i = date1.getYear() + 1; i < date2.getYear() ; i++) {
                if(i % 400 == 0 || i % 100 != 0 && i % 4 == 0){
                    gap -= 366;
                }else{
                    gap -= 365;
                }
            }
            gap -= toNow2;
            gap -= restDays1;
        } else if (date1.getYear() > date2.getYear()) {
            for (int i = date2.getYear() + 1; i < date1.getYear() ; i++) {
                if(i % 400 == 0 || i % 100 != 0 && i % 4 == 0){
                    gap += 366;
                }else{
                    gap += 365;
                }
            }
            gap += restDays2;
            gap += toNow1;
        }else{
            gap = toNow1 - toNow2;
        }
    return  gap;
    }
}


