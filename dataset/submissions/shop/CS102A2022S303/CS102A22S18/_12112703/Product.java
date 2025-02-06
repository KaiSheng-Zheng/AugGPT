import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList <Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating){
        if (rating>= 1 && rating <= 5){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
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
        String s = String.format("%.2f",price);
        float prisetran = Float.valueOf(price);
        return prisetran;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }


    public float getAvgRating(){
        int sum = 0;
        float average = 0;
        if (this.ratings.size()!=0){
            for (int i =0;i<this.ratings.size();i++){
                sum = sum + this.ratings.get(i);
            }
            average = (float)sum/ratings.size();
        }
        return average;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id, name, price, this.getAvgRating());
    }
}
