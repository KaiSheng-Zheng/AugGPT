import java.util.ArrayList;
import java.util.Scanner;
public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private Store store;

    public Product(String name, float price){
        cnt ++;
        this.name = name;
        this.price = price;
        id = cnt;
        ratings = new ArrayList<>();
    }

    public boolean setRating(int rating){
        if (rating < 1 || rating > 5)
            return false;
            ratings.add(rating);
        return true;
    }

    public float getAvgRating(){
        float temp = 0;
        for (int i = 0; i < ratings.size(); i++) {
            temp += ratings.get(i);
        }
        if (ratings.size() != 0)
        return temp/ratings.size();
        else
            return 0;
    }

    public String toString(){
        String temp = "";
        temp += "Product ID ";
        temp += id;
        temp += ", ";
        temp += name;
        temp += ", RMB ";
        temp += String.format("%.2f", price);
        temp += ", Rating ";
        temp += String.format("%.1f", getAvgRating());
        return temp;
    }

    public float getPrice() {
        return price;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }
}
