import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when theconstructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; defaultis empty.

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.price = price;
        this.name = name;
        ratings=new ArrayList<Integer>();
    }
//
    public boolean setRating(int rating) {
        if (rating ==1||rating ==2||rating ==3||rating ==4||rating ==5) {
            ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating() {
        int a = ratings.size();
        float b = 0;
        if (a == 0) {
            return 0;
        } else {
            for (int i = 0; i < a; i++) {
                b = b + ((float) ratings.get(i)) / ((float) a);
            }
            return b;
        }
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
}

    public float getPrice() {
        return price;
    }
}
