class Node {
    private boolean occupied = false;
    private MyDate date;
    private String event;
    private Node leftChild, rightChild;

    public static boolean isBigger(String string1, String string2) {
        int minimumLength = Math.min(string1.length(), string2.length());
        for (int i = 0; i < minimumLength; i++) {
            if (string1.charAt(i) > string2.charAt(i)) return true;
            if (string1.charAt(i) < string2.charAt(i)) return false;
        }
        return string1.length() > string2.length();
    }

    public void add(MyDate date, String event) {
        if (occupied) {
            if (MyDate.isBigger(this.date, date)) leftChild.add(date, event);
            else if (MyDate.isBigger(date, this.date)) rightChild.add(date, event);
            else if (isBigger(this.event, event)) leftChild.add(date, event);
            else /*if (isBigger(event, this.event))*/ rightChild.add(date, event);
        } else {
            occupied = true;
            this.date = new MyDate(date);
            this.event = event;
            leftChild = new Node();
            rightChild = new Node();
        }
    }

    private void connectRightChild() {
        if (occupied = rightChild.occupied) {
            date = rightChild.date;
            event = rightChild.event;
            leftChild = rightChild.leftChild;
            rightChild = rightChild.rightChild;
        }
    }

    public String popEvent() {
        if (leftChild.occupied) return leftChild.popEvent();
        String event = this.event;
        connectRightChild();
        return event;
    }
}

public class MyCalendar {
    private final int capacity;

    private int countEvent = 0;

    Node root = new Node();

    public MyCalendar(int capacity) {
        this.capacity = capacity;
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (countEvent == capacity) return false;
        countEvent++;
        root.add(date, eventName);
        return true;
    }

    public String finishNextEvent() {
        if (countEvent == 0) return "NONE";
        countEvent--;
        return root.popEvent();
    }
}