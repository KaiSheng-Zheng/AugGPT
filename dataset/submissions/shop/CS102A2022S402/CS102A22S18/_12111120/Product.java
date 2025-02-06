import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    public float setPrice(float price) {
        this.price = price;
        return price;
    }

    public float getPrice() {
        return setPrice(price);
    }

    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        setPrice(this.price);
        cnt++;
        this.id = cnt;
    }


    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        if (ratings.size() != 0) {
            float num = 0.0f;
            for (Integer rating : ratings) {
                num += (float) rating;
            }
            return  num/(float) ratings.size();
        }else {
            return 0.0f;
        }
    }

    public String toString(){
        String priceString = String.format("%.2f" , this.price);
        String ratingString = String.format("%.1f" , getAvgRating());
        return "Product ID " + this.id + ", " + this.name + ", RMB " + priceString + ", Rating " + ratingString;
    }
}