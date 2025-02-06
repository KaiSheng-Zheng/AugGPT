

public class MyCalendar {
    int eventsQuantity = 0;
    int capacity = 0;
    String[] events;
    int indicator = 0;
    int finishNumber=-1;

    public MyCalendar(int capacity) {
        this.capacity = capacity;
        events = new String[capacity];
    }

    public boolean addEvent(MyDate date, String eventName) {
        if (eventsQuantity < capacity) {
            if (eventsQuantity == 0) {
                events[0] = date + eventName;
            } else {
                for (int i = 0; i < eventsQuantity; i++) {
                    MyDate tempDate = new MyDate(Integer.parseInt(events[i].substring(0, 4)), Integer.parseInt(events[i].substring(5, 7)), Integer.parseInt(events[i].substring(8, 10)));
                    if (MyDate.difference(tempDate, date) > 0) {
                        if (eventsQuantity > 1) {
                            for (int j = eventsQuantity ; j > i; j--) {
                                events[j] = events[j - 1];
                            }
                            events[i] = date + eventName;
                        } else {
                            events[1] = events[0];
                            events[0] = date + eventName;
                        }
                        break;
                    } else if (MyDate.difference(tempDate, date) == 0) {
                        if(i!=eventsQuantity-1) {
                            if (!events[i].substring(0, 10).equals(events[i + 1].substring(0, 10))) {
                                int result = eventName.compareTo(events[i].substring(10));
                                if (result < 0) {
                                    for (int j = eventsQuantity; j > i; j--) {
                                        events[j] = events[j - 1];
                                    }
                                    events[i] = date + eventName;
                                } else if (result >= 0) {
                                    for (int j = eventsQuantity ; j > i + 1; j--) {
                                        events[j] = events[j - 1];
                                    }
                                    events[i + 1] = date + eventName;
                                }
                                break;
                            } else {
                                int result = eventName.compareTo(events[i].substring(10));
                                if (result <= 0) {
                                    for (int j = eventsQuantity; j > i; j--) {
                                        events[j] = events[j - 1];
                                    }
                                    events[i] = date + eventName;
                                    break;
                                }
                            }
                        }else{
                            int result = eventName.compareTo(events[i].substring(10));
                            if(result<0){
                                events[i+1]=events[i];
                                events[i]=date+eventName;
                            }else {
                                events[i+1]=date+eventName;
                            }
                        }
                    }
                }
                if (events[eventsQuantity] == null) {
                    events[eventsQuantity] = date + eventName;
                }
            }
            eventsQuantity++;
            return true;
        } else {
            return false;
        }
    }

    public String finishNextEvent() {
        finishNumber++;
        if (indicator >= eventsQuantity) {
            return "NONE";
        } else {
            String str;
            str=events[indicator].substring(10);
            for (int i = indicator; i < events.length-1; i++) {
                events[i]=events[i+1];
            }
            eventsQuantity--;
            return str;
        }
    }
}
