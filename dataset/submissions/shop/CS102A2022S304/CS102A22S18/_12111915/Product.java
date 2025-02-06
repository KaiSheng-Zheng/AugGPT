import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private Store store;
    public Product(String name, float price) {
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public Store getStore() {
        return this.store;
    }
    public boolean setRating(int rating) {
        if (rating>0&&rating<6) {
            ratings.add(rating);return true;
        }
        return false;
    }
    public float getAvgRating() {
        float t = 0;int n = 0;
        if(ratings.size()==0) return 0;
        for (int i:ratings) {
            t+=i;n+=1;
        }
        return t/n;
    }
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",
                id, name, price, getAvgRating());
    }
    public float getPrice() {
        return price;
    }
}
