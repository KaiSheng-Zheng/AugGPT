import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private boolean used = false;

    private ArrayList<Integer> ratings = new ArrayList(); // ratings from different customers; default is empty.
    private Store store;

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else return false;
    }

    public void use() {
        used = true;
    }

    public boolean isUsed() {
        return used;
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating() {
        float sum = 0;
        if (ratings.size()>0){
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            return sum / ratings.size();
        }else return 0;



    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, this.getAvgRating());
    }
}
