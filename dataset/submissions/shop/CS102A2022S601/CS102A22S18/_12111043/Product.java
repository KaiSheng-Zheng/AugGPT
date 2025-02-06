import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings=new ArrayList<>();
    public float rating;

    public Product(String name, float price) {
        this.name=name;
        this.price=price;
        cnt++;
        id = cnt;
        this.rating=getRating();
    }

    public boolean setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating=rating;
            ratings.add(rating);
            return true;
        }
        return false;
    }

    public float getAvgRating() {
        float a = 0;
        if(ratings.size()!=0) {
            for (int i = 0; i < ratings.size(); i++) {
                a += ratings.get(i);
            }
            return a / ratings.size();
        }else {
            return 0;
        }
    }

    public String toString() {
        //        return "Product ID " + id + ", " + name + ", RMB " + price + ", Rating " + getAvgRating();
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }

    public int getId(){
        return id;
    }

    public float getPrice(){
        return price;
    }
    public float getRating(){
        return rating;
    }

}
