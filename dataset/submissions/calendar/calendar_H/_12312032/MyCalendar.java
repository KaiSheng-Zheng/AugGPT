import java.util.ArrayList;
import java.util.Comparator;
public class MyCalendar {
    private int capacity;
    private final ArrayList<String> List = new ArrayList<>();
    public MyCalendar(int capacity)
    {
        this.capacity = capacity;
    }
    public boolean addEvent(MyDate date, String eventName)
    {
        if(this.capacity == 0)
        {
            return false;
        }
        String t = date.toString()+eventName;
        List.add(t);
        this.capacity--;
        return true;
    }
    public String finishNextEvent()
    {
        if (List.isEmpty())
        {
            return "NONE";
        }
        else
        {
            List.sort(Comparator.naturalOrder());
            String e = List.get(0).substring(10);
            List.remove(0);
            this.capacity++;
            return e;
        }
    }

}
