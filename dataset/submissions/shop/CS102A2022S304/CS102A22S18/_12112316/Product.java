import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();
    private Store store = new Store();
    public Product(String name, float price) {
        cnt++; id = cnt;
        this.name = name;
        this.price = price;
    }
    public boolean setRating(int rating){
        if(rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum = 0;
        if(ratings.size() == 0){
            return sum;
        } else {
            for (int i = 0; i < ratings.size(); i++) {
                sum = sum + ratings.get(i);
            }
            sum = sum / ratings.size();
            return sum;
        }
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
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
}