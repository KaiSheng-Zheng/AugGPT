import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;

    public float getPrice() {
        return price;
    }

    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
        this.ratings=new ArrayList<Integer>();
    }

    public boolean setRating(int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            this.ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating() {
        float totalRating = 0;
        float avgRating;
        for (int i = 0; i < this.ratings.size(); i++) {
            totalRating += this.ratings.get(i);
        }
        if (this.ratings.size()!=0){
        avgRating = totalRating / this.ratings.size();}
        else avgRating=0.0f;
        return avgRating;
    }


    public String toString() {
        DecimalFormat df2 = new DecimalFormat("0.00");
        DecimalFormat df1 = new DecimalFormat("0.0");
        return "Product ID " + id + ", " + name + ", RMB " + df2.format(price) + ", Rating " + df1.format(this.getAvgRating());
    }
}
