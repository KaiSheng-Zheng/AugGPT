import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating){
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        if (getRatings().size() == 0){
            return 0;
        }else {
            float sum = 0;
            for (int rating : ratings){
                sum += rating;
            }
            return (sum / ratings.size());
        }
    }

    public String toString(){
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }

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
}
