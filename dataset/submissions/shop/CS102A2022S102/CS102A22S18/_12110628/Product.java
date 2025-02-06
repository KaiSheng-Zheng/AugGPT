import java.util.ArrayList;
public class Product {
    private static int cnt = 0;
    private int id = 0;
    private String name = "";
    public float getPrice() {
        return this.price;
    }
    private float price = 0;
    private ArrayList<Integer> ratings = new ArrayList<>(0);
    public Product(String name, float price){
        cnt += 1;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }
    public boolean setRating(int rating){
        if (rating >= 1 & rating <= 5){
            ratings.add(rating);
            return true;
        }
        return false;
    }
    public float getAvgRating(){
        if (ratings.size() == 0){
            return 0;
        }
        float a = 0;
        for (Integer rating : ratings) {
            a = a + rating;
        }
        return a /ratings.size();
    }
    public String toString(){
        return "Product ID "
                + id +
                ", "
                + name +
                ", RMB "
                + String.format("%.2f",price) +
                ", Rating "
                + String.format("%.1f",getAvgRating());
    }
}
