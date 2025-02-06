import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;// unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private float rateSum;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        id = ++cnt;
        ratings = new ArrayList<>();
    }

    protected int getID(){
        return this.id;
    }

    public float getPrice() {
        return this.price;
    }

    public boolean setRating(int rating){
        if (rating>=1 && rating <=5){
            rateSum += rating;
        }else {
            rateSum += 0;
        }
        if (rating>=1 && rating<=5){
            return ratings.add(rating);
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        if (rateSum == 0){
            return 0;
        }else {
            return (rateSum / ratings.size());
        }
    }

    @Override
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
