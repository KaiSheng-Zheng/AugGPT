public class MyCalendar {
    private int capacity;
    private int space;
    private MyDate[] Datestoreage;
    private String[] Eventnamestoreage;
    private int lastthing = 2147483647;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        this.Datestoreage = new MyDate[capacity];
        this.Eventnamestoreage = new String[capacity];
        this.space = capacity;
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (space == 0) {
            return false;
        } else {
            this.Datestoreage[capacity - space] = date;
            this.Eventnamestoreage[capacity - space] = eventName;
            this.space -= 1;
            return true;
        }
    }

    public String finishNextEvent() {
        if (space == capacity) return "NONE";
        int index = findLastthing();
        for (int i = 0; i < capacity - space; i++) {
            if (Datestoreage[i].toInteger() == lastthing) {
                index = (Eventnamestoreage[i].compareTo(Eventnamestoreage[index]) < 0 ? i : index);
            }
        }
        String returnname = Eventnamestoreage[index];
        if (index!=capacity-space-1){
            for (int i = index; i < capacity - space - 1; i++) {
                Eventnamestoreage[i] = Eventnamestoreage[i + 1];
                Datestoreage[i] = Datestoreage[i + 1];
            }
        }
        space += 1;
        return returnname;
    }

    public int findLastthing() {
        lastthing = 2147483647;
        int index = 0;
        for (int i = 0; i < capacity - space; i++) {
            System.out.print(Datestoreage[i].toInteger()+" ");
            if (lastthing > this.Datestoreage[i].toInteger()) {
                lastthing = this.Datestoreage[i].toInteger();
                index = i;
            }
        }
        return index;
    }
}