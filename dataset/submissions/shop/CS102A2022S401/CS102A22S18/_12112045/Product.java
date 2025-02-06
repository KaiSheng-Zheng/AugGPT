import java.util.ArrayList;

public class Product {
    private static int cnt=0 ;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        ratings = new ArrayList<Integer>();
        cnt++;
        id=cnt;
    }

    public boolean setRating(int rating){
        if(rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }
        else
            return false;
    }

    public float getAvgRating(){
        float sum=0;
        float averagerating;
        for(int i =0;i<ratings.size();i++){
            sum+=ratings.get(i);
        }
        if(ratings.size()==0){
            averagerating = 0;
        }
        else
            averagerating = sum/ratings.size();
        return averagerating;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
