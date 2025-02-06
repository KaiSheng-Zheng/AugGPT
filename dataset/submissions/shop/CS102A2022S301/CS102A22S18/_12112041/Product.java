import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        cnt++;
        this.name=name;
        this.price=price;
        id=cnt;
        ratings=new ArrayList<Integer>();
    }

    public boolean setRating(int rating){
        if(1<=rating&&rating<=5){
            this.ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        float a=0;
        int n=ratings.size();
        for(int i=0;i<n;i++){
            a+=(float)ratings.get(i)/n;
        }
        return a;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,this.getAvgRating());
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

}