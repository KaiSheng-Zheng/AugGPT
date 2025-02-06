
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        ++cnt;
        id = cnt;
        ratings = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    public boolean setRating(int rating) {
        if (rating > 0 && rating < 6) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        float avgRating;
        float totalRating = 0;
        for (int a : ratings) {
            totalRating += a;
        }
        avgRating = ratings.size() != 0 ? (totalRating / ratings.size()) : 0;
        return avgRating;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    public float getPrice() {
        return price;
    }
}
