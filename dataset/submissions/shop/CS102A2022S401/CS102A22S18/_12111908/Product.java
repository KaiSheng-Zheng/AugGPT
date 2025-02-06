
import java.math.BigDecimal;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    Store store;
    int buyTime;
    private ArrayList<Integer> ratings = new ArrayList<>();; // ratings from different customers; default is empty.
    private long total = 0;
    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }
    public boolean setRating(int rating){
        if(rating == 1||rating == 2||rating == 3||rating == 4|| rating == 5){
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating(){
        double average = 0;
        if(ratings.size() == 0) return  0f;
        else{
            for(int i:ratings) average += i;
        }
        return (float) average / ratings.size();
    }
    public String toString(){
        if(ratings.size() == 0) return String.format("Product ID %d, %s, RMB %.2f, Rating 0.0",id,name,price);
        else return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
