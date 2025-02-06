

import java.util.ArrayList;

    public class MyCalendar {
        private int capacity;
        private ArrayList<MyDate> dates=new ArrayList<>();

        public MyCalendar(int capacity) {
            this.capacity = capacity;
        }

        public boolean addEvent(MyDate date, String event) {
            if (dates.size() < capacity) {
                MyDate temp = new MyDate(date.getYear(), date.getMonth(), date.getDay());
                temp.setEvent(event);
                dates.add(temp);
                return true;
            }
            return false;
        }

        public String finishNextEvent() {
            dates.sort((o1, o2) -> {
                if (o1.getDays() > o2.getDays())
                    return 1;
                else if (o1.getDays() < o2.getDays())
                    return -1;
                else
                    return o1.getEvent().compareTo(o2.getEvent());
            });
            if (!dates.isEmpty()) {
                String res=dates.get(0).getEvent();
                dates.remove(0);
                return res;
            } else
                return "NONE";
        }
    }
