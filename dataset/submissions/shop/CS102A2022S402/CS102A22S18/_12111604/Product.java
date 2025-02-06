import java.util.ArrayList;
import java.util.Comparator;
public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();
    public Product(String name, float price){
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
    }
    public float getprice(){
        return this.price;
    }
    public boolean setRating(int rating){
        if (rating==1 || rating==2 || rating==3 || rating==4||rating==5){
            ratings.add(rating);
            return true;
        }else return false;
    }
    public float getAvgRating(){
        float sum =0;
        if (ratings.size()==0) return 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum +=ratings.get(i);
        }
        sum = sum/ratings.size();
        return sum;
    }
    public String toString(){
        String b = "";
        b = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name, price,getAvgRating());
        return String.valueOf(b);
    }
}
