import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }
        public boolean setRating(int rating) {
            if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
                ratings.add(rating);
                return true;
            } else {
                return false;
            }
        }
        public float getAvgRating(){
        int sum = 0;
            for (Integer rating : ratings) {
                sum = sum + rating;
            }
            int n = ratings.size();
            if (n == 0){
                return 0;
            }else {
            return (float) sum /n;}
    }



        public String toString(){
            return "Product ID " + id + ", " + name + ", " + "RMB " + String.format("%.2f", price) + ", " + "Rating " + String.format("%.1f", getAvgRating());
        }
        public float getPrice(){
        return price;
        }
}
