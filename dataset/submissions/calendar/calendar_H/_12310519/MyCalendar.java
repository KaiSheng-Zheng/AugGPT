public class MyCalendar {
    private int num;
    private int a = 0;
    private int sum = 0;
    private MyDate[] myDates;
    private String[] strings;

    public MyCalendar(int capacity) {
        this.num = capacity;
        myDates = new MyDate[num * 10];
        strings = new String[num * 10];
    }

    public boolean addEvent(MyDate date, String eventName) {
        boolean result = false;
        if (a - sum == num) {
            return result;
        }
        if (a - sum <= num - 1) {
            myDates[a] = date;
            strings[a] = eventName;
            a++;
            result = true;
        }
        if(a > 1) {
            for (int i = sum; i < a - 1; i++) {
                for (int j = i + 1; j < a; j++) {
                    if (MyDate.difference(myDates[i], myDates[j]) < 0) {
                        continue;
                    }
                    if (MyDate.difference(myDates[i], myDates[j]) > 0) {
                        MyDate m = myDates[j];
                        myDates[j] = myDates[i];
                        myDates[i] = m;
                        String s = strings[j];
                        strings[j] = strings[i];
                        strings[i] = s;
                        continue;
                    }
                    if (MyDate.difference(myDates[i], myDates[j]) == 0) {
                        if (strings[i].compareTo(strings[j]) >= 0) {
                            MyDate m = myDates[j];
                            myDates[j] = myDates[i];
                            myDates[i] = m;
                            String s = strings[j];
                            strings[j] = strings[i];
                            strings[i] = s;
                        }
                    }
                }
            }
        }
        return result;
    }
    public String finishNextEvent(){
            if (sum < a) {
                sum++;
                return strings[sum-1];
            } else {
                return "NONE";
            }
        }

}
