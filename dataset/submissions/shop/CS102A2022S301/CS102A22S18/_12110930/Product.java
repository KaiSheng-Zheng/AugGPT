import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.id = ++cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        if (this.ratings != null && this.ratings.size() > 0) {
            int sum = 0;
            for (Integer rating : this.ratings) {
                sum += rating;
            }
            return sum / this.ratings.size() * 1.0f;
        }
        return 0;
    }

    public String toString() {
        return "Product ID " + this.id + ", " + this.name
                + ", RMB " + String.format("%.2f", this.price)
                + ", Rating " + String.format("%.1f", getAvgRating()) + ".";
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

}
