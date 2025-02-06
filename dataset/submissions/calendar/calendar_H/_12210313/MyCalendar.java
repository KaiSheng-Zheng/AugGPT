import java.util.Arrays;
public class MyCalendar {
    private int capacity;
    private String [] str;
    private String [] date;
    private String [] event;
    private int [][] newDate;
    public MyCalendar (int capacity){
        this.capacity = capacity;
        str = new String[capacity];
        date = new String[capacity];
        event = new String[capacity];
        newDate = new int[capacity][3];}
    private int count = 0;
    public boolean addEvent(MyDate date, String eventName){
        if (count<capacity && !eventName.isEmpty()){
            str[count] = date.toString() + "G C D" + eventName;
            count++;
            return true;}
        else {return false;}}
    int temps;
    public String finishNextEvent(){
        int k = capacity;
        for (int i = 0; i < capacity; i++) {
            if (str[i] == null){
                k--;}}
        for (int i = 0; i < k; i++) {
            date[i] = str[i].split("G C D")[0];
            event[i] = str[i].split("G C D")[1];}
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 3; j++) {
                newDate[i][j] = Integer.parseInt(date[i].split("-")[j]);}}
        String suddenEvent;
        int []temp;
        for (int i = 0; i < k-1; i++) {
            for (int j = 0; j < k-1; j++) {
                if (newDate[j][0]>newDate[j+1][0]){
                    temp =newDate[j];suddenEvent = event[j];
                    newDate[j] = newDate[j+1];event[j] = event[j+1];
                    newDate[j+1] = temp;event[j+1] = suddenEvent;}}}
        for (int i = 0; i < k-1; i++) {
            for (int j = 0; j < k-1; j++) {
                if (newDate[j][0]==newDate[j+1][0]&&newDate[j][1]>newDate[j+1][1]){
                    temp =newDate[j];suddenEvent = event[j];
                    newDate[j] = newDate[j+1];event[j] = event[j+1];
                    newDate[j+1] = temp;event[j+1] = suddenEvent;}}}
        for (int i = 0; i < k-1; i++) {
            for (int j = 0; j < k-1; j++) {
                if (newDate[j][0]==newDate[j+1][0]&&newDate[j][1]==newDate[j+1][1]&&newDate[j][2]>newDate[j+1][2]){
                    temp =newDate[j];suddenEvent = event[j];
                    newDate[j] = newDate[j+1];event[j] = event[j+1];
                    newDate[j+1] = temp;event[j+1] = suddenEvent;}}}
        for (int i = 0; i < k-1; i++) {
            for (int j = 0; j < k-1; j++) {
                if (Arrays.equals(newDate[j],newDate[j+1])&&event[j].compareTo(event[j+1])>0){
                    temp =newDate[j];suddenEvent = event[j];
                    newDate[j] = newDate[j+1];event[j] = event[j+1];
                    newDate[j+1] = temp;event[j+1] = suddenEvent;}}}
        if (temps<capacity){
            temps++;
            return event[temps-1];
        }else {
            return "NONE";}
    }}