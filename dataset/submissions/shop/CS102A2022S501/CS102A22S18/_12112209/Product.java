import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    public Product(String name, float price){
        this.id = ++cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if (rating<1||rating>5){
            return false;
        }else {
            ratings.add(rating);
            return true;
        }
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum+=ratings.get(i);
        }
        float result = 1.0f*sum/ratings.size();
        return result;
    }

    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f", price)+", Rating "+String.format("%.1f", getAvgRating());
    }

}
