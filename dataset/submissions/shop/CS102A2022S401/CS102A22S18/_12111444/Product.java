
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt += 1;
        id = cnt;
    }
    public boolean setRating(int rating){
        if(rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5){
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        float total = 0;
        float size = ratings.size();
        float average = 0;
        for(int i = 0; i<ratings.size(); i++){
            total += ratings.get(i);
        }
        if(size != 0){
            average = total/size;
        }
        return average;
    }
    public int getId(){
        return id;
    }
    public float getPrice(){
        return price;
    }
    public String toString(){
        String description = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,getPrice(),getAvgRating());
        return description;
    }
}