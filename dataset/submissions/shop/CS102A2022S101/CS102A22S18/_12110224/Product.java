
import java.util.ArrayList;
import java.util.Objects;

public class Product {
    private static int cnt = 0;
    private int id = ++cnt;
    private String name;
    private float price;
    ArrayList<Integer> ratings = new ArrayList<Integer>();


    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating <= 5 && rating >= 1) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating() {
        float total = 0;
        for (int ratings : ratings) {
            total += ratings;
        }
        return total / ratings.size();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //Product ID 3, Mouse, RMB 100.00, Rating 3.0
}
