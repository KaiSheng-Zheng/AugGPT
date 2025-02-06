import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
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
        cnt += 1;
        this.id = cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating() {
        if (ratings.size() == 0){
            return 0;
        }else {
            int sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        float avg =(float) sum / (float) ratings.size();
        return avg;
        }
    }

    @Override
    public String toString() {
        String s = String.format("%.1f",getAvgRating());
        String pr = String.format("%.2f",price);
        return "Product ID " + id +", " +name +", RMB "+ pr+", Rating "+ s;
    }
}
