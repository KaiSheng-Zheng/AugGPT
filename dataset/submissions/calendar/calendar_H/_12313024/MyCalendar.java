public class MyCalendar {
    int[] A = new int[10001];
    String[] B = new String[10001];
    int capacity;
    public MyCalendar (int cap) {
        capacity = cap;
    }
    int tail = -1;
    public boolean addEvent (MyDate date, String name) {
        if (tail + 1 == capacity)
            return false;
        int dt = date.year * 10000 + date.month * 100 + date.day;
        tail++;
        A[tail] = dt;
        B[tail] = name;
        return true;
    }
    public String finishNextEvent () {
        int lsnum = -1;
        int bj = 100000000;
        for (int i = 0; i <= tail; i++)
            if (A[i] < bj)
                bj = A[i];
        if (bj == 100000000)
            return "NONE";
        capacity++;
        String s = "\0";
        for (int i = 0; i <= tail; i++)
            if (A[i] == bj){
                s = B[i];
                lsnum = i;
                break;
            }
        for (int i = lsnum + 1; i <= tail; i++)
            if (A[i] == bj) {
                if (B[i].compareTo(s) < 0) {
                    lsnum = i;
                    s = B[i];
                }
            }
        //for (int i = 0; i <= tail; i++)
        //    System.out.println(A[i] + " " + B[i]);
        A[lsnum] = 100000001;
        return B[lsnum];
    }
}
