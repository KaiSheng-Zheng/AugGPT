import java.util.ArrayList;

class todo {
    private String name;
    private MyDate date;
    private boolean used;

    public todo(String name, MyDate date){
        this.name = name;
        this.date = date;
        used = false;
    }

    String getName() { return this.name; }
    MyDate getDate() { return this.date; }
    boolean getUsed() { return this.used; }

    public void finish() { used = true; }

    public static boolean cmp(todo e1, todo e2){
        int dt = MyDate.judge(e1.date, e2.date);
        if(dt < 0) return false;
        else if(dt > 0) return true;
        else{
            if(e1.name.compareTo(e2.name) < 0) return false;
            else return true;
        }
    }

    public String toString(){
        return String.format(this.date + " " + this.name);
    }
}

public class MyCalendar {
    ArrayList<todo> cld;
    final int mx;
    private int now;

    public MyCalendar(int capacity){
        this.mx = capacity;
        this.cld = new ArrayList<todo>();
        now = 0;
    }

    public boolean addEvent(MyDate dt, String name){
        if(now == mx) return false;
        cld.add(new todo(name, dt));
        now++;
        return true;
    }

    public String finishNextEvent(){
        boolean flag = false;
        todo cur = new todo("sgweo8ys", new MyDate(0, 0, 0));

        int ps = 0;
        for(int i = 0; i < cld.size(); i++){
            todo x = cld.get(i);
            if(x.getUsed()) continue;

            if(cur.getName().equals("sgweo8ys")) cur = x;
            if(!todo.cmp(x, cur)){
                cur = x;
                ps = i;
            }
            flag = true;
        }

        if(flag){
            cur.finish();
            cld.set(ps, cur);
            now--;
        }

        if(!flag) return "NONE";
        else return cur.getName();
    }
}