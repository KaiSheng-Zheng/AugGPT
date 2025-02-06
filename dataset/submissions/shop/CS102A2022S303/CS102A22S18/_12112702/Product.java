import java.util.ArrayList;
import java.util.Objects;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty
    Store store;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Float.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(ratings, product.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, ratings);
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        ratings = new ArrayList<>();
        Store from;
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
        if (ratings.size() == 0) {
            return 0;
        } else {
            float total = 0;
            for (Integer rating : ratings) {
                total += rating;
            }
            return total / ratings.size();
        }
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}