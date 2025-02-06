import java.math.BigDecimal;
import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();
    private int store;
    public Product(String name, float price){
        cnt++;
        id=cnt;
        this.price=price;
        this.name=name;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getAvgRating(){
        if(ratings.size()<1){
            return 0;
        }
        else {int sum=0;
        for(int i=0;i<ratings.size();i++){
            sum+=ratings.get(i);
        }
        return (float) sum/ratings.size();
    }}
    public String toString(){
        java.text.DecimalFormat   d2=new   java.text.DecimalFormat("0.00");
        java.text.DecimalFormat   d1=new   java.text.DecimalFormat("0.0");
        return "Product ID "+id+", "+name+", RMB "+d2.format(price)+", Rating "+d1.format(getAvgRating());
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }
}