import java.util.ArrayList;

public class Product {
    private Store store;
    private static int cnt;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public int getId() {
        return id;
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
        if (ratings.size()!=0){
            float he = 0f;
            for (int i = 0; i < ratings.size(); i++) {
                he += ratings.get(i);
            }
            return he / ratings.size();
        }else {
            return 0;
        }
    }

    public String toString() {
        String printf = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
        return printf;
    }

}
