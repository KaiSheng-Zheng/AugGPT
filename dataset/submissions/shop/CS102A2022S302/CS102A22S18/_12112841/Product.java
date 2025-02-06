import java.util.ArrayList;

public class Product {
        private static int cnt = 0;
        private int id;
        private String name;
        private float price;
        private float sum = 0;
        private float average;
        private ArrayList<Integer> ratings;

        public Product(String name, float price) {
            cnt++;
            this.id = cnt;
            this.name = name;
            this.price = price;
            ratings = new ArrayList<>();
        }
        public boolean setRating(int rating) {
            if (rating >= 1 && rating <= 5){
                sum += rating;
                return ratings.add(rating);
            }else{
                return false;
            }
        }
        public float getAvgRating() {
            if (sum != 0){
                average = sum/ratings.size();
                return average;
            }
            return 0;
        }
        public String toString(){
            return  String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        }
        public float getPrice() {
        return price;
        }
        public int getId() {
          return id;
        }
        public String getName() {
        return name;
       }
}


