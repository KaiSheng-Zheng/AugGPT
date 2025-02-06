import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product{
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Product(String name, float price){
        Product.cnt = Product.cnt + 1;
        this.id = Product.cnt;
        this.name = name;
        this.price = price;
    }
    public boolean setRating(int rating){
        if(rating < 1 || rating > 5){
            return false;
        }
        return this.ratings.add(rating);
    }
    public float getAvgRating(){
        if(this.ratings.size() == 0)
            return 0.0f;
        float allRating= 0;
        for (int n:this.ratings){
            allRating = allRating + n;
        }
        return allRating / this.ratings.size();
    }
    @Override
    public String toString(){
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat averageRatingFormat = new DecimalFormat("0.0");
        String description = "Product ID " + this.id + ", " + this.name + ", RMB " + priceFormat.format(this.price) + ", Rating ";
        if(this.ratings.size() == 0){
            description = description + "0.0";
        }
        else if(this.ratings.size() != 0){
            description = description + averageRatingFormat.format(this.getAvgRating());
        }
        return description;
    }
    public float getPrice(){
        return this.price;
    }
}