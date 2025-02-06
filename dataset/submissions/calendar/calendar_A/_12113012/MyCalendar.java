import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    private int capacity;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

   public boolean addEvent(MyDate date, String eventName) {
        if (treeMap.size() < capacity) {
            int dateNumber = MyDate.dateToday(date);
            KeyValue input = new KeyValue(dateNumber, eventName);
            if (isNewEntrySameAsExisting(input,eventName)) {
                int dateNumberNew = MyDate.dateToday(date)+1;
                KeyValue inputNew = new KeyValue(dateNumberNew, eventName);
                treeMap.put(inputNew, eventName);
            } else {
                treeMap.put(input, eventName);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isNewEntrySameAsExisting(KeyValue newKey, String newValue) {
        for (Map.Entry<KeyValue, String> entry : treeMap.entrySet()) {
            if (entry.getKey().equals(newKey) && entry.getValue().equals(newValue)) {
                
                return true;
            }
        }
    
        return false;
    }

    public String finishNextEvent() {
        if (treeMap.size() == 0) {
            return "NONE";
        } else {
            Map.Entry<KeyValue, String> entry = treeMap.pollFirstEntry();
            TreeMap<KeyValue, String> tempMap = new TreeMap<>(treeMap);
            treeMap.clear();
            treeMap.putAll(tempMap);
            return entry.getValue();
        }
    }


    TreeMap<KeyValue, String> treeMap = new TreeMap<>();


    static class KeyValue implements Comparable<KeyValue> {
        private int key;
        private String value;

        public KeyValue(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(KeyValue o) {
            if (this.key == o.key) {
                return this.value.compareTo(o.value);
            }
            return Integer.compare(this.key, o.key);
        }

        @Override
        public int hashCode() {
            return key;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof KeyValue)) {
                return false;
            }
            KeyValue other = (KeyValue) obj;
            return key == other.key && value.equals(other.value);
        }


    }


    public static void main(String[] args) {
        MyDate date1 = new MyDate(2023, 1, 30);
        MyDate date2 = new MyDate(2023, 3, 1);
        MyDate date3 = new MyDate(2023, 2, 5);

        date1.addDays(2);
        assert (date1.toString().equals("2023-02-01"));

        int diff = MyDate.difference(date1, date2);
        assert (diff == -28);

        int diff2 = MyDate.difference(date3, date1);
        assert (diff2 == 4);

        MyCalendar calendar = new MyCalendar(4);
        calendar.addEvent(date1, "meeting");
        calendar.addEvent(date2, "seminar");
        calendar.addEvent(date3, "appointment");
        calendar.addEvent(date1, "laundry");
        boolean success = calendar.addEvent(date1, "exam");
        assert (success == false); // event capacity exceeded
        assert (calendar.finishNextEvent().equals("laundry"));
        assert (calendar.finishNextEvent().equals("meeting"));
        assert (calendar.finishNextEvent().equals("appointment"));
        assert (calendar.finishNextEvent().equals("seminar"));
        assert (calendar.finishNextEvent().equals("NONE"));
    }
}