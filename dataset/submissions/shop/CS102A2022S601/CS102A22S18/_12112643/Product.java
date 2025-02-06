import java.util.ArrayList;
import java.text.DecimalFormat;
public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }
    public boolean setRating(int rating){
        if (rating>=1 && rating <=5) {
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating() {
        float sum = 0;
        if (ratings.size() == 0) {
            return 0;
        } else {
            for (int i = 0; i < ratings.size(); i++) {
                sum += ratings.get(i);
            }
            return sum / ratings.size();
        }
    }
    public String toString(){
        String description = "";
        DecimalFormat df1 = new DecimalFormat("#0.00");
        DecimalFormat df2 = new DecimalFormat("#0.0");
        description = "Product ID " + id + ", " + name + ", RMB " + df1.format(price) + ", Rating "+ df2.format(getAvgRating());
        return description;
    }
    public int getID(){
        return id;
    }
    public float getPrice(){
        return price;
    }
}
