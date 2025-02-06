public class MyDate {
    private int year;
    private int month;
    private int day;
    private int a=0;
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    public MyDate(int year, int month, int day){
        this.year =year;
        this.month = month;
        this.day = day;
    }
    public void addDays(int days){
        a=day+days;
        day=0;
        for(int j=1;a>=1&j>=1;j++) {
            if (month == 1) {
                for (int i = 1; a >= 1 & i <= 31; i++) {
                    a--;
                    day++;
                    if (i == 31 & a >= 1) {
                        month++;
                        day = 0;
                    }
                }
            }
            if (month == 2) {
                if (year % 4 == 0 & year % 100 != 0) {
                    for (int i = 1; a >= 1 & i <= 29; i++) {
                        a--;
                        day++;
                        if (i == 29 & a >= 1) {
                            month++;
                            day = 0;
                        }
                    }
                } else if (year % 400 == 0) {
                    for (int i = 1; a >= 1 & i <= 29; i++) {
                        a--;
                        day++;
                        if (i == 29 & a >= 1) {
                            month++;
                            day = 0;
                        }
                    }
                } else {
                    for (int i = 1; a >= 1 & i <= 28; i++) {
                        a--;
                        day++;
                        if (i == 28 & a >= 1) {
                            month++;
                            day = 0;
                        }
                    }
                }
            }
            if (month == 3) {
                for (int i = 1; a >= 1 & i <= 31; i++) {
                    a--;
                    day++;
                    if (i == 31 & a >= 1) {
                        month++;
                        day = 0;
                    }
                }
            }
            if (month == 4) {
                for (int i = 1; a >= 1 & i <= 30; i++) {
                    a--;
                    day++;
                    if (i == 30 & a >= 1) {
                        month++;
                        day = 0;
                    }
                }
            }
            if (month == 5) {
                for (int i = 1; a >= 1 & i <= 31; i++) {
                    a--;
                    day++;
                    if (i == 31 & a >= 1) {
                        month++;
                        day = 0;
                    }
                }
            }
            if (month == 6) {
                for (int i = 1; a >= 1 & i <= 30; i++) {
                    a--;
                    day++;
                    if (i == 30 & a >= 1) {
                        month++;
                        day = 0;
                    }
                }
            }
            if (month == 7) {
                for (int i = 1; a >= 1 & i <= 31; i++) {
                    a--;
                    day++;
                    if (i == 31 & a >= 1) {
                        month++;
                        day = 0;
                    }
                }
            }
            if (month == 8) {
                for (int i = 1; a >= 1 & i <= 31; i++) {
                    a--;
                    day++;
                    if (i == 31 & a >= 1) {
                        month++;
                        day = 0;
                    }
                }
            }
            if (month == 9) {
                for (int i = 1; a >= 1 & i <= 30; i++) {
                    a--;
                    day++;
                    if (i == 30 & a >= 1) {
                        month++;
                        day = 0;
                    }
                }
            }
            if (month == 10) {
                for (int i = 1; a >= 1 & i <= 31; i++) {
                    a--;
                    day++;
                    if (i == 31 & a >= 1) {
                        month++;
                        day = 0;
                    }
                }
            }
            if (month == 11) {
                for (int i = 1; a >= 1 & i <= 30; i++) {
                    a--;
                    day++;
                    if (i == 30 & a >= 1) {
                        month++;
                        day = 0;
                    }
                }
            }
            if (month == 12) {
                for (int i = 1; a >= 1 & i <= 31; i++) {
                    a--;
                    day++;
                    if (i == 31 & a >= 1) {
                        month = 1;
                        day = 0;
                        year++;
                    }
                }
            }
        }
}

    public String toString(){
        StringBuilder s=new StringBuilder();
        String a1 =String.valueOf(year);
        String a2 =String.valueOf(month);
        String a3 =String.valueOf(day);
        char[] ar1 = a1.toCharArray();
        char[] ar2 = a2.toCharArray();
        char[] ar3 = a3.toCharArray();
        for(int i=1;i<=4- ar1.length;i++){
            s.append("0");
        }
        for(int i=1;i<= ar1.length;i++){
            s.append(ar1[i-1]);
        }
        s.append("-");
        for(int i=1;i<=2-ar2.length;i++){
            s.append("0");
        }
        for(int i=1;i<= ar2.length;i++){
            s.append(ar2[i-1]);
        }
        s.append("-");
        for(int i=1;i<=2-ar3.length;i++){
            s.append("0");
        }
        for(int i=1;i<= ar3.length;i++){
            s.append(ar3[i-1]);
        }
        String s2= String.valueOf(s);
        return s2;
    }
    public static int difference(MyDate date1, MyDate date2){
        int c=0;
        int b=0;
        int y1=date1.year;
        int y2=date2.year;
        int m1=date1.month;
        int m2=date2.month;
        if(date1.year< date2.year){
            b=-1;
        }
        else if(date1.year>date2.year){
            b=1;
        }
        else if(date1.year==date2.year){
            if(date1.month<date2.month){
                b=-1;
            }
            if(date1.month> date2.month){
                b=1;
            }
            if(date1.month== date2.month){
                if(date1.day<date2.day){
                    b=-1;
                }
                if(date1.day>= date2.day){
                    b=1;
                }
            }
        }
        if(b>=0) {
            for (int j = 1; j <= 10000; j++) {
                if (date2.month == 1) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date2.month++;
                        }
                    }
                } else if (date2.month == 2) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    if (date2.year % 4 == 0 & date2.year % 100 != 0) {
                        for (int i = 1; i <= 29; i++) {
                            c++;
                            if (i == 29) {
                                date2.month++;
                            }
                        }
                    } else if (date2.year % 400 == 0) {
                        for (int i = 1; i <= 29; i++) {
                            c++;
                            if (i == 29) {
                                date2.month++;
                            }
                        }
                    } else {
                        for (int i = 1; i <= 28; i++) {
                            c++;
                            if (i == 28) {
                                date2.month++;
                            }
                        }
                    }
                } else if (date2.month == 3) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date2.month++;
                        }
                    }
                } else if (date2.month == 4) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    for (int i = 1; i <= 30; i++) {
                        c++;
                        if (i == 30) {
                            date2.month++;
                        }
                    }
                } else if (date2.month == 5) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date2.month++;
                        }
                    }
                } else if (date2.month == 6) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    for (int i = 1; i <= 30; i++) {
                        c++;
                        if (i == 30) {
                            date2.month++;
                        }
                    }
                } else if (date2.month == 7) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date2.month++;
                        }
                    }
                } else if (date2.month == 8) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date2.month++;
                        }
                    }
                } else if (date2.month == 9) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    for (int i = 1; i <= 30; i++) {
                        c++;
                        if (i == 30) {
                            date2.month++;
                        }
                    }
                } else if (date2.month == 10) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date2.month++;
                        }
                    }
                } else if (date2.month == 11) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    for (int i = 1; i <= 30; i++) {
                        c++;
                        if (i == 30) {
                            date2.month++;
                        }
                    }
                }
                if (date2.month == 12) {
                    if (date2.month == date1.month & date2.year == date1.year) {
                        c = c + date1.day - date2.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date2.month = 1;
                            date2.year++;
                        }
                    }
                }
            }
        }
        else if (b<0) {
            for (int j = 1; j <= 10000; j++) {
                if (date1.month == 1) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date1.month++;
                        }
                    }
                }
                if (date1.month == 2) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    if (date1.year % 4 == 0 & date1.year % 100 != 0) {
                        for (int i = 1; i <= 29; i++) {
                            c++;
                            if (i == 29) {
                                date1.month++;
                            }
                        }
                    } else if (date1.year % 400 == 0) {
                        for (int i = 1; i <= 29; i++) {
                            c++;
                            if (i == 29) {
                                date1.month++;
                            }
                        }
                    } else {
                        for (int i = 1; i <= 28; i++) {
                            c++;
                            if (i == 28) {
                                date1.month++;
                            }
                        }
                    }
                }
                if (date1.month == 3) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date1.month++;
                        }
                    }
                }
                if (date1.month == 4) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    for (int i = 1; i <= 30; i++) {
                        c++;
                        if (i == 30) {
                            date1.month++;
                        }
                    }
                }
                if (date1.month == 5) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date1.month++;
                        }
                    }
                }
                if (date1.month == 6) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    for (int i = 1; i <= 30; i++) {
                        c++;
                        if (i == 30) {
                            date1.month++;
                        }
                    }
                }
                if (date1.month == 7) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date1.month++;
                        }
                    }
                }
                if (date1.month == 8) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date1.month++;
                        }
                    }
                }
                if (date1.month == 9) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    for (int i = 1; i <= 30; i++) {
                        c++;
                        if (i == 30) {
                            date1.month++;
                        }
                    }
                }
                if (date1.month == 10) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date1.month++;
                        }
                    }
                }
                if (date1.month == 11) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    for (int i = 1; i <= 30; i++) {
                        c++;
                        if (i == 30) {
                            date1.month++;
                        }
                    }
                }
                if (date1.month == 12) {
                    if (date1.month == date2.month & date1.year == date2.year) {
                        c = c + date2.day - date1.day;
                        date1.year = y1;
                        date2.year = y2;
                        date1.month = m1;
                        date2.month = m2;
                        return -c;
                    }
                    for (int i = 1; i <= 31; i++) {
                        c++;
                        if (i == 31) {
                            date1.month = 1;
                            date1.year++;
                        }
                    }
                }
            }
        }
        return c;
    }
}