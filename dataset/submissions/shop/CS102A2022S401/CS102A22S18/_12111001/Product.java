import java.math.BigDecimal;
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    private Store store;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating){
        if(rating >= 1&&rating <= 5){
            ratings.add(rating);
            return true;
        }
        else{
            return false;
        }
    }
    public void setStore(Store store){
        this.store = store;
    }
    public float getAvgRating(){
        float avg;
        float sum = 0;
        if(ratings.size() == 0){
            return 0;
        }else {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            avg = sum / ratings.size();
            return avg;
        }
    }
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }
    public Store getStore(){
        return store;
    }
    public String toString(){
        String result;
        result = "Product ID " + id + ", " + name + ", " + "RMB " + String.format("%.2f",price) + ", " + "Rating " + String.format("%.1f",getAvgRating());
        return result;
    }
}
