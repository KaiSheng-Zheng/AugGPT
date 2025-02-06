import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private Store store;
    private ArrayList<Integer> ratings;// ratings from different customers; default is empty.
    public Product(String name,float price){
        this.ratings=new ArrayList<>();
        this.name=name;
        this.price=price;
        cnt++;this.id=cnt;
        store=null;
    }

    public static int getCnt() {
        return cnt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Store getStore(){
        return store;
    }

    public void setStore(Store store){
        this.store=store;
    }


    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            this.ratings.add(rating);
            return true;
        }else return false;
    }
    public float getAvgRating(){
        if(this.ratings.size()==0) return 0;
        else{
            float a=0;int total=0;
            for (Integer rating : this.ratings) {
                total += rating;
            }
            a=(float) total/this.ratings.size();
            return a;
        }
    }

    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,this.getAvgRating());
    }
}