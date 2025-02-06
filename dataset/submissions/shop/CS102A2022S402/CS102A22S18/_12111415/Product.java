
import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name,float price){
        this.price=price;
        this.name=name;
        this.id=1+cnt;
        cnt=cnt+1;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        float sum=0;
        if (ratings.size()==0){
            return 0;
        }
        else for(int i=0;i<ratings.size();i++){
            sum=sum+ratings.get(i);
        }
        return sum/ratings.size(); }
    public String toString(){
        return
                String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}