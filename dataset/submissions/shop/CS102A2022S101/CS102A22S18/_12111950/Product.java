package Product;

import java.util.ArrayList;

public class Product {
    private static int cnt=0; // initialized to 0, and will increase by 1 when the

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(){
        cnt++;
        id=cnt;
    }
    public Product(String name, float price){
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
        if(rating >=1 && rating <=5){
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public float getAvgRating(){
        int sum=0;
        for(int rating:ratings){
            sum+=rating;
        }
        return ratings.size()>0?sum/ratings.size():0;
    }
    public String toString(){
        return "Product ID"+ id+", "+name+", RMB "+ price+", Rating "
        +getAvgRating();
    }

}
