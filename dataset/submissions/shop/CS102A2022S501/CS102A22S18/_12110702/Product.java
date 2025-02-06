import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    Map<Product,Store> maps=new HashMap<>();

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        int a=0;
        for (int i = 0; i <ratings.size(); i++) {
            a+=ratings.get(i);
        }
    if (ratings.size()!=0)return (float) a/ratings.size();
    else return 0;
    }
    public String toString(){
        String a=String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return a;
    }
}
