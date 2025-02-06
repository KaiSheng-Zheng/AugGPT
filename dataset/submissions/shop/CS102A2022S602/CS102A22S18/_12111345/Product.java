import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private static int cnt ;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();
    public Store store ;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }


    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if (rating ==1 || rating == 2 ||rating == 3 || rating == 4 || rating == 5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }


   public float getAvgRating(){
        if (ratings.size()==0){
            return 0;
        }
        else{
        float sum = 0 ;
        for (Integer rating : ratings) {
            sum += rating;
        }

        return sum/ratings.size();
    }}
    @Override
    public String toString() {
        DecimalFormat priceCopy = new DecimalFormat("0.00");
        DecimalFormat average = new DecimalFormat("0.0");
        return String.format("Product ID "+id+", "+name+", "+"RMB "+priceCopy.format(price)+", Rating "+average.format(getAvgRating()));}}
