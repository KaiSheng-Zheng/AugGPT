import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private Store from;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.

    public Product(String name, float price){
        id = ++cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating){
        if (rating < 1 || rating > 5)
            return false;
        ratings.add(rating);
        return true;
    }

    public float getAvgRating(){
        float sum = 0;
        if (ratings == null)
            return 0;
        for (int i = 0;i < ratings.size();i++)
            sum += ratings.get(i) / (float) ratings.size();
        return sum;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public Store getStore() {
        return from;
    }

    public void markFrom(Store store) {
        this.from = store;
    }
}
