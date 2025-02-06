import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
    private int id;
    private String name;
    private float price;
    private ArrayList<Integer> ratings = new ArrayList<Integer>();

    public Product(String name, float price) {
        this.id = ++cnt;
        this.name = name;
        this.price = price;
    }

    public boolean setRating(int rating){
       if (rating >= 1 && rating <= 5){
           ratings.add(rating);
           return true;
        } else {
            return false;
        }
    }

    public float getPrice(){
        return price;
    }

    public float getAvgRating(){
        float total = 0;
        for(int i = 0; i < ratings.size(); i++){
            total = total + ratings.get(i);
        }
        if(ratings.size() > 0){
            float average = total / ratings.size();
            return average;
        } else {
            return 0;
        }
    }

    public String toString() {
        return String.format("Product ID %d, %s, RMB %.2f, Rating %.1f", id, name, price, getAvgRating());
    }
}
