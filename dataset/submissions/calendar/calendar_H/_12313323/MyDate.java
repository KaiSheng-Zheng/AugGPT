public class MyDate {
    //static int counter = 0;
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        //counter++;
    }

    static int[] tianShu = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public void addDays(int days) {
        day = day + days;
        for (int i = month; i < 13; i++) {
            if ((year % 4 == 0 && year % 100 != 0 && i < 12) | (year % 400 == 0 && i < 12)) {
                tianShu[2] = 29;
                if (i == 12) {
                    if (day - tianShu[i] > 0) {
                        day = day - tianShu[i];
                        year++;
                        month = 1;
                        i = 0;
                    } else {
                        break;
                    }
                } else {
                    if (day - tianShu[i] > 0) {
                        day = day - tianShu[i];
                        month++;
                    } else {
                        break;
                    }
                }
            } else {
                tianShu[2] = 28;

                if (i == 12) {
                    if (day - tianShu[i] > 0) {
                        day = day - tianShu[i];
                        year++;
                        month = 1;
                        i = 0;
                    } else {
                        break;
                    }
                } else {
                    if (day - tianShu[i] > 0) {
                        day = day - tianShu[i];
                        month++;
                    } else {
                        break;
                    }
                }
            }
        }
    }
        public String toString () {
            String a = "001";
            StringBuilder cg=new StringBuilder();

            if (month < 10 && day < 10) {
                a = (year + "-0" + month + "-0" + day);
            }
            if (month < 10 && day > 10) {
                a = (year + "-0" + month + "-" + day);
            }
            if (month > 10 && day < 10) {
                a = (year + "-" + month + "-0" + day);
            }
            if (month > 10 && day > 10) {
                a = (year + "-" + month + "-" + day);
            }
            for(int i=1;i<=10-a.length();i++){
                cg.append("0");
            }
            return a+cg.toString();
        }
        public static int difference (MyDate date1, MyDate date2){
            int c11 = 0;
            int c12 = 0;
            int c21 = 0;
            int c22 = 0;
            int nian1 = 0;
            int yue1 = 0;
            int nian2 = 0;
            int yue2 = 0;
            for (int i = 1; i < date1.year; i++) {
                if ((i % 4 == 0 && i % 100 != 0) | (i % 400 == 0)) {
                    nian1 = nian1 + 366;
                } else {
                    nian1 = nian1 + 365;
                }
            }
            c11 = nian1;
            for (int j = 1; j < date1.month; j++) {
                if ((date1.year % 4 == 0 && date1.year % 100 != 0) | (date1.year % 400 == 0)) {
                    if (j == 1 | j == 3 | j == 5 | j == 7 | j == 8 | j == 10 | j == 12) {
                        yue1 = yue1 + 31;
                    }
                    if (j == 4 | j == 6 | j == 9 | j == 11) {
                        yue1 = yue1 + 30;
                    }
                    if (j == 2) {
                        yue1 = yue1 + 29;
                    }
                } else {
                    if (j == 1 | j == 3 | j == 5 | j == 7 | j == 8 | j == 10 | j == 12) {
                        yue1 = yue1 + 31;
                    }
                    if (j == 4 | j == 6 | j == 9 | j == 11) {
                        yue1 = yue1 + 30;
                    }
                    if (j == 2) {
                        yue1 = yue1 + 28;
                    }
                }
            }
            c12 = yue1;
            int c13 = date1.day - 1;
            int c1 = c11 + c12 + c13;
            for (int i = 1; i < date2.year; i++) {
                if ((i % 4 == 0 && i % 100 != 0) | (i % 400 == 0)) {
                    nian2 = nian2 + 366;
                } else {
                    nian2 = nian2 + 365;
                }
            }
            c21 = nian2;
            for (int j = 1; j < date2.month; j++) {
                if ((date2.year % 4 == 0 && date2.year % 100 != 0) || (date2.year % 400 == 0)) {
                    if (j == 1 | j == 3 | j == 5 | j == 7 | j == 8 | j == 10 | j == 12) {
                        yue2 = yue2 + 31;
                    }
                    if (j == 4 | j == 6 | j == 9 | j == 11) {
                        yue2 = yue2 + 30;
                    }
                    if (j == 2) {
                        yue2 = yue2 + 29;
                    }
                } else {
                    if (j == 1 | j == 3 | j == 5 | j == 7 | j == 8 | j == 10 | j == 12) {
                        yue2 = yue2 + 31;
                    }
                    if (j == 4 | j == 6 | j == 9 | j == 11) {
                        yue2 = yue2 + 30;
                    }
                    if (j == 2) {
                        yue2 = yue2 + 28;
                    }
                }
            }
            c22 = yue2;
            int c23 = date2.day - 1;
            int c2 = c21 + c22 + c23;
            return c1 - c2;
        }
}

