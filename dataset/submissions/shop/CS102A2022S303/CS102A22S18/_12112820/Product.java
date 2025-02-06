import java.util.*;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price,ratingSum;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
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
    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null||getClass()!=o.getClass()){
            return false;
        }
        Product p=(Product)o;
        return id==p.id;
    }
}
