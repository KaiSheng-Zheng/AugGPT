import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(0); // ratings from different customers; default is empty.

    public float getPrice() {
        return price;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating() {
        float count = 0.0f;
        if (ratings.size()==0){
            return 0.0f;
        } else {
            for (Integer rating : ratings) {
                count += (float) rating;
            }
            return count / ratings.size();
        }
    }
    public String toString() {
        String ss = String.format("%.2f", price);
        String s = String.format("%.1f",getAvgRating());
        return "Product ID "+ this.id+", "+ this.name+", RMB "+ ss+", Rating "+s;
    }


}
