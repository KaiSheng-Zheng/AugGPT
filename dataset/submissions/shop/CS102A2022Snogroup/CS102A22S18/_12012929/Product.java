import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    private Store store;
    public Product(String name, float price) {
        id = ++cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else
            return false;
    }

    public float getAvgRating() {
        if(ratings.size() == 0)
            return 0;
        float sum = 0;
        for(Integer integer: ratings)
            sum += integer;
        return sum / ratings.size();
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    public boolean equals(Object product) {
        if (product instanceof Product)
            return ((Product) product).id == id;
        return false;
    }
}
