
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private Store store;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public void setStore(Store store){this.store=store;}
    public Store getStore(){return store;}
    public void setPrice(float price){this.price=price;}
    public float getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }
    public boolean setRating(int rating){
        if (rating<=5&&rating>=1){
            ratings.add(rating);
            return  true;
        }else {
            return  false;
        }
    }
    public float getAvgRating(){
        float sum=0;
        float averageRating=0;
        for (int i:ratings){
            sum+=i;
        }
        if (ratings.size()!=0)averageRating=(sum/ratings.size());
        return averageRating;
    }
    public String toString(){
        return "Product ID "+ getId()+", "+name+", "+ "RMB"+" "+ String.format("%.2f", price)+", "+"Rating "+String.format("%.1f", getAvgRating());
    }

}
