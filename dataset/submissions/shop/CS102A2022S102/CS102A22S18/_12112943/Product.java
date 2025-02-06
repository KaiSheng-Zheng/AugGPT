import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();

    public Product(String name, float price) {
        Product.cnt++;
        this.id = Product.cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5) {
            this.ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }

    public float getAvgRating() {
        if(ratings.size()==0){
            return 0.0f;
        }
        float sum = 0.0f;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        return sum / ratings.size();
    }

    @Override
    public String toString() {
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat ratingFormat = new DecimalFormat("0.0");

        float temp = this.getAvgRating();
        priceFormat.format(temp);
        String format = "Product ID " + this.id + ", " + this.name + ", RMB " + priceFormat.format(this.price) +
                ", Rating " + ratingFormat.format(this.getAvgRating());
        return format;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Product other = (Product) obj;
            if (this.id == other.id) {
                return true;
            } else {
                return false;
            }
        }
    }

    public float getPrice() {
        return price;
    }
}
