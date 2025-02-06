public class MyCalendar {
    private final String[] thing=new String[100000];
    private final MyDate[] time=new MyDate[100000];
    private final int[] yong=new int[100000];
    private final int num;

    public MyCalendar(int capacity){
        this.num=capacity;
    }
    public boolean addEvent(MyDate date, String eventName){
        int sum = 0;
        for (int i = 0; i <num; i++) {
            sum += yong[i];
        }
        if(sum==num){
            return false;
        }else{
            for (int i = 0; i <num; i++) {
                if(yong[i]==0){
                    thing[i]=eventName;
                    time[i]=date;
                    yong[i]=1;
                    break;
                }
            }
            return true;
        }
    }
    public String finishNextEvent() {
        int sum = 0;
        for (int i = 0; i <num; i++) {
            sum += yong[i];
        }
        if (sum == 0) {
            String c = "NONE";
            return c;
        } else {
            int b=0;
            MyDate min=time[0];
            String mi=thing[0];
            for (int i = 0; i < num; i++) {
                if (yong[i] == 1) {
                    b = i;
                    min = time[i];
                    mi = thing[i];
                    break;
                }
            }
            for (int i = 0; i < num; i++) {
                if (yong[i] == 1) {
                    if (MyDate.difference(min, time[i]) > 0) {
                        min = time[i];
                        mi = thing[i];
                        b = i;
                    } else if (MyDate.difference(min, time[i]) == 0 & thing[i].compareTo(mi)< 0) {
                        min = time[i];
                        mi = thing[i];
                        b = i;
                    }
                }
            }
            yong[b] = 0;
            return thing[b];
        }
    }
}