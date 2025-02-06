import java.util.ArrayList;

public class Product {
    private static int cnt = 0; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each product and the value is set to cnt.
    private String name;
    private float price;
    private ArrayList<Integer> ratings; // ratings from different customers; default is empty.

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }


    public Product(String name, float price){
        this.name = name;
        this.price = price;
        cnt++;
        id = cnt;
        this.ratings = new ArrayList<>();
    }
    public boolean setRating(int rating){
        if(rating<6 && rating>0){
            ratings.add(rating);
            return true;
        }
        else {
            return false;
        }
    }
    public float getAvgRating(){
        float sum = 0;
        if(ratings.size()==0){
            return 0;
        }
        else {
            for (float a : ratings)  sum += a;
            return sum/ratings.size();
        }
    }
    @Override
    public String toString(){
        return "Product ID " + id + ", " + name + ", RMB " + String.format("%.2f",price) + ", Rating " + String.format("%.1f",getAvgRating());
    }
}
