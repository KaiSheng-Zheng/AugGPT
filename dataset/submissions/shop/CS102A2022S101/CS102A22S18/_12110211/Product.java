import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id = ++cnt;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private Store belongedStore;

    public Product(String name, float price) {
        this.price = price;
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) {
            return false;
        }

        ratings.add(rating);
        return true;
    }

    public float getAvgRating() {
        return (float) ratings.stream().mapToInt(x -> x).average().orElse(0);
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Product)) {
            return false;
        }

        Product another = ((Product) obj);
        return id == another.id && belongedStore.equals(another.belongedStore);
    }

    public void setStore(Store store) {
        belongedStore = store;
    }
}
