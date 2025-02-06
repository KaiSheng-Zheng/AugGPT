import java.util.*;
import java.text.*;

public class MyCalendar {
	private int capacity;

	public MyCalendar(int capacity) {
		this.capacity = capacity;
		count=0;
		event.clear();
	}

	public static int count = 0;
	public static ArrayList<String> event = new ArrayList<String>();

	public boolean addEvent(MyDate date, String eventName) {
		if (count < capacity) {
			count++;
			event.add(date.toString());
			event.add(eventName);
		//		System.out.println(date.toString());
		//		System.out.println(eventName);
			if (count >= 2) {
				for (int i = count * 2 - 2; i > 0; i = i - 2) {
					for (int j = count * 2 - 2; j > 0; j = j - 2) {
						String e = event.get(j - 2);
						String f = event.get(j - 1);
						int judge = event.get(j).compareTo(event.get(j - 2));
						if (judge < 0) {
							event.remove(j - 1);
							event.remove(j - 2);
							event.add(e);
							event.add(f);
						} else {
							if (judge == 0) {
								String g = event.get(j - 1);
								int judge2 = event.get(j + 1).compareTo(event.get(j - 1));
								if (judge2 < 0) {
									event.set(j - 1, event.get(j + 1));
									event.set(j + 1, g);
								}
							}
						}
					}
				}
			}
			System.out.println(event);
			return (true);
		} else {
			return (false);
		}
	}
	public String finishNextEvent() {
		if (count > 0) {
			count--;
			String h = event.get(1);
			event.remove(0);
			event.remove(0);
			//System.out.println("finish:"+event);
			return (h);
		} else {
		//	System.out.println(count);
			return ("NONE");
		}
	}

	
}
