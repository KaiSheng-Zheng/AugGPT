import java.util.ArrayList;

public class Product {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer>ratings; // ratings from different customers; default is empty.
    public Product(String name, float price){
        cnt++;
        this.name = name;
        this.price = price;
        this.id=cnt;
        ArrayList<Integer>ratings = new ArrayList<>();
        setRatings(ratings);
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public boolean setRating(int rating){
        if (rating>=1&& rating<=5){
            this.ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }
    public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }else {
            float ratings = 0;
            for (int i = 0; i < getRatings().size(); i++) {
                ratings += getRatings().get(i);
            }
            return ratings / getRatings().size();
        }
    }
    public String toString(){
        String string;
        string = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
        return string;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public void setId(int id) {
        this.id = id;
    }
}