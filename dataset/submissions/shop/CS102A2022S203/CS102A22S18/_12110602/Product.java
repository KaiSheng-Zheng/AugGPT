import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id = 1;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private Store store;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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
        float sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        if (ratings.size() == 0) {
            return 0;
        } else {
            return sum / ratings.size();
        }
    }

    DecimalFormat df1 = new DecimalFormat("0.00");
    DecimalFormat df2 = new DecimalFormat("0.0");

    public String toString() {
        return "Product ID " + id + ", " + name + ", RMB " + df1.format(price) + ", Rating " + df2.format(getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public float setPrice(float price) {
        this.price = price;
        return price;
    }


}
