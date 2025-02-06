import java.util.ArrayList;

public class Product {

    private static int cnt = 0;//initialized to 0, and will increase by 1 when the constructor is called;
    private int id;//unique for each product and the value is set to cnt
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt ++;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if(rating>0 && rating<6) {
            ratings.add(rating);
            return true;
        }else{
            return false;
        }
    }

    public void setPrice(float price){
        this.price = price;
    }
    
    public float getPrice(){
        return this.price;
    }

    public float getAvgRating(){
        if(ratings.size()==0){
            return 0.0f;
        }
        int ratingSum = 0;
        for(int rating : ratings){
            ratingSum += rating;
        }
        float avgRating = (float)ratingSum/ratings.size();
        return avgRating;
    }

    @Override
    public String toString() {
        String productId = "Product ID " + id + ", ";
        String productName = name + ", ";
        String productPrice = "RMB " + String.format("%.2f", price) + ", ";
        String productRating = "Rating " + String.format("%.1f",getAvgRating());
        return productId + productName + productPrice + productRating;
    }

}