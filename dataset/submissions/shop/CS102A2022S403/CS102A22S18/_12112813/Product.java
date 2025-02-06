import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id = cnt+1;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    boolean Sold = false;//bonus
    public Store store;//bonus
    //Constructor
    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = (float)(Math.round(price*100))/100;
    }

    public boolean setRating(int rating){
        if (rating<=5 && rating>=1){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        if(ratings.size()==0){
            return 0;
        }
        int sum = 0;
        for (int i = 0;i<ratings.size();i++){
            sum += ratings.get(i);
        }
        return ((float) sum)/ratings.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
    public float getPrice(){
        return price;
    }
}