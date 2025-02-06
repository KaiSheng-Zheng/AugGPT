import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<Integer>();// ratings from different customers; default is empty.

    public Product(String name, float price){
        cnt++;
        this.name=name;
        this.price=price;
        this.id=cnt;
    }
    public boolean setRating(int rating){
        if (rating<=5&&rating>=1){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }
        float a=0;
        for (int i=0;i<ratings.size();i++){
            a+=ratings.get(i);
        }
        return a/ratings.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
    public int getId(){
        return id;
    }
    public float getPrice(){
        return price;
    }
}