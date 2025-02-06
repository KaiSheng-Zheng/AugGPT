public class MyDate {


        private int year;
        private int month;
        private int day;
        public MyDate(int year,int month,int day){
            this.year = year;
            this.month = month;
            this.day = day;
        }
        public void addDays(int days){
            int[] daymate = new int[13];
            daymate[0] = 0;
            daymate[1] = 31;
            daymate[3] = 31;
            daymate[4] = 30;
            daymate[5] = 31;
            daymate[6] = 30;
            daymate[7] = 31;
            daymate[8] = 31;
            daymate[9] = 30;
            daymate[10] = 31;
            daymate[11] = 30;
            daymate[12] = 31;
            day = day + days;
            while (day> daymate[month]){
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    daymate [2]=29;
                } else {
                    daymate [2]=28;
                }
                day = day -daymate[month];
                month = month+1;
                if (month>12){
                    month = 1 ;
                    year = year + 1;
                }
            }
        }
        public String toString(){
            if (month<10&&day<10){
                return year+"-"+0+month+"-"+0+day;
            }
            if (month>10&&day<10){
                return year+"-"+month+"-"+0+day;
            }
            if (month<10&&day>10){
                return year+"-"+0+month+"-"+day;
            }
            if (month>10&&day>10){
                return year+"-"+month+"-"+day;
            }
            return "";
        }
        public static int difference(MyDate date1,MyDate date2){
            int day1 = 0;
            int day2 = 0;
            int[] x1={0,31,28,31,30,31,30,31,31,30,31,30,31};
            int[] x2={0,31,28,31,30,31,30,31,31,30,31,30,31};
            for(int i=1;i< date1.year;i++){
                if(i%4==0&& i%100!=0 || i%400==0){
                    day1+=366;
                }else{
                    day1+=365;
                }
            }
            if(date1.year%4==0&& date1.year%100!=0 || date1.year%400==0){
                x1[2]=29;
            }
            if(date2.year%4==0&& date2.year%100!=0 || date2.year%400==0){
                x2[2]=29;
            }
            for(int p=1;p< date2.year;p++){
                if(p%4==0&& p%100!=0 || p%400==0){
                    day2+=366;
                }else{
                    day2+=365;
                }
            }
            for(int n=1;n< date1.month;n++){
                day1+=x1[n];
            }
            day1+= date1.day;
            for(int i=1;i< date2.month;i++){
                day2+=x2[i];
            }
            day2+=date2.day;
            int dif = day1 - day2;
            return dif;
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
