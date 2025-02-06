import java.util.ArrayList;

public class Product {
    private static int cnt;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public static void setCnt(int cnt) {
        Product.cnt = cnt;
    }

    public static int getCnt() {
        return cnt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        cnt++;
        this.id = cnt;
    }

    public boolean setRating(int rating){
        if (rating >=1 && rating <=5) {
            ratings.add(rating);
            return true;
        }
        else return false;
    }

    public float getAvgRating(){
        int total = 0;
        for (int i = 0 ; i < ratings.size(); i ++){
            total = total + ratings.get(i);
        }
        if (ratings.size() == 0) return 0;
        float average = (float) total/ratings.size();
        return average;
    }

    @Override
    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",id,name,price,getAvgRating());
    }
}