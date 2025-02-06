import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings;

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Product(String name, float price) {
        cnt++;
        id = cnt;
        this.price = price;
        ratings = new ArrayList<Integer>();
        this.name = name;
    }

    ;

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            ratings.add(rating);
            return true;
        } else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum=0;
        int counter=0;
        for (float rating:ratings) {
            sum+=rating;
            counter++;
        }
        return sum/counter;

    };
    public String toString(){
        String string = "Product ID "+ this.id +", "+ this.name +", RMB "+ String.format("%.2f",this.price) +", Rating "+String.format("%.1f",this.getAvgRating());
        return string;
    };


}
