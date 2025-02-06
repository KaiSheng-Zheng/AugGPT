import java.util.ArrayList;

public class Product {
    private static int cnt = 0;
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
    public String getName() {
        return name;
    }

    public Product(String name, float price){
        this.name = name;
        this.price = price;
        id = ++cnt;
        ratings = new ArrayList<Integer>();
    }

    public boolean setRating(int rating){
        boolean result = true;
        if (rating >= 1 && rating <= 5){
            ratings.add(rating);
        }else{
            result = false;
        }
        return result;
    }

    public float getAvgRating(){
        if (ratings.size() == 0){
            return 0;
        }else{
            float average = 0;
            float total = 0;
            for (int i = 0; i < ratings.size(); i++) {
                total += ratings.get(i);
            }
            average = total / ratings.size();
            return average;
        }
    }

    public String toString(){
        String s = String.format("Product ID %d, %s, RMB %.2f, Rating %.1f",getId(),getName(),getPrice(),getAvgRating());
        return s;
    }
}
