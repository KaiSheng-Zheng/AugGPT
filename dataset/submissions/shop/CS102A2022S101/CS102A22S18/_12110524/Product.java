import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id, rating_sum, time;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private Store store;
    public Product(String name, float price) {
        this.id = ++cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<Integer>();
    }

    public int getTime() {
        return this.time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public Store getStore() {
        return this.store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.ratings.add(rating);
            this.rating_sum += rating;
            return true;
        }
        else return false;
    }
    public float getAvgRating() {
        return this.ratings.isEmpty() ? 0f : 1f*rating_sum/ratings.size();
    }
    public float getPrice() {
        return this.price;
    }
    public String toString() {
        NumberFormat f1 = new DecimalFormat("0.00");
        NumberFormat f2 = new DecimalFormat("0.0");
        return "Product ID "+Integer.toString(this.id)+", "+this.name+", "+ "RMB "+
                f1.format(this.price)+", Rating "+f2.format(this.getAvgRating());
    }
}