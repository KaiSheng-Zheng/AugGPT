import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private float ratingSum=0;
    private ArrayList<Integer> ratings;
    public Product(String name , float price){
        this.price = price;
        this.name = name;
        id =  ++cnt;
        ratings = new ArrayList<>();
    }

    public float getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratingSum += rating;}
        else {ratingSum += 0;}
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else return false;
    }

    public float getAvgRating(){
        if (ratingSum == 0)
            return 0;
        else return (ratingSum/ratings.size());
    }

    public String toString(){
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        DecimalFormat averageRatingFormat = new DecimalFormat("0.0");
        return "Product ID " + this.id + ", " + this.name + ", RMB " + priceFormat.format(this.price) + ", Rating " + averageRatingFormat.format(this.getAvgRating());
    }

}


