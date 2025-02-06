import java.util.*;

public class MyCalendar {
    private int capacity;
     private List<MyDate> myDate0List = new ArrayList<>();
     private String ev;
     private int su=0;
     private int shi=0;

    public List<MyDate> getMyDate0List() {
        return myDate0List;
    }

    public void setMyDate0List(List<MyDate> myDate0List) {
        this.myDate0List = myDate0List;
    }

    public String getEv() {
        return ev;
    }

    public void setEv(String ev) {
        this.ev = ev;
    }

    public int getSu() {
        return su;
    }

    public void setSu(int su) {
        this.su = su;
    }

    public int getShi() {
        return shi;
    }

    public void setShi(int shi) {
        this.shi = shi;
    }

    public  boolean addEvent(MyDate myDate ,String eventName)
    {
        if (su<capacity){
            myDate.getListEvent().add(eventName);
            myDate.getListEvent().sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            if (!myDate0List.contains(myDate))
            {
                myDate0List.add(myDate);
            }
            myDate0List.sort(new MyComparator());
        }
        else
        {
            return false;
        }
        su++;

        return true;
    }
    class MyComparator implements Comparator<MyDate>
    {

        @Override
        public int compare(MyDate o1, MyDate o2) {
            if (o1.getYear()==o2.getYear())
            {
                if (o1.getMonth()==o2.getMonth())
                {
                    return o1.getDay()-o2.getDay();
                }
                else
                {
                    return o1.getMonth()-o2.getMonth();
                }
            }
            else
            {
                return o1.getYear()-o2.getYear();
            }
        }
    }
    public String finishNextEvent()
    {
        String strings = "NONE";
     if (!myDate0List.isEmpty())
     {
        if (!myDate0List.get(0).getListEvent().isEmpty())
        {
            strings=myDate0List.get(0).getListEvent().get(0);
            myDate0List.get(0).getListEvent().remove(0);
            if (myDate0List.get(0).getListEvent().isEmpty())
            {
                myDate0List.remove(0);
            }
        }
        else
        {
            myDate0List.remove(0);
        }
     }
     return strings;
    }

    public MyCalendar() {
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }
}
