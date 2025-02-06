import java.math.BigDecimal;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private final int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price) {
        ++cnt;
        this.name = name;
        this.price = price;
        this.id = cnt;
        this.ratings = new ArrayList<>();
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
        if (ratings.size() == 0) {
            return (float) 0.0;
        } else {
            for (Integer rating : ratings) {
                sum += rating;
            }
            return sum / ratings.size();
        }
    }

    public String toString() {
        String priceFormat = BigDecimal.valueOf(price).setScale(2).toString();
        String avgFormat = BigDecimal.valueOf(getAvgRating()).setScale(1).toString();
        return "Product ID " + id + ", " + name + ", RMB " + priceFormat
                + ", Rating " + avgFormat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public static int getCnt() {
        return cnt;
    }
}
