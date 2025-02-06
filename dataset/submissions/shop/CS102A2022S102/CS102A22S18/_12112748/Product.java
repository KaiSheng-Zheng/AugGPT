import java.util.*;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    public int pt;//purchase time in the shoppinglist
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    private Store store;

    public Product(){
        id = 0;
        name = null;
        price =0f;
        ratings = new ArrayList<>();
    };
    public Product(String name, float price){
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }

    //rating operation
    public int getRatings(int i){
        return ratings.get(i);
    }
    public void clear(){
        ratings.clear();
    }
    public int getsize(){
        return ratings.size();
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getPrice(){
        return price;
    }

    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
            getAvgRating();
            return true;
        }else{
            return false;
        }
    }

    public float getAvgRating(){
        double sum = 0;
        for(int i=0;i<ratings.size();i++){
            sum += ratings.get(i);
        }
        if(ratings.size()!=0){
            return (float) (sum/ratings.size());
        }else{
            return 0;
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

}
