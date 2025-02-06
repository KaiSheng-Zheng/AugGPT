import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private int time;
    private Store store;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }
    public boolean setRating(int rating){
        if(rating >=1 && rating <=5) {
            ratings.add(rating);
            return true;
        }
        else return false;
    }
    public float getAvgRating(){
        float sum = 0;
        for(int i = 0;i<ratings.size();i++){
            sum += ratings.get(i);
        }
        if(ratings.size() == 0)
            return (float) 0.0;
        else return sum/ratings.size();
    }
    public String toString(){
        return String.format("Product ID %s, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

    public int getId() {
        return this.id;
    }
    public float getPrice() {
        return this.price;
    }

    public void setTime(int time) {
        this.time = time;
    }
    public int getTime() {
        return time;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore(){
        return store;
    }
}
