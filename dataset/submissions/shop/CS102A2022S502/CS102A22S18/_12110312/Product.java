import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        Product.cnt++;
        this.name = name;
        this.price = price;
        this.id = Product.cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }
        this.ratings.add(rating);
        return true;
    }

    public float getAvgRating() {
        if (this.ratings.size() == 0) {
            return 0;
        }
        float sum = 0;
        for (int i : this.ratings) {
            sum += i;
        }
        return sum / this.ratings.size();
    }

    public String toString() {
        String p = String.format("%.2f", this.price);
        String avg = String.format("%.1f", this.getAvgRating());
        return  "Product ID " + this.id + ", " + this.name + ", RMB " + p + ", Rating " + avg;
    }

    public float getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
}
