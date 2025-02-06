import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;// unique for each product and the value is set to cnt.
    private String name;
    private float price;
    public Store from;
    private ArrayList<Integer> ratings =new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id=cnt;
    }

    public boolean setRating(int rating) {
        if (rating > 0 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating() {
        float totalRating = 0;
        if (ratings.size()==0){
            return 0;
        }
        for (Integer rating : ratings) {
            totalRating = totalRating + (float)rating;
        }
        return totalRating / ratings.size();
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}