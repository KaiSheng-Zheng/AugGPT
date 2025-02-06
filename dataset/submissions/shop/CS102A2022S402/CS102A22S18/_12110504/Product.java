import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    private int from;

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;

    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getPrice() {
        return price;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public float getAvgRating() {
        float sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        if (sum == 0) return 0;
        return sum / ratings.size();

    }

    public String toString() {
        DecimalFormat pricef = new DecimalFormat("0.00");
        DecimalFormat avgRatingf = new DecimalFormat("0.0");
        return "Product ID " + id + ", " + name + ", RMB " + pricef.format(price) + ", Rating " + avgRatingf.format(getAvgRating());
    }

}
