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
        int total = this.day + days;
        if(this.month == 1){
            if(total > 31){
                this.month++;
                this.day = total - 31;
            }else this.day = total;
        }
        if(this.month == 2){
            if(this.year%4 == 0 && this.year %100 !=0){
                if(total > 29){
                    this.month++;
                    this.day = total - 29;
                }else this.day = total;
            }else {
                if(total > 28){
                    this.month++;
                    this.day = total - 28;
                }else this.day = total;
            }
        }
        if(this.month == 3){
            if(total > 31){
                this.month++;
                this.day = total - 31;
            }else this.day = total;
        }
        if(this.month == 4){
            if(total > 30){
                this.month++;
                this.day = total - 30;
            }else this.day = total;
        }
        if(this.month == 5){
            if(total > 31){
                this.month++;
                this.day = total - 31;
            }else this.day = total;
        }
        if(this.month == 6){
            if(total > 30){
                this.month++;
                this.day = total - 30;
            }else this.day = total;
        }
        if(this.month == 7){
            if(total > 31){
                this.month++;
                this.day = total - 31;
            }else this.day = total;
        }
        if(this.month == 8){
            if(total > 31){
                this.month++;
                this.day = total - 31;
            }else this.day = total;
        }
        if(this.month == 9){
            if(total > 30){
                this.month++;
                this.day = total - 30;
            }else this.day = total;
        }
        if(this.month == 10){
            if(total > 31){
                this.month++;
                this.day = total - 31;
            }else this.day = total;
        }
        if(this.month == 11){
            if(total > 30){
                this.month++;
                this.day = total - 30;
            }else this.day = total;
        }
        if(this.month == 12){
            if(total > 31){
                this.month++;
                this.day = total - 31;
            }else this.day = total;
        }

    }

    public String toString(){
        return String.format("%04d-%02d-%02d",this.year,this.month,this.day);
    }

    public static int difference(MyDate date1, MyDate date2){
        int allDays;
        int yearDays;
        int runYear;
        runYear = (date1.year-1)/4 - (date1.year-1)/100;
        yearDays = (date1.year-1)*365 + runYear;
        int monthDays = 0;
        if(date1.month == 1){
            monthDays = 0;
        }
        if(date1.month == 2){
            monthDays = 31;
        }
        if(date1.month == 3){
            if(date1.year%4 == 0 && date1.year%100 != 0){
                monthDays = 60;
            }else monthDays = 59;
        }
        if(date1.month == 4){
            if(date1.year%4 == 0 && date1.year%100 != 0){
                monthDays = 91;
            }else monthDays = 90;
        }
        if(date1.month == 5){
            if(date1.year%4 == 0 && date1.year%100 != 0){
                monthDays = 121;
            }else monthDays = 120;
        }
        if(date1.month == 6){
            if(date1.year%4 == 0 && date1.year%100 != 0){
                monthDays = 152;
            }else monthDays = 151;
        }
        if(date1.month == 7){
            if(date1.year%4 == 0 && date1.year%100 != 0){
                monthDays = 182;
            }else monthDays = 181;
        }
        if(date1.month == 8){
            if(date1.year%4 == 0 && date1.year%100 != 0){
                monthDays = 213;
            }else monthDays = 212;
        }
        if(date1.month == 9){
            if(date1.year%4 == 0 && date1.year%100 != 0){
                monthDays = 244;
            }else monthDays = 243;
        }
        if(date1.month == 10){
            if(date1.year%4 == 0 && date1.year%100 != 0){
                monthDays = 274;
            }else monthDays = 273;
        }
        if(date1.month == 11){
            if(date1.year%4 == 0 && date1.year%100 != 0){
                monthDays = 305;
            }else monthDays = 304;
        }
        if(date1.month == 12){
            if(date1.year%4 == 0 && date1.year%100 != 0){
                monthDays = 335;
            }else monthDays = 334;
        }
        allDays = yearDays + monthDays +date1.day;
        int allDays2;
        int yearDays2;
        int runYear2;
        runYear2 = (date2.year-1)/4 - (date2.year-1)/100;
        yearDays2 = (date2.year-1)*365 + runYear2;
        int monthDays2 = 0;
        if(date2.month == 1){
            monthDays2 = 0;
        }
        if(date2.month == 2){
            monthDays2 = 31;
        }
        if(date2.month == 3){
            if(date2.year%4 == 0 && date2.year%100 != 0){
                monthDays2 = 60;
            }else monthDays2 = 59;
        }
        if(date2.month == 4){
            if(date2.year%4 == 0 && date2.year%100 != 0){
                monthDays2 = 91;
            }else monthDays2 = 90;
        }
        if(date2.month == 5){
            if(date2.year%4 == 0 && date2.year%100 != 0){
                monthDays2 = 121;
            }else monthDays2 = 120;
        }
        if(date2.month == 6){
            if(date2.year%4 == 0 && date2.year%100 != 0){
                monthDays2 = 152;
            }else monthDays2 = 151;
        }
        if(date2.month == 7){
            if(date2.year%4 == 0 && date2.year%100 != 0){
                monthDays2 = 182;
            }else monthDays2 = 181;
        }
        if(date2.month == 8){
            if(date2.year%4 == 0 && date2.year%100 != 0){
                monthDays2 = 213;
            }else monthDays2 = 212;
        }
        if(date2.month == 9){
            if(date2.year%4 == 0 && date2.year%100 != 0){
                monthDays2 = 244;
            }else monthDays2 = 243;
        }
        if(date2.month == 10){
            if(date2.year%4 == 0 && date2.year%100 != 0){
                monthDays2 = 274;
            }else monthDays2 = 273;
        }
        if(date2.month == 11){
            if(date2.year%4 == 0 && date2.year%100 != 0){
                monthDays2 = 305;
            }else monthDays2 = 304;
        }
        if(date2.month == 12){
            if(date2.year%4 == 0 && date2.year%100 != 0){
                monthDays2 = 335;
            }else monthDays2 = 334;
        }
        allDays2 = yearDays2 + monthDays2 +date2.day;
        return allDays-allDays2;
    }

    public int getallDays(){
        int allDays;
        int yearDays;
        int runYear;
        runYear = (this.year-1)/4 - (this.year-1)/100;
        yearDays = (this.year-1)*365 + runYear;
        int monthDays = 0;
        if(this.month == 1){
            monthDays = 0;
        }
        if(this.month == 2){
            monthDays = 31;
        }
        if(this.month == 3){
            if(this.year%4 == 0 && this.year%100 != 0){
                monthDays = 60;
            }else monthDays = 59;
        }
        if(this.month == 4){
            if(this.year%4 == 0 && this.year%100 != 0){
                monthDays = 91;
            }else monthDays = 90;
        }
        if(this.month == 5){
            if(this.year%4 == 0 && this.year%100 != 0){
                monthDays = 121;
            }else monthDays = 120;
        }
        if(this.month == 6){
            if(this.year%4 == 0 && this.year%100 != 0){
                monthDays = 152;
            }else monthDays = 151;
        }
        if(this.month == 7){
            if(this.year%4 == 0 && this.year%100 != 0){
                monthDays = 182;
            }else monthDays = 181;
        }
        if(this.month == 8){
            if(this.year%4 == 0 && this.year%100 != 0){
                monthDays = 213;
            }else monthDays = 212;
        }
        if(this.month == 9){
            if(this.year%4 == 0 && this.year%100 != 0){
                monthDays = 244;
            }else monthDays = 243;
        }
        if(this.month == 10){
            if(this.year%4 == 0 && this.year%100 != 0){
                monthDays = 274;
            }else monthDays = 273;
        }
        if(this.month == 11){
            if(this.year%4 == 0 && this.year%100 != 0){
                monthDays = 305;
            }else monthDays = 304;
        }
        if(this.month == 12){
            if(this.year%4 == 0 && this.year%100 != 0){
                monthDays = 335;
            }else monthDays = 334;
        }
        allDays = yearDays + monthDays +this.day;
        return allDays;
    }



}
