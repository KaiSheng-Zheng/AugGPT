import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price) {
        Product.cnt++;
        this.id = Product.cnt;
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        if (this.ratings.size() != 0) {
            float sum = 0;
            for (int i = 0;i < this.ratings.size();i++) {
                sum = sum + this.ratings.get(i);
            }
            return sum / this.ratings.size();
        }
        return 0.0f;
    }

    @Override
    public String toString() {
        DecimalFormat p = new DecimalFormat("0.00");
        DecimalFormat a = new DecimalFormat("0.0");
        if (this.ratings.size() != 0) {
            return "Product ID " + this.id +", " + this.name + ", RMB " + p.format(this.price) + ", Rating " + a.format(this.getAvgRating());
        }
        return "Product ID " + this.id +", " + this.name + ", RMB " + p.format(this.price) + ", Rating 0.0" ;
    }

}