import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
    }

    public boolean setRating(int rating){
        if(rating <= 5 && rating >= 1){
            ratings.add(rating);
            return true;
        }else {
            return false;
        }
    }

    public float getAvgRating(){
        float sum = 0;
        if (ratings.size()==0){
            return 0;
        }
        for (Integer rating : ratings) {
            sum += (float)rating;
        }
        return (sum/(float)ratings.size());
    }

    public String toString(){
        return "Product ID " + id + ", " + name + ", RMB " + String.format("%.2f",price) + ", Rating "+ String.format("%.1f",getAvgRating());
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }
}
