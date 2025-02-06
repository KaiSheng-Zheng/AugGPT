import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Comparator;

public class MyCalendar {
    private int capacity;
    private int i = 0;
    Map<Integer, List<String>> map = new HashMap<>();

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public static int countnumbers(Map<Integer, List<String>> map1) {
        int count = 0;
        for (Map.Entry<Integer, List<String>> entry : map1.entrySet()) {
            List<String> listp = entry.getValue();
            for (int i = 0; i < listp.size(); i++) {
                count++;
            }
        }
        return count;
    }

    public boolean addEvent(MyDate date, String eventName) {
        int in = MyDate.caculate3(date);
        if (countnumbers(map) < capacity) {
            if (map.containsKey(in)) {
                List<String> existingList = map.get(in);
                existingList.add(eventName);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(eventName);
                map.put(in, newList);
            }
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        Map<Integer, List<String>> sortedMap = new TreeMap<>(map);
        Map<Integer, List<String>> tempmap = new TreeMap<>();
        tempmap.putAll(sortedMap);
        List<Integer> keys = new ArrayList<>(tempmap.keySet());
        Integer Key = keys.get(i);
        List<String> listtemp = tempmap.get(Key);
        Collections.sort(listtemp, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        String temp;

        if (listtemp != null && !listtemp.isEmpty()) {
            temp = listtemp.get(0);
            listtemp.remove(0);
            tempmap.put(Key, listtemp);
            map.putAll(tempmap);
        } else {
            i++;
            if (i == keys.size()) {
                temp = "NONE";
            } else {
                temp = finishNextEvent();
            }
        }
        return temp;
    }
}