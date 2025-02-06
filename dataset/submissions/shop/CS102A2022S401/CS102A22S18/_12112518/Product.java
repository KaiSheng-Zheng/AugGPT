import java.util.ArrayList;
public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private static int purchaseTime = 0;
    private Store store;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        float sum = 0;
        if (ratings.size() == 0){
            return 0;
        }
        for (int i = 0; i < this.ratings.size(); i++) {
            sum = sum + this.ratings.get(i);
        }
        return sum / this.ratings.size();
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", this.id, this.name, this.price, this.getAvgRating());
    }

    public int getId(){
        return this.id;
    }

    public float getPrice(){
        return this.price;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }
}
