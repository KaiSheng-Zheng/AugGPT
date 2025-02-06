import java.util.ArrayList;

public class Product {
    private static int cnt=0; // will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        cnt++;
        this.name=name;
        id=cnt;
        this.price=price;
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){ratings.add(rating);return true;}
         else return false;
    }
    public float getAvgRating(){
        float avg=0;
        if(ratings.size()==0){return 0.0f;}
        else{
        for (int i = 0; i < ratings.size(); i++) {
            avg+=ratings.get(i);
        }
        avg=(float) avg/ratings.size();
        return avg;}
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
