import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store store;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.id = ++cnt;
        ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        return rating >= 1 && rating <= 5 && ratings.add(rating);
    }

    public float getAvgRating() {
        if (this.ratings.size() == 0)
            return 0;
        float result = 0;
        for (Integer rating : this.ratings) {
            result += rating;
        }
        return result / (float) this.ratings.size();
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}
