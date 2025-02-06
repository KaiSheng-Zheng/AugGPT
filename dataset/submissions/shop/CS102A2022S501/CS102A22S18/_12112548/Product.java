import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private Store store;

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public static int getCnt() {
        return cnt;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt ++;
        int count = cnt;
        this.id = count;
    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <=5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }

    public float getAvgRating(){
        float total = 0;
        for (int i = 0 ;i < ratings.size(); i ++){
            total += ratings.get(i);
        }
        float avg = 0;
        if (ratings.size() != 0){
            avg = total/ratings.size();
        }
        else {
            avg = 0;
        }
        return avg;
    }

    public float getPrice() {
        return price;
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public int getId(){
        return id;
    }

}
