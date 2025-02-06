package Lab;
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
    }

    public boolean setRating(int rating){
        if (rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }
        else {return false;}
    }
    public float getAvgRating(){
        float x=0;
        for (int i=0;i<ratings.toArray().length;i++){
            x=x+ratings.get(i);
        }
        x=(float)x/ratings.toArray().length;
        return x;
    }

    @Override
    public String toString() {
        return String.format("Product ID %.2f,%.2f,RMB %.2f,Rating%.1f",id,name,price,this.getAvgRating());
    }

    public float getPrice() {
        return price;
    }
}
