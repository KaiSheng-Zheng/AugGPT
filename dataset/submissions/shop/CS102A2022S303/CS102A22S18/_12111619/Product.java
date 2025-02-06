import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
        this.ratings = new ArrayList<>();
    }

    public boolean setRating(int rating) {
        if (rating <= 5 && rating >= 1) {
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        int totalRating = 0;
        for (int i = 0; i <= ratings.size() - 1; i++) {
            totalRating += ratings.get(i);
        }
        if(ratings.size() == 0){
            return (float) 0.0;
        }
        return (float) totalRating / ratings.size();
    }
    public String toString(){
        String legalPrice = String.format("%.2f",this.price);
        String legalRating = String.format("%.1f",this.getAvgRating());
        return "Product ID " + id + ", " + name + ", RMB " + legalPrice + ", Rating " + legalRating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }
}