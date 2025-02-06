import java.util.ArrayList;

public class MyCalendar {
    private int capacity;
    private ArrayList<MyDate> A=new ArrayList<>();
    private ArrayList<String> B=new ArrayList<>();

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }
    private boolean Ju(String a,String b)
    {
        int m;
        if (a.length()<b.length()) m=a.length();
        else m=b.length();
        for (int i=0;i<m;i++)
            if (a.charAt(i)<b.charAt(i)) return true;
        else if (a.charAt(i)>b.charAt(i)) return false;
        if (a.length()==m) return true;
        else return false;

    }

    public boolean addEvent(MyDate date, String eventName) {
        if (A.size() == capacity) return false;
        A.add(date);
        B.add(eventName);
        return true;
    }

    public String finishNextEvent() {
        if (A.size() == 0) return "NONE";
        int min = 0, cor = 0;
        for (int i = 0; i < A.size(); i++)
            if ((MyDate.difference(A.get(0), A.get(i))) >min||(((MyDate.difference(A.get(0), A.get(i)))==min)&&Ju(B.get(i),B.get(cor)))) {
                min = (MyDate.difference(A.get(0), A.get(i)));
                cor = i;
            }
        String temp;
        temp = B.get(cor);
        A.remove(cor);
        B.remove(cor);
        return temp;
    }
}
