import java.util.ArrayList;

public class Product {

        private static int cnt;
        private int id;
        private String name;
        private float price;
        private ArrayList<Integer> ratings;
        private Store store;

        public Store getStore() {
            return store;
        }

        public void setStore(Store store) {
            this.store = store;
        }

        public Product(String name, float price) {
            cnt++;
            id = cnt;
            this.name = name;
            this.price = price;
            ratings = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public float getPrice() {
            return price;
        }

        public boolean setRating(int rating) {
            if (rating <= 5 && rating >= 1) {
                ratings.add(rating);
                return true;
            } else {
                return false;
            }
        }

        public float getAvgRating() {
            if (ratings.size() == 0){
                return 0;
            }else{
                float avg = 0;
                for (int a : ratings) {
                    avg += a;
                }
                avg = avg / ratings.size();
                return avg;
            }
        }

        public String toString() {
            return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        }

}