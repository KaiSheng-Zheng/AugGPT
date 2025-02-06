import java.util.ArrayList;

public class Product {
    private static int cnt=0;

    private int id;
    private String name;
    private float price,sum;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        id=++cnt;
        this.name=name;
        this.price=price;
        ratings=new ArrayList<>();
    }

    public int  getID(){return id;
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating){
        sum+=(rating>=1&&rating<=5)?rating:0;
        return (rating>=1&&rating<=5)?ratings.add(rating):false;
    }
    public float getAvgRating(){
        if(sum==0){
            return 0;
        }
        return sum/ratings.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

}