import java.util.ArrayList;
import java.util.Comparator;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.id = ++ cnt;
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

    public float getAvgRating() {
        if (ratings.size() == 0) {
            return 0;
        }
        float sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String priceStr = String.format("%.2f", price);
        String avgRatingStr = String.format("%.1f", getAvgRating());
        return "Product ID " + id + ", " + name + ", RMB " + priceStr + ", Rating " + avgRatingStr;
    }

}