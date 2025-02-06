
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private Store source;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price) {
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }

    public int getId(){
        return id;
    }
    public float getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }

    public void setSource(Store source) {
        this.source = source;
    }

    public Store getSource() {
        return source;
    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating(){
        float sum = 0;
        for(int rating: ratings){
            sum += rating;
        }
        if (ratings.size() > 0) return sum/ratings.size();
        return 0;
    }

    public String toString(){
        DecimalFormat format1 = new DecimalFormat(".00");
        DecimalFormat format2 = new DecimalFormat(".0");
        if (price == 0) return "Product ID " + id + ", " + name + ", RMB 0.00, Rating "+ format2.format(getAvgRating());
        return "Product ID " + id + ", " + name + ", RMB " + format1.format(price) + ", Rating "+ format2.format(getAvgRating());
    }
}
