import java.util.*;

public class Product implements  Comparable<Product> {

    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private SortBy sortMethod = SortBy.PurchaseTime;
    private Store store;
    private boolean inStore;

    public boolean isInStore() {
        return inStore;
    }

    public void setInStore(boolean inStore) {
        this.inStore = inStore;
    }

    public Product(String name, float price) {
        cnt += 1;
        id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
        this.store = null;
        this.inStore = false;
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
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public float getAvgRating() {
        if (ratings.size()==0){
            return 0f;
        }
        float rating = 0f;
        for (int i = 0; i < ratings.size(); i++) {
            rating += ratings.get(i);
        }
        return rating / ratings.size();
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    public SortBy getSortMethod() {
        return sortMethod;
    }

    public void setSortMethod(SortBy sortMethod) {
        this.sortMethod = sortMethod;
    }

    @Override
    public int compareTo(Product product) {
        if (sortMethod == SortBy.Rating) {
            if (this.getAvgRating()>product.getAvgRating()){
                return 1;
            }else if (this.getAvgRating()<product.getAvgRating()){
                return -1;
            }else {
                return 0;
            }
        } else if (sortMethod == SortBy.Price) {
            if (this.price>product.price){
                return 1;
            }else if (this.price<product.price){
                return -1;
            }else {
                return 0;
            }
        }
        return 0;
    }
}