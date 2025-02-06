import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<Integer>();
    }
    public boolean setRating(int rating){
        if(rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public float getAvgRating(){
        float res = 0;
        int i = 0;
        for(i = 0; i < ratings.size(); i++){
            res += ratings.get(i);
        }
        res = res / ratings.size();
        return res;
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat df1 = new DecimalFormat("0.0");
        return String.format("Product ID %d, %s, RMB %s, Rating %s", id, name, df.format(price), df1.format(getAvgRating()));
    }
    public float getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
