import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.
    public Store store;

    public Product(String name, float price) {
        this.name=name;
        this.price=price;
        cnt++;
        id=cnt;
        ratings = new ArrayList<>();
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean setRating(int rating){
        if(rating>5 || rating<1) return false;
        else {
            ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating(){
        float avg=0;
        for (int i = 0; i < ratings.size(); i++) {
            avg+=ratings.get(i);
        }
        if(ratings.size()!=0)
        return avg/ratings.size();
        else return 0;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}
