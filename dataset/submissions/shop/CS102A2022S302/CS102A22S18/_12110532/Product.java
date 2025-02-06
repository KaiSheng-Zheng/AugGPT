import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }

    }

    public float getAvgRating() {
        float sum = 0;
        float avg;
        if (ratings.size() == 0) {
            return 0;
        } else {
            for (int i = 0; i < ratings.size(); i++) {
                sum = sum + ratings.get(i);
            }
            avg = sum / ratings.size();
        }
        return avg;
    }

    public float getPrice() {
        return price;
    }

    public String toString() {
        DecimalFormat price = new DecimalFormat("0.00");
        DecimalFormat avgRating = new DecimalFormat("0.0");
        return "Product ID " + id + ", " + name + ", " + "RMB " + price.format(price) + ", Rating " + avgRating.format(getAvgRating());
    }
}