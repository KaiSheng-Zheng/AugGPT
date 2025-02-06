import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price){
        Product.cnt++;
        this.name = name;
        this.price = price;
        this.id = Product.cnt;
    }
    public boolean setRating(int rating){
        if (rating>5 || rating<1){
            return false;
        }
        return this.ratings.add(rating);
    }
    public float getAvgRating(){
        if (this.ratings.size() == 0){
            return 0.0f;
        }else {
            float ratingsSum = 0;
            for (int i : ratings){
                ratingsSum = ratingsSum +i;
            }
            return ratingsSum/this.ratings.size();
        }
    }
    @Override
    public String toString(){
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat avgRatingFormat = new DecimalFormat("0.0");
        String output = "Product ID " + this.id
                + ", " + this.name
                + ", RMB " + priceFormat.format(this.price)
                + ", Rating ";
        if (this.ratings.size() == 0) {
            output += "0.0";
        } else {
            output += avgRatingFormat.format(this.getAvgRating());
        }
        return output;
    }

    public float getPrice() {
        return price;
    }
}
