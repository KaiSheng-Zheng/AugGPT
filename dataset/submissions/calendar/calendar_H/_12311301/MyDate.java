public class MyDate {
    private int year;
    private int month;
    private int day;

    private long total;

    public int getTotal() {
        return (int)total;
    }

    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
        boolean leap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
        for(int i = 1; i <= year-1; i++) {
            boolean tempLeap = i % 4 == 0 && i % 100 != 0 || i % 400 == 0;
            if(tempLeap) {
                total += 366;
            } else {
                total += 365;
            }
        }
        switch (month) {
            case 1:
                total += 0;
                break;
            case 2:
                total += 31;
                break;
            case 3:
                if(leap) {
                    total += 60;
                } else {
                    total += 59;
                }
                break;
            case 4:
                if(leap) {
                    total += 91;
                } else {
                    total += 90;
                }
                break;
            case 5:
                if(leap) {
                    total += 121;
                } else {
                    total += 120;
                }
                break;
            case 6:
                if(leap) {
                    total += 152;
                } else {
                    total += 151;
                }
                break;
            case 7:
                if(leap) {
                    total += 182;
                } else {
                    total += 181;
                }
                break;
            case 8:
                if(leap) {
                    total += 213;
                } else {
                    total += 212;
                }
                break;
            case 9:
                if(leap) {
                    total += 244;
                } else {
                    total += 243;
                }
                break;
            case 10:
                if(leap) {
                    total += 274;
                } else {
                    total += 273;
                }
                break;
            case 11:
                if(leap) {
                    total += 305;
                } else {
                    total += 304;
                }
                break;
            case 12:
                if(leap) {
                    total += 336;
                } else {
                    total += 335;
                }
                break;

        }
        total += day;
    }

    public String toString(){
        return String.format("%d-%s-%s",year,setMonth(),setDay());
    }

    private String setMonth(){
        return month >= 10? String.valueOf(month) : String.format("0%d",month);
    }

    private String setDay() {
        return day >= 10? String.valueOf(day) : String.format("0%d",day);
    }

    public void addDays(int days) {
        total += days;
        int tempYears = 1;
        int tempTotal = (int) this.total;
        while(tempTotal > 366) {
            boolean tempLeap = tempYears % 4 == 0 && tempYears % 100 != 0 || tempYears % 400 == 0;
            if(tempLeap) {
                tempTotal -= 366;
            } else {
                tempTotal -= 365;
            }
            tempYears++;
        }
        year = tempYears;
        boolean leap = tempYears % 4 == 0 && tempYears % 100 != 0 || tempYears % 400 == 0;
        int[] monthDays = {31,leap?29:28,31,30,31,30,31,31,30,31,30,31};
        int tempMonth = 1;
        for(int i : monthDays) {
            if(tempTotal - i <= 0) {
                month = tempMonth;
                day = tempTotal;
                break;
            } else {
                tempMonth++;
                tempTotal -= i;
            }
        }

    }

    public static int difference(MyDate date1, MyDate date2) {
        return (int)(date1.total - date2.total);
    }

}
