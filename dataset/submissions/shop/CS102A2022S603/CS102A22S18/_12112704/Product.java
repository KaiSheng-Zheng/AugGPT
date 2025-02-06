import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.

    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store productStore;
    private int order;

    public Product(String name, float price) {
        this.id = ++cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
        this.productStore = null;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        if (this.ratings.size() == 0) {
            return 0.0f;
        }
        long sum = 0;
        for (Integer r : this.ratings) {
            sum += r;
        }
        return 1.0f * sum / this.ratings.size();
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",
                this.id, this.name, Math.round(this.price * 100) / 100.0f, Math.round(getAvgRating() * 10) / 10.0f);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Store getProductStore() {
        return productStore;
    }

    public void setProductStore(Store productStore) {
        this.productStore = productStore;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
