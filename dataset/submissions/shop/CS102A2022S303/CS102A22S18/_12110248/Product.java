import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price) {
        Product.cnt++;
        this.name = name;
        this.price = price;
        this.id = Product.cnt;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            return this.ratings.add(rating);
        } else {
            return false;
        }

    }

    public float getAvgRating() {
        if (this.ratings.size() == 0) {
            return 0.0f;
        } else {
            float sum = 0;
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            return (sum / this.ratings.size());
        }
    }

    @Override
    public String toString() {
        DecimalFormat price = new DecimalFormat("0.00");
        DecimalFormat averageRating = new DecimalFormat("0.0");
        return "Product ID " + this.id + ", "
                + this.name
                + ", RMB " + price.format(this.getPrice())
                + ", Rating " + averageRating.format(this.getAvgRating());
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
}
