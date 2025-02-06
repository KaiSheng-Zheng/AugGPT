import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    private int purchaseTime;
    private Store store;

    public Product(String name, float price) {
        this.id = ++cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) return false;
        this.ratings.add(rating);
        return true;
    }

    public float getAvgRating() {
        if(ratings.size() == 0) return 0;
        float sum = 0f;
        for (Integer rate : this.ratings) {
            sum += rate;
        }
        return sum / this.ratings.size();
    }

    public String toString() {
        return String.format(
                "Product ID %d, %s, RMB %.2f, Rating %.1f",
                this.id, this.name, this.price, this.getAvgRating()
        );
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public int getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(int purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
}
