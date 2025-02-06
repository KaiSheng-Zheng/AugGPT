import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt += 1;
        this.id = cnt;
    }
    
    public boolean setRating(int rating) {
        if (1 <= rating && rating <= 5) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }
    
    public float getAvgRating() {
        if (this.ratings != null && this.ratings.size() > 0) {
            int sum = 0;
            for (Integer rating : this.ratings) {
                sum = sum + rating;
            }
            return (float) sum/this.ratings.size();
        }else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return "Product ID " + this.id + ", " + this.name
                + ", RMB " + String.format("%.2f", this.price)
                + ", Rating " + String.format("%.1f", getAvgRating());
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }
}
