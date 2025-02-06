public class MyCalendar {
    private int capacity, tot;
    private boolean[] vis;
    private int[] que;
    private String[] name;
    private MyDate[] date;
    public MyCalendar(int capacity) {
        tot = 0;
        this.capacity = capacity;
        name = new String[capacity];
        date = new MyDate[capacity];
        vis = new boolean[capacity];
        que = new int[capacity];
    }
    private boolean cmp(int x, int y) {
        int tmp = MyDate.difference(date[x], date[y]);
        if(tmp < 0) return false;
        if(tmp > 0) return true;
        return name[x].compareTo(name[y]) > 0;
    }
    private int newId() {
        for(int i = 0; i < capacity; i ++)
            if(!vis[i]) {
                vis[i] = true;
                return i;
            }
        return -1;
    }
    public boolean addEvent(MyDate date, String eventName) {
        if(tot == capacity) return false;
        que[tot] = newId();
        name[que[tot]] = eventName;
        this.date[que[tot]] = date;
        int now = tot;
        tot ++;
        while(now > 0 && cmp(que[now-1], que[now])) {
            int tmp = que[now];
            que[now] = que[now-1];
            que[now-1] = tmp;
            now --;
        }
        return true;
    }
    public String finishNextEvent() {
        if(tot == 0) return "NONE";
        int ers = que[0];
        tot --;
        for(int i = 0; i < tot; i ++)
            que[i] = que[i+1];
        vis[ers] = false;
        return name[ers];
    }
}
