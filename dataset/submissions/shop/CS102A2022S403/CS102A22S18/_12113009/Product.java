import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price) {//state a class called product
this.name=name;
this.price=price;
cnt++;
this.id=cnt;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean setRating(int rating) {

        if(rating<=5&&rating>=1)
        {  ratings.add(rating);
            return true;}
        else
        return false;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public float getAvgRating() {
        float cnm=0;
        int outcome=0;
        if(ratings.size()==0)return outcome;
        else{
        for(int i=0;i<ratings.size();i++)
        {
            cnm+=ratings.get(i);
        }
        float AvgRating=cnm/ratings.size();
        return AvgRating;}

    }
@Override
    public String toString() {
    return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
}



}