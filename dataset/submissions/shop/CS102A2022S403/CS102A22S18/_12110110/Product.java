import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private float averageRate;

    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
        ratings=new ArrayList<>();
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

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public boolean setRating(int rating){
        if (1<=rating && rating<=5){
            this.ratings.add(rating);
            averageRate=getAvgRating();
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum = 0;
        for (int i:ratings){
            sum+=(float) i;
        }
        if (ratings.size()==0){
            return 0;
        }
        return sum/ratings.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }



}
