    public class Myevent {
        private MyDate date;
        private String event;

        public Myevent(MyDate date, String event) {
            this.event = event;
            this.date=date;
        }

        public MyDate getDate() {
            return date;
        }

        public void setDate(MyDate date) {
            this.date = date;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }
    }
