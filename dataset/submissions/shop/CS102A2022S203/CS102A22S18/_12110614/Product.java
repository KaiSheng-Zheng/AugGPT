import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    private Store store;

    public float getPrice() {
        return price;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }


    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;

    }

    public boolean setRating(int rating) {
        boolean check;
        if (rating <= 5 && rating >= 1) {
            ratings.add(rating);
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public float getAvgRating() {
        float sum = 0;
        int a = ratings.size();
        float AvgRating;
        if (a != 0) {
            for (int i = 0; i < a; i++) {
                sum += ratings.get(i);
            }
            AvgRating = sum / a;
        } else {
            AvgRating = 0;
        }
        return AvgRating;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}
