import java.util.ArrayList;

public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.id = cnt + 1;
        cnt += 1;
        this.ratings=new ArrayList<>();
    }
    public boolean setRating(int rating) {

        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        float sum = 0;
        float avgrating=0;
        if(ratings.size()!=0){
        for (Integer rating : ratings) {
            sum += rating;
        }
        avgrating = sum / ratings.size();}
        return avgrating;
    }

    public float getPrice() {
        return price;
    }

    public String toString() {
        String idd = String.valueOf(id);
        String pri = String.format("%.2f", price);
        String ra = String.format("%.1f",getAvgRating());
        String s = "Product ID " + idd + ", " + name + ", " + "RMB " + pri + ", " + "Rating " + ra;
        return s;
    }

    public int getId() {
        return id;
    }
}