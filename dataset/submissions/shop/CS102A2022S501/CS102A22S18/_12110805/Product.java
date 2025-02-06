import java.util.ArrayList;

import static java.lang.String.format;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private Store store;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        this.name=name;
        cnt++;
        this.id=cnt;
        this.price=price;
    }
    public boolean setRating(int rating) {
    if(rating==1||rating==2||rating==3||rating==4||rating==5){
        ratings.add(rating);
        return true;
    }else{
        return false;
    }

    }
    public float getAvgRating() {
        float sum=0;
        if(ratings.size()==0){
            return 0;
        }else{
        for (int i=0;i<ratings.size();i++){
            sum+=ratings.get(i);
        }
        
        return sum/(float) ratings.size();}
    }
    public String toString() {
        String f;
        f=format("Product ID %d, %s, RMB %.2f, Rating %.1f",this.id,this.name,this.price,getAvgRating());
        return f;
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

    public float get() {
        return price;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
