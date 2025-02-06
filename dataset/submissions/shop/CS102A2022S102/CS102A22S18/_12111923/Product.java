import java.util.ArrayList;

public class Product {
    // initialized to 0, and will increase by 1 when the constructor is called.
    private static int cnt = 0;
    // unique for each product and the value is set to cnt.
    private int id;
    private String name;
    private float price;
    // ratings from different customers; default is empty.
    private ArrayList<Integer> ratings;
    // the store where product is sold
    private Store store;

    public Product(String name, float price) {
        this.id = ++cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        float avgRating = 0;
        if (!ratings.isEmpty()) {
            int totalRating = 0;
            for (int rating : ratings) {
                totalRating += rating;
            }
            avgRating = totalRating * 1.0F / ratings.size();
        }
        return avgRating;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}