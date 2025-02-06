import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id,rateNumber=0;
    private String name;
    private float price,rateSum;
    private ArrayList<Integer> ratings;
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
        ratings=new ArrayList<>();
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            rateSum+=rating;
            rateNumber++;
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }
    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }
        return (float) rateSum/rateNumber;
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
    public float getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }
}
