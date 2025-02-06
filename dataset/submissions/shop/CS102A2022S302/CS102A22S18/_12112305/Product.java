

import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>(); // ratings from different customers; default is empty.
    private Store store;


    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }

    }

    public float getAvgRating(){
        float ovo = 0;
        for (Integer rating : ratings) {
            ovo += rating;

        }
        if (ratings.size() != 0){return ovo / ratings.size();}
        else return 0;

    }



    @Override
    public String toString(){
//        return "Product ID " + id + ", " + name + ", RMB " + String.format("%.2f",price) +", Rating " + String.format("%.1f",getAvgRating());
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());

    }
}
