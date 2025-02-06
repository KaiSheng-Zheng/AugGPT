import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float sum;
    private float price;
    private ArrayList<Integer> ratings;
    private Store storeName;
    public void setStoreName(Store store){
         this.storeName=store;
    }
    public Store getStoreName(){
        return storeName;
    }
    public Product(String name,float price){
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;
        ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            sum+=rating;
            return ratings.add(rating);
        }
        else {
            return false;
        }
    }
    public float getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }
    public float getAvgRating(){
        if (ratings.size()==0)return 0;
        return sum/ratings.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
