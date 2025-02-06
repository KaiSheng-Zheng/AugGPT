import java.util.ArrayList;
public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>() ;

    public Product(String name, float price) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating < 1 || rating > 5) return false;
        else {
            ratings.add(rating);
            return true;
        }
    }

    public float getAvgRating() {
        float ans = 0;
        for (int i = 0; i < ratings.size(); i++) {
            ans += ratings.get(i);
        }
        if(ans==0 || ratings.size()==0) return 0;
        ans /= ratings.size();
        return ans;
    }

    public String toString() {
        String f1 = String.format("%.2f", price);
        String f2 = String.format("%.1f", getAvgRating());

        return "Product ID " + id + ", " + name + ", RMB " + f1 + ", Rating " + f2;
    }

    public float getPrice() {
        return price;
    }
}