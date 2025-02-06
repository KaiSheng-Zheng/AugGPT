import java.util.*;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price,ratingSum;
    private ArrayList<Integer> ratings;
    public Product(String name, float price){
        id=++cnt;
        this.name=name;
        this.price=price;
        ratings=new ArrayList<>();
    }
    protected int getID(){
        return id;
    }
    protected float getPrice(){
        return price;
    }
    public boolean setRating(int rating){
        ratingSum+=(rating>=1&&rating<=5)?rating:0;
        return (rating>=1&&rating<=5)?ratings.add(rating):false;
    }
    public float getAvgRating(){
        return ratingSum==0?0:ratingSum/ratings.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
