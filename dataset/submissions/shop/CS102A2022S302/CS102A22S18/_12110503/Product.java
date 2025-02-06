import java.util.ArrayList;
public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name, float price){
        ratings=new ArrayList<>();
        this.name=name;
        this.price=price;
        id=++cnt;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){ratings.add(rating);return true;}
        else return false;
    }
    public float getAvgRating(){
        float avgRating=0;
        for (int i:ratings) {
            avgRating+=i;
        }
        if(ratings.size()!=0)return (avgRating/ratings.size());
        else return avgRating;
    }
    public String toString(){
        return String.format ("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
    }
    public float getPrice(){
        return price;
    }
}
