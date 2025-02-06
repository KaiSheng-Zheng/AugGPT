import java.util.ArrayList;

public class Product {
    private static  int cnt;
    private int id;
    private String name;
    private float price;
    private float ratingSum=0.0f;
    private ArrayList<Integer>ratings;

    public Product(String name, float price){
        id=++cnt;
        this.name=name;
        this.price=price;
        ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratingSum+=rating;
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        if (this.ratings.size() == 0) return 0.0f;
        return ratingSum/ratings.size();
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    protected int getID(){
        return id;
    }
    protected float getPrice(){
        return price;
    }
}