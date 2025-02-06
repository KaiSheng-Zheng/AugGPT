

public class MyCalendar {
    private int capacity;
    private int n = 0;
    private MyDate[] time;
    private String[] name;
 

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        time = new MyDate[capacity];
        name = new String[capacity];
    }

    public boolean addEvent(MyDate date, String eventName) {
        n++;
        if (n <= capacity) {
            time[n - 1] = date;
            name[n - 1] = eventName;
            return true;
        } else {n--;
            return false;
        }
    }

    public String finishNextEvent() {
        for (int i = 0; i < n-1; i++) {
            for (int m = 0; m < n - i-1;m++) {
                if (MyDate.difference(time[m], time[m + 1]) > 0) {
                    MyDate temp = time[m + 1];
                    String tem = name[m + 1];
                    time[m + 1] = time[m];
                    name[m + 1] = name[m];
                    time[m] = temp;
                    name[m] = tem;
                }
            }
        }for(int i = 0;i<n-1;i++){
        for (int m = 0; m < n - i - 1; m++) {
            if (MyDate.difference(time[m], time[m + 1]) == 0) {
                char a = name[m].charAt(0);
                char b = name[m + 1].charAt(0);
                if ((int) a > (int) b) {
                    MyDate temp = time[m + 1];
                    String tem = name[m + 1];
                    time[m + 1] = time[m];
                    name[m + 1] = name[m];
                    time[m] = temp;
                    name[m] = tem;
                }
            }
        }}
        String temp = name[0];
        for(int m= 0;m<n-1;m++){
            time[m]=time[m+1];
            name[m]=name[m+1];
        }
        if(n>0){
            n--;return temp;
        }
        else{return "NONE";}
    }
}
