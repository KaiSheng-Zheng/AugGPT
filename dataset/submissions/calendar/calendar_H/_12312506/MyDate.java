
import java.util.HashMap;

public class MyDate {
    private static HashMap<Integer, String> leapYear = new HashMap<>();
    private static HashMap<String, Integer> leapYearEntry = new HashMap<>();
    private static HashMap<Integer, String> normalYear = new HashMap<>();
    private static HashMap<String, Integer> normalYearEntry = new HashMap<>();
    private static final String INITIAL = "1600-01-01";
    private int year;
    private int month;
    private int day;
    private boolean isDone=false;

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    private int days=0;
    private String event="NONE";

    public MyDate(int year, int month, int day) {
        initiateHashMap();
        this.year = year;
        this.month = month;
        this.day = day;
//        if (isValidDate(this))
        this.days = dateToDays(this, INITIAL);
//        else
//            System.out.println("Invalid Date");
    }

    public static void initiateHashMap() {
        if (leapYear.isEmpty()) {
            int count1 = 1, count2 = 1;
            for (int i = 0; i < 31; i++) {
                leapYearEntry.put("1-" + (i + 1), count1);
                leapYear.put(count1++, "1-" + (i + 1));
                normalYearEntry.put("1-" + (i + 1), count2);
                normalYear.put(count2++, "1-" + (i + 1));
            }
            for (int i = 0; i < 28; i++) {
                leapYearEntry.put("2-" + (i + 1), count1);
                leapYear.put(count1++, "2-" + (i + 1));
                normalYearEntry.put("2-" + (i + 1), count2);
                normalYear.put(count2++, "2-" + (i + 1));
            }
            leapYearEntry.put("2-29", count1);
            leapYear.put(count1++, "2-29");
            for (int i = 0; i < 31; i++) {
                leapYearEntry.put("3-" + (i + 1), count1);
                leapYear.put(count1++, "3-" + (i + 1));
                normalYearEntry.put("3-" + (i + 1), count2);
                normalYear.put(count2++, "3-" + (i + 1));
            }
            for (int i = 0; i < 30; i++) {
                leapYearEntry.put("4-" + (i + 1), count1);
                leapYear.put(count1++, "4-" + (i + 1));
                normalYearEntry.put("4-" + (i + 1), count2);
                normalYear.put(count2++, "4-" + (i + 1));
            }
            for (int i = 0; i < 31; i++) {
                leapYearEntry.put("5-" + (i + 1), count1);
                leapYear.put(count1++, "5-" + (i + 1));
                normalYearEntry.put("5-" + (i + 1), count2);
                normalYear.put(count2++, "5-" + (i + 1));
            }
            for (int i = 0; i < 30; i++) {
                leapYearEntry.put("6-" + (i + 1), count1);
                leapYear.put(count1++, "6-" + (i + 1));
                normalYearEntry.put("6-" + (i + 1), count2);
                normalYear.put(count2++, "6-" + (i + 1));
            }
            for (int i = 0; i < 31; i++) {
                leapYearEntry.put("7-" + (i + 1), count1);
                leapYear.put(count1++, "7-" + (i + 1));
                normalYearEntry.put("7-" + (i + 1), count2);
                normalYear.put(count2++, "7-" + (i + 1));
            }
            for (int i = 0; i < 31; i++) {
                leapYearEntry.put("8-" + (i + 1), count1);
                leapYear.put(count1++, "8-" + (i + 1));
                normalYearEntry.put("8-" + (i + 1), count2);
                normalYear.put(count2++, "8-" + (i + 1));
            }
            for (int i = 0; i < 30; i++) {
                leapYearEntry.put("9-" + (i + 1), count1);
                leapYear.put(count1++, "9-" + (i + 1));
                normalYearEntry.put("9-" + (i + 1), count2);
                normalYear.put(count2++, "9-" + (i + 1));
            }
            for (int i = 0; i < 31; i++) {
                leapYearEntry.put("10-" + (i + 1), count1);
                leapYear.put(count1++, "10-" + (i + 1));
                normalYearEntry.put("10-" + (i + 1), count2);
                normalYear.put(count2++, "10-" + (i + 1));
            }
            for (int i = 0; i < 30; i++) {
                leapYearEntry.put("11-" + (i + 1), count1);
                leapYear.put(count1++, "11-" + (i + 1));
                normalYearEntry.put("11-" + (i + 1), count2);
                normalYear.put(count2++, "11-" + (i + 1));
            }
            for (int i = 0; i < 31; i++) {
                leapYearEntry.put("12-" + (i + 1), count1);
                leapYear.put(count1++, "12-" + (i + 1));
                normalYearEntry.put("12-" + (i + 1), count2);
                normalYear.put(count2++, "12-" + (i + 1));
            }
        }


    }

    public static int dateToDays(MyDate date, String INITIAL) {
        String[] initial = INITIAL.split("-");
        int Y = Integer.parseInt(initial[0]);
        int M = Integer.parseInt(initial[1]);
        int D = Integer.parseInt(initial[2]);
        int leapYearCount = 0;
        for (int i = Y; i < date.year; i++) {
            if (isLeapYear(i))
                leapYearCount++;
        }
        return (date.year - Y) * 365 + getDaysInAYear(date.year, date.month, date.day) +
                leapYearCount - getDaysInAYear(Y, M, D);
    }

    public static MyDate daysToDate(int days, String INITIAL) {
        String[] initial = INITIAL.split("-");
        int Y = Integer.parseInt(initial[0]);
        int years = days / 365-1;

        MyDate res = new MyDate(Y + years, 1, 1);

        days -= dateToDays(res, INITIAL);
        res.addDaysEasy(days);
        return res;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int getDaysInAYear(int year, int month, int day) {
        if (isLeapYear(year)) {
            return leapYearEntry.get(month + "-" + day);
        } else {
            return normalYearEntry.get(month + "-" + day);
        }

    }

    public static int difference(MyDate date1, MyDate date2) {
        return (date1.getDays() - date2.getDays());
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public static boolean isValidDate(MyDate date) {
        String regex = "^(?:(?:1[6-9]|[2-9][0-9])[0-9]{2}([-/.]?)(?:(?:0?[1-9]|1[0-2])\\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\\1(?:29|30)|(?:0?[13578]|1[02])\\1(?:31))|(?:(?:1[6-9]|[2-9][0-9])(?:0[48]|[2468][048]|[13579][26])|(?:16|[2468][048]|[3579][26])00)([-/.]?)0?2\\2(?:29))$";
        return date.toString().matches(regex);
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }

    public void addDaysEasy(int days) {
        int temp1 = getDaysInAYear(this.year, this.month, this.day);
        if (isLeapYear(this.year)) {

            if (temp1 + days > 366) {
                this.year++;
                days -= 366;
                this.addDaysEasy(days);
            } else {
                temp1 += days;
                String temp = leapYear.get(temp1);
                String[] temp2 = temp.split("-");
                this.month = Integer.parseInt(temp2[0]);
                this.day = Integer.parseInt(temp2[1]);
                this.days = dateToDays(this, INITIAL);

            }
        } else {
            if (temp1 + days > 365) {
                this.year++;
                days -= 365;
                this.addDaysEasy(days);
            } else {
                temp1 += days;
                String temp = normalYear.get(temp1);
                String[] temp2 = temp.split("-");
                this.month = Integer.parseInt(temp2[0]);
                this.day = Integer.parseInt(temp2[1]);
                this.days = dateToDays(this, INITIAL);
            }
        }
    }

    public void addDays(int days) {
        MyDate temp = daysToDate((this.getDays() + days), INITIAL);
        this.year = temp.year;
        this.month = temp.month;
        this.day = temp.day;
        this.days = temp.days;

    }

    public int getDays() {
        return this.days;
    }

}

