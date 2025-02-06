public class MyCalendar{

    private int capacity;
    private int count;
    private int[] arr;
    private String[] event;

    public MyCalendar(int capacity){
        this.capacity = capacity;
        count = 0;
        arr = new int[capacity];
        event = new String[capacity];
    }

    public boolean addEvent(MyDate date, String eventName){
        int temp;
        int judge = -1;
        if(count == capacity){
            return false;
        }else{
            temp = 10000*date.getYear()+100*date.getMonth()+date.getDay();
            for(int j=0; j < count && judge == -1; j++){
                if(arr[count-1-j] > temp){
                    arr[count-j]=arr[count-1-j];
                    event[count-j]=event[count-1-j];
                }else {
                    arr[count-j] = temp;
                    event[count-j] = eventName;
                    judge = j;
                }
            }
            for(int i=1; arr[count - judge - i] == temp ; i++){
                if(compareTo(event[count - judge - i],eventName)>0){
                    event[count - judge - i + 1]= event[count - judge - i];
                }else {
                    event[count-judge - i] = eventName;
                    break;
                }
            }
            count++;
            return true;
        }
    }

    public String finishNextEvent(){
        if(count == 0){
            return "NONE";
        }else {
            String result = event[0];
            for(int i = 0; i < count-1; i++){
                arr[i]=arr[i+1];
                event[i]=event[i+1];
            }
            arr[count-1] = 0;
            count = count - 1;
            return result;
        }
    }

    public static int compareTo(String str, String another_str) {
        for (int i = 0; i < Math.min(str.length(), another_str.length()); i++) {
            if ((int) str.charAt(i) != (int) another_str.charAt(i))
                return (int) str.charAt(i) - (int) another_str.charAt(i);
        }
        if (str.length() != another_str.length())
            return str.length() - another_str.length();
        else
            return 0;
    }
}