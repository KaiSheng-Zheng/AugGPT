import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    private Store store;

    public Product(String name, float price){
        this.name=name;
        this.price=price;
        cnt++;
        this.id=cnt;
        ratings = new ArrayList<>();
        
    }

    public int getId() {
        return id;
    }

    public float getPrice(){
        return this.price;
    }

    public boolean setRating(int rating){
        if (rating>=1&&rating<=5){
            return this.ratings.add(rating);
        }else {
            return false;
        }
    }
    public float getAvgRating() {
        float sum = 0;
        if (ratings.size()==0){
            return 0;
        }else {
        for (Integer rating : this.ratings) {
            sum += rating;
        }
        float result=sum/ ratings.size();
        return result;
        }
    }

    public String toString(){
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",id, name, getPrice(), getAvgRating());
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
