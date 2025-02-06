import java.util.ArrayList;
import java.util.Arrays;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public int getId() {
        return id;
    }

    public Product(String name, float price){
        Product.cnt++;
        this.name=name;
        this.price=price;
        this.id=cnt;
        this.ratings=new ArrayList<>();
    }

    public boolean setRating(int rating){
        if(rating<=5 && rating>=1){
           this.ratings.add(rating);
           return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        if(ratings.size()==0) return 0;

        float total=0;
        for (int i=1;i<=ratings.size();i++){
            total+=ratings.get(i-1);
        }
        return total/ratings.size();
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
    }

    public float getPrice() {
        return price;
    }
}
