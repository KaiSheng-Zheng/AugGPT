
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }
    public boolean setRating(int rating){
        if(rating <= 5 && rating >= 1){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        if(ratings.size() != 0){
            int k = 0;
            for (int i = 0; i < ratings.size(); i++) {
                k += ratings.get(i);
            }
            return  ((float) k/ (float) ratings.size());
        }
        else {
            return 0;
        }
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
    public float getPrice(){
        return price;
    }

    public int getId() {
        return id;
    }
}
