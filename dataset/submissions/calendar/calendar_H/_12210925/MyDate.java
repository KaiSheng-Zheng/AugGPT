public class MyDate {
    private int year;
    private int month;
    private int day;
    private static int a1;
    private static int a2;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public static boolean leapYear(int year){
        return (year / 4 == 0 & year / 100 != 0) | year / 400 == 0;
    }
    public static int monthScale1(int month){
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return 28;
            default:
                return 0;
        }
    }
    public static int monthScale2(int month){
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return 29;
            default:
                return 0;
        }
    }
    public static int dayNumbers1(int month, int day){
        int a=0;
        for (int i = 1; i <= month; i++) {
            a+=monthScale1(i);
        }
        return day+a;
    }
    public static int dayNumbers2(int month, int day){
        int a=0;
        for (int i = 1; i <= month; i++) {
            a+=monthScale2(i);
        }
        return day+a;
    }
    public static int yearNumbers(int year){
        if(leapYear(year)){
            return 366;
        }
        else{
            return 365;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void addDays(int days){
        setDay(day+days);
        if(leapYear(getYear())){
            if(day>monthScale2(getMonth())){
                setDay(day-monthScale2(getMonth()));
                setMonth(month+1);
            }
            else{}
        }
        else{
            if(day>monthScale2(getMonth())){
                setDay(day-monthScale2(getMonth()));
                setMonth(month+1);
            }
            else{}
        }
    }
    public String toString(){
        if(month<10 & day<10){
            return year+"-"+"0"+month+"-"+"0"+day;
        }
        else if(month<10 & day>=10){
            return year+"-"+"0"+month+"-"+day;
        }
        else if(day<10){
            return year+"-"+month+"-"+"0"+day;
        }
        else{
            return year+"-"+month+"-"+day;
        }
    }

    public static int difference(MyDate date1, MyDate date2) {
        a1=date1.getDay();
        a2=date2.getDay();
        if (date1.getYear() == date2.getYear()) {
            if (date1.getMonth() == date2.getMonth()) {
                return a1-a2;
            } else {
                if (leapYear(date1.getYear())) {
                    for (int i = Math.min(date1.getMonth(), date2.getMonth()); i < Math.max(date1.getMonth(), date2.getMonth()); i++) {
                        if (date1.getMonth() < date2.getMonth()) {
                            a2+= monthScale2(i);
                        } else {
                            a1+= monthScale2(i);
                        }
                    }
                    return a1-a2;
                } else {
                    for (int i = Math.min(date1.getMonth(), date2.getMonth()); i < Math.max(date1.getMonth(), date2.getMonth()); i++) {
                        if (date1.getMonth() < date2.getMonth()) {
                            a2+= monthScale1(i);
                        } else {
                            a1+= monthScale1(i);
                        }
                    }
                    return a1-a2;
                }
            }
        } else if (leapYear(date1.getYear()) & leapYear(date2.getYear())) {
            for (int i = Math.min(date1.getYear(), date2.getYear()); i < Math.max(date1.getYear(), date2.getYear()); i++) {
                if (date1.getYear() < date2.getYear()) {
                    a2+= yearNumbers(i);
                } else {
                    a1+= yearNumbers(i);
                }
            }
            for (int i = Math.min(date1.getMonth(), date2.getMonth()); i < Math.max(date1.getMonth(), date2.getMonth()); i++) {
                if (date1.getMonth() < date2.getMonth()) {
                    a2+= monthScale2(i);
                } else {
                    a1+= monthScale2(i);
                }
            }
            return a1-a2;
        } else if (!leapYear(date1.getYear()) & leapYear(date2.getYear())) {
            for (int i = Math.min(date1.getYear(), date2.getYear()); i < Math.max(date1.getYear(), date2.getYear()); i++) {
                if (date1.getYear() < date2.getYear()) {
                    a2+= yearNumbers(i);
                } else {
                    a1+= yearNumbers(i);
                }
            }
            for (int i = Math.min(date1.getMonth(), date2.getMonth()); i < Math.max(date1.getMonth(), date2.getMonth()); i++) {
                if (date1.getMonth() < date2.getMonth()) {
                    a2+= monthScale2(i);
                } else {
                    a1+= monthScale1(i);
                }
            }
            return a1-a2;
        } else if (leapYear(date1.getYear()) & !leapYear(date2.getYear())) {
            for (int i = Math.min(date1.getYear(), date2.getYear()); i < Math.max(date1.getYear(), date2.getYear()); i++) {
                if (date1.getYear() < date2.getYear()) {
                    a2+= yearNumbers(i);
                } else {
                    a1+= yearNumbers(i);
                }
            }
            for (int i = Math.min(date1.getMonth(), date2.getMonth()); i < Math.max(date1.getMonth(), date2.getMonth()); i++) {
                if (date1.getMonth() < date2.getMonth()) {
                    a2+= monthScale1(i);
                } else {
                    a1+= monthScale2(i);
                }
            }
            return a1-a2;
        } else {
            for (int i = Math.min(date1.getYear(), date2.getYear()); i < Math.max(date1.getYear(), date2.getYear()); i++) {
                if (date1.getYear() < date2.getYear()) {
                    a2+= yearNumbers(i);
                } else {
                    a1+= yearNumbers(i);
                }
            }
            for (int i = Math.min(date1.getMonth(), date2.getMonth()); i < Math.max(date1.getMonth(), date2.getMonth()); i++) {
                if (date1.getMonth() < date2.getMonth()) {
                    a2+= monthScale1(i);
                } else {
                    a1+= monthScale1(i);
                }
            }
            return a1-a2;
        }
    }
}
