import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        ratings=new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating() {
        int n = 0;
        for (int i : ratings) {
            n += i;
        }
        return ratings.size() > 0 ? ((float) n) / ratings.size() : 0f;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, this.getAvgRating());
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

}
