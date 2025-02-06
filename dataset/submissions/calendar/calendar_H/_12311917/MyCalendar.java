import java.util.ArrayList;
public class MyCalendar {
    private final int capacity;
    private int calendars;
    private final ArrayList<ArrayList<String>> event_list = new ArrayList<>();

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (capacity <= 0 || calendars>=capacity) return false;
        calendars++;
        String dateNow = date.toString();
        if (event_list.size() != 0) {
            for (var strings : event_list) {
                if (dateNow.equals(strings.get(0))) {
                    strings.add(eventName);
                    return true;
                }
            }
        }
        event_list.add(new ArrayList<>());
        event_list.get(event_list.size() - 1).add(dateNow);
        event_list.get(event_list.size() - 1).add(eventName);
        return true;
    }

    public String finishNextEvent() {
        if (event_list.size() == 0) return "NONE";
        calendars--;
        int index=0,index2=1, day_near = toDays(event_list.get(0).get(0));
        for (int i = 0; i < event_list.size(); i++) if (toDays(event_list.get(i).get(0)) < day_near) index = i;
        String output = event_list.get(index).get(1);
        for (int i=1;i<event_list.get(index).size();i++){
            if (event_list.get(index).get(i).compareTo(output)<=0){
                output=event_list.get(index).get(i);
                index2=i;
            }
        }
        event_list.get(index).remove(index2);
        if (event_list.get(index).size() <= 1) event_list.remove(index);
        return output;
    }

    public void showEvents() {
        if (event_list.size() == 0) {
            System.out.println("NONE");
            return;
        }
        for (ArrayList<String> strings : event_list) {
            for (String j : strings) System.out.printf("%s  ", j);
            System.out.println();
        }
    }

    public int toDays(String date) {
        String[] dateNum = date.split("-");
        return (Integer.parseInt(dateNum[0]) - 1970) * 365 + (Integer.parseInt(dateNum[1]) - 1) * 30 + Integer.parseInt(dateNum[2]);
    }
}
