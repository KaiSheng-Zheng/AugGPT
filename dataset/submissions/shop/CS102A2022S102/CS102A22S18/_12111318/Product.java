
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private float price;
    private String name;
    private Store store1;
    private ArrayList <Integer>ratings=new ArrayList<> ();
    private static int time;
    private int purchaseTime;
    private int id;


    public Product(String name,float price) {
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
    }
    public boolean setRating(int rating) {
        if(rating>5||rating<1) {
            return false;
        }else {
            ratings.add(rating);
            return true;
        }

    }
    public  void setCn(){
        int Cn=1;
    }
    public void setStore(Store store) {
        store1=store;
    }
    public void setPurchaseTime() {
        time++;
        purchaseTime=time;
    }
    public int getId() {
        return id;
    }
    public float getPrice() {
        return price;
    }
    public int getPurchaseTime() {
        return purchaseTime;
    }
    public Store getStore() {
        return store1;
    }
    public float getAvgRating() {
        int now3=ratings.size();
        if(now3==0) {

            return 0F;
        }
        float now4=0F;
        for (int rating : ratings) now4+= rating;
        return now4/now3;
    }
    //0F  yuan lai shi 0f

    public String toString() {
        return "Product ID "+ id +", "+name+","+" RMB "+ String.format("%.2f",price)+","+" Rating "+String.format("%.1f",getAvgRating());
    }


}

