import java.util.ArrayList;
import java.util.Arrays;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.

    public static void main(String[] args) {
        Product x = new Product("milk",10);
        System.out.println(x.getAvgRating());
    }

    public Product(String name, float price){
        cnt++;
        this.id= cnt;
        this.name=name;
        if(price>0){
            this.price=price;
        }

    };

    public boolean setRating(int rating){
        if(rating <= 5 && rating >= 1 ){
            ratings.add(rating);
            return true;

        }else{
            return false;
        }

    };

    public float getAvgRating(){
        float avgTotal = 0;
        if(ratings.size()>0){
            for(int i : this.ratings) {
                avgTotal = avgTotal + i;
            }
            return avgTotal/ratings.size();

        } else{
            return 0;
        }

    };

    public String toString(){
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    };

    public float getPrice(){
        return this.price;
    }

    public ArrayList<Integer> getRatings(){
        return this.ratings;
    }
}