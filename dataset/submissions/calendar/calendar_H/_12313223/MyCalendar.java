import java.util.*;

public class MyCalendar {
  private int capacity = 0;
  private int n = 0;
  private MyDate[] a = new MyDate[100];
  private String[] b = new String[100];

  public MyCalendar(int capacity) {
    this.capacity = capacity;
  }

  public boolean addEvent(MyDate date, String eventname) {
    if (this.n >= this.capacity) {
      return false;
    }
    int i = this.n;
    for (; i >= 1; i--) {
      if (MyDate.difference(date, this.a[i]) > 0
          || (MyDate.difference(date, this.a[i]) == 0 && eventname.compareTo(this.b[i]) > 0)) {
        this.a[i + 1] = this.a[i];
        this.b[i + 1] = this.b[i];
      } else break;
    }
    this.a[i + 1] = date;
    this.b[i + 1] = eventname;
    this.n++;
    return true;
  }

  public String finishNextEvent() {
    if (this.n == 0) {
      return String.format("NONE");
    } else {
      this.n--;
      return String.format("%s", this.b[this.n + 1]);
    }
  }
}
