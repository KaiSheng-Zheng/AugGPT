public class MyDate {
    private int year;
    private int month;
    private int day;
    public MyDate(int year,int month,int day){
        this.year = year;
        this.day = day;
        this.month = month;
    }
    public void addDays(int days){
        int r = 0;
        for (int p = r; p < days; p++) {
            if (year % 400 == 0) {
                for (int i = r; i < days; i++) {
                    this.day++;
                    if (month == 2) {
                        r = i+1;
                        if (this.day == 30) {
                            month++;
                            this.day = 1;
                        }
                    } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
                        r = i+1;
                        if (this.day == 32) {
                            month++;
                            this.day = 1;
                        }
                    } else if (month == 12) {
                        r = i+1;
                        if (this.day == 32) {
                            this.year++;
                            this.month = 1;
                            this.day = 1;
                            break;
                        }
                    } else {
                        r = i+1;
                        if (this.day == 31) {
                            month++;
                            this.day = 1;
                        }
                    }
                }
            } else {
                if (year % 4 == 0 && year % 100 != 0) {
                    for (int i = r; i < days; i++) {
                        this.day++;
                        if (month == 2) {
                            r = i+1;
                            if (this.day == 30) {
                                month++;
                                this.day = 1;
                            }
                        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
                            r = i+1;
                            if (this.day == 32) {
                                month++;
                                this.day = 1;
                            }
                        } else if (month == 12) {
                            r = i+1;
                            if (this.day == 32) {
                                this.year++;
                                this.month = 1;
                                this.day = 1;
                                break;
                            }
                        } else {
                            r = i+1;
                            if (this.day == 31) {
                                month++;
                                this.day = 1;
                            }
                        }
                    }
                } else {
                    for (int i = r; i < days; i++) {
                        this.day++;
                        if (month == 2) {
                            r = i+1;
                            if (this.day == 29) {
                                month++;
                                this.day = 1;
                            }
                        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
                            r = i+1;
                            if (this.day == 32) {
                                month++;
                                this.day = 1;
                            }
                        } else if (month == 12) {
                            r = i+1;
                            if (this.day == 32) {
                                this.year++;
                                this.month = 1;
                                this.day = 1;
                                break;
                            }
                        } else {
                            r = i+1;
                            if (this.day == 31) {
                                month++;
                                this.day = 1;
                            }
                        }
                    }
                }
            }
        }
    }
    public String toString(){
        return String.format("%4d-%02d-%02d",this.year,this.month,this.day);
    }
    public int getYear(){
        return this.year;
    }
    public void setYear(){
        this.year = year;
    }
    public int getMonth(){
        return this.month;
    }
    public void setMonth(){
        this.month = month;
    }
    public void setDay(){
        this.day = day;
    }
    public int getDay(){
        return this.day;
    }

    public static int difference(MyDate date1,MyDate date2){
        int sum = 0;
        int yearsum = 0;
        int sum1 = 0;
        if (date1.year==date2.year){
            if (date1.month<date2.month) {
                for (int i = 1; i <= date2.month - date1.month; i++) {
                    if (date1.year % 400 == 0) {
                        if (date1.month+i-1 == 2) {
                            yearsum += 29;
                        } else if (date1.month+i-1 == 1 || date1.month+i-1 == 3 || date1.month+i-1 == 5 || date1.month+i-1 == 7 || date1.month+i-1 == 8 || date1.month+i-1 == 10 || date1.month+i-1 == 12) {
                            yearsum += 31;
                        } else {
                            yearsum += 30;
                        }
                    }else {
                        if (date1.year % 4 == 0 && date1.year % 100 != 0){
                            if (date1.month+i-1 == 2) {
                                yearsum += 29;
                            } else if (date1.month+i-1 == 1 || date1.month+i-1 == 3 || date1.month+i-1 == 5 || date1.month+i-1 == 7 || date1.month+i-1 == 8 || date1.month+i-1 == 10 || date1.month+i-1 == 12) {
                                yearsum += 31;
                            } else {
                                yearsum += 30;
                            }
                        }else {
                            if (date1.month+i-1 == 2) {
                                yearsum += 28;
                            } else if (date1.month+i-1 == 1 || date1.month+i-1 == 3 || date1.month+i-1 == 5 || date1.month+i-1 == 7 || date1.month+i-1 == 8 || date1.month+i-1 == 10 || date1.month+i-1 == 12) {
                                yearsum += 31;
                            } else {
                                yearsum += 30;
                            }
                        }
                    }
                }
                yearsum -= date1.day;
                yearsum += date2.day;
                yearsum = 0-yearsum;
            } else if (date1.month == date2.month) {
                if (date1.day<=date2.day){
                    yearsum=date2.day-date1.day;
                }else {
                    yearsum=date1.day-date2.day;
                }
            }else {
                for (int i = 1; i <= date1.month - date2.month; i++) {
                    if (date2.year % 400 == 0) {
                        if (date2.month+i-1 == 2) {
                            yearsum += 29;
                        } else if (date2.month+i-1 == 1 || date2.month+i-1 == 3 || date2.month+i-1 == 5 || date2.month+i-1 == 7 || date2.month+i-1 == 8 || date2.month+i-1 == 10 || date2.month+i-1 == 12) {
                            yearsum += 31;
                        } else {
                            yearsum += 30;
                        }
                    }else {
                        if (date2.year % 4 == 0 && date2.year % 100 != 0){
                            if (date2.month+i-1 == 2) {
                                yearsum += 29;
                            } else if (date2.month+i-1 == 1 || date2.month+i-1 == 3 || date2.month+i-1 == 5 || date2.month+i-1 == 7 || date2.month+i-1 == 8 || date2.month+i-1 == 10 || date2.month+i-1 == 12) {
                                yearsum += 31;
                            } else {
                                yearsum += 30;
                            }
                        }else {
                            if (date2.month+i-1 == 2) {
                                yearsum += 28;
                            } else if (date2.month+i-1 == 1 || date2.month+i-1 == 3 || date2.month+i-1 == 5 || date2.month+i-1 == 7 || date2.month+i-1 == 8 || date2.month+i-1 == 10 || date2.month+i-1 == 12) {
                                yearsum += 31;
                            } else {
                                yearsum += 30;
                            }
                        }
                    }
                }
                yearsum -= date2.day;
                yearsum += date1.day;
            }
        }else if (date1.year<date2.year){
            for (int i = 1; i <= date2.year-date1.year; i++) {
                if ((date1.year+i-1)%400==0){
                    yearsum+=366;
                } else{
                    if ((date1.year + i - 1) % 4 == 0 && (date1.year + i - 1) % 100 != 0) {
                        yearsum+=366;
                    } else {
                        yearsum+=365;
                    }
                }
            }
            if (date1.year % 400 == 0) {
                for (int i = 1; i < date1.month; i++) {
                    if (i == 2) {
                        sum += 29;
                    } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                        sum += 31;
                    } else {
                        sum += 30;
                    }
                }
            }else {
                for (int i = 1; i < date1.month; i++) {
                    if (date1.year % 4 == 0 && date1.year % 100 != 0) {
                        if (i == 2) {
                            sum += 29;
                        } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            sum += 31;
                        } else {
                            sum += 30;
                        }
                    } else {
                        if (i == 2) {
                            sum += 28;
                        } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            sum += 31;
                        } else {
                            sum += 30;
                        }
                    }
                }
            }
            sum+=date1.day;
            if (date2.year % 400 == 0) {
                for (int i = 1; i < date2.month; i++) {
                    if (i == 2) {
                        sum1 += 29;
                    } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                        sum1 += 31;
                    } else {
                        sum1 += 30;
                    }
                }
            }else {
                for (int i = 1; i < date2.month; i++) {
                    if (date2.year % 4 == 0 && date2.year % 100 != 0) {
                        if (i == 2) {
                            sum1 += 29;
                        } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            sum1 += 31;
                        } else {
                            sum1 += 30;
                        }
                    } else {
                        if (i == 2) {
                            sum1 += 28;
                        } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            sum1 += 31;
                        } else {
                            sum1 += 30;
                        }
                    }
                }
                sum1+=date2.day;
                yearsum-=sum;
                yearsum+=sum1;
                yearsum = yearsum*(-1);
            }
        } else{
            for (int i = 1; i <= date1.year-date2.year; i++) {
                if ((date2.year+i-1)%400==0){
                    yearsum+=366;
                } else{
                    if ((date2.year + i - 1) % 4 == 0 && (date2.year + i - 1) % 100 != 0) {
                        yearsum+=366;
                    } else {
                        yearsum+=365;
                    }
                }
            }
            if (date2.year % 400 == 0) {
                for (int i = 1; i < date2.month; i++) {
                    if (i == 2) {
                        sum += 29;
                    } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                        sum += 31;
                    } else {
                        sum += 30;
                    }
                }
            }else {
                for (int i = 1; i < date2.month; i++) {
                    if (date2.year % 4 == 0 && date2.year % 100 != 0) {
                        if (i == 2) {
                            sum += 29;
                        } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            sum += 31;
                        } else {
                            sum += 30;
                        }
                    } else {
                        if (i == 2) {
                            sum += 28;
                        } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            sum += 31;
                        } else {
                            sum += 30;
                        }
                    }
                }
            }
            sum+=date2.day;
            if (date1.year % 400 == 0) {
                for (int i = 1; i < date1.month; i++) {
                    if (i == 2) {
                        sum1 += 29;
                    } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                        sum1 += 31;
                    } else {
                        sum1 += 30;
                    }
                }
            }else {
                for (int i = 1; i < date1.month; i++) {
                    if (date1.year % 4 == 0 && date1.year % 100 != 0) {
                        if (i == 2) {
                            sum1 += 29;
                        } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            sum1 += 31;
                        } else {
                            sum1 += 30;
                        }
                    } else {
                        if (i == 2) {
                            sum1 += 28;
                        } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                            sum1 += 31;
                        } else {
                            sum1 += 30;
                        }
                    }
                }
            }
            sum1+=date1.day;
            yearsum-=sum;
            yearsum+=sum1;
        }
        return yearsum;
    }
}
