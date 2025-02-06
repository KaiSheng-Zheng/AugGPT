public class MyDate{
    private int year;
    private int month;
    private int day;
    int count = 0;
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
        count++;
    }
    public void addDays(int days){
        int limit = 0;
        while (days > 0){
            switch (month){
                case 1 :
                case 3 :
                case 5 :
                case 7 :
                case 8 :
                case 10 :
                case 12 :
                    limit = 31;
                    break;
                case 2 :
                    if (judgeLeapYear(year)){
                        limit = 29;
                    }else {
                        limit = 28;
                    }
                    break;
                case 4 :
                case 6 :
                case 9 :
                case 11:
                    limit = 30;
                    break;
            }
            if (limit >= days + day){
                day += days;
                days = 0;
            }else {
                days -= limit - day + 1;
                month++;
                day = 1;
            }
        }
    }

    @Override
    public String toString() {
        String R = "";
        if (year / 1000 == 0){
            if (year / 100 >= 1) {
                R += "0";
            } else if (year / 10 >= 1) {
                R += "00";
            }else {
                R += "000";
            }
        }
        R += year + "-";
        if (month / 10 == 0){
            R += "0";
        }
        R += month + "-";
        if (day / 10 == 0){
            R += "0";
        }
        R += day;
        return R;
    }
    public static int difference(MyDate date1, MyDate date2){
        int y1 = date1.year,y2 = date2.year,m1 = date1.month,m2 = date2.month,d1 = date1.day,d2 = date2.day;
        int R[] = findNumOfLeapYear(y1,y2);
        int dif = (y1 - y2) * 365 + R[0] + d1 - d2;
        switch (m1){
            case 2: dif += 31;break;
            case 3: dif += 59;break;
            case 4: dif += 90;break;
            case 5: dif += 120;break;
            case 6: dif += 151;break;
            case 7: dif += 181;break;
            case 8: dif += 212;break;
            case 9: dif += 243;break;
            case 10: dif += 273;break;
            case 11: dif += 304;break;
            case 12: dif += 334;break;
            default: break;
        }
        switch (m2){
            case 2: dif -= 31;break;
            case 3: dif -= 59;break;
            case 4: dif -= 90;break;
            case 5: dif -= 120;break;
            case 6: dif -= 151;break;
            case 7: dif -= 181;break;
            case 8: dif -= 212;break;
            case 9: dif -= 243;break;
            case 10: dif -= 273;break;
            case 11: dif -= 304;break;
            case 12: dif -= 334;break;
            default: break;
        }
        switch (R[1]){
            case 1:
                if (m1 >= 3){dif++;}break;
            case 2:
                if (m2 >= 3){dif++;}break;
            case 3:
                if (m1 >= 3){dif++;}
                if (m2 >= 3){dif--;}break;
            default:break;
        }
        return dif;
    }
    public static int[] findNumOfLeapYear(int year1,int year2){
        int R[] ={0,0};
        if (year1 == year2){
            if (judgeLeapYear(year1)){R[1] = 3;}
        }
        if (year1 > year2){
            if (judgeLeapYear(year1)){R[1] = 1;}
            if (judgeLeapYear(year2)){
                R[0]++;
                if (R[1] == 1){
                    R[1] = 3;
                }else {
                    R[1] = 2;
                }
            }
            for (int i = year2 + 1;i < year1;i++){
                if (judgeLeapYear(i)){R[0]++;i += 3;}
            }
        }
        if (year1 < year2){
            if (judgeLeapYear(year1)){R[1] = 1;}
            if (judgeLeapYear(year2)){
                R[0]--;
                if (R[1] == 1){
                    R[1] = 3;
                }else {
                    R[1] = 2;
                }
            }
            for (int i = year1 + 1;i < year2;i++){
                if (judgeLeapYear(i)){R[0]--;i += 3;}
            }
        }
        return R;
    }
    public static boolean judgeLeapYear(int year){
        if (year % 400 == 0){
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        }else {
            return false;
        }
    }
}