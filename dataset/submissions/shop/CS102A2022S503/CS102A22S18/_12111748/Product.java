import java.text.DecimalFormat;
import java.util.ArrayList;
public class Product {
    private static int cnt=0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public Product(String name, float price){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.price=price;
    }
    public boolean setRating(int rating){
        if(rating==1||rating==2||rating==3||rating==4||rating==5){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getAvgRating(){
        if(ratings.size()==0){
            return 0;
        }
        else
        {
        double total=0;
        for (Integer rating : ratings) {
            total += rating;
        }
        return (float) total / ratings.size();
        }
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
    @Override
    public String toString(){
        DecimalFormat priceFormat =new DecimalFormat("0.00");
        DecimalFormat averageRatingFormat = new DecimalFormat("0.0");
        return "Product ID "+ this.id +", "+ this.name +", RMB " +priceFormat.format(this.price) +", Rating " +averageRatingFormat.format(this.getAvgRating());
    }
}