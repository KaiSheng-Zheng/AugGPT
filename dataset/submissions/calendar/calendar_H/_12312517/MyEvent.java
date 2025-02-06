public class MyEvent {
        private MyDate date;
        private String name;
        public MyEvent(MyDate date, String name) {
            this.date = date;
            this.name = name;
        }
    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
