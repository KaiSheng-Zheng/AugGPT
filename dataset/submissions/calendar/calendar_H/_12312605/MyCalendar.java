public class MyCalendar {
    private int max;
    private int count = 0,count1=0;

    String[][] keep = new String[1000000+5][4];

    public MyCalendar(int capacity) {
        this.max = capacity;
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (count1 < max) {
            count++;
            count1++;
            String year = Integer.toString(date.getYear());
            String month = Integer.toString(date.getMonth());
            String day = Integer.toString(date.getDay());
            keep[count][0] = year + month + day;
            keep[count][1] = eventName;
            keep[count][2] = "0";
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        int n = 0;
        for (int i = 1; i <= count; i++) {
            if (keep[i][2] == "0") {
                n = i;
                break;
            }
        }
        if (n == 0) {
            return "NONE";
        }
        for (int i = n; i <= count; i++) {
            if ((keep[i][0].compareTo(keep[n][0]) < 0 && keep[i][2] == "0") || (keep[i][0].compareTo(keep[n][0]) == 0 && keep[i][2] == "0" && keep[i][1].compareTo(keep[n][1]) < 0)) {
                n = i;
            }
        }
        keep[n][2] = "1";
        count1--;
        return keep[n][1];
    }
}
