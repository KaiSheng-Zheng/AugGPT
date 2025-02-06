import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public Product(String name, float price){
        ratings = new ArrayList<>();
        this.name = name;
        this.price = price;
        this.id = cnt + 1;
        cnt++;
    }

    public boolean setRating(int rating){
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5){
            this.ratings.add(rating);
            return true;
        }
        else return false;
    }

    public float getAvgRating(){
        float a = 0;
        if (ratings.size() >= 1){
            for (Integer rating : ratings) {
                a = a + rating;
            }
            a = a/ratings.size();
        }
        return a;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String toString(){
        String p = String.format("%.2f",this.price);
        String r = String.format("%.1f",getAvgRating());
        return "Product ID " + id + ", " + name + ", RMB "+p+", Rating "+r;
    }
}