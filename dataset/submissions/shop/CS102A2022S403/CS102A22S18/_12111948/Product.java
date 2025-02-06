import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;
    public Product(String name, float price)
    {
        this.id = ++cnt;
        this.name = name;
        this.price = price;
        ratings = new ArrayList<>();
    }
    public boolean setRating(int rating) {
        if(rating < 1 || rating > 5)
            return false;
        ratings.add(rating);
        return true;
    }

    public float getAvgRating() {
        float res = 0;
        for(int i = 0;i < ratings.size();i++)
            res += ratings.get(i);
        return res/ratings.size()*1.0f;
    }
    public float getPrice()
    {
        return price;
    }
    public String toString()
    {
        return "Product ID " + id
                + ", " + name
                + ", RMB " + String.format("%.2f", getPrice())
                + ", Rating " + String.format("%.1f", getAvgRating());
    }
}
