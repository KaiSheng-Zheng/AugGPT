import java.util.ArrayList;

public class Product {
    private static int cnt = 1; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store store;
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
        this.id = cnt;
        cnt++;
    }

    public boolean setRating(int rating){
        if (rating < 1 || rating > 5) return false;
        else {
            ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating(){
        if (ratings.size() == 0)
            return 0;
        float res = 0;
        for (Integer rating : ratings) {
            res += rating;
        }
        return res/ratings.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id, this.name, this.price, getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
