import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store onceBeenIn;                                 //
    public Product(String name, float price){
        this.name = name;
        this.price = price;
        id = ++cnt;
        ratings = new ArrayList<>();
    }
    public boolean setRating(int rating){
        if (rating >= 1 & rating <= 5){
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public float getAvgRating(){
        if (ratings.size() == 0){
            return 0;
        }
        int total = 0;
        for (int i = 0; i < ratings.size(); i++) {
            total += ratings.get(i);
        }
        return (float) total/ratings.size();
    }
    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public int getID(){
        return id;
    }
    public float getPrice(){
        return price;
    }
    public void setOnceBeenIn(Store store){          //
        onceBeenIn = store;
    }
    public Store getOnceBeenIn(){                    //
        return onceBeenIn;
    }
}