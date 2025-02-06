import java.util.ArrayList;
public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    private Store store;
    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        this.id = cnt;
    }
    public boolean setRating(int rating){
        if (rating >5 || rating<1){
            return false;
        }
        else {
            this.ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating(){
        if (ratings.size()>0){
            int counter = 0;
            for (Integer rating : ratings) {
                counter += rating;
            }
            return (float) counter / (float) ratings.size();
        }
        else {
            return 0;
        }
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return "Product ID "+ id +", "+ name +", RMB "+ String.format("%.2f",price)+", Rating "+ String.format("%.1f",getAvgRating());
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public void setStore(Store store){
        this.store = store;
    }
    public Store getStore(){
        return this.store;
    }
}

