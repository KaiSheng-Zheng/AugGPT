import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private ArrayList<Integer> ratings = new ArrayList<>();

    public Product(String name,float price){
        cnt++;
        this.id = cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
            return true;
        } else
         return false;
    }

    public float getAvgRating() {
        float sum=0;
        for (int i = 0; i < ratings.size(); i++) {
            sum = sum + ratings.get(i);
        }
        if(ratings.size() != 0)
            return sum / ratings.size();
        else return 0;

    }


    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public String toString() {
        String str ;
        str = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
        return str;




    }


}
