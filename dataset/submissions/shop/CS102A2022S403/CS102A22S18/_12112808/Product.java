import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private int ratingSum=0;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price) {
        id=++cnt;
        this.price = price;
        this.name = name;
        ratings=new ArrayList<>();
    }
    int getID(){
        return id;}
    float getPrice(){return price;}
    public boolean setRating(int rating) {
        if (rating > 1 && rating < 5)
        {ratings.add(rating);
            ratingSum += rating;
        return true;}
        else return false;
    }

    public float getAvgRating() {
        int i;
        if (ratings.size()==0){return 0;}
        else {i= ratingSum / ratings.size();
        return i;}
    }

    public String toString() {
String f= String.format("Product ID %d, %s, %.2f, Rating %.1f",id,name,price,getAvgRating());
return f;
    }

}