import java.util.ArrayList;
import java.util.Date;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;
    public Product(String name, float price){
        ratings = new ArrayList<>();
        this.name = name;
        this.price = price;
        Product.cnt++;
        this.id = cnt;
    }
    public boolean setRating(int rating){
        if ((rating != 1)&&(rating != 2)&&(rating != 3)&&(rating != 4)&&(rating != 5)){
            return false;
        }else {
            ratings.add(rating);
            return true;
        }
    }
    public float getAvgRating(){
        if (ratings == null){
            return 0.0f;
        }
        float score;
        float sum = 0.0f;
        int length = 0;
        for (Integer rating : ratings) {
            sum += rating;
            length ++;
        }
        if (length != 0){
            score = sum / length;
            return score;
        }else {
            return 0.0f;
        }
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

    public String toString(){
        return "Product ID "+ this.getId()+", "+ this.getName()+", RMB "+String.format("%.2f", this.getPrice())+", Rating "+String.format("%.1f", this.getAvgRating());
    }
}
