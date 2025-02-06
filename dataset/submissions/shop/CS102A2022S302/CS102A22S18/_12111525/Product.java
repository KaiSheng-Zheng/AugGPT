import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private Store store;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }
    public float getPrice(){
        return price;
    }
    public boolean setRating(int rating){
        if ((rating>=1)&&(rating<=5)){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getAvgRating(){
        int a = 0;
        if (ratings.size()>0){
            for (int i = 0; i < ratings.size(); i++) {
                a += ratings.get(i);
            }
            float b = (float) a/ratings.size();
            return  b;
        }
        else {
            return 0;
        }
    }
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public int getId(){
        return id;
    }
}
