import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt ++;
        id = cnt;
        ratings=new ArrayList<>();
    }

    public boolean setRating(int rating){
        if (1 <= rating && rating <= 5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        float sum = 0.0f ;
        if (ratings.size() == 0){
            return 0;
        }else {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            float average = sum / ratings.size();
            return average;
        }

    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,getPrice(),getAvgRating());
    }

    public float getPrice(){
        return price;
    }

}