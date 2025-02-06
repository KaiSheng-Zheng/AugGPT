import java.util.ArrayList;

public class MyCalendar {

    private int capacity;

    private  int counter = 0;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    ArrayList<MyDate> arrayList1 = new ArrayList<>();
    ArrayList<String> arrayList2 = new ArrayList<>();

    public boolean addEvent(MyDate date, String eventName) {
        if (counter < capacity) {
            arrayList1.add(date);
            arrayList2.add(eventName);
            counter++;
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        if (counter == 0){
            return "NONE";
        }else {
            counter--;
            int item = 0 ;
            if (arrayList1.size() > 1){
                for (int i = 1; i < arrayList1.size(); i++) {
                    if (arrayList1.get(item).getYear() > arrayList1.get(i).getYear()){
                        item = i;
                    }else if (arrayList1.get(item).getYear() == arrayList1.get(i).getYear()){
                        if (arrayList1.get(item).numbers(arrayList1.get(item).getYear(),arrayList1.get(item).getMonth(),arrayList1.get(item).getDay())
                                > arrayList1.get(i).numbers(arrayList1.get(i).getYear(),arrayList1.get(i).getMonth(),arrayList1.get(i).getDay())){
                            item = i;
                        }else if (arrayList1.get(item).numbers(arrayList1.get(item).getYear(),arrayList1.get(item).getMonth(),arrayList1.get(item).getDay())
                                == arrayList1.get(i).numbers(arrayList1.get(i).getYear(),arrayList1.get(i).getMonth(),arrayList1.get(i).getDay())){
                            if (arrayList2.get(item).compareToIgnoreCase(arrayList2.get(i)) > 0){
                                item = i;
                            }
                        }
                    }
                }
            }
            String arrayItem = arrayList2.get(item);
            arrayList1.remove(item);
            arrayList2.remove(item);
            return arrayItem;
        }
    }
}