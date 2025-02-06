import java.lang.reflect.Array;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    float rateSum;


    public Product(String name, float price){
        id=++cnt;
        this.name=name;
        this.price=price;
        ratings=new ArrayList<>();
    }


    public boolean setRating(int rating){

        if (rating >= 1 && rating <= 5) rateSum += rating;
        else rateSum += 0;
        return rating >= 1 && rating <= 5 && ratings.add(rating);
    }
    public float getAvgRating(){
        float v;
        if(ratings.size()==0){ v=0;}
        else { v = rateSum / ratings.size();}
        return v;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public int getId() {
        return id;
    }


    public float getPrice() {
        return price;
    }
}
