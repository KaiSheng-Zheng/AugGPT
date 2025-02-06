
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;// initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store store;


    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(rating > 5 || rating < 1) return false;
        else {
            ratings.add(rating);
            return true;
        }
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public float getAvgRating(){
        float sum = 0;
        int count = 0;
        for (int a: ratings) {
            sum += a;
            count++;
        }
        if(count == 0) return 0;
        else return sum / count;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

}
