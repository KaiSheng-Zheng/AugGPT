import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public Product(String name, float price){
        cnt++;
        id=cnt;
        this.name=name;
        this.price=price;
        this.ratings = new ArrayList<>();
    }
    public boolean setRating(int rating){
        if(rating>=1&&rating<=5){
            ratings.add(rating);
        return true;}
        else return false;
    }
    public float getAvgRating(){
        float avgRating=0;
        if(ratings.size()!=0){for (Integer rating : ratings) {
            avgRating += rating;
        }avgRating=avgRating/ratings.size();}
        return avgRating;
    }
    public String toString(){
        return "Product ID "+id+", "+name+", RMB "+String.format("%.2f",price)+", Rating "+String.format("%.1f",getAvgRating());
    }
}