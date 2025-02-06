import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
    }

    public boolean setRating(int rating) {
       if (rating>=1&&rating<=5){
           ratings.add(rating);
return true;
       }else{
           return false;
       }
    }

    public float getAvgRating() {
        int sum = 0;

        for (Integer rating : ratings) {
            sum += rating;
        }
        return (float) sum/(float) ratings.size();
       
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return  "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+
                ", Rating "+String.format("%.1f",getAvgRating());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
